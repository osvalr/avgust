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
* DATE CREATE : 18/05/2015 04:29:11
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReportePlanillaPagoSNPService;
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQuery;
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQueryCriteria;
import sernanp.app.dao.query.mapper.RpPlanillaPagoONPQueryMapper;

public class ReportePlanillaPagoSNPAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReportePlanillaPagoSNPService reportePlanillaPagoSNPService;
	
	private RpPlanillaPagoONPQuery rpPlanillaPagoONPQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpPlanillaPagoONPQueryCriteria rpPlanillaPagoONPQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpPlanillaPagoONPQueryCriteria.class);
			List<RpPlanillaPagoONPQuery> listRpPlanillaPagoONPQuery = reportePlanillaPagoSNPService.getListByQuery(RpPlanillaPagoONPQueryMapper.class, rpPlanillaPagoONPQueryCriteria, start, limit);
			int total = reportePlanillaPagoSNPService.getCountRowsByQuery(RpPlanillaPagoONPQueryMapper.class, rpPlanillaPagoONPQueryCriteria);
			
			this.success(listRpPlanillaPagoONPQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reportePlanillaPagoSNPService.create(rpPlanillaPagoONPQuery);
			this.success(rpPlanillaPagoONPQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reportePlanillaPagoSNPService.save(rpPlanillaPagoONPQuery);
			this.success(rpPlanillaPagoONPQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reportePlanillaPagoSNPService.remove(rpPlanillaPagoONPQuery);
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
	
	public ReportePlanillaPagoSNPService getReportePlanillaPagoSNPService() {
		return reportePlanillaPagoSNPService;
	}

	public void setReportePlanillaPagoSNPService(ReportePlanillaPagoSNPService reportePlanillaPagoSNPService) {
		this.reportePlanillaPagoSNPService = reportePlanillaPagoSNPService;
	}

	public RpPlanillaPagoONPQuery getRpPlanillaPagoONPQuery() {
		return rpPlanillaPagoONPQuery;
	}

	public void setRpPlanillaPagoONPQuery(RpPlanillaPagoONPQuery rpPlanillaPagoONPQuery) {
		this.rpPlanillaPagoONPQuery = rpPlanillaPagoONPQuery;
	}

/*
<!-- Start Actions ReportePlanillaPagoSNP -->
<action name="ReportePlanillaPagoSNPView" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoSNPAction" method="view">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoSNPCreate" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoSNPAction" method="create">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoSNPSave" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoSNPAction" method="save">
		<result type="json" />
</action>

<action name="ReportePlanillaPagoSNPRemove" class="sernanp.rrhh.web.action.planilla.ReportePlanillaPagoSNPAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReportePlanillaPagoSNP -->
*/

}
