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
* DATE CREATE : 07/05/2015 22:38:06
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.RpNominaCASMesAnioFuenteMetaService;
import sernanp.app.dao.query.domain.RpNominaCASMesAnioFuenteMetaQuery;
import sernanp.app.dao.query.domain.RpNominaCASMesAnioFuenteMetaQueryCriteria;
import sernanp.app.dao.query.mapper.RpNominaCASMesAnioFuenteMetaQueryMapper;

public class RpNominaCASMesAnioFuenteMetaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private RpNominaCASMesAnioFuenteMetaService rpNominaCASMesAnioFuenteMetaService;
	
	private RpNominaCASMesAnioFuenteMetaQuery rpNominaCASMesAnioFuenteMetaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			RpNominaCASMesAnioFuenteMetaQueryCriteria rpNominaCASMesAnioFuenteMetaQueryCriteria = this.loadCriteria(this.getHttpRequest(), RpNominaCASMesAnioFuenteMetaQueryCriteria.class);
			List<RpNominaCASMesAnioFuenteMetaQuery> listRpNominaCASMesAnioFuenteMetaQuery = rpNominaCASMesAnioFuenteMetaService.getListByQuery(RpNominaCASMesAnioFuenteMetaQueryMapper.class, rpNominaCASMesAnioFuenteMetaQueryCriteria, start, limit);
			int total = rpNominaCASMesAnioFuenteMetaService.getCountRowsByQuery(RpNominaCASMesAnioFuenteMetaQueryMapper.class, rpNominaCASMesAnioFuenteMetaQueryCriteria);
			
			this.success(listRpNominaCASMesAnioFuenteMetaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			rpNominaCASMesAnioFuenteMetaService.create(rpNominaCASMesAnioFuenteMetaQuery);
			this.success(rpNominaCASMesAnioFuenteMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		
		try{
			
			rpNominaCASMesAnioFuenteMetaService.save(rpNominaCASMesAnioFuenteMetaQuery);
			this.success(rpNominaCASMesAnioFuenteMetaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			rpNominaCASMesAnioFuenteMetaService.remove(rpNominaCASMesAnioFuenteMetaQuery);
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
	
	public RpNominaCASMesAnioFuenteMetaService getRpNominaCASMesAnioFuenteMetaService() {
		return rpNominaCASMesAnioFuenteMetaService;
	}

	public void setRpNominaCASMesAnioFuenteMetaService(RpNominaCASMesAnioFuenteMetaService rpNominaCASMesAnioFuenteMetaService) {
		this.rpNominaCASMesAnioFuenteMetaService = rpNominaCASMesAnioFuenteMetaService;
	}

	public RpNominaCASMesAnioFuenteMetaQuery getRpNominaCASMesAnioFuenteMetaQuery() {
		return rpNominaCASMesAnioFuenteMetaQuery;
	}

	public void setRpNominaCASMesAnioFuenteMetaQuery(RpNominaCASMesAnioFuenteMetaQuery rpNominaCASMesAnioFuenteMetaQuery) {
		this.rpNominaCASMesAnioFuenteMetaQuery = rpNominaCASMesAnioFuenteMetaQuery;
	}

/*
<!-- Start Actions RpNominaCASMesAnioFuenteMeta -->
<action name="RpNominaCASMesAnioFuenteMetaView" class="sernanp.rrhh.web.action.planilla.RpNominaCASMesAnioFuenteMetaAction" method="view">
		<result type="json" />
</action>

<action name="RpNominaCASMesAnioFuenteMetaCreate" class="sernanp.rrhh.web.action.planilla.RpNominaCASMesAnioFuenteMetaAction" method="create">
		<result type="json" />
</action>

<action name="RpNominaCASMesAnioFuenteMetaSave" class="sernanp.rrhh.web.action.planilla.RpNominaCASMesAnioFuenteMetaAction" method="save">
		<result type="json" />
</action>

<action name="RpNominaCASMesAnioFuenteMetaRemove" class="sernanp.rrhh.web.action.planilla.RpNominaCASMesAnioFuenteMetaAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions RpNominaCASMesAnioFuenteMeta -->
*/

}
