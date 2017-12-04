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
* DATE CREATE : 20/04/2015 14:52:17
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.seleccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.seleccion.service.GestionarNotasPostulanteService;
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQuery;
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarNotasPostulanteQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GestionarNotasPostulanteAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarNotasPostulanteService gestionarNotasPostulanteService;
	
	private GestionarNotasPostulanteQuery gestionarNotasPostulanteQuery;
	
	public String view(){
		System.out.println("GestionarNotasPostulanteAction - view");
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarNotasPostulanteQueryCriteria gestionarNotasPostulanteQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarNotasPostulanteQueryCriteria.class);
			List<GestionarNotasPostulanteQuery> listGestionarNotasPostulanteQuery = gestionarNotasPostulanteService.getListByQuery(GestionarNotasPostulanteQueryMapper.class, gestionarNotasPostulanteQueryCriteria, start, limit);
			
			if(listGestionarNotasPostulanteQuery.isEmpty()){
				gestionarNotasPostulanteService.agregarFactores(gestionarNotasPostulanteQueryCriteria.getSrl_id_postulante_conv_area_org());
			}
			
			listGestionarNotasPostulanteQuery = gestionarNotasPostulanteService.getListByQuery(GestionarNotasPostulanteQueryMapper.class, gestionarNotasPostulanteQueryCriteria, start, limit);
			int total = gestionarNotasPostulanteService.getCountRowsByQuery(GestionarNotasPostulanteQueryMapper.class, gestionarNotasPostulanteQueryCriteria);
			
			this.success(listGestionarNotasPostulanteQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String create(){
		
		try{
			
			gestionarNotasPostulanteService.create(gestionarNotasPostulanteQuery);
			this.success(gestionarNotasPostulanteQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String save(){
		System.out.println("Guardando nota ...");
		try{
			
			gestionarNotasPostulanteService.save(gestionarNotasPostulanteQuery);
			this.success(gestionarNotasPostulanteQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
			gestionarNotasPostulanteService.remove(gestionarNotasPostulanteQuery);
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
	
	public GestionarNotasPostulanteService getGestionarNotasPostulanteService() {
		return gestionarNotasPostulanteService;
	}

	public void setGestionarNotasPostulanteService(GestionarNotasPostulanteService gestionarNotasPostulanteService) {
		this.gestionarNotasPostulanteService = gestionarNotasPostulanteService;
	}

	public GestionarNotasPostulanteQuery getGestionarNotasPostulanteQuery() {
		return gestionarNotasPostulanteQuery;
	}

	public void setGestionarNotasPostulanteQuery(GestionarNotasPostulanteQuery gestionarNotasPostulanteQuery) {
		this.gestionarNotasPostulanteQuery = gestionarNotasPostulanteQuery;
	}

/*
<!-- Start Actions GestionarNotasPostulante -->
<action name="GestionarNotasPostulanteView" class="sernanp.rrhh.web.action.seleccion.GestionarNotasPostulanteAction" method="view">
		<result type="json" />
</action>

<action name="GestionarNotasPostulanteCreate" class="sernanp.rrhh.web.action.seleccion.GestionarNotasPostulanteAction" method="create">
		<result type="json" />
</action>

<action name="GestionarNotasPostulanteSave" class="sernanp.rrhh.web.action.seleccion.GestionarNotasPostulanteAction" method="save">
		<result type="json" />
</action>

<action name="GestionarNotasPostulanteRemove" class="sernanp.rrhh.web.action.seleccion.GestionarNotasPostulanteAction" method="remove">
		<result type="json" />
</action>
<!-- End Actions GestionarNotasPostulante -->
*/

}
