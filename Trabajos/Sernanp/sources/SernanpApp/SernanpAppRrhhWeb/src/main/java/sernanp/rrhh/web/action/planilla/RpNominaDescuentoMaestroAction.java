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
* DATE CREATE : 01/06/2015 19:30:15
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.RpNominaDescuentoMaestroService;
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQuery;
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQueryCriteria;
import sernanp.app.dao.query.mapper.RpNominaDescuentosMaestroQueryMapper;

public class RpNominaDescuentoMaestroAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RpNominaDescuentoMaestroService rpNominaDescuentoMaestroService;
	
	private RpNominaDescuentosMaestroQuery rpNominaDescuentosMaestroQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpNominaDescuentosMaestroQueryCriteria rpNominaDescuentosMaestroQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpNominaDescuentosMaestroQueryCriteria.class);
			List<RpNominaDescuentosMaestroQuery> listRpNominaDescuentosMaestroQuery = rpNominaDescuentoMaestroService.getListByQuery(RpNominaDescuentosMaestroQueryMapper.class, rpNominaDescuentosMaestroQueryCriteria, start, limit);
			int total = rpNominaDescuentoMaestroService.getCountRowsByQuery(RpNominaDescuentosMaestroQueryMapper.class, rpNominaDescuentosMaestroQueryCriteria);
			
			this.success(listRpNominaDescuentosMaestroQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rpNominaDescuentoMaestroService.create(rpNominaDescuentosMaestroQuery);
			this.success(rpNominaDescuentosMaestroQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rpNominaDescuentoMaestroService.save(rpNominaDescuentosMaestroQuery);
			this.success(rpNominaDescuentosMaestroQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rpNominaDescuentoMaestroService.remove(rpNominaDescuentosMaestroQuery);
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
	
	public RpNominaDescuentoMaestroService getRpNominaDescuentoMaestroService() {
		return rpNominaDescuentoMaestroService;
	}

	public void setRpNominaDescuentoMaestroService(RpNominaDescuentoMaestroService rpNominaDescuentoMaestroService) {
		this.rpNominaDescuentoMaestroService = rpNominaDescuentoMaestroService;
	}

	public RpNominaDescuentosMaestroQuery getRpNominaDescuentosMaestroQuery() {
		return rpNominaDescuentosMaestroQuery;
	}

	public void setRpNominaDescuentosMaestroQuery(RpNominaDescuentosMaestroQuery rpNominaDescuentosMaestroQuery) {
		this.rpNominaDescuentosMaestroQuery = rpNominaDescuentosMaestroQuery;
	}

/*
<!-- Start Actions RpNominaDescuentoMaestro -->
<action name="RpNominaDescuentoMaestroView" class="sernanp.rrhh.web.action.planilla.RpNominaDescuentoMaestroAction" method="view">
		<result type="json" />
</action>

<action name="RpNominaDescuentoMaestroCreate" class="sernanp.rrhh.web.action.planilla.RpNominaDescuentoMaestroAction" method="create">
		<result type="json" />
</action>

<action name="RpNominaDescuentoMaestroSave" class="sernanp.rrhh.web.action.planilla.RpNominaDescuentoMaestroAction" method="save">
		<result type="json" />
</action>

<action name="RpNominaDescuentoMaestroRemove" class="sernanp.rrhh.web.action.planilla.RpNominaDescuentoMaestroAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RpNominaDescuentoMaestro -->
*/

}
