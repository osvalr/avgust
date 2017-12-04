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
* DATE CREATE : 19/04/2015 06:16:31
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.GestionarMetaFuenteGenericaService;
import sernanp.app.dao.query.domain.GestionarMetaFuenteGenericaQuery;
import sernanp.app.dao.query.domain.GestionarMetaFuenteGenericaQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarMetaFuenteGenericaQueryMapper;

public class GestionarMetaFuenteGenericaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarMetaFuenteGenericaService gestionarMetaFuenteGenericaService;
	
	private GestionarMetaFuenteGenericaQuery gestionarMetaFuenteGenericaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarMetaFuenteGenericaQueryCriteria gestionarMetaFuenteGenericaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarMetaFuenteGenericaQueryCriteria.class);
			List<GestionarMetaFuenteGenericaQuery> listGestionarMetaFuenteGenericaQuery = gestionarMetaFuenteGenericaService.getListByQuery(GestionarMetaFuenteGenericaQueryMapper.class, gestionarMetaFuenteGenericaQueryCriteria, start, limit);
			int total = gestionarMetaFuenteGenericaService.getCountRowsByQuery(GestionarMetaFuenteGenericaQueryMapper.class, gestionarMetaFuenteGenericaQueryCriteria);
			
			this.success(listGestionarMetaFuenteGenericaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			gestionarMetaFuenteGenericaService.create(gestionarMetaFuenteGenericaQuery);
			this.success(gestionarMetaFuenteGenericaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			gestionarMetaFuenteGenericaService.save(gestionarMetaFuenteGenericaQuery);
			this.success(gestionarMetaFuenteGenericaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			gestionarMetaFuenteGenericaService.remove(gestionarMetaFuenteGenericaQuery);
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
	
	public GestionarMetaFuenteGenericaService getGestionarMetaFuenteGenericaService() {
		return gestionarMetaFuenteGenericaService;
	}

	public void setGestionarMetaFuenteGenericaService(GestionarMetaFuenteGenericaService gestionarMetaFuenteGenericaService) {
		this.gestionarMetaFuenteGenericaService = gestionarMetaFuenteGenericaService;
	}

	public GestionarMetaFuenteGenericaQuery getGestionarMetaFuenteGenericaQuery() {
		return gestionarMetaFuenteGenericaQuery;
	}

	public void setGestionarMetaFuenteGenericaQuery(GestionarMetaFuenteGenericaQuery gestionarMetaFuenteGenericaQuery) {
		this.gestionarMetaFuenteGenericaQuery = gestionarMetaFuenteGenericaQuery;
	}

/*
<!-- Start Actions GestionarMetaFuenteGenerica -->
<action name="GestionarMetaFuenteGenericaView" class="sernanp.rrhh.web.action.planilla.GestionarMetaFuenteGenericaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarMetaFuenteGenericaCreate" class="sernanp.rrhh.web.action.planilla.GestionarMetaFuenteGenericaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarMetaFuenteGenericaSave" class="sernanp.rrhh.web.action.planilla.GestionarMetaFuenteGenericaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarMetaFuenteGenericaRemove" class="sernanp.rrhh.web.action.planilla.GestionarMetaFuenteGenericaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions GestionarMetaFuenteGenerica -->
*/

}
