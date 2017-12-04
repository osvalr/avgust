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
* DATE CREATE : 18/04/2015 17:45:06
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

import sernanp.app.business.core.seleccion.service.GestionarFactorEvaluacionService;
import sernanp.app.dao.query.domain.GestionarConfigFactorEvalQuery;
import sernanp.app.dao.query.domain.GestionarConfigFactorEvalQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarConfigFactorEvalQueryMapper;

import sernanp.app.dao.query.domain.FactorEvaluacionQuery;
import sernanp.app.dao.query.mapper.FactorEvaluacionQueryMapper;

public class GestionarFactorEvaluacionAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarFactorEvaluacionService gestionarFactorEvaluacionService;
	private GestionarConfigFactorEvalQuery gestionarConfigFactorEvalQuery;
	private FactorEvaluacionQuery factorEvaluacionQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarConfigFactorEvalQueryCriteria gestionarConfigFactorEvalQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarConfigFactorEvalQueryCriteria.class);
			List<GestionarConfigFactorEvalQuery> listGestionarConfigFactorEvalQuery = gestionarFactorEvaluacionService.getListByQuery(GestionarConfigFactorEvalQueryMapper.class, gestionarConfigFactorEvalQueryCriteria, start, limit);
			int total = gestionarFactorEvaluacionService.getCountRowsByQuery(GestionarConfigFactorEvalQueryMapper.class, gestionarConfigFactorEvalQueryCriteria);
			
			this.success(listGestionarConfigFactorEvalQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<FactorEvaluacionQuery> listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
			gestionarFactorEvaluacionService.create(gestionarConfigFactorEvalQuery,listFactorEvaluacionQuery);
			this.getSessionContext().setAttribute("FactorEvaluacionQueryList",null);
			this.success(gestionarConfigFactorEvalQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<FactorEvaluacionQuery> listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
			gestionarFactorEvaluacionService.save(gestionarConfigFactorEvalQuery,listFactorEvaluacionQuery);
			this.getSessionContext().setAttribute("FactorEvaluacionQueryList",null);
			this.success(gestionarConfigFactorEvalQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_configuracion_factor_evaluacion", gestionarConfigFactorEvalQuery.getSrl_id_configuracion_factor_evaluacion());
			List<FactorEvaluacionQuery> listFactorEvaluacionQuery = this.gestionarFactorEvaluacionService.getListByQuery(FactorEvaluacionQueryMapper.class, paramMap);
			gestionarFactorEvaluacionService.remove(gestionarConfigFactorEvalQuery,listFactorEvaluacionQuery);
			this.getSessionContext().removeAttribute("FactorEvaluacionQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String FactorEvaluacionQueryList(){
		
		List<FactorEvaluacionQuery> listFactorEvaluacionQuery;
		List<FactorEvaluacionQuery> subListFactorEvaluacionQuery;
		Integer srl_id_configuracion_factor_evaluacion = this.getIntegerParameter("srl_id_configuracion_factor_evaluacion");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_configuracion_factor_evaluacion == null){
			listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
		}else if(srl_id_configuracion_factor_evaluacion.equals("-1")){
			listFactorEvaluacionQuery = new ArrayList<FactorEvaluacionQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_configuracion_factor_evaluacion", srl_id_configuracion_factor_evaluacion);
			listFactorEvaluacionQuery = this.gestionarFactorEvaluacionService.getListByQuery(FactorEvaluacionQueryMapper.class, paramMap);
		}

		if(listFactorEvaluacionQuery == null){
			listFactorEvaluacionQuery = new ArrayList<FactorEvaluacionQuery>();
		}
		this.getSessionContext(true).setAttribute("FactorEvaluacionQueryList",listFactorEvaluacionQuery);
		int size = listFactorEvaluacionQuery.size();
		subListFactorEvaluacionQuery = this.getSubList(listFactorEvaluacionQuery, start, limit);
		
		this.success(subListFactorEvaluacionQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String FactorEvaluacionQueryAdd(){
		
		List<FactorEvaluacionQuery> listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
		int randomInt = this.getNegativeIdRandom();
		factorEvaluacionQuery.setSrl_id_factor_evaluacion(randomInt);
		listFactorEvaluacionQuery.add(factorEvaluacionQuery);	
		this.getSessionContext().setAttribute("FactorEvaluacionQueryList",listFactorEvaluacionQuery);
		this.success(factorEvaluacionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String FactorEvaluacionQueryUpdate(){
		
		List<FactorEvaluacionQuery> listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
		int index = -1;
		
		for (int i = 0; i < listFactorEvaluacionQuery.size(); i++) {
			if(listFactorEvaluacionQuery.get(i).getSrl_id_factor_evaluacion().equals(factorEvaluacionQuery.getSrl_id_factor_evaluacion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listFactorEvaluacionQuery.set(index, factorEvaluacionQuery);
		}
		
		this.getSessionContext().setAttribute("FactorEvaluacionQueryList",listFactorEvaluacionQuery);
		this.success(factorEvaluacionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String FactorEvaluacionQueryDelete(){
		
		List<FactorEvaluacionQuery> listFactorEvaluacionQuery = (List<FactorEvaluacionQuery>) this.getSessionContext().getAttribute("FactorEvaluacionQueryList");
		int index = -1;
		for (int i = 0; i < listFactorEvaluacionQuery.size(); i++) {
			if(listFactorEvaluacionQuery.get(i).getSrl_id_factor_evaluacion().equals(factorEvaluacionQuery.getSrl_id_factor_evaluacion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listFactorEvaluacionQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("FactorEvaluacionQueryList",listFactorEvaluacionQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarFactorEvaluacionService getGestionarFactorEvaluacionService() {
		return gestionarFactorEvaluacionService;
	}

	public void setGestionarFactorEvaluacionService(GestionarFactorEvaluacionService gestionarFactorEvaluacionService) {
		this.gestionarFactorEvaluacionService = gestionarFactorEvaluacionService;
	}
	
	public GestionarConfigFactorEvalQuery getGestionarConfigFactorEvalQuery() {
		return gestionarConfigFactorEvalQuery;
	}

	public void setGestionarConfigFactorEvalQuery(GestionarConfigFactorEvalQuery gestionarConfigFactorEvalQuery) {
		this.gestionarConfigFactorEvalQuery = gestionarConfigFactorEvalQuery;
	}
	public FactorEvaluacionQuery getFactorEvaluacionQuery() {
		return factorEvaluacionQuery;
	}

	public void setFactorEvaluacionQuery(FactorEvaluacionQuery factorEvaluacionQuery) {
		this.factorEvaluacionQuery = factorEvaluacionQuery;
	}

/*
<!-- Start Actions GestionarFactorEvaluacion -->
<action name="GestionarFactorEvaluacionView" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="view">
		<result type="json" />
</action>

<action name="GestionarFactorEvaluacionCreate" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="create">
		<result type="json" />
</action>

<action name="GestionarFactorEvaluacionSave" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="save">
		<result type="json" />
</action>

<action name="GestionarFactorEvaluacionRemove" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model FactorEvaluacionQuery Actions -->
<action name="FactorEvaluacionQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="FactorEvaluacionQueryList">
		<result type="json" />
</action>

<action name="FactorEvaluacionQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="FactorEvaluacionQueryAdd">
		<result type="json" />
</action>

<action name="FactorEvaluacionQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="FactorEvaluacionQueryUpdate">
		<result type="json" />
</action>

<action name="FactorEvaluacionQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarFactorEvaluacionAction" method="FactorEvaluacionQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model FactorEvaluacionQuery Actions -->

<!-- End Actions GestionarFactorEvaluacion -->
*/
}
