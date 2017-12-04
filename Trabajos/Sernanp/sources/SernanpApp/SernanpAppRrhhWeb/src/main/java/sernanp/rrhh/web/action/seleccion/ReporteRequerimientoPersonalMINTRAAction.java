/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 19/05/2015 22:46:28
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sernanp.app.business.core.common.service.CommonServiceMybatis;
import sernanp.app.business.core.seleccion.service.ReporteRequerimientoPersonalMINTRAService;
import sernanp.app.dao.query.domain.ResumenNominaPagosQuery;
import sernanp.app.dao.query.domain.RpOficioMintraQuery;
import sernanp.app.dao.query.domain.RpOficioMintraQueryCriteria;
import sernanp.app.dao.query.mapper.RpOficioMintraQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.NumeroLiteralUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteRequerimientoPersonalMINTRAAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteRequerimientoPersonalMINTRAService reporteRequerimientoPersonalMINTRAService;
	
	private RpOficioMintraQuery rpOficioMintraQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;

	private String tipoResultado;

	@Autowired
	private CommonServiceMybatis commonServiceMybatis;
	
	
	
	public String reporteOficioMintra (){		
		
		
		int srl_id_convocatoria = this.getIntegerParameter("srl_id_convocatoria").equals("") ? null : this.getIntegerParameter("srl_id_convocatoria");
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");
		
		Integer int_conv_area_org = null;		
		
		
		if(srl_id_conv_area_org == null){
			int_conv_area_org = null;
		}else{
			int_conv_area_org = Integer.parseInt(srl_id_conv_area_org);
			int_conv_area_org.intValue();
		}
		
		RpOficioMintraQueryCriteria rpOficioMintraQueryCriteria = new RpOficioMintraQueryCriteria();
		
		rpOficioMintraQueryCriteria.setInt_id_estado(rpOficioMintraQueryCriteria.getInt_id_estado());
		rpOficioMintraQueryCriteria.setIdarea_solicitante(rpOficioMintraQueryCriteria.getIdarea_solicitante());
		rpOficioMintraQueryCriteria.setSrl_id_convocatoria(srl_id_convocatoria);
		
		List<RpOficioMintraQuery> list = commonServiceMybatis.getListByQuery(RpOficioMintraQueryMapper.class,rpOficioMintraQueryCriteria); 
		
		String ultimaConvocatoria = null;
		
		for(RpOficioMintraQuery j : list){			
			
			
			if(j.getUltimo_lanzamiento() != null){
				if(ultimaConvocatoria == null){
					ultimaConvocatoria = j.getUltimo_lanzamiento();
				}else{
					if(!j.getUltimo_lanzamiento().contentEquals(ultimaConvocatoria)){
						ultimaConvocatoria = ultimaConvocatoria + ", " + j.getUltimo_lanzamiento();	
					}
						
				}
				 
				j.setVar_denominacion_requerimiento(j.getVar_denominacion_requerimiento() + " (*)");				
			}
			
			j.setVar_denominacion_requerimiento(NumeroLiteralUtil.getInstance().ConvertirToLetras(j.getInt_cantidad_requerida() + "",false) + " " +	j.getVar_denominacion_requerimiento());
		}
		
//		if(ultimaConvocatoria != null){
//			for(RpOficioMintraQuery j : list){				
//				j.setUltimo_lanzamiento(ultimaConvocatoria);
//				j.setFlag_segunda_convocataria("Si");
//			}		
//			
//		}
		
		Map parametros	= new HashMap();
		
		JRMapCollectionDataSource listMapDetalleCab_DS = new JRMapCollectionDataSource((Collection)list);
		parametros.put("datos", listMapDetalleCab_DS);
		
		jasperGenerateReport(parametros, null);
		
		listResult = 	list;
		
		tipoResultado ="pdf";
		return tipoResultado;
	}
	
	
	
	public void jasperGenerateReport(Map parametros, String strView){
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
			strReport  = "ReporteRequerimientoMintra.jasper";
			strDirExp  = "/Datos/Otros/";
			strDirImp  = "/Datos/DesarrolloSW/Proyectos/SernanpApp/SernanpAppRrhhWeb/src/main/webapp/jasper/seleccion/";
			strTipExp  = "WRD";
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

					report  = (JasperReport) JRLoader.loadObject(FJasper);
//							loadObject(strFile);
					
//					jPrint  = JasperFillManager.fillReportToStream(report, map, con);
					
					jPrint  = JasperFillManager. fillReport(report, parametros);
					
					// Recreando el Archivo y directorio en donde se exporta el REPORTE
					strFile = strDirExp + strReport;
					
					// Creando en memoria la Salida del REPORTE a Generar
	                if (strTipExp.equalsIgnoreCase("WRD")){
	                	strFile = strFile.replace(strEndWith, "doc");	         
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

	
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpOficioMintraQueryCriteria rpOficioMintraQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpOficioMintraQueryCriteria.class);
			List<RpOficioMintraQuery> listRpOficioMintraQuery = reporteRequerimientoPersonalMINTRAService.getListByQuery(RpOficioMintraQueryMapper.class, rpOficioMintraQueryCriteria, start, limit);
			int total = reporteRequerimientoPersonalMINTRAService.getCountRowsByQuery(RpOficioMintraQueryMapper.class, rpOficioMintraQueryCriteria);
			
			this.success(listRpOficioMintraQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteRequerimientoPersonalMINTRAService.create(rpOficioMintraQuery);
			this.success(rpOficioMintraQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteRequerimientoPersonalMINTRAService.save(rpOficioMintraQuery);
			this.success(rpOficioMintraQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteRequerimientoPersonalMINTRAService.remove(rpOficioMintraQuery);
			this.extjsReturn.setSuccess(true);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public ReporteRequerimientoPersonalMINTRAService getReporteRequerimientoPersonalMINTRAService() {
		return reporteRequerimientoPersonalMINTRAService;
	}

	public void setReporteRequerimientoPersonalMINTRAService(ReporteRequerimientoPersonalMINTRAService reporteRequerimientoPersonalMINTRAService) {
		this.reporteRequerimientoPersonalMINTRAService = reporteRequerimientoPersonalMINTRAService;
	}

	public RpOficioMintraQuery getRpOficioMintraQuery() {
		return rpOficioMintraQuery;
	}

	public void setRpOficioMintraQuery(RpOficioMintraQuery rpOficioMintraQuery) {
		this.rpOficioMintraQuery = rpOficioMintraQuery;
	}




	public List getListResult() {
		return listResult;
	}




	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteRequerimientoPersonalMINTRA -->
<action name="ReporteRequerimientoPersonalMINTRAView" class="sernanp.rrhh.web.action.seleccion.ReporteRequerimientoPersonalMINTRAAction" method="view">
		<result type="json" />
</action>

<action name="ReporteRequerimientoPersonalMINTRACreate" class="sernanp.rrhh.web.action.seleccion.ReporteRequerimientoPersonalMINTRAAction" method="create">
		<result type="json" />
</action>

<action name="ReporteRequerimientoPersonalMINTRASave" class="sernanp.rrhh.web.action.seleccion.ReporteRequerimientoPersonalMINTRAAction" method="save">
		<result type="json" />
</action>

<action name="ReporteRequerimientoPersonalMINTRARemove" class="sernanp.rrhh.web.action.seleccion.ReporteRequerimientoPersonalMINTRAAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteRequerimientoPersonalMINTRA -->
*/

}
