package sernanp.rrhh.web.action.contrato;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.cons.Estados;
import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.contrato.service.BuscarContratoService;
import sernanp.app.business.core.contrato.service.GestionarContratoService;
import sernanp.app.business.core.persona.service.BuscarPersonaService;
import sernanp.app.business.dto.ContratoDto;
import sernanp.app.business.dto.GenerateDocDto;
import sernanp.app.dao.domain.Areanatural;
import sernanp.app.dao.domain.Areaorganica;
import sernanp.app.dao.domain.Categoriaanp;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.PersonalExample;
import sernanp.app.dao.domain.TCargo;
import sernanp.app.dao.domain.TDetalleEstadoTabla;
import sernanp.app.dao.domain.TDetalleEstadoTablaExample;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoKey;
import sernanp.app.dao.domain.TRegimenContractual;
import sernanp.app.dao.domain.TRegimenContractualExample;
import sernanp.app.dao.mapper.AreaorganicaMapper;
import sernanp.app.dao.mapper.CategoriaanpMapper;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.TCargoMapper;
import sernanp.app.dao.mapper.TDetalleEstadoTablaMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.mapper.TRegimenContractualMapper;
import sernanp.app.dao.query.domain.AreaOrganicaQuery;
import sernanp.app.dao.query.domain.AreaOrganicaQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaCodigoPostulacionPersonaQuery;
import sernanp.app.dao.query.domain.ConvocatoriaCodigoPostulacionPersonaQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQuery;
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.PersonaNaturalQuery;
import sernanp.app.dao.query.domain.PersonaNaturalQueryCriteria;
import sernanp.app.dao.query.domain.TablaTipoQuery;
import sernanp.app.dao.query.mapper.AreaOrganicaQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaCodigoPostulacionPersonaQueryMapper;
import sernanp.app.dao.query.mapper.ConvocatoriaDisponibleQueryMapper;
import sernanp.app.dao.query.mapper.PersonaNaturalQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ConstantesUtil;
import sernanp.app.util.PropUtil;
import sernanp.app.util.TransaccionUtil;
import sernanp.rrhh.util.GeneratePdfUtil;
import sernanp.rrhh.web.action.helper.ActionHelper;

public class GestionarContratoAction extends ActionHelper {

	private static Logger log = Logger.getLogger(GestionarContratoAction.class);
	
	private static final long serialVersionUID = -8901916746697082453L;
	private final String INSERT = "insert";
	private final String UPDATE = "update";

	private final String CONTRATO = "contrato";
	private final String ADENDA = "adenda";
	
	private InputStream contratoIs; 
	
	@Autowired
	BuscarContratoService buscarContratoService;
	
	@Autowired
	BuscarPersonaService buscarPersonaService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	GestionarContratoService gestionarContratoService;
	
	private ContratoDto contrato;
	private Integer idContrato;
	
	private PersonaNaturalQuery personaNatural;
	private Integer idPersonaNatural;
	private Integer idPersonal;
	private Integer idPostulacion;
	private List<ConvocatoriaDisponibleQuery> listCD;
	private List<Areaorganica> listAreaOrganica;
	private ConvocatoriaCodigoPostulacionPersonaQuery convocatoriaCodigoPostulacionPersonaQuery;
	private List<ConvocatoriaCodigoPostulacionPersonaQuery> listCcpp;
	private List<TCargo> listCargos;
	private List<TDetalleEstadoTabla> listEstado;
	private String op;
	private String tipoReg;
	private String numContrato;
	private List<TablaTipoQuery> listTratoPersona;
	private List<TRegimenContractual> listTipoContrato;
	private AreaOrganicaQuery areaOrganica;
	
	private String idContratos;
	private String idAdendas;
	
	private List<TRegimenContractual> listRegimenContractual;
	private List<TCargo> listCargo;
	private List<Personal> listEstadoPersonal;
	private List<Categoriaanp> listCategoriaAnp;
	private List<Areanatural> listAreaNatural;
	
	public String gestionarContratoFiltro(){
		
		ConvocatoriaDisponibleQueryCriteria criteriaCD = new ConvocatoriaDisponibleQueryCriteria();
		criteriaCD.setInt_id_estado(Estados.CODIGO_POSTULACION_CONVOCATORIA_EN_PROCESO);
		
		listCD = commonService.selectByCriteria(ConvocatoriaDisponibleQueryMapper.class, criteriaCD);
		
		AreaOrganicaQueryCriteria criteria = new AreaOrganicaQueryCriteria();
		listAreaOrganica = commonService.selectByCriteria(AreaOrganicaQueryMapper.class,criteria);
		
		setListRegimenContractual(commonService.obtenerRegimenContractual());
		setListCargo(commonService.obtenerCargo());
		listCategoriaAnp =(commonService.selectAll(CategoriaanpMapper.class));
		
		
		return SUCCESS;
	}
	
