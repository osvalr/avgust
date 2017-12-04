package sernanp.rrhh.web.action.legajo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.legajo.service.GestionarLegajoService;
import sernanp.app.business.dto.PersonalLegajoDto;
import sernanp.app.dao.domain.TPersonaNaturalLegajo;
import sernanp.app.dao.domain.TPersonaNaturalLegajoKey;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoKey;
import sernanp.app.dao.mapper.TPersonaNaturalLegajoMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.query.domain.InfoContratosPersonalConstanciaQuery;
import sernanp.app.dao.query.domain.InfoContratosPersonalConstanciaQueryCriteria;
import sernanp.app.dao.query.domain.InfoPersonalConstanciaQuery;
import sernanp.app.dao.query.domain.InfoPersonalConstanciaQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerLegajosPersonalQuery;
import sernanp.app.dao.query.domain.UltimaFotoPersonalQuery;
import sernanp.app.dao.query.domain.UltimaFotoPersonalQueryCriteria;
import sernanp.app.dao.query.domain.UltimoArchivoLegajoQuery;
import sernanp.app.dao.query.domain.UltimoArchivoLegajoQueryCriteria;
import sernanp.app.dao.query.mapper.InfoContratosPersonalConstanciaQueryMapper;
import sernanp.app.dao.query.mapper.InfoPersonalConstanciaQueryMapper;
import sernanp.app.dao.query.mapper.UltimaFotoPersonalQueryMapper;
import sernanp.app.dao.query.mapper.UltimoArchivoLegajoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.NumeroLiteralUtil;
import sernanp.app.util.PropUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarLegajoAction extends ActionHelper{

	
	private static final long serialVersionUID = 2512069725373210463L;

	@Autowired
	GestionarLegajoService gestionarLegajoService;
	
	@Autowired
	CommonService commonService;
	
	private PersonalLegajoDto legajo;
	
	private static Logger log = Logger.getLogger(GestionarLegajoAction.class);
	
	private ObtenerLegajosPersonalQuery obtenerLegajosPersonalQuery;
	private ObtenerDatosBasicosPersonalQuery obtenerDBPQuery; 
	private Integer idLegajo;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	
	
	private File fileFoto;
	private String fileFotoContentType;
	private String fileFotoFileName;
	
	
	private InputStream fileInputStream;
    private String fileName;
    private String contentType;
	
	private Integer srl_id_persona_natural_legajo;
	private String op;
	
	private Integer idPersonaNatural;
	private String base64StringFoto;
	private String mimeType;
	
	private Integer idPersonal;
	

	public String grabar(){
		
        try {

        	//11-02-2015 DAVID        	
        	if(legajo.getSrl_id_contrato() != null){
    			TPersonalContratoKey ck = new TPersonalContratoKey();
    			ck.setSrl_id_contrato(legajo.getSrl_id_contrato());
    			TPersonalContrato pc = commonService.selectByPrimaryKey(TPersonalContratoMapper.class, ck); 
    			
            	if(pc.getSrl_id_contrato_padre() == null && pc.getIdpersonal() != null ){
        			legajo.setInt_id_tipo_documento(161);
        			legajo.setVar_nombre_documento("CONTRATO");
        		}else if(pc.getSrl_id_contrato_padre() != null && pc.getIdpersonal() == null ){
        			legajo.setInt_id_tipo_documento(167);
        			legajo.setVar_nombre_documento("ADENDA");
        		}
            	
            	legajo.setVar_asunto_documento(pc.getVar_num_contrato());
            	
            	SimpleDateFormat df	= new SimpleDateFormat("dd/MM/yyyy");            	
            	
//            	System.out.println("pc.getDte_fec_termino() --> " + pc.getDte_fec_termino());
            	if(pc.getDte_fec_termino() != null){
            		legajo.setVar_descripcion_documento("DESDE " + df.format( pc.getDte_fec_inicio()) +  " HASTA " + df.format(pc.getDte_fec_termino()));	
            	}else{
            		legajo.setVar_descripcion_documento("DESDE " + df.format( pc.getDte_fec_inicio()) +  " HASTA " );
            	}
            	
            	
        	}
        	// FIN
        	
        	if(op.equals("insert")){
        		legajo.setVar_nombre_archivo(fileUploadFileName);
                legajo.setVar_tipo_archivo(fileUploadContentType);
                legajo.setLegajo_file(fileUpload);
              
        		gestionarLegajoService.registrarLegajo(legajo);
        		
        		transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
        		transaccionUtil.setMensaje("Legajo registrado con éxito.");
        	}else{
        		legajo.setSrl_id_persona_natural_legajo(srl_id_persona_natural_legajo);
        		legajo.setVar_nombre_archivo(fileUploadFileName);
                legajo.setVar_tipo_archivo(fileUploadContentType);
                legajo.setLegajo_file(fileUpload);
              
        		gestionarLegajoService.actualizarLegajo(legajo);
        		
        		transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
        		transaccionUtil.setMensaje("Legajo actualizado con éxito.");
        	}
        	
    		
		} catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(), e);	
		} catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
			
			log.error(e.getMessage(),e);
			
		}finally{
			
			fileUpload = null;
			fileUploadContentType  = null;
			fileUploadFileName  = null;
		}
		
		
		return SUCCESS;
		
	}
	
	public String grabarFotoPersonal(){
		
        try {
		
        		legajo.setVar_nombre_archivo(fileFotoFileName);
                legajo.setVar_tipo_archivo(fileFotoContentType);
                legajo.setLegajo_file(fileFoto);
              
        		gestionarLegajoService.grabarFotoPersonal(legajo);
        		
        		transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
        		transaccionUtil.setMensaje("Foto Personal registrado con éxito.");

		} catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(), e);	
		} catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
			
			log.error(e.getMessage(),e);
			
		}finally{
			
			fileUpload = null;
			fileUploadContentType  = null;
			fileUploadFileName  = null;
		}
		
		
		return SUCCESS;
		
	}
	
	
	
	public String decargarLegajo() throws FileNotFoundException{
		
		UltimoArchivoLegajoQueryCriteria criteria = new UltimoArchivoLegajoQueryCriteria();
		criteria.setSrl_id_persona_natural_legajo(srl_id_persona_natural_legajo);
		
		List<UltimoArchivoLegajoQuery> list = commonService.selectByCriteria(UltimoArchivoLegajoQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			UltimoArchivoLegajoQuery ual = list.get(0);
			contentType = ual.getVar_tipo_archivo();
			
			File fileToDownload = new File(ual.getVar_archivo_ruta_almacen());
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
		}
		
		return SUCCESS;
	}
	
	public String anularLegajo(){
		
		TPersonaNaturalLegajoKey key = new TPersonaNaturalLegajoKey();
		key.setSrl_id_persona_natural_legajo(srl_id_persona_natural_legajo);
		
		TPersonaNaturalLegajo record = commonService.selectByPrimaryKey(TPersonaNaturalLegajoMapper.class, key);
		record.setInt_id_estado(2);
		commonService.actualizarPorPkSelectivo(TPersonaNaturalLegajoMapper.class, record);
		
		return SUCCESS;
	}
	
	public String obtenerFotoPersonal(){

		UltimaFotoPersonalQueryCriteria criteria = new UltimaFotoPersonalQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatural);
		
		List<UltimaFotoPersonalQuery> list = commonService.selectByCriteria(UltimaFotoPersonalQueryMapper.class, criteria);
		
		if(!list.isEmpty()){
			UltimaFotoPersonalQuery ufpq = list.get(0);
			mimeType = ufpq.getVar_tipo_archivo();
			
			try {
				base64StringFoto = encodeFileToBase64Binary(ufpq.getVar_archivo_ruta_almacen());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
		}
		return SUCCESS;
	}
	
	public String generarConstancia() throws Exception{
		
		InfoPersonalConstanciaQueryCriteria cipc = new InfoPersonalConstanciaQueryCriteria();
		cipc.setIdpersonal(idPersonal);
		
		List<InfoPersonalConstanciaQuery> lipc = commonService.selectByCriteria(InfoPersonalConstanciaQueryMapper.class, cipc);
		
		InfoPersonalConstanciaQuery ipc = null;
		
		if(!lipc.isEmpty()){
			ipc = lipc.get(0);
		}
		
		InfoContratosPersonalConstanciaQueryCriteria icpcc = new InfoContratosPersonalConstanciaQueryCriteria();
		icpcc.setIdpersonal(idPersonal);
		
		List<InfoContratosPersonalConstanciaQuery> licpc = commonService.selectByCriteria(InfoContratosPersonalConstanciaQueryMapper.class, icpcc);
		
		// read war.zip and write to append.zip
		String pathTemplate = PropUtil.getInstance().getPropVal("documents.properties", "ruta.template.constancia"); 
		ZipFile zipFile = new ZipFile(pathTemplate);

		String pathTmp = PropUtil.getInstance().getPropVal("documents.properties", "ruta.temp.constancia") + "CONS.docx"; 

		File fDocx = new File(pathTmp);

		fDocx.delete();

		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(pathTmp));

		// first, copy contents from existing war

		Enumeration<? extends ZipEntry> entries = zipFile.entries();

		while (entries.hasMoreElements()) {

			ZipEntry e = entries.nextElement();

			if (!e.getName().equals("word/document.xml")) {

				zipOutputStream.putNextEntry(e);

				if (!e.isDirectory()) {

					copy(zipFile.getInputStream(e), zipOutputStream);

				}

				zipOutputStream.closeEntry();

			}

		}

		// now append some extra content

		ZipEntry e = new ZipEntry("word/document.xml");

		zipOutputStream.putNextEntry(e);

		zipOutputStream.write(generateDocumentXml(pathTemplate,ipc,licpc).getBytes("UTF-8"));

		zipOutputStream.closeEntry();

		// close

		zipFile.close();

		zipOutputStream.close();
		
		File fileToDownload = new File(pathTmp);
        fileInputStream = new FileInputStream(fileToDownload);
		
		return SUCCESS;
		
	}
	
	public void copy(InputStream input, OutputStream output) throws IOException {

		int bytesRead;
		
		byte[] buffer = new byte[4096 * 1024];

		while ((bytesRead = input.read(buffer)) != -1) {

			output.write(buffer, 0, bytesRead);

		}

	}
	
	static ZipInputStream getInputStream(File zip, String entry)
			throws IOException {

		ZipInputStream zin = new ZipInputStream(new FileInputStream(zip));

		for (ZipEntry e; (e = zin.getNextEntry()) != null;) {

			if (e.getName().equals(entry)) {

				return zin;

			}

		}

		throw new EOFException("Cannot find " + entry);

	}
	
	public String generateDocumentXml(String pathTmp,InfoPersonalConstanciaQuery ipc,List<InfoContratosPersonalConstanciaQuery> licpc) throws Exception {

		Map<String, String> map = new HashMap<String, String>();

		
		List<InfoContratosPersonalConstanciaQuery> licpcAux = licpc;
		
		DateFormat dfx = DateFormat.getDateInstance(DateFormat.LONG,new Locale("ES"));

		String fa = dfx.format(new Date());
		
		String text = "";
		
		map.put("#{tipoDoc}", ipc.getTipoDoc());
		map.put("#{numerodoc}", ipc.getNumerodoc());
		map.put("#{nombre_completo}", ipc.getNombre() + " " + ipc.getApepat() + " " + ipc.getApemat());
		map.put("#{var_descripcion_regimen_contractual}", ipc.getVar_descripcion_regimen_contractual());
		map.put("#{fecha.actual}", fa);
		
		ZipInputStream in = getInputStream(new File(pathTmp), "word/document.xml");

		Scanner sc = new Scanner(in, "UTF-8");

		int count = 0;

		while (sc.hasNextLine()) {

			String line = "";

			line = sc.nextLine();

			if (count == 0) {

				text += line + "\n";

			} else {

				text += line;

			}

			count++;

		}
		
		for (Entry<String, String> e : map.entrySet()) {
			if(e.getValue() != null){
				if(!e.getValue().equals("")){
					text = text.replace(e.getKey(), e.getValue());
				}
			}
		}

		sc.close();

		in.close();
		String bloque = "";	
		
		for (InfoContratosPersonalConstanciaQuery x : licpc) {
		
		bloque = bloque +"<w:p>" +
							"<w:pPr>"+
								"<w:pStyle w:val=\"Normal\"/>"+
								"<w:jc w:val=\"both\"/>"+
								"<w:rPr>"+
									"<w:sz w:val=\"22\"/>"+
									"<w:b/>"+
									"<w:sz w:val=\"22\"/>"+
									"<w:b/>"+
									"<w:szCs w:val=\"22\"/>"+
									"<w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:cs=\"Arial\"/>"+
								"</w:rPr>"+
							"</w:pPr>"+
							"<w:r>"+
								"<w:rPr>"+
									"<w:rFonts w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
									"<w:b/>"+
									"<w:sz w:val=\"22\"/>"+
									"<w:szCs w:val=\"22\"/>"+
								"</w:rPr>"+
								"<w:t xml:space=\"preserve\">Cargo: "+x.getVar_nom_cargo()+" – "+x.getDesarea()+" </w:t>"+
							"</w:r>"+
							"<w:r/>"+
						"</w:p>";
		
		bloque = bloque + "<w:p>"+
									"<w:pPr>"+
										"<w:pStyle w:val=\"Normal\"/>"+
										"<w:jc w:val=\"both\"/>"+
										"<w:rPr>"+
											"<w:sz w:val=\"22\"/>"+
											"<w:b/>"+
											"<w:sz w:val=\"22\"/>"+
											"<w:b/>"+
											"<w:szCs w:val=\"22\"/>"+
											"<w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:eastAsia=\"Times New Roman\" w:cs=\"Arial\"/>"+
											"<w:color w:val=\"00000A\"/>"+
											"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
										"</w:rPr>"+
									"</w:pPr>"+
									"<w:r>"+
										"<w:rPr>"+
											"<w:rFonts w:eastAsia=\"Times New Roman\" w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
											"<w:b/>"+
											"<w:color w:val=\"00000A\"/>"+
											"<w:sz w:val=\"22\"/>"+
											"<w:szCs w:val=\"22\"/>"+
											"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
										"</w:rPr>"+
									"</w:r>"+
									"<w:r/>"+
								"</w:p>";
			
			for (InfoContratosPersonalConstanciaQuery y : licpcAux) {
				if(x.getVar_nom_cargo() != null && x.getDesarea() != null){
					if(x.getVar_nom_cargo().equals(y.getVar_nom_cargo()) && x.getDesarea().equals(y.getDesarea()) && x.getNum_sueldo().equals(y.getNum_sueldo())){
						
						DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,new Locale("ES"));

						String fi = df.format(y.getDte_fec_inicio());
//						String ft = df.format(y.getDte_fec_termino());

					// 06-03-2015 DAVID
						
						String ft = "";
						if(y.getDte_fec_termino() != null){
							ft = df.format(y.getDte_fec_termino());
						}
						
					//END DAVID
						
						bloque = bloque + "<w:p>"+
											"<w:pPr>"+
												"<w:pStyle w:val=\"Normal\"/>"+
												"<w:numPr>"+
													"<w:ilvl w:val=\"0\"/>"+
													"<w:numId w:val=\"1\"/>"+
												"</w:numPr>"+
												"<w:jc w:val=\"both\"/>"+
											"</w:pPr>"+
											"<w:r>"+
												"<w:rPr>"+
													"<w:rFonts w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
													"<w:sz w:val=\"22\"/>"+
													"<w:szCs w:val=\"22\"/>"+
												"</w:rPr>"+
												"<w:t>Desde el "+fi+" hasta "+ft+".</w:t>"+
											"</w:r>"+
											"<w:r/>"+
										"</w:p>";
						
					}
				}
			}
			
			bloque = bloque +"<w:p>"+
								"<w:pPr>"+
									"<w:pStyle w:val=\"Normal\"/>"+
									"<w:ind w:left=\"1068\" w:hanging=\"0\"/>"+
									"<w:jc w:val=\"both\"/>"+
									"<w:rPr>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:szCs w:val=\"22\"/>"+
										"<w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:eastAsia=\"Times New Roman\" w:cs=\"Arial\"/>"+
										"<w:color w:val=\"00000A\"/>"+
										"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
									"</w:rPr>"+
								"</w:pPr>"+
								"<w:r>"+
									"<w:rPr>"+
										"<w:rFonts w:eastAsia=\"Times New Roman\" w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
										"<w:color w:val=\"00000A\"/>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:szCs w:val=\"22\"/>"+
										"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
									"</w:rPr>"+
								"</w:r>"+
								"<w:r/>"+
							"</w:p>";
			
			bloque = bloque +"<w:p>"+
								"<w:pPr>"+
									"<w:pStyle w:val=\"Normal\"/>"+
									"<w:jc w:val=\"both\"/>"+
									"<w:rPr>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:szCs w:val=\"22\"/>"+
										"<w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:cs=\"Arial\"/>"+
									"</w:rPr>"+
								"</w:pPr>"+
								"<w:r>"+
									"<w:rPr>"+
										"<w:rFonts w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
										"<w:sz w:val=\"22\"/>"+
										"<w:szCs w:val=\"22\"/>"+
									"</w:rPr>"+
									"<w:t>Percibiendo honorario de "+NumeroLiteralUtil.getInstance().Convertir(x.getNum_sueldo().toString(), false)+".</w:t>"+
								"</w:r>"+
								"<w:r/>"+
							"</w:p>";
			
			bloque = bloque +"<w:p>"+
					"<w:pPr>"+
						"<w:pStyle w:val=\"Normal\"/>"+
						"<w:ind w:left=\"1068\" w:hanging=\"0\"/>"+
						"<w:jc w:val=\"both\"/>"+
						"<w:rPr>"+
							"<w:sz w:val=\"22\"/>"+
							"<w:sz w:val=\"22\"/>"+
							"<w:szCs w:val=\"22\"/>"+
							"<w:rFonts w:ascii=\"Arial\" w:hAnsi=\"Arial\" w:eastAsia=\"Times New Roman\" w:cs=\"Arial\"/>"+
							"<w:color w:val=\"00000A\"/>"+
							"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
						"</w:rPr>"+
					"</w:pPr>"+
					"<w:r>"+
						"<w:rPr>"+
							"<w:rFonts w:eastAsia=\"Times New Roman\" w:cs=\"Arial\" w:ascii=\"Arial\" w:hAnsi=\"Arial\"/>"+
							"<w:color w:val=\"00000A\"/>"+
							"<w:sz w:val=\"22\"/>"+
							"<w:szCs w:val=\"22\"/>"+
							"<w:lang w:val=\"es-ES\" w:eastAsia=\"es-ES\" w:bidi=\"ar-SA\"/>"+
						"</w:rPr>"+
					"</w:r>"+
					"<w:r/>"+
				"</w:p>";
			
		}

		text = text.replaceAll("<!-- -->", bloque);

		return text;

	}
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		
		return transaccionUtil;
	}

	public PersonalLegajoDto getLegajo() {
		return legajo;
	}

	public void setLegajo(PersonalLegajoDto legajo) {
		this.legajo = legajo;
	}

	public Integer getIdLegajo() {
		return idLegajo;
	}

	public void setIdLegajo(Integer idLegajo) {
		this.idLegajo = idLegajo;
	}

	public ObtenerLegajosPersonalQuery getObtenerLegajosPersonalQuery() {
		return obtenerLegajosPersonalQuery;
	}

	public void setObtenerLegajosPersonalQuery(
			ObtenerLegajosPersonalQuery obtenerLegajosPersonalQuery) {
		this.obtenerLegajosPersonalQuery = obtenerLegajosPersonalQuery;
	}

	public ObtenerDatosBasicosPersonalQuery getObtenerDBPQuery() {
		return obtenerDBPQuery;
	}

	public void setObtenerDBPQuery(ObtenerDatosBasicosPersonalQuery obtenerDBPQuery) {
		this.obtenerDBPQuery = obtenerDBPQuery;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public Integer getSrl_id_persona_natural_legajo() {
		return srl_id_persona_natural_legajo;
	}

	public void setSrl_id_persona_natural_legajo(
			Integer srl_id_persona_natural_legajo) {
		this.srl_id_persona_natural_legajo = srl_id_persona_natural_legajo;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public File getFileFoto() {
		return fileFoto;
	}

	public void setFileFoto(File fileFoto) {
		this.fileFoto = fileFoto;
	}

	public String getFileFotoContentType() {
		return fileFotoContentType;
	}

	public void setFileFotoContentType(String fileFotoContentType) {
		this.fileFotoContentType = fileFotoContentType;
	}

	public String getFileFotoFileName() {
		return fileFotoFileName;
	}

	public void setFileFotoFileName(String fileFotoFileName) {
		this.fileFotoFileName = fileFotoFileName;
	}

	public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public String getBase64StringFoto() {
		return base64StringFoto;
	}

	public void setBase64StringFoto(String base64StringFoto) {
		this.base64StringFoto = base64StringFoto;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	private String encodeFileToBase64Binary(String fileName)
			throws IOException {
 
		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);
 
		return encodedString;
	}
 
	@SuppressWarnings("resource")
	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);
 
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }
 
	    if (offset < bytes.length) {
	        throw new IOException("No se puede leer el archivo "+file.getName());
	    }
 
	    is.close();
	    return bytes;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

}
