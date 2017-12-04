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
* DATE CREATE : 17/05/2015 17:00:41
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.ReporteResumenAfpService;
import sernanp.app.dao.query.domain.RpResumenAfpQuery;
import sernanp.app.dao.query.domain.RpResumenAfpQueryCriteria;
import sernanp.app.dao.query.mapper.RpResumenAfpQueryMapper;

public class ReporteResumenAfpAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteResumenAfpService reporteResumenAfpService;
	
	private RpResumenAfpQuery rpResumenAfpQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpResumenAfpQueryCriteria rpResumenAfpQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpResumenAfpQueryCriteria.class);
			List<RpResumenAfpQuery> listRpResumenAfpQuery = reporteResumenAfpService.getListByQuery(RpResumenAfpQueryMapper.class, rpResumenAfpQueryCriteria, start, limit);
			int total = reporteResumenAfpService.getCountRowsByQuery(RpResumenAfpQueryMapper.class, rpResumenAfpQueryCriteria);
			
			this.success(listRpResumenAfpQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			reporteResumenAfpService.create(rpResumenAfpQuery);
			this.success(rpResumenAfpQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			reporteResumenAfpService.save(rpResumenAfpQuery);
			this.success(rpResumenAfpQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			reporteResumenAfpService.remove(rpResumenAfpQuery);
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
	
	public ReporteResumenAfpService getReporteResumenAfpService() {
		return reporteResumenAfpService;
	}

	public void setReporteResumenAfpService(ReporteResumenAfpService reporteResumenAfpService) {
		this.reporteResumenAfpService = reporteResumenAfpService;
	}

	public RpResumenAfpQuery getRpResumenAfpQuery() {
		return rpResumenAfpQuery;
	}

	public void setRpResumenAfpQuery(RpResumenAfpQuery rpResumenAfpQuery) {
		this.rpResumenAfpQuery = rpResumenAfpQuery;
	}

/*
<!-- Start Actions ReporteResumenAfp -->
<action name="ReporteResumenAfpView" class="sernanp.rrhh.web.action.planilla.ReporteResumenAfpAction" method="view">
		<result type="json" />
</action>

<action name="ReporteResumenAfpCreate" class="sernanp.rrhh.web.action.planilla.ReporteResumenAfpAction" method="create">
		<result type="json" />
</action>

<action name="ReporteResumenAfpSave" class="sernanp.rrhh.web.action.planilla.ReporteResumenAfpAction" method="save">
		<result type="json" />
</action>

<action name="ReporteResumenAfpRemove" class="sernanp.rrhh.web.action.planilla.ReporteResumenAfpAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions ReporteResumenAfp -->
*/

}
