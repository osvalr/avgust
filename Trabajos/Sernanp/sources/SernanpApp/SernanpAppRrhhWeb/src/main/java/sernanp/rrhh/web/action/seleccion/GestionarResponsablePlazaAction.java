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
* DATE CREATE : 17/04/2015 16:51:57
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

import sernanp.app.business.core.seleccion.service.GestionarResponsablePlazaService;
import sernanp.app.dao.query.domain.GestionarAsignarResponsableQuery;
import sernanp.app.dao.query.domain.GestionarAsignarResponsableQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarAsignarResponsableQueryMapper;

import sernanp.app.dao.query.domain.ResponsablePlazaQuery;
import sernanp.app.dao.query.mapper.ResponsablePlazaQueryMapper;

public class GestionarResponsablePlazaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarResponsablePlazaService gestionarResponsablePlazaService;
	private GestionarAsignarResponsableQuery gestionarAsignarResponsableQuery;
	private ResponsablePlazaQuery responsablePlazaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarAsignarResponsableQueryCriteria gestionarAsignarResponsableQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarAsignarResponsableQueryCriteria.class);
			List<GestionarAsignarResponsableQuery> listGestionarAsignarResponsableQuery = gestionarResponsablePlazaService.getListByQuery(GestionarAsignarResponsableQueryMapper.class, gestionarAsignarResponsableQueryCriteria, start, limit);
			int total = gestionarResponsablePlazaService.getCountRowsByQuery(GestionarAsignarResponsableQueryMapper.class, gestionarAsignarResponsableQueryCriteria);
			
			this.success(listGestionarAsignarResponsableQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
		
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<ResponsablePlazaQuery> listResponsablePlazaQuery = (List<ResponsablePlazaQuery>) this.getSessionContext().getAttribute("ResponsablePlazaQueryList");
			gestionarResponsablePlazaService.save(gestionarAsignarResponsableQuery,listResponsablePlazaQuery);
			this.getSessionContext().setAttribute("ResponsablePlazaQueryList",null);
			this.success(gestionarAsignarResponsableQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
		
	@SuppressWarnings("unchecked")
	public String ResponsablePlazaQueryList(){
		
		List<ResponsablePlazaQuery> listResponsablePlazaQuery;
		List<ResponsablePlazaQuery> subListResponsablePlazaQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listResponsablePlazaQuery = (List<ResponsablePlazaQuery>) this.getSessionContext().getAttribute("ResponsablePlazaQueryList");
		}else if(idpersonal.equals("-1")){
			listResponsablePlazaQuery = new ArrayList<ResponsablePlazaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listResponsablePlazaQuery = this.gestionarResponsablePlazaService.getListByQuery(ResponsablePlazaQueryMapper.class, paramMap);
		}

		if(listResponsablePlazaQuery == null){
			listResponsablePlazaQuery = new ArrayList<ResponsablePlazaQuery>();
		}
		this.getSessionContext(true).setAttribute("ResponsablePlazaQueryList",listResponsablePlazaQuery);
		int size = listResponsablePlazaQuery.size();
		subListResponsablePlazaQuery = this.getSubList(listResponsablePlazaQuery, start, limit);
		
		this.success(subListResponsablePlazaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ResponsablePlazaQueryAdd(){
		
		List<ResponsablePlazaQuery> listResponsablePlazaQuery = (List<ResponsablePlazaQuery>) this.getSessionContext().getAttribute("ResponsablePlazaQueryList");
//		int randomInt = this.getNegativeIdRandom();
//		responsablePlazaQuery.setSrl_id_conv_area_org(randomInt);
		listResponsablePlazaQuery.add(responsablePlazaQuery);	
		this.getSessionContext().setAttribute("ResponsablePlazaQueryList",listResponsablePlazaQuery);
		this.success(responsablePlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ResponsablePlazaQueryUpdate(){
		
		List<ResponsablePlazaQuery> listResponsablePlazaQuery = (List<ResponsablePlazaQuery>) this.getSessionContext().getAttribute("ResponsablePlazaQueryList");
		int index = -1;
		
		for (int i = 0; i < listResponsablePlazaQuery.size(); i++) {
			if(listResponsablePlazaQuery.get(i).getSrl_id_conv_area_org().equals(responsablePlazaQuery.getSrl_id_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listResponsablePlazaQuery.set(index, responsablePlazaQuery);
		}
		
		this.getSessionContext().setAttribute("ResponsablePlazaQueryList",listResponsablePlazaQuery);
		this.success(responsablePlazaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ResponsablePlazaQueryDelete(){
		
		List<ResponsablePlazaQuery> listResponsablePlazaQuery = (List<ResponsablePlazaQuery>) this.getSessionContext().getAttribute("ResponsablePlazaQueryList");
		int index = -1;
		for (int i = 0; i < listResponsablePlazaQuery.size(); i++) {
			if(listResponsablePlazaQuery.get(i).getSrl_id_conv_area_org().equals(responsablePlazaQuery.getSrl_id_conv_area_org())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listResponsablePlazaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ResponsablePlazaQueryList",listResponsablePlazaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarResponsablePlazaService getGestionarResponsablePlazaService() {
		return gestionarResponsablePlazaService;
	}

	public void setGestionarResponsablePlazaService(GestionarResponsablePlazaService gestionarResponsablePlazaService) {
		this.gestionarResponsablePlazaService = gestionarResponsablePlazaService;
	}
	
	public GestionarAsignarResponsableQuery getGestionarAsignarResponsableQuery() {
		return gestionarAsignarResponsableQuery;
	}

	public void setGestionarAsignarResponsableQuery(GestionarAsignarResponsableQuery gestionarAsignarResponsableQuery) {
		this.gestionarAsignarResponsableQuery = gestionarAsignarResponsableQuery;
	}
	public ResponsablePlazaQuery getResponsablePlazaQuery() {
		return responsablePlazaQuery;
	}

	public void setResponsablePlazaQuery(ResponsablePlazaQuery responsablePlazaQuery) {
		this.responsablePlazaQuery = responsablePlazaQuery;
	}

/*
<!-- Start Actions GestionarResponsablePlaza -->
<action name="GestionarResponsablePlazaView" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarResponsablePlazaCreate" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarResponsablePlazaSave" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarResponsablePlazaRemove" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ResponsablePlazaQuery Actions -->
<action name="ResponsablePlazaQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="ResponsablePlazaQueryList">
		<result type="json" />
</action>

<action name="ResponsablePlazaQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="ResponsablePlazaQueryAdd">
		<result type="json" />
</action>

<action name="ResponsablePlazaQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="ResponsablePlazaQueryUpdate">
		<result type="json" />
</action>

<action name="ResponsablePlazaQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarResponsablePlazaAction" method="ResponsablePlazaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ResponsablePlazaQuery Actions -->

<!-- End Actions GestionarResponsablePlaza -->
*/
}