	public String gestionarContrato(){
		
		if(idPersonaNatural == null){
			return ERROR;
		}
		
		personaNatural=null;
		PersonaNaturalQueryCriteria criteria = new PersonaNaturalQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatural);
		
		List<PersonaNaturalQuery> list = buscarPersonaService.selectByCriteria(PersonaNaturalQueryMapper.class, criteria);
		if(!list.isEmpty()){
			personaNatural = list.get(0);
			idPersonal = obtenerIdPersonal(idPersonaNatural);
		}
		
		listCcpp = obtenerPostulaciones(idPersonaNatural);
		
		if(personaNatural == null){
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String edicionContrato(){
		
		if(idPersonaNatural == null){
			return ERROR;
		}
		
		personaNatural=null;
		PersonaNaturalQueryCriteria criteria = new PersonaNaturalQueryCriteria();
		criteria.setIdpersonanatural(idPersonaNatural);
		
		List<PersonaNaturalQuery> list = buscarPersonaService.selectByCriteria(PersonaNaturalQueryMapper.class, criteria);
		if(!list.isEmpty()){
			personaNatural = list.get(0);
		}
		
		if(personaNatural == null){
			return ERROR;
		}
		

		
		listTratoPersona = commonService.obtenerValoresTablaTipo("Tipo Trato Persona");
		
		List<Integer> idRc = new ArrayList<Integer>();
		idRc.add(1);
		idRc.add(3);
		TRegimenContractualExample eRc = new TRegimenContractualExample();
		eRc.createCriteria().andSrl_id_regimen_contractualIn(idRc);
		
		listTipoContrato = commonService.selectByExample(TRegimenContractualMapper.class, eRc);
		
//		listCargos = commonService.selectAll(TCargoMapper.class);
		listCargos = commonService.obtenerCargo();
		
		TDetalleEstadoTablaExample example = new TDetalleEstadoTablaExample();
		example.createCriteria().andSrl_id_estado_tablaEqualTo(2);
		
		listEstado = commonService.selectByExample(TDetalleEstadoTablaMapper.class, example);
		
		if(tipoReg.equals(CONTRATO)){
			
			if(contrato == null){
				
				numContrato = commonService.obtenerSecuencia(Tablas.T_PERSONAL_CONTRATO, false, false);
				
				convocatoriaCodigoPostulacionPersonaQuery = obtenerPostuacion(idPersonaNatural, idPostulacion);
				//ADD 01-01-2016  -- DAVID
				contrato = new ContratoDto();
				
				contrato.setNum_sueldo(convocatoriaCodigoPostulacionPersonaQuery.getDec_honorario_personal());
				contrato.setDte_fec_inicio(convocatoriaCodigoPostulacionPersonaQuery.getDte_fecha_inicio_contrato());
				contrato.setDte_fec_termino(convocatoriaCodigoPostulacionPersonaQuery.getDte_fecha_fin_contrato());
				contrato.setSrl_id_sede_pres(convocatoriaCodigoPostulacionPersonaQuery.getIdsede());
				//END
				
				
			}else if(contrato.getSrl_id_contrato() != null){
				
				TPersonalContratoKey ck = new TPersonalContratoKey();
				ck.setSrl_id_contrato(contrato.getSrl_id_contrato());
				TPersonalContrato pc = commonService.selectByPrimaryKey(TPersonalContratoMapper.class, ck);
				
				contrato.setDte_fec_suscrip(this.dateToString(pc.getDte_fec_suscrip()));
				contrato.setDte_fec_inicio(this.dateToString(pc.getDte_fec_inicio()));
				contrato.setDte_fec_termino(this.dateToString(pc.getDte_fec_termino()));
				contrato.setNum_sueldo(pc.getNum_sueldo());
				contrato.setSrl_id_postulante_conv_area_org(pc.getSrl_id_postulante_conv_area_org());
				contrato.setSrl_id_cargo(pc.getSrl_id_cargo());
				contrato.setInt_id_estado(pc.getInt_id_estado());
				contrato.setInt_id_tipo_trato(pc.getInt_id_tipo_trato());
				contrato.setSrl_id_regimen_contractual(pc.getSrl_id_regimen_contractual());
				contrato.setVar_num_resolucion(pc.getVar_num_resolucion());
				contrato.setVar_lugar_prestacion(pc.getVar_lugar_prestacion());
				contrato.setDte_fec_cese(this.dateToString(pc.getDte_fec_cese()));
				
				// ADD 03-09-2015 DAVID
				contrato.setSrl_id_sede_pres(pc.getSrl_id_sede_pres());
				//END
				
				convocatoriaCodigoPostulacionPersonaQuery = obtenerPostuacion(null, pc.getSrl_id_postulante_conv_area_org());
				if(convocatoriaCodigoPostulacionPersonaQuery != null){
					convocatoriaCodigoPostulacionPersonaQuery.setSede_direccion(convocatoriaCodigoPostulacionPersonaQuery.getSede_direccion().trim());
				}
				
				AreaOrganicaQueryCriteria caoq = new AreaOrganicaQueryCriteria();
				caoq.setIdarea(pc.getIdarea());
				List<AreaOrganicaQuery> laoq = commonService.selectByCriteria(AreaOrganicaQueryMapper.class, caoq);
				
				if(!laoq.isEmpty()){
					areaOrganica = laoq.get(0);
				}
				
					
				numContrato = commonService.obtenerFormatoLargoSecuencia(Tablas.T_PERSONAL_CONTRATO, pc.getVar_num_contrato());

				
			}else {
				numContrato = commonService.obtenerSecuencia(Tablas.T_PERSONAL_CONTRATO, false, false);
				convocatoriaCodigoPostulacionPersonaQuery = obtenerPostuacion(idPersonaNatural, idPostulacion);
			}
			
		}else if(tipoReg.equals(ADENDA)){
			
			if(contrato.getSrl_id_contrato() != null){
				
				TPersonalContratoKey ck = new TPersonalContratoKey();
				ck.setSrl_id_contrato(contrato.getSrl_id_contrato());
				TPersonalContrato pc = commonService.selectByPrimaryKey(TPersonalContratoMapper.class, ck);
				
				contrato.setDte_fec_suscrip(this.dateToString(pc.getDte_fec_suscrip()));
				contrato.setDte_fec_inicio(this.dateToString(pc.getDte_fec_inicio()));
				contrato.setDte_fec_termino(this.dateToString(pc.getDte_fec_termino()));
				contrato.setDte_fec_cese(this.dateToString(pc.getDte_fec_cese()));
				contrato.setInt_id_estado(pc.getInt_id_estado());
				contrato.setInt_id_tipo_trato(pc.getInt_id_tipo_trato());
				contrato.setSrl_id_contrato_padre(pc.getSrl_id_contrato_padre());
				
				numContrato = commonService.obtenerFormatoLargoSecuenciaAdenda(pc.getVar_num_contrato());
				
				TPersonalContratoKey pck = new TPersonalContratoKey();
				pck.setSrl_id_contrato(pc.getSrl_id_contrato_padre());
				
				TPersonalContrato pcx = commonService.selectByPrimaryKey(TPersonalContratoMapper.class, pck);
				
				convocatoriaCodigoPostulacionPersonaQuery = obtenerPostuacion(null, pcx.getSrl_id_postulante_conv_area_org());
				if(convocatoriaCodigoPostulacionPersonaQuery != null){
					convocatoriaCodigoPostulacionPersonaQuery.setSede_direccion(convocatoriaCodigoPostulacionPersonaQuery.getSede_direccion().trim());
				}
				
				AreaOrganicaQueryCriteria caoq = new AreaOrganicaQueryCriteria();
				caoq.setIdarea(pcx.getIdarea());
				List<AreaOrganicaQuery> laoq = commonService.selectByCriteria(AreaOrganicaQueryMapper.class, caoq);
				
				if(!laoq.isEmpty()){
					areaOrganica = laoq.get(0);
				}
				
				
			}else{
//				numContrato = commonService.obtenerSecuenciaAdenda(contrato.getSrl_id_contrato_padre(), true);

				numContrato = commonService.obtenerSecuenciaAdenda(contrato.getSrl_id_contrato_padre(), new Date(), false);
//				numContrato = "Adenda CAS - " + numContrato.substring(5, numContrato.length());
//				System.out.println("numContrato --> " + numContrato);
//				System.out.println("numContrato.substring(5, numContrato.length()) --> " + numContrato.substring(5, numContrato.length()));
				numContrato = numContrato.substring(5, numContrato.length());
//				numContrato = "Adenda CAS";
				
				TPersonalContratoKey pck = new TPersonalContratoKey();
				pck.setSrl_id_contrato(contrato.getSrl_id_contrato_padre());
				
				TPersonalContrato pcx = commonService.selectByPrimaryKey(TPersonalContratoMapper.class, pck);
				
				convocatoriaCodigoPostulacionPersonaQuery = obtenerPostuacion(null, pcx.getSrl_id_postulante_conv_area_org());
				if(convocatoriaCodigoPostulacionPersonaQuery != null){
					convocatoriaCodigoPostulacionPersonaQuery.setSede_direccion(convocatoriaCodigoPostulacionPersonaQuery.getSede_direccion().trim());
				}
				
				AreaOrganicaQueryCriteria caoq = new AreaOrganicaQueryCriteria();
				caoq.setIdarea(pcx.getIdarea());
				List<AreaOrganicaQuery> laoq = commonService.selectByCriteria(AreaOrganicaQueryMapper.class, caoq);
				
				if(!laoq.isEmpty()){
					areaOrganica = laoq.get(0);
				}
				
			}
		}
		
		return SUCCESS;
	}
	
	public String grabar(){
		
		contrato.setIdpersonanatural(personaNatural.getIdpersonanatural());

		try {
			if(op.equals(INSERT)){

				gestionarContratoService.registrarContrato(contrato,tipoReg);
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Contrato registrado con exito.");

				
			}else if(op.equals(UPDATE)){
				
				gestionarContratoService.actualizar(contrato,tipoReg);
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Contrato actualizado con exito.");
				
			}
		}catch (BusinessException e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
			
		} catch (Exception e) {
			
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
						
			log.error(e.getMessage(),e);
			
		}
		
		return SUCCESS;
	}
	
	public String generarContratoPdf(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			GenerateDocDto dto = gestionarContratoService.generarContratoPdf(idContrato);
			list.add(dto);
		}

		try {
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				util.preparePdf();
				util.start();
				
				PDFMergerUtility mergePdf = new PDFMergerUtility();

		        for (GenerateDocDto x : list){
//		        	System.out.println("x.getPathTmpPdf() --> " +x.getPathTmpPdf());
		            mergePdf.addSource(x.getPathTmpPdf());    
		        }
		        mergePdf.setDestinationFileName(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"contratos.pdf");
		        mergePdf.mergeDocuments();
				
				contratoIs = new FileInputStream(new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"contratos.pdf"));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getCause(),e);
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarContratoWord(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			GenerateDocDto dto = gestionarContratoService.generarContratoPdf(idContrato);
			list.add(dto);
		}

