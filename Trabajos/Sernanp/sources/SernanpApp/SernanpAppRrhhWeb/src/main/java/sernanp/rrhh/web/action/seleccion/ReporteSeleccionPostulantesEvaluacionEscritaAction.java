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
* DATE CREATE : 13/07/2015 13:44:48
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.seleccion.service.ReporteSeleccionPostulantesEvaluacionEscritaService;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEvaluacionEscritaQuery;
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEvaluacionEscritaQueryCriteria;
import sernanp.app.dao.query.mapper.RpSeleccionPostulantesEvaluacionEscritaQueryMapper;

public class ReporteSeleccionPostulantesEvaluacionEscritaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteSeleccionPostulantesEvaluacionEscritaService reporteSeleccionPostulantesEvaluacionEscritaService;
	
	private RpSeleccionPostulantesEvaluacionEscritaQuery rpSeleccionPostulantesEvaluacionEscritaQuery;
	
	String resultado;
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	public String reportePostulantesEvaluacionEscrita(){
		
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
		
		RpSeleccionPostulantesEvaluacionEscritaQueryCriteria criteria = new RpSeleccionPostulantesEvaluacionEscritaQueryCriteria();
		
		criteria.setNombre_completo(nombre_completo);
		criteria.setNumerodoc(numerodoc);
		criteria.setSrl_id_convocatoria(convocatoria);
		criteria.setSrl_id_conv_area_org(cod_postulacion);
		
		listResult = reporteSeleccionPostulantesEvaluacionEscritaService.getListByQuery(RpSeleccionPostulantesEvaluacionEscritaQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
		
	}
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpSeleccionPostulantesEvaluacionEscritaQueryCriteria rpSeleccionPostulantesEvaluacionEscritaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpSeleccionPostulantesEvaluacionEscritaQueryCriteria.class);
			List<RpSeleccionPostulantesEvaluacionEscritaQuery> listRpSeleccionPostulantesEvaluacionEscritaQuery = reporteSeleccionPostulantesEvaluacionEscritaService.getListByQuery(RpSeleccionPostulantesEvaluacionEscritaQueryMapper.class, rpSeleccionPostulantesEvaluacionEscritaQueryCriteria, start, limit);
			int total = reporteSeleccionPostulantesEvaluacionEscritaService.getCountRowsByQuery(RpSeleccionPostulantesEvaluacionEscritaQueryMapper.class, rpSeleccionPostulantesEvaluacionEscritaQueryCriteria);
			
			this.success(listRpSeleccionPostulantesEvaluacionEscritaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteSeleccionPostulantesEvaluacionEscritaService.create(rpSeleccionPostulantesEvaluacionEscritaQuery);
			this.success(rpSeleccionPostulantesEvaluacionEscritaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteSeleccionPostulantesEvaluacionEscritaService.save(rpSeleccionPostulantesEvaluacionEscritaQuery);
			this.success(rpSeleccionPostulantesEvaluacionEscritaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteSeleccionPostulantesEvaluacionEscritaService.remove(rpSeleccionPostulantesEvaluacionEscritaQuery);
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
	
	public ReporteSeleccionPostulantesEvaluacionEscritaService getReporteSeleccionPostulantesEvaluacionEscritaService() {
		return reporteSeleccionPostulantesEvaluacionEscritaService;
	}

	public void setReporteSeleccionPostulantesEvaluacionEscritaService(ReporteSeleccionPostulantesEvaluacionEscritaService reporteSeleccionPostulantesEvaluacionEscritaService) {
		this.reporteSeleccionPostulantesEvaluacionEscritaService = reporteSeleccionPostulantesEvaluacionEscritaService;
	}

	public RpSeleccionPostulantesEvaluacionEscritaQuery getRpSeleccionPostulantesEvaluacionEscritaQuery() {
		return rpSeleccionPostulantesEvaluacionEscritaQuery;
	}

	public void setRpSeleccionPostulantesEvaluacionEscritaQuery(RpSeleccionPostulantesEvaluacionEscritaQuery rpSeleccionPostulantesEvaluacionEscritaQuery) {
		this.rpSeleccionPostulantesEvaluacionEscritaQuery = rpSeleccionPostulantesEvaluacionEscritaQuery;
	}



	public List getListResult() {
		return listResult;
	}



	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions ReporteSeleccionPostulantesEvaluacionEscrita -->
<action name="ReporteSeleccionPostulantesEvaluacionEscritaView" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEvaluacionEscritaAction" method="view">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEvaluacionEscritaCreate" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEvaluacionEscritaAction" method="create">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEvaluacionEscritaSave" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEvaluacionEscritaAction" method="save">
		<result type="json" />
</action>

<action name="ReporteSeleccionPostulantesEvaluacionEscritaRemove" class="sernanp.rrhh.web.action.seleccion.ReporteSeleccionPostulantesEvaluacionEscritaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteSeleccionPostulantesEvaluacionEscrita -->
*/

}
