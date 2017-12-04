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
* DATE CREATE : 25/06/2015 14:27:10
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.seleccion.service.ReporteContratoSuscritosYNoSuscritosService;
import sernanp.app.dao.query.domain.RpPostulantesInscritosQueryCriteria;
import sernanp.app.dao.query.domain.RpSeleccionContratosSuscritosNoSuscritosQuery;
import sernanp.app.dao.query.domain.RpSeleccionContratosSuscritosNoSuscritosQueryCriteria;
import sernanp.app.dao.query.mapper.RpPostulantesInscritosQueryMapper;
import sernanp.app.dao.query.mapper.RpSeleccionContratosSuscritosNoSuscritosQueryMapper;

public class ReporteContratoSuscritosYNoSuscritosAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteContratoSuscritosYNoSuscritosService reporteContratoSuscritosYNoSuscritosService;
	
	private RpSeleccionContratosSuscritosNoSuscritosQuery rpSeleccionContratosSuscritosNoSuscritosQuery;
	
	String resultado;
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Map reportParameters;
	
	public String reporteContratosSuscritosNoSuscritos(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String numerodoc = this.getParameter("numerodoc").equals("") ? null : this.getParameter("numerodoc");
		String int_id_estado = this.getParameter("int_id_estado").equals("") ? null : this.getParameter("int_id_estado");
		String srl_id_convocatoria = this.getParameter("srl_id_convocatoria").equals("") ? null : this.getParameter("srl_id_convocatoria");		
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");	
//		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");

		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/		
		String srl_id_sede_req_sel	= this.getParameter("srl_id_sede_req_sel").equals("") ? null : this.getParameter("srl_id_sede_req_sel");
//		String srl_id_sede_uni_ope_anp	= this.getParameter("srl_id_sede_uni_ope_anp").equals("") ? null : this.getParameter("srl_id_sede_uni_ope_anp");
		
		Integer sede_administrativa = null;
		
		if(srl_id_sede_req_sel == null){
			sede_administrativa = null;
		}else{
			sede_administrativa = Integer.parseInt(srl_id_sede_req_sel);
		}		
		
		
		/*END*/
		
		Integer convocatoria = null;
		Integer contrato = null;
		Integer plaza = null;
		
		if(srl_id_convocatoria==null){
			convocatoria = null;
		}else{
			convocatoria =Integer.parseInt(srl_id_convocatoria);
			convocatoria.intValue();
		}

		
		if(int_id_estado == null){
			contrato = null;

		}else{
			contrato = Integer.parseInt(int_id_estado);
			contrato.intValue();			
		}
		

		if(srl_id_conv_area_org==null){
			plaza = null;
		}else{
			plaza = Integer.parseInt(srl_id_conv_area_org);
			plaza.intValue();
		}
		
		RpSeleccionContratosSuscritosNoSuscritosQueryCriteria criteria = new RpSeleccionContratosSuscritosNoSuscritosQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setNumerodoc(numerodoc);
		criteria.setInt_id_estado(contrato);
		criteria.setSrl_id_convocatoria(convocatoria);
		criteria.setSrl_id_conv_area_org(plaza);
		
		
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
		criteria.setSrl_id_sede_req_sel(sede_administrativa);
//		criteria.setSrl_id_sede_uni_ope_anp(sede_unidad_operativa_anp);
		/*END*/
		
		/*ADD TO FILTER FOR ESTADO POSTULANTE*/
		/*
		if(criteria.getInt_id_estado() == null){

//			criteria.setInt_id_estado(null);
			criteria.setInt_estado_postulante_prop(6);
			
		}else{

			if(criteria.getInt_id_estado() == 6){
				criteria.setInt_id_estado(null);
				criteria.setInt_estado_postulante_prop(3);
			}else{
				criteria.setInt_estado_postulante_prop(6);
			}

		}
		*/
		/*END*/
		
		listResult = reporteContratoSuscritosYNoSuscritosService.getListByQuery(RpSeleccionContratosSuscritosNoSuscritosQueryMapper.class, criteria);
		
		if (listResult.size() > 0){
			String ruta = PropUtil.getInstance().getPropVal("personal.properties", "ruta.logo");
			
			reportParameters = new HashMap();

			reportParameters.put("logo", ruta);		
	
		}
		
//		return resultado = tipo_reporte;
		return SUCCESS;
	}
	
	
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpSeleccionContratosSuscritosNoSuscritosQueryCriteria rpSeleccionContratosSuscritosNoSuscritosQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpSeleccionContratosSuscritosNoSuscritosQueryCriteria.class);
/*			
			if(rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.getInt_id_estado() == null){

				rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.setInt_id_estado(null);
				rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.setInt_estado_postulante_prop(6);
				
			}else{

				if(rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.getInt_id_estado() == 6){
					rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.setInt_id_estado(null);
					rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.setInt_estado_postulante_prop(3);
				}else{
					rpSeleccionContratosSuscritosNoSuscritosQueryCriteria.setInt_estado_postulante_prop(6);
				}

			}
*/
			List<RpSeleccionContratosSuscritosNoSuscritosQuery> listRpSeleccionContratosSuscritosNoSuscritosQuery = 
					reporteContratoSuscritosYNoSuscritosService.getListByQuery(RpSeleccionContratosSuscritosNoSuscritosQueryMapper.class, rpSeleccionContratosSuscritosNoSuscritosQueryCriteria, start, limit);
			int total = reporteContratoSuscritosYNoSuscritosService.getCountRowsByQuery(RpSeleccionContratosSuscritosNoSuscritosQueryMapper.class, rpSeleccionContratosSuscritosNoSuscritosQueryCriteria);
			
			this.success(listRpSeleccionContratosSuscritosNoSuscritosQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteContratoSuscritosYNoSuscritosService.create(rpSeleccionContratosSuscritosNoSuscritosQuery);
			this.success(rpSeleccionContratosSuscritosNoSuscritosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteContratoSuscritosYNoSuscritosService.save(rpSeleccionContratosSuscritosNoSuscritosQuery);
			this.success(rpSeleccionContratosSuscritosNoSuscritosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteContratoSuscritosYNoSuscritosService.remove(rpSeleccionContratosSuscritosNoSuscritosQuery);
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
	
	public ReporteContratoSuscritosYNoSuscritosService getReporteContratoSuscritosYNoSuscritosService() {
		return reporteContratoSuscritosYNoSuscritosService;
	}

	public void setReporteContratoSuscritosYNoSuscritosService(ReporteContratoSuscritosYNoSuscritosService reporteContratoSuscritosYNoSuscritosService) {
		this.reporteContratoSuscritosYNoSuscritosService = reporteContratoSuscritosYNoSuscritosService;
	}

	public RpSeleccionContratosSuscritosNoSuscritosQuery getRpSeleccionContratosSuscritosNoSuscritosQuery() {
		return rpSeleccionContratosSuscritosNoSuscritosQuery;
	}

	public void setRpSeleccionContratosSuscritosNoSuscritosQuery(RpSeleccionContratosSuscritosNoSuscritosQuery rpSeleccionContratosSuscritosNoSuscritosQuery) {
		this.rpSeleccionContratosSuscritosNoSuscritosQuery = rpSeleccionContratosSuscritosNoSuscritosQuery;
	}





	public List getListResult() {
		return listResult;
	}





	public void setListResult(List listResult) {
		this.listResult = listResult;
	}





	public Map getReportParameters() {
		return reportParameters;
	}





	public void setReportParameters(Map reportParameters) {
		this.reportParameters = reportParameters;
	}

/*
<!-- Start Actions ReporteContratoSuscritosYNoSuscritos -->
<action name="ReporteContratoSuscritosYNoSuscritosView" class="sernanp.rrhh.web.action.seleccion.ReporteContratoSuscritosYNoSuscritosAction" method="view">
		<result type="json" />
</action>

<action name="ReporteContratoSuscritosYNoSuscritosCreate" class="sernanp.rrhh.web.action.seleccion.ReporteContratoSuscritosYNoSuscritosAction" method="create">
		<result type="json" />
</action>

<action name="ReporteContratoSuscritosYNoSuscritosSave" class="sernanp.rrhh.web.action.seleccion.ReporteContratoSuscritosYNoSuscritosAction" method="save">
		<result type="json" />
</action>

<action name="ReporteContratoSuscritosYNoSuscritosRemove" class="sernanp.rrhh.web.action.seleccion.ReporteContratoSuscritosYNoSuscritosAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteContratoSuscritosYNoSuscritos -->
*/

}