		try {
			
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				contratoIs = new FileInputStream(new File(list.get(0).getPathTmpDocx()));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarContratosMasivosPdf(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			String[] ids = idContratos.split(",");
			for(String id: ids){
				GenerateDocDto dto = gestionarContratoService.generarContratoPdf(Integer.parseInt(id));
				list.add(dto);
			}
			
		}

		try {
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				util.preparePdf();
				util.start();
				
				PDFMergerUtility mergePdf = new PDFMergerUtility();

		        for (GenerateDocDto x : list)
		        {
		            mergePdf.addSource(x.getPathTmpPdf());    
		        }
		        mergePdf.setDestinationFileName(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"contratos.pdf");
		        mergePdf.mergeDocuments();
				
				contratoIs = new FileInputStream(new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"contratos.pdf"));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarAdendaPdf(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			GenerateDocDto dto = gestionarContratoService.generarAdendaPdf(idContrato);
			list.add(dto);
		}

		try {
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				util.preparePdf();
				util.start();
				
				PDFMergerUtility mergePdf = new PDFMergerUtility();

		        for (GenerateDocDto x : list)
		        {
		            mergePdf.addSource(x.getPathTmpPdf());    
		        }
		        mergePdf.setDestinationFileName(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"adendas.pdf");
		        mergePdf.mergeDocuments();
				
				contratoIs = new FileInputStream(new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"adendas.pdf"));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarAdendaWord(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			GenerateDocDto dto = gestionarContratoService.generarAdendaPdf(idContrato);
			list.add(dto);
		}

		try {
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				
				contratoIs = new FileInputStream(new File(list.get(0).getPathTmpDocx()));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String generarAdendasMasivoPdf(){
		List<GenerateDocDto> list = new ArrayList<GenerateDocDto>();
		{
			String[] ids = idAdendas.split(",");
			for(String id: ids){
				GenerateDocDto dto = gestionarContratoService.generarAdendaPdf(Integer.parseInt(id));
				list.add(dto);
			}
		}

		try {
				GeneratePdfUtil util = GeneratePdfUtil.getInstance();
				util.setListDto(list);
				util.generarDocumento();
				util.preparePdf();
				util.start();
				
				PDFMergerUtility mergePdf = new PDFMergerUtility();

		        for (GenerateDocDto x : list)
		        {
		            mergePdf.addSource(x.getPathTmpPdf());    
		        }
		        mergePdf.setDestinationFileName(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"adendas.pdf");
		        mergePdf.mergeDocuments();
				
				contratoIs = new FileInputStream(new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.merge") +"adendas.pdf"));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}
	public String suscribirContratosMasivos(){
		try{
			
			String[] ids = idContratos.split(",");
			for(String id: ids){
				gestionarContratoService.suscribirContrato(null, Integer.parseInt(id));
				transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
				transaccionUtil.setMensaje("Suscripciones generadas con exito.");
			}
			
		}catch (BusinessException e) {
		
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
		
		} catch (Exception e) {
		
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
						
			log.error(e.getMessage(),e);
		
		}
		return SUCCESS;
	}
	
	public String suscribirAdendasMasivos(){
		try{
			
			String[] ids = idAdendas.split(",");
			for(String id: ids){
				gestionarContratoService.suscribirAdenda(Integer.parseInt(id));
			}
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_SUCCCESS);
			transaccionUtil.setMensaje("Suscripciones generadas con exito.");
			
		}catch (BusinessException e) {
		
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje(e.getMsjError());
			
			log.error(e.getMessage(),e);
		
		} catch (Exception e) {
		
			transaccionUtil.setEstadoTransaccion(ConstantesUtil.ESTADO_TRANSACCION_EXCEPTION);
			transaccionUtil.setMensaje("Ocurrio un error ejecutando la operacion solicitada.");
						
			log.error(e.getMessage(),e);
		
		}
		return SUCCESS;
	}
	
	
	
	
	@Override
	public TransaccionUtil getTransaccionUtil() {
		return transaccionUtil;
	}

	public PersonaNaturalQuery getPersonaNatural() {
		return personaNatural;
	}

	public void setPersonaNatural(PersonaNaturalQuery personaNatural) {
		this.personaNatural = personaNatural;
	}

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public List<ConvocatoriaDisponibleQuery> getListCD() {
		return listCD;
	}

	public void setListCD(List<ConvocatoriaDisponibleQuery> listCD) {
		this.listCD = listCD;
	}

	public List<Areaorganica> getListAreaOrganica() {
		return listAreaOrganica;
	}

	public void setListAreaOrganica(List<Areaorganica> listAreaOrganica) {
		this.listAreaOrganica = listAreaOrganica;
	}

	public List<TCargo> getListCargos() {
		return listCargos;
	}

	public void setListCargos(List<TCargo> listCargos) {
		this.listCargos = listCargos;
	}

	public List<TDetalleEstadoTabla> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<TDetalleEstadoTabla> listEstado) {
		this.listEstado = listEstado;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getTipoReg() {
		return tipoReg;
	}

	public void setTipoReg(String tipoReg) {
		this.tipoReg = tipoReg;
	}

	public ContratoDto getContrato() {
		return contrato;
	}

	public void setContrato(ContratoDto contrato) {
		this.contrato = contrato;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public ConvocatoriaCodigoPostulacionPersonaQuery getConvocatoriaCodigoPostulacionPersonaQuery() {
		return convocatoriaCodigoPostulacionPersonaQuery;
	}

	public void setConvocatoriaCodigoPostulacionPersonaQuery(
			ConvocatoriaCodigoPostulacionPersonaQuery convocatoriaCodigoPostulacionPersonaQuery) {
		this.convocatoriaCodigoPostulacionPersonaQuery = convocatoriaCodigoPostulacionPersonaQuery;
	}

	public List<TablaTipoQuery> getListTratoPersona() {
		return listTratoPersona;
	}

	public void setListTratoPersona(List<TablaTipoQuery> listTratoPersona) {
		this.listTratoPersona = listTratoPersona;
	}

	public Integer getIdPostulacion() {
		return idPostulacion;
	}

	public void setIdPostulacion(Integer idPostulacion) {
		this.idPostulacion = idPostulacion;
	}
	public ConvocatoriaCodigoPostulacionPersonaQuery obtenerPostuacion(Integer idPersonaNatural, Integer idPostulacion){
		ConvocatoriaCodigoPostulacionPersonaQueryCriteria criteriaCCPP = new ConvocatoriaCodigoPostulacionPersonaQueryCriteria();
		criteriaCCPP.setInt_id_postulante(idPersonaNatural);
		criteriaCCPP.setSrl_id_postulante_conv_area_org(idPostulacion);
		List<ConvocatoriaCodigoPostulacionPersonaQuery> listCCPP = commonService.selectByCriteria(ConvocatoriaCodigoPostulacionPersonaQueryMapper.class, criteriaCCPP);
		if(!listCCPP.isEmpty()){
			return listCCPP.get(0);
		}else{
			return null;
		}
	}
	
	public List<ConvocatoriaCodigoPostulacionPersonaQuery> obtenerPostulaciones(Integer idPersonaNatural){
		
		ConvocatoriaCodigoPostulacionPersonaQueryCriteria criteriaCCPP = new ConvocatoriaCodigoPostulacionPersonaQueryCriteria();
		criteriaCCPP.setInt_id_postulante(idPersonaNatural);
		criteriaCCPP.setSrl_id_postulante_conv_area_org(idPostulacion);
		List<ConvocatoriaCodigoPostulacionPersonaQuery> listCCPP = commonService.selectByCriteria(ConvocatoriaCodigoPostulacionPersonaQueryMapper.class, criteriaCCPP);

		return listCCPP;

	}

	public List<ConvocatoriaCodigoPostulacionPersonaQuery> getListCcpp() {
		return listCcpp;
	}

	public void setListCcpp(List<ConvocatoriaCodigoPostulacionPersonaQuery> listCcpp) {
		this.listCcpp = listCcpp;
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public InputStream getContratoIs() {
		return contratoIs;
	}

	public void setContratoIs(InputStream contratoIs) {
		this.contratoIs = contratoIs;
	}

	public List<TRegimenContractual> getListTipoContrato() {
		return listTipoContrato;
	}

	public void setListTipoContrato(List<TRegimenContractual> listTipoContrato) {
		this.listTipoContrato = listTipoContrato;
	}

	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}
	
	public Integer obtenerIdPersonal(Integer idPersonaNatural){
		PersonalExample example = new PersonalExample();
		example.createCriteria().andIdpersonanaturalEqualTo(idPersonaNatural);
		
		List<Personal> list = commonService.selectByExample(PersonalMapper.class, example);
		
		if(!list.isEmpty()){
			return list.get(0).getIdpersonal();
		}
		else{
			return null;
		}
		
	}

	public String getIdContratos() {
		return idContratos;
	}

	public void setIdContratos(String idContratos) {
		this.idContratos = idContratos;
	}

	public String getIdAdendas() {
		return idAdendas;
	}

	public void setIdAdendas(String idAdendas) {
		this.idAdendas = idAdendas;
	}

	public AreaOrganicaQuery getAreaOrganica() {
		return areaOrganica;
	}

	public void setAreaOrganica(AreaOrganicaQuery areaOrganica) {
		this.areaOrganica = areaOrganica;
	}

	public List<TRegimenContractual> getListRegimenContractual() {
		return listRegimenContractual;
	}

	public void setListRegimenContractual(List<TRegimenContractual> listRegimenContractual) {
		this.listRegimenContractual = listRegimenContractual;
	}

	public List<TCargo> getListCargo() {
		return listCargo;
	}

	public void setListCargo(List<TCargo> listCargo) {
		this.listCargo = listCargo;
	}

	public List<Personal> getListEstadoPersonal() {
		return listEstadoPersonal;
	}

	public void setListEstadoPersonal(List<Personal> listEstadoPersonal) {
		this.listEstadoPersonal = listEstadoPersonal;
	}

	public List<Categoriaanp> getListCategoriaAnp() {
		return listCategoriaAnp;
	}

	public void setListCategoriaAnp(List<Categoriaanp> listCategoriaAnp) {
		this.listCategoriaAnp = listCategoriaAnp;
	}

	public List<Areanatural> getListAreaNatural() {
		return listAreaNatural;
	}

	public void setListAreaNatural(List<Areanatural> listAreaNatural) {
		this.listAreaNatural = listAreaNatural;
	}
	
}
