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
* DATE CREATE : 23/03/2015 00:00:56
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.GestionarParametroPlanillaService;
import sernanp.app.dao.query.domain.GestionarParametroPlanillaQuery;
import sernanp.app.dao.query.domain.GestionarParametroPlanillaQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarParametroPlanillaQueryMapper;

public class GestionarParametroPlanillaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarParametroPlanillaService gestionarParametroPlanillaService;
	
	private GestionarParametroPlanillaQuery gestionarParametroPlanillaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarParametroPlanillaQueryCriteria gestionarParametroPlanillaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarParametroPlanillaQueryCriteria.class);
			List<GestionarParametroPlanillaQuery> listGestionarParametroPlanillaQuery = gestionarParametroPlanillaService.getListByQuery(GestionarParametroPlanillaQueryMapper.class, gestionarParametroPlanillaQueryCriteria, start, limit);
			int total = gestionarParametroPlanillaService.getCountRowsByQuery(GestionarParametroPlanillaQueryMapper.class, gestionarParametroPlanillaQueryCriteria);
			
			this.success(listGestionarParametroPlanillaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			gestionarParametroPlanillaService.create(gestionarParametroPlanillaQuery);
			this.success(gestionarParametroPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			gestionarParametroPlanillaService.save(gestionarParametroPlanillaQuery);
			this.success(gestionarParametroPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			gestionarParametroPlanillaService.remove(gestionarParametroPlanillaQuery);
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
	
	public GestionarParametroPlanillaService getGestionarParametroPlanillaService() {
		return gestionarParametroPlanillaService;
	}

	public void setGestionarParametroPlanillaService(GestionarParametroPlanillaService gestionarParametroPlanillaService) {
		this.gestionarParametroPlanillaService = gestionarParametroPlanillaService;
	}

	public GestionarParametroPlanillaQuery getGestionarParametroPlanillaQuery() {
		return gestionarParametroPlanillaQuery;
	}

	public void setGestionarParametroPlanillaQuery(GestionarParametroPlanillaQuery gestionarParametroPlanillaQuery) {
		this.gestionarParametroPlanillaQuery = gestionarParametroPlanillaQuery;
	}

/*
<!-- Start Actions GestionarParametroPlanilla -->
<action name="GestionarParametroPlanillaView" class="sernanp.rrhh.web.action.planilla.GestionarParametroPlanillaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarParametroPlanillaCreate" class="sernanp.rrhh.web.action.planilla.GestionarParametroPlanillaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarParametroPlanillaSave" class="sernanp.rrhh.web.action.planilla.GestionarParametroPlanillaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarParametroPlanillaRemove" class="sernanp.rrhh.web.action.planilla.GestionarParametroPlanillaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions GestionarParametroPlanilla -->
*/

}
