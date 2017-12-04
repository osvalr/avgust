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
* DATE CREATE : 03/06/2015 12:15:18
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.RptEmisionDetalleNominaxMesxRCService;
import sernanp.app.dao.query.domain.RptEmitirDetalleNominaxMesxRCQuery;
import sernanp.app.dao.query.domain.RptEmitirDetalleNominaxMesxRCQueryCriteria;
import sernanp.app.dao.query.mapper.RptEmitirDetalleNominaxMesxRCQueryMapper;

public class RptEmisionDetalleNominaxMesxRCAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RptEmisionDetalleNominaxMesxRCService rptEmisionDetalleNominaxMesxRCService;
	
	private RptEmitirDetalleNominaxMesxRCQuery rptEmitirDetalleNominaxMesxRCQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
	
			RptEmitirDetalleNominaxMesxRCQueryCriteria rptEmitirDetalleNominaxMesxRCQueryCriteria = this.loadCriteria(this.getHttpRequest(), RptEmitirDetalleNominaxMesxRCQueryCriteria.class);
			List<RptEmitirDetalleNominaxMesxRCQuery> listRptEmitirDetalleNominaxMesxRCQuery = rptEmisionDetalleNominaxMesxRCService.getListByQuery(RptEmitirDetalleNominaxMesxRCQueryMapper.class, rptEmitirDetalleNominaxMesxRCQueryCriteria, start, limit);
			
			int total = rptEmisionDetalleNominaxMesxRCService.getCountRowsByQuery(RptEmitirDetalleNominaxMesxRCQueryMapper.class, rptEmitirDetalleNominaxMesxRCQueryCriteria);
			
			this.success(listRptEmitirDetalleNominaxMesxRCQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rptEmisionDetalleNominaxMesxRCService.create(rptEmitirDetalleNominaxMesxRCQuery);
			this.success(rptEmitirDetalleNominaxMesxRCQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rptEmisionDetalleNominaxMesxRCService.save(rptEmitirDetalleNominaxMesxRCQuery);
			this.success(rptEmitirDetalleNominaxMesxRCQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rptEmisionDetalleNominaxMesxRCService.remove(rptEmitirDetalleNominaxMesxRCQuery);
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
	
	public RptEmisionDetalleNominaxMesxRCService getRptEmisionDetalleNominaxMesxRCService() {
		return rptEmisionDetalleNominaxMesxRCService;
	}

	public void setRptEmisionDetalleNominaxMesxRCService(RptEmisionDetalleNominaxMesxRCService rptEmisionDetalleNominaxMesxRCService) {
		this.rptEmisionDetalleNominaxMesxRCService = rptEmisionDetalleNominaxMesxRCService;
	}

	public RptEmitirDetalleNominaxMesxRCQuery getRptEmitirDetalleNominaxMesxRCQuery() {
		return rptEmitirDetalleNominaxMesxRCQuery;
	}

	public void setRptEmitirDetalleNominaxMesxRCQuery(RptEmitirDetalleNominaxMesxRCQuery rptEmitirDetalleNominaxMesxRCQuery) {
		this.rptEmitirDetalleNominaxMesxRCQuery = rptEmitirDetalleNominaxMesxRCQuery;
	}

/*
<!-- Start Actions RptEmisionDetalleNominaxMesxRC -->
<action name="RptEmisionDetalleNominaxMesxRCView" class="sernanp.rrhh.web.action.planilla.RptEmisionDetalleNominaxMesxRCAction" method="view">
		<result type="json" />
</action>

<action name="RptEmisionDetalleNominaxMesxRCCreate" class="sernanp.rrhh.web.action.planilla.RptEmisionDetalleNominaxMesxRCAction" method="create">
		<result type="json" />
</action>

<action name="RptEmisionDetalleNominaxMesxRCSave" class="sernanp.rrhh.web.action.planilla.RptEmisionDetalleNominaxMesxRCAction" method="save">
		<result type="json" />
</action>

<action name="RptEmisionDetalleNominaxMesxRCRemove" class="sernanp.rrhh.web.action.planilla.RptEmisionDetalleNominaxMesxRCAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RptEmisionDetalleNominaxMesxRC -->
*/

}
