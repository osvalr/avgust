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
* DATE CREATE : 29/05/2015 17:16:29
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.planilla.service.RptResumenPadronTrabajadoresService;
import sernanp.app.dao.query.domain.RptResumenPadronTrabajadoresQuery;
import sernanp.app.dao.query.domain.RptResumenPadronTrabajadoresQueryCriteria;
import sernanp.app.dao.query.mapper.RptResumenPadronTrabajadoresQueryMapper;

public class RptResumenPadronTrabajadoresAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RptResumenPadronTrabajadoresService rptResumenPadronTrabajadoresService;
	
	private RptResumenPadronTrabajadoresQuery rptResumenPadronTrabajadoresQuery;
	
	@SuppressWarnings("rawtypes")
	private List listResult;
	
	private String tipo_reporte;

	
	public String listarPadronTrabajadores(){
		
		int int_anio = this.getIntegerParameter("int_anio");
		int int_id_periodo_mes = this.getIntegerParameter("int_id_periodo_mes");
		String tipo_reporte = this.getParameter("tipo_reporte").equals("") ? null : this.getParameter("tipo_reporte");
		String srl_id_regimen_contractual = this.getParameter("srl_id_regimen_contractual").equals("") ? null : this.getParameter("srl_id_regimen_contractual");
		
		Integer int_regimen = null;
		
		if (srl_id_regimen_contractual == null) {
			int_regimen = null;
		}else{
			int_regimen = Integer.parseInt(srl_id_regimen_contractual);
			int_regimen.intValue();
		}
		
		RptResumenPadronTrabajadoresQueryCriteria criteria = new RptResumenPadronTrabajadoresQueryCriteria();
		criteria.setInt_anio(int_anio);
		criteria.setInt_id_periodo_mes(int_id_periodo_mes);
		criteria.setSrl_id_regimen_contractual(int_regimen);
		
		listResult = rptResumenPadronTrabajadoresService.getListByQuery(RptResumenPadronTrabajadoresQueryMapper.class,criteria);
		
		return tipo_reporte;
	}
	
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RptResumenPadronTrabajadoresQueryCriteria rptResumenPadronTrabajadoresQueryCriteria = this.loadCriteria(this.getHttpRequest(), RptResumenPadronTrabajadoresQueryCriteria.class);
			List<RptResumenPadronTrabajadoresQuery> listRptResumenPadronTrabajadoresQuery = rptResumenPadronTrabajadoresService.getListByQuery(RptResumenPadronTrabajadoresQueryMapper.class, rptResumenPadronTrabajadoresQueryCriteria, start, limit);
			int total = rptResumenPadronTrabajadoresService.getCountRowsByQuery(RptResumenPadronTrabajadoresQueryMapper.class, rptResumenPadronTrabajadoresQueryCriteria);
			
			this.success(listRptResumenPadronTrabajadoresQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rptResumenPadronTrabajadoresService.create(rptResumenPadronTrabajadoresQuery);
			this.success(rptResumenPadronTrabajadoresQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rptResumenPadronTrabajadoresService.save(rptResumenPadronTrabajadoresQuery);
			this.success(rptResumenPadronTrabajadoresQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rptResumenPadronTrabajadoresService.remove(rptResumenPadronTrabajadoresQuery);
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
	
	public RptResumenPadronTrabajadoresService getRptResumenPadronTrabajadoresService() {
		return rptResumenPadronTrabajadoresService;
	}

	public void setRptResumenPadronTrabajadoresService(RptResumenPadronTrabajadoresService rptResumenPadronTrabajadoresService) {
		this.rptResumenPadronTrabajadoresService = rptResumenPadronTrabajadoresService;
	}

	public RptResumenPadronTrabajadoresQuery getRptResumenPadronTrabajadoresQuery() {
		return rptResumenPadronTrabajadoresQuery;
	}

	public void setRptResumenPadronTrabajadoresQuery(RptResumenPadronTrabajadoresQuery rptResumenPadronTrabajadoresQuery) {
		this.rptResumenPadronTrabajadoresQuery = rptResumenPadronTrabajadoresQuery;
	}
	
	public String getTipo_reporte() {
		return tipo_reporte;
	}

	public void setTipo_reporte(String tipo_reporte) {
		this.tipo_reporte = tipo_reporte;
	}
	@SuppressWarnings("rawtypes")
	public List getListResult() {
		return listResult;
	}

	@SuppressWarnings("rawtypes")
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}

/*
<!-- Start Actions RptResumenPadronTrabajadores -->
<action name="RptResumenPadronTrabajadoresView" class="sernanp.rrhh.web.action.planilla.RptResumenPadronTrabajadoresAction" method="view">
		<result type="json" />
</action>

<action name="RptResumenPadronTrabajadoresCreate" class="sernanp.rrhh.web.action.planilla.RptResumenPadronTrabajadoresAction" method="create">
		<result type="json" />
</action>

<action name="RptResumenPadronTrabajadoresSave" class="sernanp.rrhh.web.action.planilla.RptResumenPadronTrabajadoresAction" method="save">
		<result type="json" />
</action>

<action name="RptResumenPadronTrabajadoresRemove" class="sernanp.rrhh.web.action.planilla.RptResumenPadronTrabajadoresAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RptResumenPadronTrabajadores -->
*/

}
