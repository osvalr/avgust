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
* DATE CREATE : 17/05/2015 16:50:57
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.ReporteDescuentoJudicialService;
import sernanp.app.dao.query.domain.RpDescuentoJudicialQuery;
import sernanp.app.dao.query.domain.RpDescuentoJudicialQueryCriteria;
import sernanp.app.dao.query.mapper.RpDescuentoJudicialQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class ReporteDescuentoJudicialAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteDescuentoJudicialService reporteDescuentoJudicialService;
	
	private RpDescuentoJudicialQuery rpDescuentoJudicialQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	
	String resultado;
	
	
	public String listarDescuentoJudicial(){
		
		String nombre_completo = this.getParameter("nombre_completo").equals("") ? null : this.getParameter("nombre_completo");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		String int_anio = this.getParameter("int_anio").equals("") ? null : this.getParameter("int_anio");
		String int_id_periodo_mes = this.getParameter("int_id_periodo_mes").equals("") ? null : this.getParameter("int_id_periodo_mes");
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
		
		RpDescuentoJudicialQueryCriteria criteria = new RpDescuentoJudicialQueryCriteria();
		criteria.setSrl_id_regimen_contractual(int_regimen);
		criteria.setNombre_completo(nombre_completo);
		criteria.setInt_anio(anio);
		criteria.setInt_id_periodo_mes(id_periodo);
		
				
		listResult = reporteDescuentoJudicialService.getListByQuery(RpDescuentoJudicialQueryMapper.class, criteria);
		
        return resultado = tipo_reporte;
	}
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpDescuentoJudicialQueryCriteria rpDescuentoJudicialQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpDescuentoJudicialQueryCriteria.class);
			List<RpDescuentoJudicialQuery> listRpDescuentoJudicialQuery = reporteDescuentoJudicialService.getListByQuery(RpDescuentoJudicialQueryMapper.class, rpDescuentoJudicialQueryCriteria, start, limit);
			int total = reporteDescuentoJudicialService.getCountRowsByQuery(RpDescuentoJudicialQueryMapper.class, rpDescuentoJudicialQueryCriteria);
			
			this.success(listRpDescuentoJudicialQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteDescuentoJudicialService.create(rpDescuentoJudicialQuery);
			this.success(rpDescuentoJudicialQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteDescuentoJudicialService.save(rpDescuentoJudicialQuery);
			this.success(rpDescuentoJudicialQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteDescuentoJudicialService.remove(rpDescuentoJudicialQuery);
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
	
	public ReporteDescuentoJudicialService getReporteDescuentoJudicialService() {
		return reporteDescuentoJudicialService;
	}

	public void setReporteDescuentoJudicialService(ReporteDescuentoJudicialService reporteDescuentoJudicialService) {
		this.reporteDescuentoJudicialService = reporteDescuentoJudicialService;
	}

	public RpDescuentoJudicialQuery getRpDescuentoJudicialQuery() {
		return rpDescuentoJudicialQuery;
	}

	public void setRpDescuentoJudicialQuery(RpDescuentoJudicialQuery rpDescuentoJudicialQuery) {
		this.rpDescuentoJudicialQuery = rpDescuentoJudicialQuery;
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
<!-- Start Actions ReporteDescuentoJudicial -->
<action name="ReporteDescuentoJudicialView" class="sernanp.rrhh.web.action.planilla.ReporteDescuentoJudicialAction" method="view">
		<result type="json" />
</action>

<action name="ReporteDescuentoJudicialCreate" class="sernanp.rrhh.web.action.planilla.ReporteDescuentoJudicialAction" method="create">
		<result type="json" />
</action>

<action name="ReporteDescuentoJudicialSave" class="sernanp.rrhh.web.action.planilla.ReporteDescuentoJudicialAction" method="save">
		<result type="json" />
</action>

<action name="ReporteDescuentoJudicialRemove" class="sernanp.rrhh.web.action.planilla.ReporteDescuentoJudicialAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteDescuentoJudicial -->
*/

}
