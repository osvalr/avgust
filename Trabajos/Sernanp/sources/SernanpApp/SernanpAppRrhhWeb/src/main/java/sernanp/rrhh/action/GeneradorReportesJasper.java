package sernanp.rrhh.action;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GeneradorReportesJasper  extends ActionSupport{

	public GeneradorReportesJasper() {		
	}

	// Usando los Archivos Jrxml (Compilados XML)
	public void jRXMLGenerateReport(Connection con, String strView, Map<String, Object> map){
		JasperReport report = null;
		JasperPrint jPrint  = null;
		File FJasper        = null;
		String strDirExp    = null;
		String strDirImp    = null;
		String strTipExp    = null;
		String strEndWith   = null;
		String strReport    = null;
		String strFile      = null;
		int nIndex              = 0;
		try {
			strReport  = (String)map.get("P_NOMBRE_ARCHIVO");
			strDirExp  = (String)map.get("P_DIRECTORIO_EXPORTAR");
			strDirImp  = (String)map.get("P_DIRECTORIO_REPORTE");
			strTipExp  = (String)map.get("P_TIPO_ARCHIVO");
			strFile    = strDirImp + strReport;
			nIndex     = strFile.indexOf(".");
			strEndWith = strFile.substring(nIndex + 1); 
			FJasper    = new File(strFile);
			if(FJasper.exists()==true){
				if(strFile.endsWith("." + strEndWith)){
					// Permite Poner los Parametros en el Reporte
					if(strView == null){
						strView = "S";
					}
					
					
					
					report  = JasperCompileManager.compileReport(strFile);
					jPrint  = JasperFillManager.fillReport(report, map, con);
					
					// Recreando el Archivo y directorio en donde se exporta el REPORTE
					strFile = strDirExp + strReport;
					
					// Genera Reporte PDF's
					if(strTipExp.equalsIgnoreCase("PDF")){
						strFile = strFile.replace("jrxml", "pdf");
						JasperExportManager.exportReportToPdfFile(jPrint, strFile);
					}

					// Genera Reporte Word
	                if (strTipExp.equalsIgnoreCase("WRD")){
						strFile                 = strFile.replace("jrxml", "doc");
	                    JRRtfExporter exportDoc = new JRRtfExporter();
	                    exportDoc.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exportDoc.setParameter(JRExporterParameter.OUTPUT_STREAM, strFile);
	                    exportDoc.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte XLS's
					if(strTipExp.equalsIgnoreCase("XLS")){
						strFile                 = strFile.replace("jrxml", "xls");
						JRXlsExporter exportXLS = new JRXlsExporter();
						exportXLS.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
						exportXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, strFile);
						exportXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
						exportXLS.exportReport();
						strView = "N";
					}
					
					// Genera Reporte HTML's
					if(strTipExp.equalsIgnoreCase("HTML")){
						strFile = strFile.replace("jrxml", "html");
						JasperExportManager.exportReportToHtmlFile(jPrint, strFile);
						strView = "N";
					}
					if(strView.equalsIgnoreCase("S")){
						JasperViewer.viewReport(jPrint, false);					
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Usando los Archivos JASPER
	public void jasperGenerateReport(Map<String, Object>  con, String strView, Map<String, Object> map){
		JasperReport report = null;
		JasperPrint jPrint  = null;
        FileOutputStream os = null;
		File FJasper        = null;
		String strDirExp    = null;
		String strDirImp    = null;
		String strTipExp    = null;
		String strEndWith   = null;
		String strReport    = null;
		String strFile      = null;
		int nIndex          = 0;
		try {
			strReport  = (String)map.get("P_NOMBRE_ARCHIVO");
			strDirExp  = (String)map.get("P_DIRECTORIO_EXPORTAR");
			strDirImp  = (String)map.get("P_DIRECTORIO_REPORTE");
			strTipExp  = (String)map.get("P_TIPO_ARCHIVO");
			strFile    = strDirImp + strReport;
			nIndex     = strFile.indexOf(".");
			strEndWith = strFile.substring(nIndex + 1); 
			FJasper    = new File(strFile);
			if(FJasper.exists()==true){
				if(strFile.endsWith("." + strEndWith)){
					// Permite Poner los Parametros en el Reporte
					if(strView == null){
						strView = "S";
					}

					report  = (JasperReport) JRLoader.loadObject(strFile);
					
//					jPrint  = JasperFillManager.fillReportToStream(report, map, con);
					jPrint  = JasperFillManager.fillReport(report, con);
					
					// Recreando el Archivo y directorio en donde se exporta el REPORTE
					strFile = strDirExp + strReport;
					
					// Creando en memoria la Salida del REPORTE a Generar
	                if (strTipExp.equalsIgnoreCase("WRD")){
	                	strFile = strFile.replace(strEndWith, "doc");
	                }else if(strTipExp.equalsIgnoreCase("XLS")){
	                	strFile = strFile.replace(strEndWith, "xls");
	                }else if(strTipExp.equalsIgnoreCase("PDF")){
	                	strFile = strFile.replace(strEndWith, "pdf");
	                }else{
	                	strFile = strFile.replace(strEndWith, "html");
	                }
	                os = new FileOutputStream(strFile);
					
					// Genera Reporte Word
	                if (strTipExp.equalsIgnoreCase("WRD")){
	                    JRRtfExporter exporter = new JRRtfExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte PDF's
	                if (strTipExp.equalsIgnoreCase("PDF")){
	                    JRPdfExporter exporter = new JRPdfExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();		                    
	                }
					
					// Genera Reporte Excel
	                if (strTipExp.equalsIgnoreCase("XLS")){
	                    JRXlsExporter exporter = new JRXlsExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte HTML
	                if (strTipExp.equalsIgnoreCase("HTML")){
	                    JRHtmlExporter exporter = new JRHtmlExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();		                    
						strView = "N";
	                }
	                
	                // Grabando en Disco y Cerrando el REPORTE Generado
	                os.flush();
	                os.close();
	                
	                // Mostrar en Pantalla el REPORTE Generado
					if(strView.equalsIgnoreCase("S")){
						JasperViewer.viewReport(jPrint, false);					
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Usando los Archivos Jrxml (Compilados XML)
	public String GenerateJasperReport(Connection con, String strView, Map<String, Object> map){
		JasperReport report = null;
		JasperPrint jPrint  = null;
        FileOutputStream os = null;
		File fJasper        = null;
		String strDirExp    = null;
		String strDirImp    = null;
		String strTipExp    = null;
		String strEndWith   = null;
		String strReport    = null;
		String strFile      = null;
		int nIndex          = 0;
		try {
			if(strView == null){
				strView = "S";
			}
			strReport = (String)map.get("P_NOMBRE_ARCHIVO");
			strDirImp = (String)map.get("P_DIRECTORIO_REPORTES");
			strFile   = strDirImp + strReport;
			fJasper   = new File(strFile);
			if(fJasper.exists()==true){
				strDirExp  = (String)map.get("P_DIRECTORIO_EXPORTAR");
				strTipExp  = (String)map.get("P_TIPO_ARCHIVO");
				nIndex     = strFile.indexOf(".");
				strEndWith = strFile.substring(nIndex + 1); 
				if(strEndWith.equalsIgnoreCase("jasper")){      // Para Archivos jasper
                    report = (JasperReport) JRLoader.loadObject(strFile);
				}else{											// Para Archivos jrxml
					report = JasperCompileManager.compileReport(strFile);	                
				}
				jPrint  = JasperFillManager.fillReport(report, map, con);
				
				// Recreando el Archivo y directorio en donde se exporta el REPORTE
				strFile = strDirExp + strReport;
/*
				// Muestra datos del MAP
				System.out.println("1. " + map.get("P_TITULO_REPORTE"));
				System.out.println("****** 2, 3 y 4.... ******");
				System.out.println("2. " + map.get("P_CODALT"));
				System.out.println("3. " + map.get("P_FECHA_INI"));
				System.out.println("4. " + map.get("P_FECHA_FIN"));
				System.out.println("5. " + map.get("P_NOMBRE_USUARIO"));
				System.out.println("6. " + map.get("P_CODIGO_EMPRESA"));
				System.out.println("7. " + map.get("P_DIRECTORIO_REPORTES"));
				System.out.println("8. " + map.get("P_DIRECTORIO_EXPORTAR"));
				System.out.println("9. " + map.get("P_TIPO_ARCHIVO"));
				System.out.println("0. " + map.get("P_NOMBRE_ARCHIVO"));
				*/
				
				
				// Creando en memoria la Salida del REPORTE a Generar
                if (strTipExp.equalsIgnoreCase("WRD")){
                	strFile = strFile.replace(strEndWith, "doc");
                }else if(strTipExp.equalsIgnoreCase("XLS")){
                	strFile = strFile.replace(strEndWith, "xls");
                }else if(strTipExp.equalsIgnoreCase("PDF")){
                	strFile = strFile.replace(strEndWith, "pdf");
                }else{
                	strFile = strFile.replace(strEndWith, "html");
                }
				
				if(strEndWith.equalsIgnoreCase("jrxml")){         // Para Archivos jrxml
					
					// Genera Reporte PDF's
					if(strTipExp.equalsIgnoreCase("PDF")){
						JasperExportManager.exportReportToPdfFile(jPrint, strFile);
					}

					// Genera Reporte Word
	                if (strTipExp.equalsIgnoreCase("WRD")){
	                	JRRtfExporter exportDoc = new JRRtfExporter();
	                    exportDoc.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exportDoc.setParameter(JRExporterParameter.OUTPUT_STREAM, strFile);
	                    exportDoc.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte XLS's
					if(strTipExp.equalsIgnoreCase("XLS")){						
						JRXlsExporter exportXLS = new JRXlsExporter();
						exportXLS.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
						exportXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, strFile);
						exportXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
						exportXLS.exportReport();
						strView = "N";
					}
					
					// Genera Reporte HTML's
					if(strTipExp.equalsIgnoreCase("HTML")){
						JasperExportManager.exportReportToHtmlFile(jPrint, strFile);
						strView = "N";
					}
				}else{
	                os = new FileOutputStream(strFile);
					
					// Genera Reporte Word
	                if (strTipExp.equalsIgnoreCase("WRD")){
	                    JRRtfExporter exporter = new JRRtfExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte PDF's
	                if (strTipExp.equalsIgnoreCase("PDF")){
	                    JRPdfExporter exporter = new JRPdfExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();		                    
	                }
					
					// Genera Reporte Excel
	                if (strTipExp.equalsIgnoreCase("XLS")){
	                    JRXlsExporter exporter = new JRXlsExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();
						strView = "N";
	                }
					
					// Genera Reporte HTML
	                if (strTipExp.equalsIgnoreCase("HTML")){
	                    JRHtmlExporter exporter = new JRHtmlExporter();
	                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
	                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
	                    exporter.exportReport();		                    
						strView = "N";
	                }
	                
	                // Grabando en Disco y Cerrando el REPORTE Generado
	                os.flush();
	                os.close();
				}
                
                // Mostrar en Pantalla el REPORTE Generado
				if(strView.equalsIgnoreCase("S")){
					JasperViewer.viewReport(jPrint, false);					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strFile;
	}

}