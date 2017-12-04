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
* DATE CREATE : 18/05/2015 01:24:16
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteBoletaPersonalService;
import sernanp.app.business.core.planilla.service.ReporteDetalleBoletaPersonalService;
import sernanp.app.dao.query.domain.RpBoletasPersonalQuery;
import sernanp.app.dao.query.domain.RpBoletasPersonalQueryCriteria;
import sernanp.app.dao.query.domain.RpDetalleBoletasPersonalQueryCriteria;
import sernanp.app.dao.query.mapper.RpBoletasPersonalQueryMapper;
import sernanp.app.dao.query.mapper.RpDetalleBoletasPersonalQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteBoletaPersonalAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteBoletaPersonalService reporteBoletaPersonalService;
	
	@Autowired
	private ReporteDetalleBoletaPersonalService reporteDetalleBoletaPersonalService;
	
	private RpBoletasPersonalQuery rpBoletasPersonalQuery;
		
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	private Object record;
	
	String resultado;
	
	public String reporteBoletaPersonal(){
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String srl_id_fuente_financiamiento = this.getParameter("srl_id_fuente_financiamiento").equals("") ? null : this.getParameter("srl_id_fuente_financiamiento");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		

		Integer id_fuente = null;
		Integer int_regimen = null;
		
		if(srl_id_fuente_financiamiento == null){
			id_fuente = null;
		}else{
			id_fuente = Integer.parseInt(srl_id_fuente_financiamiento);
			id_fuente.intValue();
		}
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpBoletasPersonalQueryCriteria criteria = new RpBoletasPersonalQueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setSrl_id_fuente_financiamiento(id_fuente);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);
		
		listResult = reporteBoletaPersonalService.getListByQuery(RpBoletasPersonalQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
	
	}
	
	public String reporteDetalleBoletaPersonal(){
		
		
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		
		Integer int_regimen = null;
		
		if(srl_id_regimen_contractual == null){
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		int id_periodo = Integer.parseInt(int_id_periodo_mes);
		int anio = Integer.parseInt(int_anio);
		
		RpDetalleBoletasPersonalQueryCriteria criteria = new RpDetalleBoletasPersonalQueryCriteria();
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setInt_anio(anio);
		criteria.setNombre_completo(nombre_completo);
		criteria.setFecha_mes(""+int_anio+"-"+int_id_periodo_mes+"-01");
	   
		
				
		listResult = reporteDetalleBoletaPersonalService.getListByQuery(RpDetalleBoletasPersonalQueryMapper.class, criteria);
		
		return resultado = tipo_reporte;
	}
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpBoletasPersonalQueryCriteria rpBoletasPersonalQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpBoletasPersonalQueryCriteria.class);
			
			List<RpBoletasPersonalQuery> listRpBoletasPersonalQuery = reporteBoletaPersonalService.getListByQuery(RpBoletasPersonalQueryMapper.class, rpBoletasPersonalQueryCriteria, start, limit);
			int total = reporteBoletaPersonalService.getCountRowsByQuery(RpBoletasPersonalQueryMapper.class, rpBoletasPersonalQueryCriteria);
			
			this.success(listRpBoletasPersonalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteBoletaPersonalService.create(rpBoletasPersonalQuery);
			this.success(rpBoletasPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteBoletaPersonalService.save(rpBoletasPersonalQuery);
			this.success(rpBoletasPersonalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteBoletaPersonalService.remove(rpBoletasPersonalQuery);
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
	
	public ReporteBoletaPersonalService getReporteBoletaPersonalService() {
		return reporteBoletaPersonalService;
	}

	public void setReporteBoletaPersonalService(ReporteBoletaPersonalService reporteBoletaPersonalService) {
		this.reporteBoletaPersonalService = reporteBoletaPersonalService;
	}

	public RpBoletasPersonalQuery getRpBoletasPersonalQuery() {
		return rpBoletasPersonalQuery;
	}

	public void setRpBoletasPersonalQuery(RpBoletasPersonalQuery rpBoletasPersonalQuery) {
		this.rpBoletasPersonalQuery = rpBoletasPersonalQuery;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}

	

/*
<!-- Start Actions ReporteBoletaPersonal -->
<action name="ReporteBoletaPersonalView" class="sernanp.rrhh.web.action.planilla.ReporteBoletaPersonalAction" method="view">
		<result type="json" />
</action>

<action name="ReporteBoletaPersonalCreate" class="sernanp.rrhh.web.action.planilla.ReporteBoletaPersonalAction" method="create">
		<result type="json" />
</action>

<action name="ReporteBoletaPersonalSave" class="sernanp.rrhh.web.action.planilla.ReporteBoletaPersonalAction" method="save">
		<result type="json" />
</action>

<action name="ReporteBoletaPersonalRemove" class="sernanp.rrhh.web.action.planilla.ReporteBoletaPersonalAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteBoletaPersonal -->
*/
	
//	for (RpBoletasPersonalQuery obj : listaboleta) {
//	RpDetalleBoletaPersonalQueryCriteria criteriaDetalle = new RpDetalleBoletaPersonalQueryCriteria();
//	criteriaDetalle.setInt_anio(2015);
//	criteriaDetalle.setInt_id_periodo_mes(1);
//	listadetalleboleta = commonServiceMybatis.getListByQuery(RpDetalleBoletaPersonalQueryMapper.class, criteriaDetalle);
//	obj.setListadetalleboleta(listadetalleboleta);
//	
//
// }

}
