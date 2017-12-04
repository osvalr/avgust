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
* DATE CREATE : 13/05/2015 03:25:11
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.RpNomina728MesAnioFuenteMetaService;
import sernanp.app.dao.query.domain.RpNomina728MesAnioFuenteMetaQuery;
import sernanp.app.dao.query.domain.RpNomina728MesAnioFuenteMetaQueryCriteria;
import sernanp.app.dao.query.mapper.RpNomina728MesAnioFuenteMetaQueryMapper;

public class RpNomina728MesAnioFuenteMetaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RpNomina728MesAnioFuenteMetaService rpNomina728MesAnioFuenteMetaService;
	
	private RpNomina728MesAnioFuenteMetaQuery rpNomina728MesAnioFuenteMetaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpNomina728MesAnioFuenteMetaQueryCriteria rpNomina728MesAnioFuenteMetaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpNomina728MesAnioFuenteMetaQueryCriteria.class);
			List<RpNomina728MesAnioFuenteMetaQuery> listRpNomina728MesAnioFuenteMetaQuery = rpNomina728MesAnioFuenteMetaService.getListByQuery(RpNomina728MesAnioFuenteMetaQueryMapper.class, rpNomina728MesAnioFuenteMetaQueryCriteria, start, limit);
			int total = rpNomina728MesAnioFuenteMetaService.getCountRowsByQuery(RpNomina728MesAnioFuenteMetaQueryMapper.class, rpNomina728MesAnioFuenteMetaQueryCriteria);
			
			this.success(listRpNomina728MesAnioFuenteMetaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rpNomina728MesAnioFuenteMetaService.create(rpNomina728MesAnioFuenteMetaQuery);
			this.success(rpNomina728MesAnioFuenteMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rpNomina728MesAnioFuenteMetaService.save(rpNomina728MesAnioFuenteMetaQuery);
			this.success(rpNomina728MesAnioFuenteMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rpNomina728MesAnioFuenteMetaService.remove(rpNomina728MesAnioFuenteMetaQuery);
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
	
	public RpNomina728MesAnioFuenteMetaService getRpNomina728MesAnioFuenteMetaService() {
		return rpNomina728MesAnioFuenteMetaService;
	}

	public void setRpNomina728MesAnioFuenteMetaService(RpNomina728MesAnioFuenteMetaService rpNomina728MesAnioFuenteMetaService) {
		this.rpNomina728MesAnioFuenteMetaService = rpNomina728MesAnioFuenteMetaService;
	}

	public RpNomina728MesAnioFuenteMetaQuery getRpNomina728MesAnioFuenteMetaQuery() {
		return rpNomina728MesAnioFuenteMetaQuery;
	}

	public void setRpNomina728MesAnioFuenteMetaQuery(RpNomina728MesAnioFuenteMetaQuery rpNomina728MesAnioFuenteMetaQuery) {
		this.rpNomina728MesAnioFuenteMetaQuery = rpNomina728MesAnioFuenteMetaQuery;
	}

/*
<!-- Start Actions RpNomina728MesAnioFuenteMeta -->
<action name="RpNomina728MesAnioFuenteMetaView" class="sernanp.rrhh.web.action.planilla.RpNomina728MesAnioFuenteMetaAction" method="view">
		<result type="json" />
</action>

<action name="RpNomina728MesAnioFuenteMetaCreate" class="sernanp.rrhh.web.action.planilla.RpNomina728MesAnioFuenteMetaAction" method="create">
		<result type="json" />
</action>

<action name="RpNomina728MesAnioFuenteMetaSave" class="sernanp.rrhh.web.action.planilla.RpNomina728MesAnioFuenteMetaAction" method="save">
		<result type="json" />
</action>

<action name="RpNomina728MesAnioFuenteMetaRemove" class="sernanp.rrhh.web.action.planilla.RpNomina728MesAnioFuenteMetaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RpNomina728MesAnioFuenteMeta -->
*/

}
