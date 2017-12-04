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
* DATE CREATE : 31/05/2015 14:56:55
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteResumenPlanilla728Service;
import sernanp.app.dao.query.domain.ReporteResumenPlanilla728Query;
import sernanp.app.dao.query.domain.ReporteResumenPlanilla728QueryCriteria;
import sernanp.app.dao.query.mapper.ReporteResumenPlanilla728QueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteResumenPlanilla728Action extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenPlanilla728Service reporteResumenPlanilla728Service;
	
	private ReporteResumenPlanilla728Query reporteResumenPlanilla728Query;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	String resultado;
	
	public String listarResumenPlanilla728(){
		
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
		
		ReporteResumenPlanilla728QueryCriteria criteria = new ReporteResumenPlanilla728QueryCriteria();
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_id_periodo_mes(id_periodo);
		criteria.setSrl_id_fuente_financiamiento(id_fuente);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setInt_anio(anio);

		
		listResult = reporteResumenPlanilla728Service.getListByQuery(ReporteResumenPlanilla728QueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
		
		
	}
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			ReporteResumenPlanilla728QueryCriteria reporteResumenPlanilla728QueryCriteria = this.loadCriteria(this.getHttpRequest(), ReporteResumenPlanilla728QueryCriteria.class);
			List<ReporteResumenPlanilla728Query> listReporteResumenPlanilla728Query = reporteResumenPlanilla728Service.getListByQuery(ReporteResumenPlanilla728QueryMapper.class, reporteResumenPlanilla728QueryCriteria, start, limit);
			int total = reporteResumenPlanilla728Service.getCountRowsByQuery(ReporteResumenPlanilla728QueryMapper.class, reporteResumenPlanilla728QueryCriteria);
			
			this.success(listReporteResumenPlanilla728Query,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenPlanilla728Service.create(reporteResumenPlanilla728Query);
			this.success(reporteResumenPlanilla728Query, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenPlanilla728Service.save(reporteResumenPlanilla728Query);
			this.success(reporteResumenPlanilla728Query, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenPlanilla728Service.remove(reporteResumenPlanilla728Query);
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
	
	public ReporteResumenPlanilla728Service getReporteResumenPlanilla728Service() {
		return reporteResumenPlanilla728Service;
	}

	public void setReporteResumenPlanilla728Service(ReporteResumenPlanilla728Service reporteResumenPlanilla728Service) {
		this.reporteResumenPlanilla728Service = reporteResumenPlanilla728Service;
	}

	public ReporteResumenPlanilla728Query getReporteResumenPlanilla728Query() {
		return reporteResumenPlanilla728Query;
	}

	public void setReporteResumenPlanilla728Query(ReporteResumenPlanilla728Query reporteResumenPlanilla728Query) {
		this.reporteResumenPlanilla728Query = reporteResumenPlanilla728Query;
	}
	
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

/*
<!-- Start Actions ReporteResumenPlanilla728 -->
<action name="ReporteResumenPlanilla728View" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanilla728Action" method="view">
		<result type="json" />
</action>

<action name="ReporteResumenPlanilla728Create" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanilla728Action" method="create">
		<result type="json" />
</action>

<action name="ReporteResumenPlanilla728Save" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanilla728Action" method="save">
		<result type="json" />
</action>

<action name="ReporteResumenPlanilla728Remove" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanilla728Action" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteResumenPlanilla728 -->
*/

}
