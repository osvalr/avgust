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
* DATE CREATE : 18/04/2015 18:55:24
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
import sernanp.app.business.core.seleccion.service.GestionarEtapaProcesoSeleccionService;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQuery;
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQuery;
import sernanp.app.dao.query.domain.GestionarEtapasProcesoSeleccionQuery;
import sernanp.app.dao.query.domain.GestionarEtapasProcesoSeleccionQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarEtapasProcesoSeleccionQueryMapper;
import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQuery;
import sernanp.app.dao.query.mapper.SubEtapaProcesoSelecionQueryMapper;

public class GestionarEtapaProcesoSeleccionAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarEtapaProcesoSeleccionService gestionarEtapaProcesoSeleccionService;
	private GestionarEtapasProcesoSeleccionQuery gestionarEtapasProcesoSeleccionQuery;
	private SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery;
	private GestionarConvocatoriaPersonalQuery gestionarConvocatoriaPersonalQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarEtapasProcesoSeleccionQueryCriteria gestionarEtapasProcesoSeleccionQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarEtapasProcesoSeleccionQueryCriteria.class);
			List<GestionarEtapasProcesoSeleccionQuery> listGestionarEtapasProcesoSeleccionQuery = gestionarEtapaProcesoSeleccionService.getListByQuery(GestionarEtapasProcesoSeleccionQueryMapper.class, gestionarEtapasProcesoSeleccionQueryCriteria, start, limit);
			int total = gestionarEtapaProcesoSeleccionService.getCountRowsByQuery(GestionarEtapasProcesoSeleccionQueryMapper.class, gestionarEtapasProcesoSeleccionQueryCriteria);
			
			this.success(listGestionarEtapasProcesoSeleccionQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
			gestionarEtapaProcesoSeleccionService.create(gestionarEtapasProcesoSeleccionQuery,listSubEtapaProcesoSelecionQuery);
			this.getSessionContext().setAttribute("SubEtapaProcesoSelecionQueryList",null);
			this.success(gestionarEtapasProcesoSeleccionQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
			gestionarEtapaProcesoSeleccionService.save(gestionarEtapasProcesoSeleccionQuery,listSubEtapaProcesoSelecionQuery);
			this.getSessionContext().setAttribute("SubEtapaProcesoSelecionQueryList",null);
			this.success(gestionarEtapasProcesoSeleccionQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_etapa_proceso_seleccion", gestionarEtapasProcesoSeleccionQuery.getSrl_id_etapa_proceso_seleccion());
			List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = this.gestionarEtapaProcesoSeleccionService.getListByQuery(SubEtapaProcesoSelecionQueryMapper.class, paramMap);
			gestionarEtapaProcesoSeleccionService.remove(gestionarEtapasProcesoSeleccionQuery,listSubEtapaProcesoSelecionQuery);
			this.getSessionContext().removeAttribute("SubEtapaProcesoSelecionQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaProcesoSelecionQueryList(){
		
		List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery;
		List<SubEtapaProcesoSelecionQuery> subListSubEtapaProcesoSelecionQuery;
		Integer srl_id_etapa_proceso_seleccion = this.getIntegerParameter("srl_id_etapa_proceso_seleccion");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_etapa_proceso_seleccion == null){
			listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
		}else if(srl_id_etapa_proceso_seleccion.equals("-1")){
			listSubEtapaProcesoSelecionQuery = new ArrayList<SubEtapaProcesoSelecionQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_etapa_proceso_seleccion", srl_id_etapa_proceso_seleccion);
			listSubEtapaProcesoSelecionQuery = this.gestionarEtapaProcesoSeleccionService.getListByQuery(SubEtapaProcesoSelecionQueryMapper.class, paramMap);
			
		}

		if(listSubEtapaProcesoSelecionQuery == null){
			listSubEtapaProcesoSelecionQuery = new ArrayList<SubEtapaProcesoSelecionQuery>();
			
		}
		this.getSessionContext(true).setAttribute("SubEtapaProcesoSelecionQueryList",listSubEtapaProcesoSelecionQuery);
		int size = listSubEtapaProcesoSelecionQuery.size();
		subListSubEtapaProcesoSelecionQuery = this.getSubList(listSubEtapaProcesoSelecionQuery, start, limit);
		        
		this.success(subListSubEtapaProcesoSelecionQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaProcesoSelecionQueryAdd(){
		
		List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
		int randomInt = this.getNegativeIdRandom();
		subEtapaProcesoSelecionQuery.setSrl_id_subetapa_proceso_seleccion(randomInt);
		listSubEtapaProcesoSelecionQuery.add(subEtapaProcesoSelecionQuery);	
		this.getSessionContext().setAttribute("SubEtapaProcesoSelecionQueryList",listSubEtapaProcesoSelecionQuery);
		this.success(subEtapaProcesoSelecionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaProcesoSelecionQueryUpdate(){
		
		List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
		int index = -1;
		
		for (int i = 0; i < listSubEtapaProcesoSelecionQuery.size(); i++) {
			if(listSubEtapaProcesoSelecionQuery.get(i).getSrl_id_subetapa_proceso_seleccion().equals(subEtapaProcesoSelecionQuery.getSrl_id_subetapa_proceso_seleccion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSubEtapaProcesoSelecionQuery.set(index, subEtapaProcesoSelecionQuery);
		}
		
		this.getSessionContext().setAttribute("SubEtapaProcesoSelecionQueryList",listSubEtapaProcesoSelecionQuery);
		this.success(subEtapaProcesoSelecionQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SubEtapaProcesoSelecionQueryDelete(){
		
		List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery = (List<SubEtapaProcesoSelecionQuery>) this.getSessionContext().getAttribute("SubEtapaProcesoSelecionQueryList");
		int index = -1;
		for (int i = 0; i < listSubEtapaProcesoSelecionQuery.size(); i++) {
			if(listSubEtapaProcesoSelecionQuery.get(i).getSrl_id_subetapa_proceso_seleccion().equals(subEtapaProcesoSelecionQuery.getSrl_id_subetapa_proceso_seleccion())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSubEtapaProcesoSelecionQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("SubEtapaProcesoSelecionQueryList",listSubEtapaProcesoSelecionQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarEtapaProcesoSeleccionService getGestionarEtapaProcesoSeleccionService() {
		return gestionarEtapaProcesoSeleccionService;
	}

	public void setGestionarEtapaProcesoSeleccionService(GestionarEtapaProcesoSeleccionService gestionarEtapaProcesoSeleccionService) {
		this.gestionarEtapaProcesoSeleccionService = gestionarEtapaProcesoSeleccionService;
	}
	
	public GestionarEtapasProcesoSeleccionQuery getGestionarEtapasProcesoSeleccionQuery() {
		return gestionarEtapasProcesoSeleccionQuery;
	}

	public void setGestionarEtapasProcesoSeleccionQuery(GestionarEtapasProcesoSeleccionQuery gestionarEtapasProcesoSeleccionQuery) {
		this.gestionarEtapasProcesoSeleccionQuery = gestionarEtapasProcesoSeleccionQuery;
	}
	public SubEtapaProcesoSelecionQuery getSubEtapaProcesoSelecionQuery() {
		return subEtapaProcesoSelecionQuery;
	}

	public void setSubEtapaProcesoSelecionQuery(SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery) {
		this.subEtapaProcesoSelecionQuery = subEtapaProcesoSelecionQuery;
	}

/*
<!-- Start Actions GestionarEtapaProcesoSeleccion -->
<action name="GestionarEtapaProcesoSeleccionView" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="view">
		<result type="json" />
</action>

<action name="GestionarEtapaProcesoSeleccionCreate" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="create">
		<result type="json" />
</action>

<action name="GestionarEtapaProcesoSeleccionSave" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="save">
		<result type="json" />
</action>

<action name="GestionarEtapaProcesoSeleccionRemove" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model SubEtapaProcesoSelecionQuery Actions -->
<action name="SubEtapaProcesoSelecionQueryList" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="SubEtapaProcesoSelecionQueryList">
		<result type="json" />
</action>

<action name="SubEtapaProcesoSelecionQueryAdd" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="SubEtapaProcesoSelecionQueryAdd">
		<result type="json" />
</action>

<action name="SubEtapaProcesoSelecionQueryUpdate" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="SubEtapaProcesoSelecionQueryUpdate">
		<result type="json" />
</action>

<action name="SubEtapaProcesoSelecionQueryDelete" class="sernanp.rrhh.web.action.seleccion.GestionarEtapaProcesoSeleccionAction" method="SubEtapaProcesoSelecionQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model SubEtapaProcesoSelecionQuery Actions -->

<!-- End Actions GestionarEtapaProcesoSeleccion -->
*/
}
