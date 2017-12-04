package sernanp.rrhh.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

//import org.artofsolving.jodconverter.OfficeDocumentConverter;
//import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
//import org.artofsolving.jodconverter.office.OfficeManager;

import sernanp.app.business.dto.GenerateDocDto;
import sernanp.app.util.NumeroLiteralUtil;
import sernanp.app.util.PropUtil;

public class GeneratePdfUtil extends Thread {

	private List<GenerateDocDto> listDto;

//	private OfficeManager officeManager;

	Process p;

	public static GeneratePdfUtil getInstance() {

		return new GeneratePdfUtil();

	}

	// 4MB buffer

	private static final byte[] BUFFER = new byte[4096 * 1024];

	/**
	 * 
	 * copy input to output stream - available in several StreamUtils or Streams
	 * classes
	 */

	public void copy(InputStream input, OutputStream output) throws IOException {

		int bytesRead;

		while ((bytesRead = input.read(BUFFER)) != -1) {

			output.write(BUFFER, 0, bytesRead);

		}

	}

	public void generarDocumento() throws Exception {

		for (GenerateDocDto dto : listDto) {

			// read war.zip and write to append.zip

			ZipFile zipFile = new ZipFile(dto.getPathTemplate());

			dto.setPathTmpDocx(dto.getPathRutaTmp() + "DOC_"
					+ dto.getIdContrato().toString() + ".docx");

			File fDocx = new File(dto.getPathTmpDocx());

			fDocx.delete();

			ZipOutputStream zipOutputStream = new ZipOutputStream(
					new FileOutputStream(dto.getPathTmpDocx()));

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

			zipOutputStream.write(generateDocumentXml(dto).getBytes("UTF-8"));

			zipOutputStream.closeEntry();

			// close

			zipFile.close();

			zipOutputStream.close();

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

	public String generateDocumentXml(GenerateDocDto dto) throws Exception {

		Map<String, String> map = null;
		// 05-02-2015 DAVID
//		DateFormat df 			= DateFormat.getDateInstance(DateFormat.LONG,new Locale("ES"));
		SimpleDateFormat fm 	= new SimpleDateFormat("MMMMM",new Locale("ES"));
		

		String text = "";

		if (dto.getAdenda() != null) {
			
			/*

			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,new Locale("ES"));


			String fs = df.format(dto.getContratoAdenda().getDte_fec_suscrip());

			String fsa = df.format(dto.getAdenda().getDte_fec_suscrip());

			String fic = df.format(dto.getContratoAdenda().getDte_fec_inicio());

			String ffc = df.format(dto.getContratoAdenda().getDte_fec_termino());
			
			 */
			String fs = fechacompleta(dto.getContratoAdenda().getDte_fec_suscrip());

			String fsa = fechacompleta(dto.getAdenda().getDte_fec_suscrip());

			String fic = fechacompleta(dto.getContratoAdenda().getDte_fec_inicio());

			String ffc = fechacompleta(dto.getContratoAdenda().getDte_fec_termino());
			
			Calendar c = Calendar.getInstance();

			c.setTime(dto.getAdenda().getDte_fec_inicio());

			String diaInicio = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			// 06-02-2015 DAVID
			if(Integer.valueOf(diaInicio) < 10) diaInicio = "0"+diaInicio; 

			c.setTime(dto.getAdenda().getDte_fec_termino());

			String diaFin = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			// 06-02-2015 DAVID
			if(Integer.valueOf(diaFin) < 10) diaFin = "0"+diaFin; 

			Calendar f1 = Calendar.getInstance();

			Calendar f2 = Calendar.getInstance();

			f1.setTime(dto.getAdenda().getDte_fec_inicio());

			f2.setTime(dto.getAdenda().getDte_fec_termino());


			int cantMeses = this.diferenciaFechas(dto.getAdenda().getDte_fec_inicio(), dto.getAdenda().getDte_fec_termino(), 2)+1;

			if (cantMeses == 0) {

				cantMeses = 1;

			}

			int year = f2.get(Calendar.YEAR);

			String nombreMesInicio = fm.format(dto.getAdenda().getDte_fec_inicio());

			String nombreMesFin = fm.format(dto.getAdenda().getDte_fec_termino());

			map = new HashMap<String, String>();

			map.put("#{numero.adenda}", isNull(dto.getAdenda().getVar_num_contrato()));

			map.put("#{numero.contrato.ref}",  isNull(dto.getContratoAdenda().getVar_num_contrato()));

			map.put("#{nombre.responsable.unidad}",  isNull(dto.getResponsable().getNombres()));

			map.put("#{dni.responsable}",  isNull(dto.getResponsable().getNumerodoc()));

			map.put("#{nombre.trabajador}",  isNull(dto.getTrabajador().getNombres()));

			map.put("#{dni.trabajador}",  isNull(dto.getTrabajador().getNumerodoc()));

			map.put("#{ruc.trabajador}",  isNull(dto.getTrabajador().getRuc()));

			//ADD 03-08-2015 DAVID
//			map.put("#{domicilio.trabajador}",  isNull(dto.getTrabajador().getVar_direccion_domiciliaria()));
			map.put("#{domicilio.trabajador}",  isNull(dto.getContratoAdenda().getVar_direccion_personal()));
			
			//END DAVID

			map.put("#{cargo.trabajador}",  isNull(dto.getContratoAdenda().getVar_nom_cargo()));


			map.put("#{dia.inicio}",  isNull(diaInicio));

			map.put("#{mes.inicio}",  isNull(nombreMesInicio));

			map.put("#{dia.fin}",  isNull(diaFin));

			map.put("#{mes.fin}",  isNull(nombreMesFin));

			map.put("#{fecha.suscripcion.contrato}",  isNull(fs));

			map.put("#{fecha.inicio.contrato}",  isNull(fic));

			map.put("#{fecha.fin.contrato}",  isNull(ffc));

			map.put("#{trato.trabajador}", dto.getContratoAdenda().getDes_tipo_trato());

			map.put("#{tipo.responsable.unidad}",  isNull(dto.getResponsable().getDes_tipo_responsable()));
			map.put("#{trato.responsable}", isNull(dto.getResponsable().getDes_tipo_trato()));

			map.put("#{cantidad.meses.adenda}", String.valueOf(cantMeses));
			
			if(cantMeses > 1){
				map.put("#{descriptivoCantidadMes}", "meses");
			}else{
				map.put("#{descriptivoCantidadMes}", "mes");
			}

			map.put("#{anho.adenda}", String.valueOf(year));
			map.put("#{fecha.suscripcion.adenda}", fsa);
			map.put("#{trato.responsable.unidad}", dto.getResponsable().getDes_tipo_trato());

		} else {
			
			// 05-02-2015 DAVID
			
			String nombreMesSusc 	= fechacompleta(dto.getContrato().getDte_fec_suscrip());
			
			Calendar c = Calendar.getInstance();
			c.setTime(dto.getContrato().getDte_fec_inicio());
			
			String diaInicio = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			
			// 05-02-2015 DAVID
			if(Integer.valueOf(diaInicio) < 10) diaInicio = "0"+diaInicio; 
			
			Date ft = (dto.getContrato().getDte_fec_termino() == null) ? new Date() : dto.getContrato().getDte_fec_termino();
			
			c.setTime(ft);

			String diaFin = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
			// 05-02-2015 DAVID
			if(Integer.valueOf(diaFin) < 10) diaFin = "0"+diaFin;


			String nombreMesInicio = fm.format(dto.getContrato().getDte_fec_inicio());

			String nombreMesFin = fm.format(ft);

			map = new HashMap<String, String>();

			map.put("#{numero.contrato}", isNull(dto.getContrato().getVar_num_contrato()));

			if(dto.getContrato().getSrl_id_regimen_contractual().equals(1)){
				
//				String fi = df.format(dto.getContrato().getDte_fec_inicio());
				String fi = fechacompleta(dto.getContrato().getDte_fec_inicio());

				map.put("#{fecha.inicio.contrato}", fi);
				map.put("#{num.resolucion}", isNull(dto.getContrato().getVar_num_resolucion()));
				map.put("#{nombre.responsable.sernanp}", isNull(dto.getResponsableSernanp().getNombres()));
				map.put("#{dni.responsable.sernanp}", isNull(dto.getResponsableSernanp().getNumerodoc()));
				map.put("#{trato.responsable}", isNull(dto.getResponsableSernanp().getDes_tipo_trato()));
			}else{
				map.put("#{nombre.responsable.unidad}", isNull(dto.getResponsable().getNombres()));
				map.put("#{dni.responsable}", isNull(dto.getResponsable().getNumerodoc()));
				map.put("#{tipo.responsable.unidad}", isNull(dto.getResponsable().getDes_tipo_responsable()));
				map.put("#{trato.responsable}", isNull(dto.getResponsable().getDes_tipo_trato()));
				
			}


			map.put("#{nombre.trabajador}", isNull(dto.getTrabajador().getNombres()));

			map.put("#{dni.trabajador}", isNull(dto.getTrabajador().getNumerodoc()));

			map.put("#{ruc.trabajador}", isNull(dto.getTrabajador().getRuc()));

			//ADD 03-08-2015 DAVID
			//map.put("#{domicilio.trabajador}", isNull(dto.getTrabajador().getVar_direccion_domiciliaria()));
			map.put("#{domicilio.trabajador}",  isNull(dto.getContrato().getVar_direccion_personal()));
			
			//END DAVID			
			

			map.put("#{cargo.trabajador}", isNull(dto.getContrato().getVar_nom_cargo()));

			map.put("#{sede.prestacion}", isNull(dto.getContrato().getNombre_dependencia()));

			map.put("#{numero.convocatoria}", isNull(dto.getContrato().getVar_num_convocatoria()));
			
			map.put("#{descrip.activacion}", isNull(dto.getContrato().getDescrip_num_activacion()));

			map.put("#{dia.inicio}", diaInicio);

			map.put("#{mes.inicio}", nombreMesInicio);

			map.put("#{dia.fin}", diaFin);

			map.put("#{mes.fin}", nombreMesFin);

			map.put("#{sueldo.trabajador}",NumeroLiteralUtil.getInstance().Convertir(round(dto.getContrato().getNum_sueldo(), 2) + "",false));

			map.put("#{lugar.prestacion}", isNull(dto.getContrato().getVar_lugar_prestacion()));

			// 05-02-2015 DAVID
//			map.put("#{fecha.suscripcion.contrato}", fs);
			map.put("#{fecha.suscripcion.contrato}", nombreMesSusc);
			

			map.put("#{trato.trabajador}", dto.getContrato().getDes_tipo_trato());
			
			Calendar f1 = Calendar.getInstance();
			f1.setTime(dto.getContrato().getDte_fec_inicio());
			int year = f1.get(Calendar.YEAR);
			map.put("#{anho.inicio}", String.valueOf(year));
			

		}

		ZipInputStream in = getInputStream(new File(dto.getPathTemplate()),
				"word/document.xml");

		Scanner sc = new Scanner(in, "UTF-8");

		int count = 0;

		while (sc.hasNextLine()) {

			String line = "";

			line = sc.nextLine();

			for (Entry<String, String> e : map.entrySet()) {
				if(!e.getValue().equals("")){
					line = line.replace(e.getKey(), e.getValue());
				}
			}

			if (count == 0) {

				text += line + "\n";

			} else {

				text += line;

			}

			count++;

		}

		sc.close();

		in.close();

		return text;

	}

	// 05-02-2015 DAVID
	public String fechacompleta (Date fecha){
		

		SimpleDateFormat fm 	= new SimpleDateFormat("MMMMM",new Locale("ES"));
		Calendar cs 			= Calendar.getInstance();
		
		cs.setTime(fecha);
		String diaSuscripcion = String.valueOf(cs.get(Calendar.DAY_OF_MONTH));
		
		if(Integer.valueOf(diaSuscripcion) < 10) diaSuscripcion = "0"+diaSuscripcion;
		
		String nombreMesSusc 	= diaSuscripcion + " de " + fm.format(fecha)+ " de " + String.valueOf(cs.get(Calendar.YEAR));
		return  nombreMesSusc;
	}
	
	public void preparePdf() {

		Process pk = executeCommand(PropUtil.getInstance().getPropVal("documents.properties", "comand.kill.process"));

		pk.destroy();

		p = executeCommand(PropUtil.getInstance().getPropVal("documents.properties", "comand.start.libreoffice"));

		// 1) Start LibreOffice in headless mode.

//		officeManager = new DefaultOfficeManagerConfiguration().setOfficeHome(new File(PropUtil.getInstance().getPropVal("documents.properties", "ruta.libreoffice"))).buildOfficeManager();

//		officeManager.start();

		// 2) Create JODConverter converter

//		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);

		// 3) Create PDF

		for (GenerateDocDto dto : listDto) {

//			createPdf(converter, dto);

		}

	}

//	private void createPdf(OfficeDocumentConverter converter, GenerateDocDto dto) {
//
//		try {
//
//			dto.setPathTmpPdf(dto.getPathRutaTmp() + "DOC_"
//					+ dto.getIdContrato().toString() + ".pdf");
//
//			File fPdf = new File(dto.getPathTmpPdf());
//
//			fPdf.delete();
//
//			converter.convert(new File(dto.getPathTmpDocx()),
//					new File(dto.getPathTmpPdf()));
//
//		} catch (Throwable e) {
//
//			e.printStackTrace();
//
//		}
//
//	}

	private double round(double value, int places) {

		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);

		value = value * factor;

		long tmp = Math.round(value);

		return (double) tmp / factor;

	}

//	@Override
//	public void run() {
//
//		if (officeManager != null) {
//
//			officeManager.stop();
//
//			p.destroy();
//
//			executeCommand(PropUtil.getInstance().getPropVal("documents.properties", "comand.kill.process"));
//
//		}
//
//	}

	private Process executeCommand(String command) {

		Process p = null;

		try {

			p = Runtime.getRuntime().exec(command);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return p;

	}

	public List<GenerateDocDto> getListDto() {

		return listDto;

	}

	public void setListDto(List<GenerateDocDto> listDto) {

		this.listDto = listDto;

	}
	
	public String isNull(Object obj){
		if(obj == null){
			return "";
		}else{
			return String.valueOf(obj);
		}
	}

	public int diferenciaFechas(Date fec1, Date fec2,int valor) 
	{ 
	int retorno=0; 
	Calendar cal1 = null;  
	cal1=Calendar.getInstance(); 

	Calendar cal2 = null; 
	cal2=Calendar.getInstance(); 


	// different date might have different offset 
	cal1.setTime(fec1); 
	long ldate1 = fec1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET); 

	cal2.setTime(fec2); 
	long ldate2 = fec2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET); 

	// Use integer calculation, truncate the decimals 
	int hr1 = (int)(ldate1/3600000); //60*60*1000 
	int hr2 = (int)(ldate2/3600000); 

	int days1 = (int)hr1/24; 
	int days2 = (int)hr2/24; 

	int dateDiff = days2 - days1; 
	int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR); 
	int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH); 


	if(valor==1) { 
	if (dateDiff<0) dateDiff=dateDiff*(-1); 
	retorno=dateDiff; 
	}else if(valor==2){ 
	if (monthDiff<0) monthDiff=monthDiff*(-1); 
	retorno=monthDiff; 
	}else if(valor==3){ 
	if (yearDiff<0) yearDiff=yearDiff*(-1); 
	retorno=yearDiff; 
	} 
	return retorno; 
	}
	
}