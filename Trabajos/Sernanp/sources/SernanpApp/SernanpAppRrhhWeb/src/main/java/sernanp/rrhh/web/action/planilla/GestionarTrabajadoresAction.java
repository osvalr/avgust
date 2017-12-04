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
* DATE CREATE : 27/05/2015 04:42:23
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

import sernanp.app.business.core.planilla.service.GestionarTrabajadoresService;
import sernanp.app.dao.query.domain.GestionarTrabajadoresQuery;
import sernanp.app.dao.query.domain.GestionarTrabajadoresQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarTrabajadoresQueryMapper;

import sernanp.app.dao.query.domain.GestionarTrabajadoresPresupuestoQuery;
import sernanp.app.dao.query.mapper.GestionarTrabajadoresPresupuestoQueryMapper;

public class GestionarTrabajadoresAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarTrabajadoresService gestionarTrabajadoresService;
	private GestionarTrabajadoresQuery gestionarTrabajadoresQuery;
	private GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarTrabajadoresQueryCriteria gestionarTrabajadoresQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarTrabajadoresQueryCriteria.class);
			List<GestionarTrabajadoresQuery> listGestionarTrabajadoresQuery = gestionarTrabajadoresService.getListByQuery(GestionarTrabajadoresQueryMapper.class, gestionarTrabajadoresQueryCriteria, start, limit);
			int total = gestionarTrabajadoresService.getCountRowsByQuery(GestionarTrabajadoresQueryMapper.class, gestionarTrabajadoresQueryCriteria);
			
			this.success(listGestionarTrabajadoresQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
			gestionarTrabajadoresService.create(gestionarTrabajadoresQuery,listGestionarTrabajadoresPresupuestoQuery);
			this.getSessionContext().setAttribute("GestionarTrabajadoresPresupuestoQueryList",null);
			this.success(gestionarTrabajadoresQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
			gestionarTrabajadoresService.save(gestionarTrabajadoresQuery,listGestionarTrabajadoresPresupuestoQuery);
			this.getSessionContext().setAttribute("GestionarTrabajadoresPresupuestoQueryList",null);
			this.success(gestionarTrabajadoresQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonanatural", gestionarTrabajadoresQuery.getIdpersonanatural());
			List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = this.gestionarTrabajadoresService.getListByQuery(GestionarTrabajadoresPresupuestoQueryMapper.class, paramMap);
			gestionarTrabajadoresService.remove(gestionarTrabajadoresQuery,listGestionarTrabajadoresPresupuestoQuery);
			this.getSessionContext().removeAttribute("GestionarTrabajadoresPresupuestoQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarTrabajadoresPresupuestoQueryList(){
		
		List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery;
		List<GestionarTrabajadoresPresupuestoQuery> subListGestionarTrabajadoresPresupuestoQuery;

		Integer idpersonanatural = this.getIntegerParameter("idpersonanatural");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		
		if(idpersonanatural == null){
			listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
		}else if(idpersonanatural.equals("-1")){
			listGestionarTrabajadoresPresupuestoQuery = new ArrayList<GestionarTrabajadoresPresupuestoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonanatural", idpersonanatural);
			listGestionarTrabajadoresPresupuestoQuery = this.gestionarTrabajadoresService.getListByQuery(GestionarTrabajadoresPresupuestoQueryMapper.class, paramMap);
		}

		if(listGestionarTrabajadoresPresupuestoQuery == null){
			listGestionarTrabajadoresPresupuestoQuery = new ArrayList<GestionarTrabajadoresPresupuestoQuery>();
		}
		this.getSessionContext(true).setAttribute("GestionarTrabajadoresPresupuestoQueryList",listGestionarTrabajadoresPresupuestoQuery);
		int size = listGestionarTrabajadoresPresupuestoQuery.size();
		subListGestionarTrabajadoresPresupuestoQuery = this.getSubList(listGestionarTrabajadoresPresupuestoQuery, start, limit);
		
		this.success(subListGestionarTrabajadoresPresupuestoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarTrabajadoresPresupuestoQueryAdd(){
		
		List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
		
		int randomInt = this.getNegativeIdRandom();					
		gestionarTrabajadoresPresupuestoQuery.setIdpersonanatural(randomInt);
		listGestionarTrabajadoresPresupuestoQuery.add(gestionarTrabajadoresPresupuestoQuery);	
		
		this.getSessionContext().setAttribute("GestionarTrabajadoresPresupuestoQueryList",listGestionarTrabajadoresPresupuestoQuery);
		this.success(gestionarTrabajadoresPresupuestoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarTrabajadoresPresupuestoQueryUpdate(){
		
		List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
		int index = -1;
		
		for (int i = 0; i < listGestionarTrabajadoresPresupuestoQuery.size(); i++) {
			if(listGestionarTrabajadoresPresupuestoQuery.get(i).getIdpersonanatural().equals(gestionarTrabajadoresPresupuestoQuery.getIdpersonanatural())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarTrabajadoresPresupuestoQuery.set(index, gestionarTrabajadoresPresupuestoQuery);
		}
		
		this.getSessionContext().setAttribute("GestionarTrabajadoresPresupuestoQueryList",listGestionarTrabajadoresPresupuestoQuery);
		this.success(gestionarTrabajadoresPresupuestoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarTrabajadoresPresupuestoQueryDelete(){
		
		List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery = (List<GestionarTrabajadoresPresupuestoQuery>) this.getSessionContext().getAttribute("GestionarTrabajadoresPresupuestoQueryList");
		int index = -1;
		for (int i = 0; i < listGestionarTrabajadoresPresupuestoQuery.size(); i++) {
			if(listGestionarTrabajadoresPresupuestoQuery.get(i).getIdpersonanatural().equals(gestionarTrabajadoresPresupuestoQuery.getIdpersonanatural())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarTrabajadoresPresupuestoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("GestionarTrabajadoresPresupuestoQueryList",listGestionarTrabajadoresPresupuestoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarTrabajadoresService getGestionarTrabajadoresService() {
		return gestionarTrabajadoresService;
	}

	public void setGestionarTrabajadoresService(GestionarTrabajadoresService gestionarTrabajadoresService) {
		this.gestionarTrabajadoresService = gestionarTrabajadoresService;
	}
	
	public GestionarTrabajadoresQuery getGestionarTrabajadoresQuery() {
		return gestionarTrabajadoresQuery;
	}

	public void setGestionarTrabajadoresQuery(GestionarTrabajadoresQuery gestionarTrabajadoresQuery) {
		this.gestionarTrabajadoresQuery = gestionarTrabajadoresQuery;
	}
	public GestionarTrabajadoresPresupuestoQuery getGestionarTrabajadoresPresupuestoQuery() {
		return gestionarTrabajadoresPresupuestoQuery;
	}

	public void setGestionarTrabajadoresPresupuestoQuery(GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery) {
		this.gestionarTrabajadoresPresupuestoQuery = gestionarTrabajadoresPresupuestoQuery;
	}

/*
<!-- Start Actions GestionarTrabajadores -->
<action name="GestionarTrabajadoresView" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="view">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresCreate" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="create">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresSave" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="save">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresRemove" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model GestionarTrabajadoresPresupuestoQuery Actions -->
<action name="GestionarTrabajadoresPresupuestoQueryList" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="GestionarTrabajadoresPresupuestoQueryList">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresPresupuestoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="GestionarTrabajadoresPresupuestoQueryAdd">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresPresupuestoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="GestionarTrabajadoresPresupuestoQueryUpdate">
		<result type="json" />
</action>

<action name="GestionarTrabajadoresPresupuestoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarTrabajadoresAction" method="GestionarTrabajadoresPresupuestoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model GestionarTrabajadoresPresupuestoQuery Actions -->

<!-- End Actions GestionarTrabajadores -->
*/
}
