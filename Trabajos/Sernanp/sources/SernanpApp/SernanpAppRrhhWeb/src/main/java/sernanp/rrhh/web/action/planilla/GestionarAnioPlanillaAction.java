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
* DATE CREATE : 23/03/2015 12:20:16
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;
import sernanp.app.business.core.planilla.service.GestionarAnioPlanillaService;
import sernanp.app.dao.query.domain.ConfParametroQuery;
import sernanp.app.dao.query.domain.ConfParametroQueryCriteria;
import sernanp.app.dao.query.domain.GestionarAnioPlanillaQuery;
import sernanp.app.dao.query.domain.GestionarAnioPlanillaQueryCriteria;
import sernanp.app.dao.query.mapper.ConfParametroQueryMapper;
import sernanp.app.dao.query.mapper.GestionarAnioPlanillaQueryMapper;
import sernanp.app.dao.query.domain.GestionarAnioParametroPlanillaQuery;
import sernanp.app.dao.query.mapper.GestionarAnioParametroPlanillaQueryMapper;
import sernanp.app.dao.query.domain.GestionarAnioPeriodoPlanillaQuery;
import sernanp.app.dao.query.mapper.GestionarAnioPeriodoPlanillaQueryMapper;

public class GestionarAnioPlanillaAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarAnioPlanillaService gestionarAnioPlanillaService;
	private GestionarAnioPlanillaQuery gestionarAnioPlanillaQuery;
	private GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery;
	private GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery;
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarAnioPlanillaQueryCriteria gestionarAnioPlanillaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarAnioPlanillaQueryCriteria.class);
			List<GestionarAnioPlanillaQuery> listGestionarAnioPlanillaQuery = gestionarAnioPlanillaService.getListByQuery(GestionarAnioPlanillaQueryMapper.class, gestionarAnioPlanillaQueryCriteria, start, limit);
			int total = gestionarAnioPlanillaService.getCountRowsByQuery(GestionarAnioPlanillaQueryMapper.class, gestionarAnioPlanillaQueryCriteria);
			
			this.success(listGestionarAnioPlanillaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");
			List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
			gestionarAnioPlanillaService.create(gestionarAnioPlanillaQuery,listGestionarAnioParametroPlanillaQuery, listGestionarAnioPeriodoPlanillaQuery);
			this.getSessionContext().setAttribute("GestionarAnioParametroPlanillaQueryList",null);
			this.getSessionContext().setAttribute("GestionarAnioPeriodoPlanillaQueryList",null);
			this.success(gestionarAnioPlanillaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");
			List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
			
			gestionarAnioPlanillaService.save(gestionarAnioPlanillaQuery,listGestionarAnioParametroPlanillaQuery, listGestionarAnioPeriodoPlanillaQuery);
			this.getSessionContext().setAttribute("GestionarAnioParametroPlanillaQueryList",null);
			this.getSessionContext().setAttribute("GestionarAnioPeriodoPlanillaQueryList",null);
			this.success(gestionarAnioPlanillaQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_anio_planilla", gestionarAnioPlanillaQuery.getSrl_id_anio_planilla());
			List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = this.gestionarAnioPlanillaService.getListByQuery(GestionarAnioParametroPlanillaQueryMapper.class, paramMap);
			paramMap.put("srl_id_anio_planilla", gestionarAnioPlanillaQuery.getSrl_id_anio_planilla());
			List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = this.gestionarAnioPlanillaService.getListByQuery(GestionarAnioPeriodoPlanillaQueryMapper.class, paramMap);
			gestionarAnioPlanillaService.remove(gestionarAnioPlanillaQuery,listGestionarAnioParametroPlanillaQuery, listGestionarAnioPeriodoPlanillaQuery);
			this.getSessionContext().removeAttribute("GestionarAnioParametroPlanillaQueryList");
			this.getSessionContext().removeAttribute("GestionarAnioPeriodoPlanillaQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioParametroPlanillaQueryList(){
		
		List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery;
		List<GestionarAnioParametroPlanillaQuery> subListGestionarAnioParametroPlanillaQuery;
		Integer srl_id_anio_planilla = this.getIntegerParameter("srl_id_anio_planilla");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_anio_planilla == null){
			listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");
		}else if(srl_id_anio_planilla.equals("-1")){
			listGestionarAnioParametroPlanillaQuery = new ArrayList<GestionarAnioParametroPlanillaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_anio_planilla", srl_id_anio_planilla);
			listGestionarAnioParametroPlanillaQuery = this.gestionarAnioPlanillaService.getListByQuery(GestionarAnioParametroPlanillaQueryMapper.class, paramMap);
		}

		if(listGestionarAnioParametroPlanillaQuery == null){
			listGestionarAnioParametroPlanillaQuery = new ArrayList<GestionarAnioParametroPlanillaQuery>();
		}
		
		if(listGestionarAnioParametroPlanillaQuery.isEmpty()){
			
			ConfParametroQueryCriteria criteria = new ConfParametroQueryCriteria();
			criteria.setTsp_fecha_registro(new Date());
			
			List<ConfParametroQuery> list = gestionarAnioPlanillaService.getListByQuery(ConfParametroQueryMapper.class, criteria);
			
			for(ConfParametroQuery obj : list){
				GestionarAnioParametroPlanillaQuery x = new GestionarAnioParametroPlanillaQuery();
				x.setSrl_id_anio_planilla(srl_id_anio_planilla);
				x.setSrl_id_anio_parametro_planilla(this.getNegativeIdRandom());
				x.setSrl_id_parametro_planilla(obj.getSrl_id_parametro_planilla());
				x.setVar_descrip_parametro(obj.getVar_descrip_parametro());
				x.setDec_valor_parametro(obj.getDec_valor_parametro());
				x.setInt_id_estado(1);
				x.setVar_des_tipo_estado("ACTIVO");
				listGestionarAnioParametroPlanillaQuery.add(x);
			}
			
		}
		
		this.getSessionContext(true).setAttribute("GestionarAnioParametroPlanillaQueryList",listGestionarAnioParametroPlanillaQuery);
		int size = listGestionarAnioParametroPlanillaQuery.size();
		subListGestionarAnioParametroPlanillaQuery = this.getSubList(listGestionarAnioParametroPlanillaQuery, start, limit);
		
		this.success(subListGestionarAnioParametroPlanillaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioParametroPlanillaQueryAdd(){
		
		List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");
		int randomInt = this.getNegativeIdRandom();
		gestionarAnioParametroPlanillaQuery.setSrl_id_anio_parametro_planilla(randomInt);
		listGestionarAnioParametroPlanillaQuery.add(gestionarAnioParametroPlanillaQuery);	
		this.getSessionContext().setAttribute("GestionarAnioParametroPlanillaQueryList",listGestionarAnioParametroPlanillaQuery);
		this.success(gestionarAnioParametroPlanillaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioParametroPlanillaQueryUpdate(){			
		
		List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");		
		int index = -1;		
		for (int i = 0; i < listGestionarAnioParametroPlanillaQuery.size(); i++) {						
			if(listGestionarAnioParametroPlanillaQuery.get(i).getSrl_id_anio_parametro_planilla().equals(gestionarAnioParametroPlanillaQuery.getSrl_id_anio_parametro_planilla())){
					index = i;
					break;				
				}
			}			
		
		if(index > -1){
			listGestionarAnioParametroPlanillaQuery.set(index, gestionarAnioParametroPlanillaQuery);
		}
		
		this.getSessionContext().setAttribute("GestionarAnioParametroPlanillaQueryList",listGestionarAnioParametroPlanillaQuery);
		this.success(gestionarAnioParametroPlanillaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioParametroPlanillaQueryDelete(){
		
		List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery = (List<GestionarAnioParametroPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioParametroPlanillaQueryList");
		int index = -1;
		for (int i = 0; i < listGestionarAnioParametroPlanillaQuery.size(); i++) {
			if(listGestionarAnioParametroPlanillaQuery.get(i).getSrl_id_anio_parametro_planilla().equals(gestionarAnioParametroPlanillaQuery.getSrl_id_anio_parametro_planilla())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarAnioParametroPlanillaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("GestionarAnioParametroPlanillaQueryList",listGestionarAnioParametroPlanillaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String GestionarAnioPeriodoPlanillaQueryList(){
		
		List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery;
		List<GestionarAnioPeriodoPlanillaQuery> subListGestionarAnioPeriodoPlanillaQuery;
		Integer srl_id_anio_planilla = this.getIntegerParameter("srl_id_anio_planilla");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_anio_planilla == null){
			listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
		}else if(srl_id_anio_planilla.equals("-1")){
			listGestionarAnioPeriodoPlanillaQuery = new ArrayList<GestionarAnioPeriodoPlanillaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_anio_planilla", srl_id_anio_planilla);
			listGestionarAnioPeriodoPlanillaQuery = this.gestionarAnioPlanillaService.getListByQuery(GestionarAnioPeriodoPlanillaQueryMapper.class, paramMap);
		}

		if(listGestionarAnioPeriodoPlanillaQuery == null){
			listGestionarAnioPeriodoPlanillaQuery = new ArrayList<GestionarAnioPeriodoPlanillaQuery>();
		}
		this.getSessionContext(true).setAttribute("GestionarAnioPeriodoPlanillaQueryList",listGestionarAnioPeriodoPlanillaQuery);
		int size = listGestionarAnioPeriodoPlanillaQuery.size();
		subListGestionarAnioPeriodoPlanillaQuery = this.getSubList(listGestionarAnioPeriodoPlanillaQuery, start, limit);
		
		this.success(subListGestionarAnioPeriodoPlanillaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioPeriodoPlanillaQueryAdd(){
		
		List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
		int randomInt = this.getNegativeIdRandom();
		gestionarAnioPeriodoPlanillaQuery.setSrl_id_anio_periodo_planilla(randomInt);
		listGestionarAnioPeriodoPlanillaQuery.add(gestionarAnioPeriodoPlanillaQuery);	
		this.getSessionContext().setAttribute("GestionarAnioPeriodoPlanillaQueryList",listGestionarAnioPeriodoPlanillaQuery);
		this.success(gestionarAnioPeriodoPlanillaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioPeriodoPlanillaQueryUpdate(){
		
		List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
		int index = -1;
		
		for (int i = 0; i < listGestionarAnioPeriodoPlanillaQuery.size(); i++) {
			if(listGestionarAnioPeriodoPlanillaQuery.get(i).getSrl_id_anio_periodo_planilla().equals(gestionarAnioPeriodoPlanillaQuery.getSrl_id_anio_periodo_planilla())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarAnioPeriodoPlanillaQuery.set(index, gestionarAnioPeriodoPlanillaQuery);
		}
		
		this.getSessionContext().setAttribute("GestionarAnioPeriodoPlanillaQueryList",listGestionarAnioPeriodoPlanillaQuery);
		this.success(gestionarAnioPeriodoPlanillaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String GestionarAnioPeriodoPlanillaQueryDelete(){
		
		List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery = (List<GestionarAnioPeriodoPlanillaQuery>) this.getSessionContext().getAttribute("GestionarAnioPeriodoPlanillaQueryList");
		int index = -1;
		for (int i = 0; i < listGestionarAnioPeriodoPlanillaQuery.size(); i++) {
			if(listGestionarAnioPeriodoPlanillaQuery.get(i).getSrl_id_anio_periodo_planilla().equals(gestionarAnioPeriodoPlanillaQuery.getSrl_id_anio_periodo_planilla())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listGestionarAnioPeriodoPlanillaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("GestionarAnioPeriodoPlanillaQueryList",listGestionarAnioPeriodoPlanillaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarAnioPlanillaService getGestionarAnioPlanillaService() {
		return gestionarAnioPlanillaService;
	}

	public void setGestionarAnioPlanillaService(GestionarAnioPlanillaService gestionarAnioPlanillaService) {
		this.gestionarAnioPlanillaService = gestionarAnioPlanillaService;
	}
	
	public GestionarAnioPlanillaQuery getGestionarAnioPlanillaQuery() {
		return gestionarAnioPlanillaQuery;
	}

	public void setGestionarAnioPlanillaQuery(GestionarAnioPlanillaQuery gestionarAnioPlanillaQuery) {
		this.gestionarAnioPlanillaQuery = gestionarAnioPlanillaQuery;
	}
	public GestionarAnioParametroPlanillaQuery getGestionarAnioParametroPlanillaQuery() {
		return gestionarAnioParametroPlanillaQuery;
	}

	public void setGestionarAnioParametroPlanillaQuery(GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery) {
		this.gestionarAnioParametroPlanillaQuery = gestionarAnioParametroPlanillaQuery;
	}
	public GestionarAnioPeriodoPlanillaQuery getGestionarAnioPeriodoPlanillaQuery() {
		return gestionarAnioPeriodoPlanillaQuery;
	}

	public void setGestionarAnioPeriodoPlanillaQuery(GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery) {
		this.gestionarAnioPeriodoPlanillaQuery = gestionarAnioPeriodoPlanillaQuery;
	}

/*
<!-- Start Actions GestionarAnioPlanilla -->
<action name="GestionarAnioPlanillaView" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="view">
		<result type="json" />
</action>

<action name="GestionarAnioPlanillaCreate" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="create">
		<result type="json" />
</action>

<action name="GestionarAnioPlanillaSave" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="save">
		<result type="json" />
</action>

<action name="GestionarAnioPlanillaRemove" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model GestionarAnioParametroPlanillaQuery Actions -->
<action name="GestionarAnioParametroPlanillaQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioParametroPlanillaQueryList">
		<result type="json" />
</action>

<action name="GestionarAnioParametroPlanillaQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioParametroPlanillaQueryAdd">
		<result type="json" />
</action>

<action name="GestionarAnioParametroPlanillaQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioParametroPlanillaQueryUpdate">
		<result type="json" />
</action>

<action name="GestionarAnioParametroPlanillaQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioParametroPlanillaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model GestionarAnioParametroPlanillaQuery Actions -->
<!-- Start Sub Model GestionarAnioPeriodoPlanillaQuery Actions -->
<action name="GestionarAnioPeriodoPlanillaQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioPeriodoPlanillaQueryList">
		<result type="json" />
</action>

<action name="GestionarAnioPeriodoPlanillaQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioPeriodoPlanillaQueryAdd">
		<result type="json" />
</action>

<action name="GestionarAnioPeriodoPlanillaQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioPeriodoPlanillaQueryUpdate">
		<result type="json" />
</action>

<action name="GestionarAnioPeriodoPlanillaQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAnioPlanillaAction" method="GestionarAnioPeriodoPlanillaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model GestionarAnioPeriodoPlanillaQuery Actions -->

<!-- End Actions GestionarAnioPlanilla -->
*/
}
