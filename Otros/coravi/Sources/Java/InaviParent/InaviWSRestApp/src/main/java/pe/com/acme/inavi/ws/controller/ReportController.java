package pe.com.acme.inavi.ws.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.acme.domain.mybatis.mapper.PersonaMapper;
import pe.com.acme.domain.mybatis.model.Persona;
import pe.com.acme.domain.mybatis.model.PersonaExample;
import pe.com.acme.inavi.business.implement.InaviCommonServiceImpl;
import pe.com.acme.inavi.business.util.InaviConstantes;
import pe.com.acme.query.mybatis.mapper.*;
import pe.com.acme.query.mybatis.model.*;
import pe.com.acme.util.JsonReturnUtil;
import pe.com.acme.util.web.ControllerHelper;

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

/**
 * Created by JRaffo on 26/04/16.
 */
@Controller
@RequestMapping("/report")
public class ReportController extends ControllerHelper {


    private static Logger log = Logger.getLogger(ReportController.class);

    @Autowired
    private InaviCommonServiceImpl inaviCommonServiceImpl;

    private static final String MIME_PDF = "application/x-pdf";
    private static final String MIME_DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    private static final String MIME_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @RequestMapping(value = "/ventasPorClienteReport")
    @ResponseBody
    public void ventasPorClienteReport(String id_cliente, String fecha_inicio, String fecha_fin, String doc_type, HttpServletResponse response) throws JRException, IOException {


        try{
        	if(fecha_fin.equals(StringUtils.EMPTY)){
        		fecha_fin = null;
        	}
        	Integer int_id_cliente = null;
        	
        	if(this.isInteger(id_cliente)){
        		int_id_cliente = Integer.parseInt(id_cliente);
        	}
        	
            VentasPorClienteReportQueryCriteria criteria = new VentasPorClienteReportQueryCriteria();

            criteria.setFecha_inicio(fecha_inicio);
            criteria.setFecha_fin(fecha_fin);
            criteria.setId_cliente(int_id_cliente);

            List<VentasPorClienteReportQuery> list = inaviCommonServiceImpl.selectByQuery(VentasPorClienteReportQueryMapper.class,criteria);

            Map<String,Object> params = new HashMap<>();
//            params.put("nom_cliente",this.obtenerNombreCliente(id_cliente));
            params.put("periodo",fecha_inicio+" - "+fecha_fin);
            params.put("fecha_generacion",this.dateToString(new Date()));

            ClassPathResource cpr = new ClassPathResource("/report/VentasPorClienteReport.jasper");
            InputStream jasperStream =  cpr.getInputStream();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list,false));

            String mime = this.getMime(doc_type);
            String fileName = "reporte_ventas_cliente"+"."+doc_type;

