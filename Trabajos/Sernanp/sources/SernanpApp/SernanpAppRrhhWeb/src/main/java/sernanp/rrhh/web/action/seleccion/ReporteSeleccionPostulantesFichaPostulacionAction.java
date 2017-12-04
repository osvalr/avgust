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
* DATE CREATE : 10/07/2015 13:32:32
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.seleccion.service.ReporteSeleccionPostulantesFichaPostulacionService;
import sernanp.app.dao.query.domain.RpPostulantesInscritosQueryCriteria;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesFichaPostulacionQuery;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesFichaPostulacionQueryCriteria;
import sernanp.app.dao.query.mapper.RpPostulantesInscritosQueryMapper;
import sernanp.app.dao.query.mapper.RpSeleccionPostulantesFichaPostulacionQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.app.util.PropUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteSeleccionPostulantesFichaPostulacionAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteSeleccionPostulantesFichaPostulacionService reporteSeleccionPostulantesFichaPostulacionService;
	
	private RpSeleccionPostulantesFichaPostulacionQuery rpSeleccionPostulantesFichaPostulacionQuery;
	
	String resultado;
	@SuppressWarnings("rawtypes")
	private List listResult;
	private Map reportParameters;
	
	public String reporteFichaPostulacion(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String numerodoc = this.getParameter("numerodoc").equals("") ? null : this.getParameter("numerodoc");
		String srl_id_convocatoria = this.getParameter("srl_id_convocatoria").equals("") ? null : this.getParameter("srl_id_convocatoria");		
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");	
		String int_id_tipo_factor	= this.getParameter("int_id_tipo_factor").equals("") ? null : this.getParameter("int_id_tipo_factor");
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
		Integer plaza = null;
		Integer int_id_tipo_factor_ = null;
		
		if(srl_id_convocatoria==null){
			convocatoria = null;
		}else{
			convocatoria =Integer.parseInt(srl_id_convocatoria);
			convocatoria.intValue();
		}
		
		if(srl_id_conv_area_org==null){
			plaza = null;
		}else{
			plaza = Integer.parseInt(srl_id_conv_area_org);
			plaza.intValue();
		}
		
		if(int_id_tipo_factor == null){
			int_id_tipo_factor_ = null;
		}else{
			int_id_tipo_factor_ = Integer.parseInt(int_id_tipo_factor);
			int_id_tipo_factor_.intValue();
			
		}
		
		RpSeleccionPostulantesFichaPostulacionQueryCriteria criteria = new RpSeleccionPostulantesFichaPostulacionQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setNumerodoc(numerodoc);
		criteria.setSrl_id_convocatoria(convocatoria);
		criteria.setSrl_id_conv_area_org(plaza);
		criteria.setInt_id_tipo_factor(int_id_tipo_factor_);		
		
		/*ADD TO FILTER FOR UNIDAD OPERATIVA*/
		criteria.setSrl_id_sede_req_sel(sede_administrativa);
//		criteria.setSrl_id_sede_uni_ope_anp(sede_unidad_operativa_anp);
		/*END*/
		
		listResult = reporteSeleccionPostulantesFichaPostulacionService.getListByQuery(RpSeleccionPostulantesFichaPostulacionQueryMapper.class, criteria);
		
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
			
			RpSeleccionPostulantesFichaPostulacionQueryCriteria rpSeleccionPostulantesFichaPostulacionQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpSeleccionPostulantesFichaPostulacionQueryCriteria.class);
			
			List<RpSeleccionPostulantesFichaPostulacionQuery> listRpSeleccionPostulantesFichaPostulacionQuery = 
					reporteSeleccionPostulantesFichaPostulacionService.getListByQuery(RpSeleccionPostulantesFichaPostulacionQueryMapper.class, rpSeleccionPostulantesFichaPostulacionQueryCriteria, start, limit);
			int total = reporteSeleccionPostulantesFichaPostulacionService.getCountRowsByQuery(RpSeleccionPostulantesFichaPostulacionQueryMapper.class, rpSeleccionPostulantesFichaPostulacionQueryCriteria);
			System.out.println("ReporteSeleccionPostulantesFichaPostulacionView - view --> " + total);
			this.success(listRpSeleccionPostulantesFichaPostulacionQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteSeleccionPostulantesFichaPostulacionService.create(rpSeleccionPostulantesFichaPostulacionQuery);
			this.success(rpSeleccionPostulantesFichaPostulacionQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteSeleccionPostulantesFichaPostulacionService.save(rpSeleccionPostulantesFichaPostulacionQuery);
			this.success(rpSeleccionPostulantesFichaPostulacionQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteSeleccionPostulantesFichaPostulacionService.remove(rpSeleccionPostulantesFichaPostulacionQuery);
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
	
	public ReporteSeleccionPostulantesFichaPostulacionService getReporteSeleccionPostulantesFichaPostulacionService() {
		return reporteSeleccionPostulantesFichaPostulacionService;
	}

	public void setReporteSeleccionPostulantesFichaPostulacionService(ReporteSeleccionPostulantesFichaPostulacionService reporteSeleccionPostulantesFichaPostulacionService) {
		this.reporteSeleccionPostulantesFichaPostulacionService = reporteSeleccionPostulantesFichaPostulacionService;
	}

	public RpSeleccionPostulantesFichaPostulacionQuery getRpSeleccionPostulantesFichaPostulacionQuery() {
		return rpSeleccionPostulantesFichaPostulacionQuery;
	}

	public void setRpSeleccionPostulantesFichaPostulacionQuery(RpSeleccionPostulantesFichaPostulacionQuery rpSeleccionPostulantesFichaPostulacionQuery) {
		this.rpSeleccionPostulantesFichaPostulacionQuery = rpSeleccionPostulantesFichaPostulacionQuery;
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
<!-- Start Actions ReporteSeleccionPostulantesFichaPostulacion -->
<action name="ReporteSeleccionPostulantesFichaPostulacionView" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesFichaPostulacionAction" method="view">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesFichaPostulacionCreate" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesFichaPostulacionAction" method="create">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesFichaPostulacionSave" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesFichaPostulacionAction" method="save">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesFichaPostulacionRemove" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesFichaPostulacionAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteSeleccionPostulantesFichaPostulacion -->
*/

}
