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
* DATE CREATE : 13/07/2015 14:25:29
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.seleccion.service.ReporteSeleccionPostulantesEntrevistaPersonalService;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEntrevistaPersonalQuery;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEntrevistaPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.RpSeleccionPostulantesEntrevistaPersonalQueryMapper;

public class ReporteSeleccionPostulantesEntrevistaPersonalAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteSeleccionPostulantesEntrevistaPersonalService reporteSeleccionPostulantesEntrevistaPersonalService;
	
	private RpSeleccionPostulantesEntrevistaPersonalQuery rpSeleccionPostulantesEntrevistaPersonalQuery;
	
	String resultado;
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	public String reportePostulantesEntrevistaPersonal(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String numerodoc = this.getParameter("numerodoc").equals("") ? null : this.getParameter("numerodoc");
		String srl_id_convocatoria = this.getParameter("srl_id_convocatoria").equals("") ? null : this.getParameter("srl_id_convocatoria");		
		String srl_id_conv_area_org = this.getParameter("srl_id_conv_area_org").equals("") ? null : this.getParameter("srl_id_conv_area_org");	
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");

		Integer convocatoria = null;
		
		if(srl_id_convocatoria==null){
			convocatoria = null;
		}else{
			convocatoria =Integer.parseInt(srl_id_convocatoria);
			convocatoria.intValue();
		}
		
		Integer cod_postulacion = null;
		
		if(srl_id_conv_area_org == null){
			cod_postulacion = null;
		}else{
			cod_postulacion = Integer.parseInt(srl_id_conv_area_org);
			cod_postulacion.intValue();
		}
		
		RpSeleccionPostulantesEntrevistaPersonalQueryCriteria criteria = new RpSeleccionPostulantesEntrevistaPersonalQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setNumerodoc(numerodoc);
		criteria.setSrl_id_convocatoria(convocatoria);
		criteria.setSrl_id_conv_area_org(cod_postulacion);
		
		listResult = reporteSeleccionPostulantesEntrevistaPersonalService.getListByQuery(RpSeleccionPostulantesEntrevistaPersonalQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	}
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpSeleccionPostulantesEntrevistaPersonalQueryCriteria rpSeleccionPostulantesEntrevistaPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpSeleccionPostulantesEntrevistaPersonalQueryCriteria.class);
			List<RpSeleccionPostulantesEntrevistaPersonalQuery> listRpSeleccionPostulantesEntrevistaPersonalQuery = reporteSeleccionPostulantesEntrevistaPersonalService.getListByQuery(RpSeleccionPostulantesEntrevistaPersonalQueryMapper.class, rpSeleccionPostulantesEntrevistaPersonalQueryCriteria, start, limit);
			int total = reporteSeleccionPostulantesEntrevistaPersonalService.getCountRowsByQuery(RpSeleccionPostulantesEntrevistaPersonalQueryMapper.class, rpSeleccionPostulantesEntrevistaPersonalQueryCriteria);
			
			this.success(listRpSeleccionPostulantesEntrevistaPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteSeleccionPostulantesEntrevistaPersonalService.create(rpSeleccionPostulantesEntrevistaPersonalQuery);
			this.success(rpSeleccionPostulantesEntrevistaPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteSeleccionPostulantesEntrevistaPersonalService.save(rpSeleccionPostulantesEntrevistaPersonalQuery);
			this.success(rpSeleccionPostulantesEntrevistaPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteSeleccionPostulantesEntrevistaPersonalService.remove(rpSeleccionPostulantesEntrevistaPersonalQuery);
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
	
	public ReporteSeleccionPostulantesEntrevistaPersonalService getReporteSeleccionPostulantesEntrevistaPersonalService() {
		return reporteSeleccionPostulantesEntrevistaPersonalService;
	}

	public void setReporteSeleccionPostulantesEntrevistaPersonalService(ReporteSeleccionPostulantesEntrevistaPersonalService reporteSeleccionPostulantesEntrevistaPersonalService) {
		this.reporteSeleccionPostulantesEntrevistaPersonalService = reporteSeleccionPostulantesEntrevistaPersonalService;
	}

	public RpSeleccionPostulantesEntrevistaPersonalQuery getRpSeleccionPostulantesEntrevistaPersonalQuery() {
		return rpSeleccionPostulantesEntrevistaPersonalQuery;
	}

	public void setRpSeleccionPostulantesEntrevistaPersonalQuery(RpSeleccionPostulantesEntrevistaPersonalQuery rpSeleccionPostulantesEntrevistaPersonalQuery) {
		this.rpSeleccionPostulantesEntrevistaPersonalQuery = rpSeleccionPostulantesEntrevistaPersonalQuery;
	}


	public List getListResult() {
		return listResult;
	}


	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteSeleccionPostulantesEntrevistaPersonal -->
<action name="ReporteSeleccionPostulantesEntrevistaPersonalView" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEntrevistaPersonalAction" method="view">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEntrevistaPersonalCreate" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEntrevistaPersonalAction" method="create">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEntrevistaPersonalSave" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEntrevistaPersonalAction" method="save">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEntrevistaPersonalRemove" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEntrevistaPersonalAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteSeleccionPostulantesEntrevistaPersonal -->
*/

}
