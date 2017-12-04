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
* DATE CREATE : 17/05/2015 16:35:02
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReporteResumenPlanillaPagoService;
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQuery;
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQueryCriteria;
import sernanp.app.dao.query.mapper.RpResumenPlanillaPagosQueryMapper;

public class ReporteResumenPlanillaPagoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenPlanillaPagoService reporteResumenPlanillaPagoService;
	
	private RpResumenPlanillaPagosQuery rpResumenPlanillaPagosQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpResumenPlanillaPagosQueryCriteria rpResumenPlanillaPagosQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpResumenPlanillaPagosQueryCriteria.class);
			List<RpResumenPlanillaPagosQuery> listRpResumenPlanillaPagosQuery = reporteResumenPlanillaPagoService.getListByQuery(RpResumenPlanillaPagosQueryMapper.class, rpResumenPlanillaPagosQueryCriteria, start, limit);
			int total = reporteResumenPlanillaPagoService.getCountRowsByQuery(RpResumenPlanillaPagosQueryMapper.class, rpResumenPlanillaPagosQueryCriteria);
			
			this.success(listRpResumenPlanillaPagosQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenPlanillaPagoService.create(rpResumenPlanillaPagosQuery);
			this.success(rpResumenPlanillaPagosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenPlanillaPagoService.save(rpResumenPlanillaPagosQuery);
			this.success(rpResumenPlanillaPagosQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenPlanillaPagoService.remove(rpResumenPlanillaPagosQuery);
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
	
	public ReporteResumenPlanillaPagoService getReporteResumenPlanillaPagoService() {
		return reporteResumenPlanillaPagoService;
	}

	public void setReporteResumenPlanillaPagoService(ReporteResumenPlanillaPagoService reporteResumenPlanillaPagoService) {
		this.reporteResumenPlanillaPagoService = reporteResumenPlanillaPagoService;
	}

	public RpResumenPlanillaPagosQuery getRpResumenPlanillaPagosQuery() {
		return rpResumenPlanillaPagosQuery;
	}

	public void setRpResumenPlanillaPagosQuery(RpResumenPlanillaPagosQuery rpResumenPlanillaPagosQuery) {
		this.rpResumenPlanillaPagosQuery = rpResumenPlanillaPagosQuery;
	}

/*
<!-- Start Actions ReporteResumenPlanillaPago -->
<action name="ReporteResumenPlanillaPagoView" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanillaPagoAction" method="view">
		<result type="json" />
</action>

<action name="ReporteResumenPlanillaPagoCreate" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanillaPagoAction" method="create">
		<result type="json" />
</action>

<action name="ReporteResumenPlanillaPagoSave" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanillaPagoAction" method="save">
		<result type="json" />
</action>

<action name="ReporteResumenPlanillaPagoRemove" class="sernanp.rrhh.web.action.planilla.ReporteResumenPlanillaPagoAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteResumenPlanillaPago -->
*/

}
