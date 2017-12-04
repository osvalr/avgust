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
* DATE CREATE : 17/03/2015 19:55:09
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.planilla.service.GestionarAfpService;
import sernanp.app.dao.query.domain.GestionarAfpPlanillaQuery;
import sernanp.app.dao.query.domain.GestionarAfpPlanillaQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarAfpPlanillaQueryMapper;

import sernanp.app.dao.query.domain.GestionarAfpPlanillaComisionQuery;
import sernanp.app.dao.query.mapper.GestionarAfpPlanillaComisionQueryMapper;

public class GestionarAfpAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarAfpService gestionarAfpService;
	private GestionarAfpPlanillaQuery gestionarAfpPlanillaQuery;
	private GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarAfpPlanillaQueryCriteria gestionarAfpPlanillaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarAfpPlanillaQueryCriteria.class);
			List<GestionarAfpPlanillaQuery> listGestionarAfpPlanillaQuery = gestionarAfpService.getListByQuery(GestionarAfpPlanillaQueryMapper.class, gestionarAfpPlanillaQueryCriteria, start, limit);
			int total = gestionarAfpService.getCountRowsByQuery(GestionarAfpPlanillaQueryMapper.class, gestionarAfpPlanillaQueryCriteria);
			
			this.success(listGestionarAfpPlanillaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
			gestionarAfpService.create(gestionarAfpPlanillaQuery,listGestionarAfpPlanillaComisionQuery);
			this.getSessionContext().setAttribute("GestionarAfpPlanillaComisionQueryList",null);
			this.success(gestionarAfpPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
			gestionarAfpService.save(gestionarAfpPlanillaQuery,listGestionarAfpPlanillaComisionQuery);
			this.getSessionContext().setAttribute("GestionarAfpPlanillaComisionQueryList",null);
			this.success(gestionarAfpPlanillaQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_afp", gestionarAfpPlanillaQuery.getSrl_id_afp());
			List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = this.gestionarAfpService.getListByQuery(GestionarAfpPlanillaComisionQueryMapper.class, paramMap);
			gestionarAfpService.remove(gestionarAfpPlanillaQuery,listGestionarAfpPlanillaComisionQuery);
			this.getSessionContext().removeAttribute("GestionarAfpPlanillaComisionQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAfpPlanillaComisionQueryList(){
		
		List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery;
		List<GestionarAfpPlanillaComisionQuery> subListGestionarAfpPlanillaComisionQuery;
		Integer srl_id_afp = this.getIntegerParameter("srl_id_afp");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_afp == null){
			listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
		}else if(srl_id_afp.equals("-1")){
			listGestionarAfpPlanillaComisionQuery = new ArrayList<GestionarAfpPlanillaComisionQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_afp", srl_id_afp);
			listGestionarAfpPlanillaComisionQuery = this.gestionarAfpService.getListByQuery(GestionarAfpPlanillaComisionQueryMapper.class, paramMap);
		}

		if(listGestionarAfpPlanillaComisionQuery == null){
			listGestionarAfpPlanillaComisionQuery = new ArrayList<GestionarAfpPlanillaComisionQuery>();
		}
		this.getSessionContext(true).setAttribute("GestionarAfpPlanillaComisionQueryList",listGestionarAfpPlanillaComisionQuery);
		int size = listGestionarAfpPlanillaComisionQuery.size();
		subListGestionarAfpPlanillaComisionQuery = this.getSubList(listGestionarAfpPlanillaComisionQuery, start, limit);
		
		this.success(subListGestionarAfpPlanillaComisionQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAfpPlanillaComisionQueryAdd(){
		
		List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
		int randomInt = this.getNegativeIdRandom();
		gestionarAfpPlanillaComisionQuery.setSrl_id_afp_comision(randomInt);
		listGestionarAfpPlanillaComisionQuery.add(gestionarAfpPlanillaComisionQuery);	
		this.getSessionContext().setAttribute("GestionarAfpPlanillaComisionQueryList",listGestionarAfpPlanillaComisionQuery);
		this.success(gestionarAfpPlanillaComisionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAfpPlanillaComisionQueryUpdate(){
		
		List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
		int index = -1;
		
		for (int i = 0; i < listGestionarAfpPlanillaComisionQuery.size(); i++) {
			if(listGestionarAfpPlanillaComisionQuery.get(i).getSrl_id_afp_comision().equals(gestionarAfpPlanillaComisionQuery.getSrl_id_afp_comision())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarAfpPlanillaComisionQuery.set(index, gestionarAfpPlanillaComisionQuery);
		}
		
		this.getSessionContext().setAttribute("GestionarAfpPlanillaComisionQueryList",listGestionarAfpPlanillaComisionQuery);
		this.success(gestionarAfpPlanillaComisionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAfpPlanillaComisionQueryDelete(){
		
		List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery = (List<GestionarAfpPlanillaComisionQuery>) this.getSessionContext().getAttribute("GestionarAfpPlanillaComisionQueryList");
		int index = -1;
		for (int i = 0; i < listGestionarAfpPlanillaComisionQuery.size(); i++) {
			if(listGestionarAfpPlanillaComisionQuery.get(i).getSrl_id_afp_comision().equals(gestionarAfpPlanillaComisionQuery.getSrl_id_afp_comision())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarAfpPlanillaComisionQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("GestionarAfpPlanillaComisionQueryList",listGestionarAfpPlanillaComisionQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarAfpService getGestionarAfpService() {
		return gestionarAfpService;
	}

	public void setGestionarAfpService(GestionarAfpService gestionarAfpService) {
		this.gestionarAfpService = gestionarAfpService;
	}
	
	public GestionarAfpPlanillaQuery getGestionarAfpPlanillaQuery() {
		return gestionarAfpPlanillaQuery;
	}

	public void setGestionarAfpPlanillaQuery(GestionarAfpPlanillaQuery gestionarAfpPlanillaQuery) {
		this.gestionarAfpPlanillaQuery = gestionarAfpPlanillaQuery;
	}
	public GestionarAfpPlanillaComisionQuery getGestionarAfpPlanillaComisionQuery() {
		return gestionarAfpPlanillaComisionQuery;
	}

	public void setGestionarAfpPlanillaComisionQuery(GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery) {
		this.gestionarAfpPlanillaComisionQuery = gestionarAfpPlanillaComisionQuery;
	}

/*
<!-- Start Actions GestionarAfp -->
<action name="GestionarAfpView" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="view">
		<result type="json" />
</action>

<action name="GestionarAfpCreate" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="create">
		<result type="json" />
</action>

<action name="GestionarAfpSave" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="save">
		<result type="json" />
</action>

<action name="GestionarAfpRemove" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model GestionarAfpPlanillaComisionQuery Actions -->
<action name="GestionarAfpPlanillaComisionQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="GestionarAfpPlanillaComisionQueryList">
		<result type="json" />
</action>

<action name="GestionarAfpPlanillaComisionQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="GestionarAfpPlanillaComisionQueryAdd">
		<result type="json" />
</action>

<action name="GestionarAfpPlanillaComisionQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="GestionarAfpPlanillaComisionQueryUpdate">
		<result type="json" />
</action>

<action name="GestionarAfpPlanillaComisionQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAfpAction" method="GestionarAfpPlanillaComisionQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model GestionarAfpPlanillaComisionQuery Actions -->

<!-- End Actions GestionarAfp -->
*/
}
