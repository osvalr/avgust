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
* DATE CREATE : 18/05/2015 03:23:36
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReporteResumenNominaPagoService;
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQuery;
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQueryCriteria;
import sernanp.app.dao.query.mapper.RpResumenPlanillaPagosQueryMapper;

public class ReporteResumenNominaPagoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenNominaPagoService reporteResumenNominaPagoService;
	
	private RpResumenPlanillaPagosQuery rpResumenPlanillaPagosQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpResumenPlanillaPagosQueryCriteria rpResumenPlanillaPagosQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpResumenPlanillaPagosQueryCriteria.class);
			List<RpResumenPlanillaPagosQuery> listRpResumenPlanillaPagosQuery = reporteResumenNominaPagoService.getListByQuery(RpResumenPlanillaPagosQueryMapper.class, rpResumenPlanillaPagosQueryCriteria, start, limit);
			int total = reporteResumenNominaPagoService.getCountRowsByQuery(RpResumenPlanillaPagosQueryMapper.class, rpResumenPlanillaPagosQueryCriteria);
			
			this.success(listRpResumenPlanillaPagosQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenNominaPagoService.create(rpResumenPlanillaPagosQuery);
			this.success(rpResumenPlanillaPagosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenNominaPagoService.save(rpResumenPlanillaPagosQuery);
			this.success(rpResumenPlanillaPagosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenNominaPagoService.remove(rpResumenPlanillaPagosQuery);
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
	
	public ReporteResumenNominaPagoService getReporteResumenNominaPagoService() {
		return reporteResumenNominaPagoService;
	}

	public void setReporteResumenNominaPagoService(ReporteResumenNominaPagoService reporteResumenNominaPagoService) {
		this.reporteResumenNominaPagoService = reporteResumenNominaPagoService;
	}

	public RpResumenPlanillaPagosQuery getRpResumenPlanillaPagosQuery() {
		return rpResumenPlanillaPagosQuery;
	}

	public void setRpResumenPlanillaPagosQuery(RpResumenPlanillaPagosQuery rpResumenPlanillaPagosQuery) {
		this.rpResumenPlanillaPagosQuery = rpResumenPlanillaPagosQuery;
	}

/*
<!-- Start Actions ReporteResumenNominaPago -->
<action name="ReporteResumenNominaPagoView" class="sernanp.rrhh.web.action.planilla.ReporteResumenNominaPagoAction" method="view">
		<result type="json" />
</action>

<action name="ReporteResumenNominaPagoCreate" class="sernanp.rrhh.web.action.planilla.ReporteResumenNominaPagoAction" method="create">
		<result type="json" />
</action>

<action name="ReporteResumenNominaPagoSave" class="sernanp.rrhh.web.action.planilla.ReporteResumenNominaPagoAction" method="save">
		<result type="json" />
</action>

<action name="ReporteResumenNominaPagoRemove" class="sernanp.rrhh.web.action.planilla.ReporteResumenNominaPagoAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteResumenNominaPago -->
*/

}