            this.setResponseInfo(response,mime,fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type,jasperPrint,outStream,fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @RequestMapping(value = "/guiasPorCobrar")
    @ResponseBody
    public void guiasPorCobrar(String doc_type,String id_cliente, HttpServletResponse response) throws JRException, IOException {


        try{

        	Integer int_id_cliente = null;
        	
        	if(this.isInteger(id_cliente)){
        		int_id_cliente = Integer.parseInt(id_cliente);
        	}
        	
            CobrosPendientesReportQueryCriteria criteria = new CobrosPendientesReportQueryCriteria();
            criteria.setId_cliente(int_id_cliente);
            
            List<CobrosPendientesReportQuery> list = inaviCommonServiceImpl.selectByQuery(CobrosPendientesReportQueryMapper.class,criteria);

            Map<String,Object> params = new HashMap<>();
            params.put("fecha_generacion",this.dateToString(new Date()));

            ClassPathResource cpr = new ClassPathResource("/report/CobrosPendientesReport.jasper");
            InputStream jasperStream =  cpr.getInputStream();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list,false));

            String mime = this.getMime(doc_type);
            String fileName = "reporte_guias_cobrar."+doc_type;

            this.setResponseInfo(response,mime,fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type,jasperPrint,outStream,fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @RequestMapping(value = "/resumenCompraVenta")
    @ResponseBody
    public void resumenCompraVenta(String fecha_jornada, String doc_type, HttpServletResponse response) throws JRException, IOException {


        try{

            ResumenCompraVentaReportQueryCriteria criteria = new ResumenCompraVentaReportQueryCriteria();
            criteria.setFecha_jornada(fecha_jornada);

            List<ResumenCompraVentaReportQuery> list = inaviCommonServiceImpl.selectByQuery(ResumenCompraVentaReportQueryMapper.class,criteria);
            String[] fecha = fecha_jornada.split("/");
            
            int anio = Integer.parseInt(fecha[2]);
            int mes = Integer.parseInt(fecha[1]);
            int dia = Integer.parseInt(fecha[0]);
            
            TotalGuiasPeriodoTipoMvtoQuery totalGuiasCompra;
            TotalGuiasPeriodoTipoMvtoQuery totalGuiasVenta;
            
            {
            	
                TotalGuiasPeriodoTipoMvtoQueryCriteria totalGuiasPeriodoTipoMvtoQueryCriteria = new TotalGuiasPeriodoTipoMvtoQueryCriteria();
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_anio(anio);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_mes(mes);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_dia(dia);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setId_tipo_mvto_guia(InaviConstantes.TIPO_MVTO_GUIA_COMPRA);
                
                totalGuiasCompra = inaviCommonServiceImpl.selectOneByQuery(TotalGuiasPeriodoTipoMvtoQueryMapper.class, totalGuiasPeriodoTipoMvtoQueryCriteria);
                            	
            }
            
            {
            	
                TotalGuiasPeriodoTipoMvtoQueryCriteria totalGuiasPeriodoTipoMvtoQueryCriteria = new TotalGuiasPeriodoTipoMvtoQueryCriteria();
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_anio(anio);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_mes(mes);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setNum_dia(dia);
                totalGuiasPeriodoTipoMvtoQueryCriteria.setId_tipo_mvto_guia(InaviConstantes.TIPO_MVTO_GUIA_VENTA);
                
                totalGuiasVenta = inaviCommonServiceImpl.selectOneByQuery(TotalGuiasPeriodoTipoMvtoQueryMapper.class, totalGuiasPeriodoTipoMvtoQueryCriteria);
                            	
            }
            
            double ganancia = totalGuiasVenta.getTotal_importe().doubleValue() - totalGuiasCompra.getTotal_importe().doubleValue();
            double pesoPromedioCompra = totalGuiasCompra.getTotal_peso_neto().doubleValue() / totalGuiasCompra.getTotal_aves_vendidas().intValue();
            double pesoPromedioVenta = totalGuiasVenta.getTotal_peso_neto().doubleValue() / totalGuiasVenta.getTotal_aves_vendidas().intValue();
            double merma = pesoPromedioCompra - pesoPromedioVenta;

            Map<String,Object> params = new HashMap<>();
            params.put("fecha_generacion",this.dateToString(new Date()));
            params.put("fecha_jornada",fecha_jornada);
            params.put("ganancia",ganancia);
            params.put("pesoPromedioCompra",pesoPromedioCompra);
            params.put("pesoPromedioVenta",pesoPromedioVenta);
            params.put("merma",merma);
            params.put("total_aves_vendidas",totalGuiasVenta.getTotal_aves_vendidas());
            params.put("total_peso_neto",totalGuiasVenta.getTotal_peso_neto());

            ClassPathResource cpr = new ClassPathResource("/report/ResumenCompraVentaReport.jasper");
            InputStream jasperStream =  cpr.getInputStream();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list,false));

            String mime = this.getMime(doc_type);
            String fileName = "resumen_compra_venta."+doc_type;

            this.setResponseInfo(response,mime,fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type,jasperPrint,outStream,fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @RequestMapping(value = "/resumenPagosPorFechasReport")
    @ResponseBody
    public void resumenPagosPorFechas(Integer id_cliente, String fecha_inicio, String fecha_fin, String doc_type, HttpServletResponse response) throws JRException, IOException {


        String periodo = null;
        try{
            if(fecha_fin.equals(StringUtils.EMPTY)){
                fecha_fin = null;
                periodo = fecha_inicio + " - " + this.dateToString(new Date(),"dd/MM/yyyy");
            }else{
                 periodo = fecha_inicio+" - "+fecha_fin;
            }

            ResumenPagosPorFechaQueryCriteria criteria = new ResumenPagosPorFechaQueryCriteria();

            criteria.setFecha_inicio(this.stringToDate(fecha_inicio));
            criteria.setFecha_fin(this.stringToDate(fecha_fin));
            criteria.setFechaCorte(fecha_inicio);
            criteria.setId_cliente(id_cliente);

            List<ResumenPagosPorFechaQuery> list = inaviCommonServiceImpl.selectByQuery(ResumenPagosPorFechaQueryMapper.class,criteria);

            Map<String,Object> params = new HashMap<>();
            params.put("periodo",periodo);
            params.put("fecha_generacion",this.dateToString(new Date()));

            ClassPathResource cpr = new ClassPathResource("/report/ResumenPagosPorFechas.jasper");
            InputStream jasperStream =  cpr.getInputStream();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(list,false));

            String mime = this.getMime(doc_type);
            String fileName = "resumen_pagos_por_fechas"+"."+doc_type;

            this.setResponseInfo(response,mime,fileName);

            final OutputStream outStream = response.getOutputStream();

            JRAbstractExporter exporter = this.getExporter(doc_type,jasperPrint,outStream,fileName);

            exporter.exportReport();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @RequestMapping(value = "/resumenPagosPorFechasJson")
    public @ResponseBody Map<String,? extends Object> resumenPagosPorFechasJson(Integer id_cliente, String fecha_inicio, String fecha_fin) throws IOException {

        try{
            if(fecha_fin.equals(StringUtils.EMPTY)){
                fecha_fin = null;
            }

            ResumenPagosPorFechaQueryCriteria criteria = new ResumenPagosPorFechaQueryCriteria();

            criteria.setFecha_inicio(this.stringToDate(fecha_inicio));
            criteria.setFecha_fin(this.stringToDate(fecha_fin));
            criteria.setFechaCorte(fecha_inicio);
            criteria.setId_cliente(id_cliente);

            List<ResumenPagosPorFechaQuery> list = inaviCommonServiceImpl.selectByQuery(ResumenPagosPorFechaQueryMapper.class,criteria);

            return JsonReturnUtil.success(list,list.size());

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonReturnUtil.exception(e.getMessage());
        }
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

    public String getMime(String doc_type){
        if(doc_type.equals("pdf")){
            return MIME_PDF;
        }
        if(doc_type.equals("docx")){
            return MIME_DOCX;
        }
        if(doc_type.equals("xlsx")){
            return MIME_XLSX;
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

    private String obtenerNombreCliente(Integer id_cliente) throws Exception {

        String nombre="";

        PersonaExample example = new PersonaExample();
        example.createCriteria().andId_personaEqualTo(id_cliente);

        Persona persona = this.inaviCommonServiceImpl.selectOneByExample(PersonaMapper.class,example);

        if(persona!=null){
            nombre = this.checkString(persona.getNombres())  + " "+ this.checkString(persona.getApe_pater()) + " " + this.checkString(persona.getApe_mater()) ;
        }

        return nombre;
    }
    
    private String checkString(String str){
    	if(StringUtils.isBlank(str)){
    		return "";
    	}else{
    		return str;
    	}
    }
}
