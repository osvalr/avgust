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
* DATE CREATE : 02/04/2015 11:57:25
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.GestionarConceptoService;
import sernanp.app.dao.query.domain.ConceptoAfectoQuery;
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.GestionarConceptoQuery;
import sernanp.app.dao.query.domain.GestionarConceptoQueryCriteria;
import sernanp.app.dao.query.mapper.ConceptoAfectoQueryMapper;
import sernanp.app.dao.query.mapper.ConceptoFrecuenciaQueryMapper;
import sernanp.app.dao.query.mapper.GestionarConceptoQueryMapper;
import sernanp.app.dao.query.mapper.TablaTipoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GestionarConceptoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;

	@Autowired
	private GestionarConceptoService gestionarConceptoService;
	private GestionarConceptoQuery gestionarConceptoQuery;
	private ConceptoAfectoQuery conceptoAfectoQuery;
	private ConceptoFrecuenciaQuery conceptoFrecuenciaQuery;
	
//	Begin JRaffo 09/03/2015
	@Autowired
	private TablaTipoQueryMapper tablaTipoQueryMapper;
//	End JRaffo 09/03/2015
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarConceptoQueryCriteria gestionarConceptoQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarConceptoQueryCriteria.class);
			List<GestionarConceptoQuery> listGestionarConceptoQuery = gestionarConceptoService.getListByQuery(GestionarConceptoQueryMapper.class, gestionarConceptoQueryCriteria, start, limit);
			int total = gestionarConceptoService.getCountRowsByQuery(GestionarConceptoQueryMapper.class, gestionarConceptoQueryCriteria);
			
			this.success(listGestionarConceptoQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<ConceptoAfectoQuery> listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
			List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
			gestionarConceptoService.create(gestionarConceptoQuery,listConceptoAfectoQuery, listConceptoFrecuenciaQuery);
			this.getSessionContext().setAttribute("ConceptoAfectoQueryList",null);
			this.getSessionContext().setAttribute("ConceptoFrecuenciaQueryList",null);
			this.success(gestionarConceptoQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<ConceptoAfectoQuery> listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
			List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
			gestionarConceptoService.save(gestionarConceptoQuery,listConceptoAfectoQuery, listConceptoFrecuenciaQuery);
			this.getSessionContext().setAttribute("ConceptoAfectoQueryList",null);
			this.getSessionContext().setAttribute("ConceptoFrecuenciaQueryList",null);
			this.success(gestionarConceptoQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_concepto_planilla", gestionarConceptoQuery.getSrl_id_concepto_planilla());
			List<ConceptoAfectoQuery> listConceptoAfectoQuery = this.gestionarConceptoService.getListByQuery(ConceptoAfectoQueryMapper.class, paramMap);
			paramMap.put("srl_id_concepto_planilla", gestionarConceptoQuery.getSrl_id_concepto_planilla());
			List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = this.gestionarConceptoService.getListByQuery(ConceptoFrecuenciaQueryMapper.class, paramMap);
			gestionarConceptoService.remove(gestionarConceptoQuery,listConceptoAfectoQuery, listConceptoFrecuenciaQuery);
			this.getSessionContext().removeAttribute("ConceptoAfectoQueryList");
			this.getSessionContext().removeAttribute("ConceptoFrecuenciaQueryList");
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoAfectoQueryList(){
		
		List<ConceptoAfectoQuery> listConceptoAfectoQuery;
		List<ConceptoAfectoQuery> subListConceptoAfectoQuery;
		Integer srl_id_concepto_planilla = this.getIntegerParameter("srl_id_concepto_planilla");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_concepto_planilla == null){
			listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
		}else if(srl_id_concepto_planilla.equals("-1")){
			listConceptoAfectoQuery = new ArrayList<ConceptoAfectoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_concepto_planilla", srl_id_concepto_planilla);
			listConceptoAfectoQuery = this.gestionarConceptoService.getListByQuery(ConceptoAfectoQueryMapper.class, paramMap);
		}

		if(listConceptoAfectoQuery == null){
			listConceptoAfectoQuery = new ArrayList<ConceptoAfectoQuery>();
		}
		this.getSessionContext(true).setAttribute("ConceptoAfectoQueryList",listConceptoAfectoQuery);
		int size = listConceptoAfectoQuery.size();
		subListConceptoAfectoQuery = this.getSubList(listConceptoAfectoQuery, start, limit);
		
		this.success(subListConceptoAfectoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoAfectoQueryAdd(){
		
		List<ConceptoAfectoQuery> listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
		
		for(ConceptoAfectoQuery conceptoAfectoQuery : listConceptoAfectoQuery){
			if(conceptoAfectoQuery.getSrl_id_concepto_planilla_afecto().equals(this.conceptoAfectoQuery.getSrl_id_concepto_planilla_afecto())){
				this.exception("Error, ya existe el concepto enviado.");
				return SUCCESS;
			}
		}
		
		int randomInt = this.getNegativeIdRandom();
		conceptoAfectoQuery.setSrl_id_afecto_concepto(randomInt);
		listConceptoAfectoQuery.add(conceptoAfectoQuery);	
		this.getSessionContext().setAttribute("ConceptoAfectoQueryList",listConceptoAfectoQuery);
		this.success(conceptoAfectoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoAfectoQueryUpdate(){
		
		List<ConceptoAfectoQuery> listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
		int index = -1;
		
		for (int i = 0; i < listConceptoAfectoQuery.size(); i++) {
			if(listConceptoAfectoQuery.get(i).getSrl_id_afecto_concepto().equals(conceptoAfectoQuery.getSrl_id_afecto_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConceptoAfectoQuery.set(index, conceptoAfectoQuery);
		}
		
		this.getSessionContext().setAttribute("ConceptoAfectoQueryList",listConceptoAfectoQuery);
		this.success(conceptoAfectoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoAfectoQueryDelete(){
		
		List<ConceptoAfectoQuery> listConceptoAfectoQuery = (List<ConceptoAfectoQuery>) this.getSessionContext().getAttribute("ConceptoAfectoQueryList");
		int index = -1;
		for (int i = 0; i < listConceptoAfectoQuery.size(); i++) {
			if(listConceptoAfectoQuery.get(i).getSrl_id_afecto_concepto().equals(conceptoAfectoQuery.getSrl_id_afecto_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConceptoAfectoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConceptoAfectoQueryList",listConceptoAfectoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String ConceptoFrecuenciaQueryList(){
		
		List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery;
		List<ConceptoFrecuenciaQuery> subListConceptoFrecuenciaQuery;
		Integer srl_id_concepto_planilla = this.getIntegerParameter("srl_id_concepto_planilla");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_concepto_planilla == null){
			listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
		}else if(srl_id_concepto_planilla.equals("-1")){
			listConceptoFrecuenciaQuery = new ArrayList<ConceptoFrecuenciaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_concepto_planilla", srl_id_concepto_planilla);
			paramMap.put("orderColumn", "int_id_mes");
			listConceptoFrecuenciaQuery = this.gestionarConceptoService.getListByQuery(ConceptoFrecuenciaQueryMapper.class, paramMap);
		}

		if(listConceptoFrecuenciaQuery == null){
			listConceptoFrecuenciaQuery = new ArrayList<ConceptoFrecuenciaQuery>();
		}
		
//		Begin JRaffo 09/03/2015
//		if(listConceptoFrecuenciaQuery.isEmpty()){
//			TablaTipoQueryCriteria criteria = new TablaTipoQueryCriteria();
//			criteria.setDestabla("Meses");
//			List<TablaTipoQuery> listMeses = tablaTipoQueryMapper.getListQuery(criteria);
//			for(TablaTipoQuery ttq : listMeses){
//				int randomInt = this.getNegativeIdRandom();
//				ConceptoFrecuenciaQuery idfq = new ConceptoFrecuenciaQuery();
//				idfq.setInt_id_mes(ttq.getCodinttablatipo());
//				idfq.setDescrip_mes(ttq.getDestablatipo());
//				idfq.setInt_id_estado(1);
//				idfq.setDescrip_estado("Activo");
//				idfq.setSrl_id_concepto_planilla(srl_id_concepto_planilla);
//				idfq.setSrl_id_frecuencia(randomInt);
//				listConceptoFrecuenciaQuery.add(idfq);
//			}
//		}
//		End JRaffo 09/03/2015
		
		this.getSessionContext(true).setAttribute("ConceptoFrecuenciaQueryList",listConceptoFrecuenciaQuery);
		int size = listConceptoFrecuenciaQuery.size();
		subListConceptoFrecuenciaQuery = this.getSubList(listConceptoFrecuenciaQuery, start, limit);
		
		this.success(subListConceptoFrecuenciaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoFrecuenciaQueryAdd(){
		
		List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
		
		for(ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery){
			if(conceptoFrecuenciaQuery.getInt_id_mes().equals(this.conceptoFrecuenciaQuery.getInt_id_mes())){
				this.exception("Error, ya existe el mes enviado.");
				return SUCCESS;
			}
		}
		
		int randomInt = this.getNegativeIdRandom();
		conceptoFrecuenciaQuery.setSrl_id_frecuencia(randomInt);
		listConceptoFrecuenciaQuery.add(conceptoFrecuenciaQuery);	
		this.getSessionContext().setAttribute("ConceptoFrecuenciaQueryList",listConceptoFrecuenciaQuery);
		this.success(conceptoFrecuenciaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoFrecuenciaQueryUpdate(){
		
		List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
		int index = -1;
		
		for (int i = 0; i < listConceptoFrecuenciaQuery.size(); i++) {
			if(listConceptoFrecuenciaQuery.get(i).getSrl_id_frecuencia().equals(conceptoFrecuenciaQuery.getSrl_id_frecuencia())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConceptoFrecuenciaQuery.set(index, conceptoFrecuenciaQuery);
		}
		
		this.getSessionContext().setAttribute("ConceptoFrecuenciaQueryList",listConceptoFrecuenciaQuery);
		this.success(conceptoFrecuenciaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoFrecuenciaQueryDelete(){
		
		List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery = (List<ConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("ConceptoFrecuenciaQueryList");
		int index = -1;
		for (int i = 0; i < listConceptoFrecuenciaQuery.size(); i++) {
			if(listConceptoFrecuenciaQuery.get(i).getSrl_id_frecuencia().equals(conceptoFrecuenciaQuery.getSrl_id_frecuencia())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConceptoFrecuenciaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConceptoFrecuenciaQueryList",listConceptoFrecuenciaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarConceptoService getGestionarConceptoService() {
		return gestionarConceptoService;
	}

	public void setGestionarConceptoService(GestionarConceptoService gestionarConceptoService) {
		this.gestionarConceptoService = gestionarConceptoService;
	}
	
	public GestionarConceptoQuery getGestionarConceptoQuery() {
		return gestionarConceptoQuery;
	}

	public void setGestionarConceptoQuery(GestionarConceptoQuery gestionarConceptoQuery) {
		this.gestionarConceptoQuery = gestionarConceptoQuery;
	}
	public ConceptoAfectoQuery getConceptoAfectoQuery() {
		return conceptoAfectoQuery;
	}

	public void setConceptoAfectoQuery(ConceptoAfectoQuery conceptoAfectoQuery) {
		this.conceptoAfectoQuery = conceptoAfectoQuery;
	}
	public ConceptoFrecuenciaQuery getConceptoFrecuenciaQuery() {
		return conceptoFrecuenciaQuery;
	}

	public void setConceptoFrecuenciaQuery(ConceptoFrecuenciaQuery conceptoFrecuenciaQuery) {
		this.conceptoFrecuenciaQuery = conceptoFrecuenciaQuery;
	}

/*
<!-- Start Actions GestionarConcepto -->
<action name="GestionarConceptoView" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="view">
		<result type="json" />
</action>

<action name="GestionarConceptoCreate" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="create">
		<result type="json" />
</action>

<action name="GestionarConceptoSave" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="save">
		<result type="json" />
</action>

<action name="GestionarConceptoRemove" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ConceptoAfectoQuery Actions -->
<action name="ConceptoAfectoQueryList" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoAfectoQueryList">
		<result type="json" />
</action>

<action name="ConceptoAfectoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoAfectoQueryAdd">
		<result type="json" />
</action>

<action name="ConceptoAfectoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoAfectoQueryUpdate">
		<result type="json" />
</action>

<action name="ConceptoAfectoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoAfectoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConceptoAfectoQuery Actions -->
<!-- Start Sub Model ConceptoFrecuenciaQuery Actions -->
<action name="ConceptoFrecuenciaQueryList" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoFrecuenciaQueryList">
		<result type="json" />
</action>

<action name="ConceptoFrecuenciaQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoFrecuenciaQueryAdd">
		<result type="json" />
</action>

<action name="ConceptoFrecuenciaQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoFrecuenciaQueryUpdate">
		<result type="json" />
</action>

<action name="ConceptoFrecuenciaQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarConceptoAction" method="ConceptoFrecuenciaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConceptoFrecuenciaQuery Actions -->

<!-- End Actions GestionarConcepto -->
*/
}
