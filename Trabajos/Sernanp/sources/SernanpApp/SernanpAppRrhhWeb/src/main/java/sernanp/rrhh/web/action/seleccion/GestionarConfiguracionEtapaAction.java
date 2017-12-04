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
* DATE CREATE : 18/04/2015 19:13:57
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

import sernanp.app.business.core.seleccion.service.GestionarConfiguracionEtapaService;
import sernanp.app.dao.query.domain.GestionarConfiguarionEtapaQuery;
import sernanp.app.dao.query.domain.GestionarConfiguarionEtapaQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarConfiguarionEtapaQueryMapper;

import sernanp.app.dao.query.domain.ConfiguracionEtapaQuery;
import sernanp.app.dao.query.mapper.ConfiguracionEtapaQueryMapper;

public class GestionarConfiguracionEtapaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarConfiguracionEtapaService gestionarConfiguracionEtapaService;
	private GestionarConfiguarionEtapaQuery gestionarConfiguarionEtapaQuery;
	private ConfiguracionEtapaQuery configuracionEtapaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarConfiguarionEtapaQueryCriteria gestionarConfiguarionEtapaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarConfiguarionEtapaQueryCriteria.class);
			List<GestionarConfiguarionEtapaQuery> listGestionarConfiguarionEtapaQuery = gestionarConfiguracionEtapaService.getListByQuery(GestionarConfiguarionEtapaQueryMapper.class, gestionarConfiguarionEtapaQueryCriteria, start, limit);
			int total = gestionarConfiguracionEtapaService.getCountRowsByQuery(GestionarConfiguarionEtapaQueryMapper.class, gestionarConfiguarionEtapaQueryCriteria);
			
			this.success(listGestionarConfiguarionEtapaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
			gestionarConfiguracionEtapaService.create(gestionarConfiguarionEtapaQuery,listConfiguracionEtapaQuery);
			this.getSessionContext().setAttribute("ConfiguracionEtapaQueryList",null);
			this.success(gestionarConfiguarionEtapaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
			gestionarConfiguracionEtapaService.save(gestionarConfiguarionEtapaQuery,listConfiguracionEtapaQuery);
			this.getSessionContext().setAttribute("ConfiguracionEtapaQueryList",null);
			this.success(gestionarConfiguarionEtapaQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_configuracion_evaluacion_personal", gestionarConfiguarionEtapaQuery.getSrl_id_configuracion_evaluacion_personal());
			List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = this.gestionarConfiguracionEtapaService.getListByQuery(ConfiguracionEtapaQueryMapper.class, paramMap);
			gestionarConfiguracionEtapaService.remove(gestionarConfiguarionEtapaQuery,listConfiguracionEtapaQuery);
			this.getSessionContext().removeAttribute("ConfiguracionEtapaQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConfiguracionEtapaQueryList(){
		
		List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery;
		List<ConfiguracionEtapaQuery> subListConfiguracionEtapaQuery;
		Integer srl_id_configuracion_evaluacion_personal = this.getIntegerParameter("srl_id_configuracion_evaluacion_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_configuracion_evaluacion_personal == null){
			listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
		}else if(srl_id_configuracion_evaluacion_personal.equals("-1")){
			listConfiguracionEtapaQuery = new ArrayList<ConfiguracionEtapaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_configuracion_evaluacion_personal", srl_id_configuracion_evaluacion_personal);
			listConfiguracionEtapaQuery = this.gestionarConfiguracionEtapaService.getListByQuery(ConfiguracionEtapaQueryMapper.class, paramMap);
		}

		if(listConfiguracionEtapaQuery == null){
			listConfiguracionEtapaQuery = new ArrayList<ConfiguracionEtapaQuery>();
		}
		this.getSessionContext(true).setAttribute("ConfiguracionEtapaQueryList",listConfiguracionEtapaQuery);
		int size = listConfiguracionEtapaQuery.size();
		subListConfiguracionEtapaQuery = this.getSubList(listConfiguracionEtapaQuery, start, limit);
		
		this.success(subListConfiguracionEtapaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConfiguracionEtapaQueryAdd(){
		
		List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
		int randomInt = this.getNegativeIdRandom();
		configuracionEtapaQuery.setSrl_id_configuracion_etapa(randomInt);
		listConfiguracionEtapaQuery.add(configuracionEtapaQuery);	
		this.getSessionContext().setAttribute("ConfiguracionEtapaQueryList",listConfiguracionEtapaQuery);
		this.success(configuracionEtapaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConfiguracionEtapaQueryUpdate(){
		
		List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
		int index = -1;
		
		for (int i = 0; i < listConfiguracionEtapaQuery.size(); i++) {
			if(listConfiguracionEtapaQuery.get(i).getSrl_id_configuracion_etapa().equals(configuracionEtapaQuery.getSrl_id_configuracion_etapa())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConfiguracionEtapaQuery.set(index, configuracionEtapaQuery);
		}
		
		this.getSessionContext().setAttribute("ConfiguracionEtapaQueryList",listConfiguracionEtapaQuery);
		this.success(configuracionEtapaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConfiguracionEtapaQueryDelete(){
		
		List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery = (List<ConfiguracionEtapaQuery>) this.getSessionContext().getAttribute("ConfiguracionEtapaQueryList");
		int index = -1;
		for (int i = 0; i < listConfiguracionEtapaQuery.size(); i++) {
			if(listConfiguracionEtapaQuery.get(i).getSrl_id_configuracion_etapa().equals(configuracionEtapaQuery.getSrl_id_configuracion_etapa())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConfiguracionEtapaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConfiguracionEtapaQueryList",listConfiguracionEtapaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarConfiguracionEtapaService getGestionarConfiguracionEtapaService() {
		return gestionarConfiguracionEtapaService;
	}

	public void setGestionarConfiguracionEtapaService(GestionarConfiguracionEtapaService gestionarConfiguracionEtapaService) {
		this.gestionarConfiguracionEtapaService = gestionarConfiguracionEtapaService;
	}
	
	public GestionarConfiguarionEtapaQuery getGestionarConfiguarionEtapaQuery() {
		return gestionarConfiguarionEtapaQuery;
	}

	public void setGestionarConfiguarionEtapaQuery(GestionarConfiguarionEtapaQuery gestionarConfiguarionEtapaQuery) {
		this.gestionarConfiguarionEtapaQuery = gestionarConfiguarionEtapaQuery;
	}
	public ConfiguracionEtapaQuery getConfiguracionEtapaQuery() {
		return configuracionEtapaQuery;
	}

	public void setConfiguracionEtapaQuery(ConfiguracionEtapaQuery configuracionEtapaQuery) {
		this.configuracionEtapaQuery = configuracionEtapaQuery;
	}

/*
<!-- Start Actions GestionarConfiguracionEtapa -->
<action name="GestionarConfiguracionEtapaView" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarConfiguracionEtapaCreate" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarConfiguracionEtapaSave" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarConfiguracionEtapaRemove" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ConfiguracionEtapaQuery Actions -->
<action name="ConfiguracionEtapaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="ConfiguracionEtapaQueryList">
		<result type="json" />
</action>

<action name="ConfiguracionEtapaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="ConfiguracionEtapaQueryAdd">
		<result type="json" />
</action>

<action name="ConfiguracionEtapaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="ConfiguracionEtapaQueryUpdate">
		<result type="json" />
</action>

<action name="ConfiguracionEtapaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarConfiguracionEtapaAction" method="ConfiguracionEtapaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConfiguracionEtapaQuery Actions -->

<!-- End Actions GestionarConfiguracionEtapa -->
*/
}
