package pe.com.kapcom.facturador.ws.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportHelper {
	
    public static Map<String, String> mapContepType;
    
    static{
    	mapContepType = new HashMap<>();
    	mapContepType.put("pdf", "application/x-pdf");
    	mapContepType.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    	mapContepType.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
	
    public JasperPrint getJasperPrint(String pathJasper, Map params, List<?> list) throws JRException, IOException{
        ClassPathResource cpr = new ClassPathResource(pathJasper);
        InputStream jasperStream =  cpr.getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list,false));
        return jasperPrint;
    }
    
	public JRAbstractExporter getExporter(String doc_type, JasperPrint jasperPrint, OutputStream outStream, String fileName) throws JRException {
        if(doc_type.equals("pdf")){

            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);

            return exporter;

        }

        if(doc_type.equals("xlsx")){

            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, fileName);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);

            return exporter;

        }

        if(doc_type.equals("docx")){

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, fileName);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);

            return exporter;

        }

        return null;
    }


    public void setResponseInfo(HttpServletResponse response, String contentType, String fileName){
        response.setContentType(contentType);
        response.setHeader("Content-disposition", "inline; filename="+fileName);
    }

    public String dateToString(Date date){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String reportDate = df.format(date);
        return reportDate;

    }

    public String dateToString(Date date, String format){

        DateFormat df = new SimpleDateFormat(format);
        String reportDate = df.format(date);
        return reportDate;

    }

    public Date stringToDate(String strDate){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = df.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    
    private String checkString(String str){
    	if(StringUtils.isBlank(str)){
    		return "";
    	}else{
    		return str;
    	}
    }
}
