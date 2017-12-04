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
* DATE CREATE : 07/06/2015 11:08:36
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.GestionarAnhoMetaService;
import sernanp.app.dao.query.domain.GestionarAnhoMetaQuery;
import sernanp.app.dao.query.domain.GestionarAnhoMetaQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarAnhoMetaQueryMapper;

public class GestionarAnhoMetaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarAnhoMetaService gestionarAnhoMetaService;
	
	private GestionarAnhoMetaQuery gestionarAnhoMetaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarAnhoMetaQueryCriteria gestionarAnhoMetaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarAnhoMetaQueryCriteria.class);
			List<GestionarAnhoMetaQuery> listGestionarAnhoMetaQuery = gestionarAnhoMetaService.getListByQuery(GestionarAnhoMetaQueryMapper.class, gestionarAnhoMetaQueryCriteria, start, limit);
			int total = gestionarAnhoMetaService.getCountRowsByQuery(GestionarAnhoMetaQueryMapper.class, gestionarAnhoMetaQueryCriteria);
			
			this.success(listGestionarAnhoMetaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			gestionarAnhoMetaService.create(gestionarAnhoMetaQuery);
			this.success(gestionarAnhoMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			gestionarAnhoMetaService.save(gestionarAnhoMetaQuery);
			this.success(gestionarAnhoMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			gestionarAnhoMetaService.remove(gestionarAnhoMetaQuery);
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
	
	public GestionarAnhoMetaService getGestionarAnhoMetaService() {
		return gestionarAnhoMetaService;
	}

	public void setGestionarAnhoMetaService(GestionarAnhoMetaService gestionarAnhoMetaService) {
		this.gestionarAnhoMetaService = gestionarAnhoMetaService;
	}

	public GestionarAnhoMetaQuery getGestionarAnhoMetaQuery() {
		return gestionarAnhoMetaQuery;
	}

	public void setGestionarAnhoMetaQuery(GestionarAnhoMetaQuery gestionarAnhoMetaQuery) {
		this.gestionarAnhoMetaQuery = gestionarAnhoMetaQuery;
	}

/*
<!-- Start Actions GestionarAnhoMeta -->
<action name="GestionarAnhoMetaView" class="sernanp.rrhh.web.action.planilla.GestionarAnhoMetaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarAnhoMetaCreate" class="sernanp.rrhh.web.action.planilla.GestionarAnhoMetaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarAnhoMetaSave" class="sernanp.rrhh.web.action.planilla.GestionarAnhoMetaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarAnhoMetaRemove" class="sernanp.rrhh.web.action.planilla.GestionarAnhoMetaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions GestionarAnhoMeta -->
*/

}
