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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.GestionarAsignarConceptoService;
import sernanp.app.dao.query.domain.BeneficiarioDescuentoJudicialQuery;
import sernanp.app.dao.query.domain.ConceptoPersonalQuery;
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQuery;
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQueryCriteria;
import sernanp.app.dao.query.domain.PersonalConceptoAfectoQuery;
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.PersonalInfoAdendasPorContratoQuery;
import sernanp.app.dao.query.domain.PersonalInfoContratoQuery;
import sernanp.app.dao.query.domain.PersonalInfoFormacionQuery;
import sernanp.app.dao.query.domain.SuspensionCuartaCategoriaQuery;
import sernanp.app.dao.query.mapper.BeneficiarioDescuentoJudicialQueryMapper;
import sernanp.app.dao.query.mapper.ConceptoPersonalQueryMapper;
import sernanp.app.dao.query.mapper.GestionarAsignarConceptoQueryMapper;
import sernanp.app.dao.query.mapper.PersonalConceptoAfectoQueryMapper;
import sernanp.app.dao.query.mapper.PersonalConceptoFrecuenciaQueryMapper;
import sernanp.app.dao.query.mapper.PersonalInfoAdendasPorContratoQueryMapper;
import sernanp.app.dao.query.mapper.PersonalInfoContratoQueryMapper;
import sernanp.app.dao.query.mapper.PersonalInfoFormacionQueryMapper;
import sernanp.app.dao.query.mapper.SuspensionCuartaCategoriaQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GestionarAsignarConceptoAction extends ActionHelperExtjs {


	private static final long serialVersionUID = 1L;
	
	private final int TIPO_DOCUMENTO_RUC = 123;

	@Autowired
	private GestionarAsignarConceptoService gestionarAsignarConceptoService;
	private GestionarAsignarConceptoQuery gestionarAsignarConceptoQuery;
	private ConceptoPersonalQuery conceptoPersonalQuery;
	private PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery;
	
	private PersonalConceptoAfectoQuery personalConceptoAfectoQuery;
	
	private SuspensionCuartaCategoriaQuery suspensionCuartaCategoriaQuery;
	
	private BeneficiarioDescuentoJudicialQuery beneficiarioDescuentoJudicialQuery;
	
	private PersonalInfoContratoQuery personalInfoContratoQuery;
	private PersonalInfoFormacionQuery personalInfoFormacionQuery;
	private PersonalInfoAdendasPorContratoQuery personalInfoAdendasPorContratoQuery;
	
	
	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarAsignarConceptoQueryCriteria gestionarAsignarConceptoQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarAsignarConceptoQueryCriteria.class);
			
			if(gestionarAsignarConceptoQueryCriteria.getIdtipodocumento() != null){
				if(gestionarAsignarConceptoQueryCriteria.getIdtipodocumento().intValue() == TIPO_DOCUMENTO_RUC){
					gestionarAsignarConceptoQueryCriteria.setRuc(gestionarAsignarConceptoQueryCriteria.getNumerodoc());
					gestionarAsignarConceptoQueryCriteria.setNumerodoc(null);
					gestionarAsignarConceptoQueryCriteria.setIdtipodocumento(null);
				}
			}
			
			List<GestionarAsignarConceptoQuery> listGestionarAsignarConceptoQuery = gestionarAsignarConceptoService.getListByQuery(GestionarAsignarConceptoQueryMapper.class, gestionarAsignarConceptoQueryCriteria, start, limit);
			int total = gestionarAsignarConceptoService.getCountRowsByQuery(GestionarAsignarConceptoQueryMapper.class, gestionarAsignarConceptoQueryCriteria);
			
			this.success(listGestionarAsignarConceptoQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
			List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
			
			List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
			
			List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery = (List<SuspensionCuartaCategoriaQuery>) this.getSessionContext().getAttribute("SuspensionCuartaCategoriaQueryList");
			List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery = (List<BeneficiarioDescuentoJudicialQuery>) this.getSessionContext().getAttribute("BeneficiarioDescuentoJudicialQueryList");
			
			List<PersonalInfoContratoQuery> listPersonalInfoContratoQuery = (List<PersonalInfoContratoQuery>) this.getSessionContext().getAttribute("PersonalInfoContratoQueryList");
			
			gestionarAsignarConceptoService.save(gestionarAsignarConceptoQuery,listConceptoPersonalQuery, listPersonalConceptoFrecuenciaQuery, listPersonalConceptoAfectoQuery, listSuspensionCuartaCategoriaQuery, listBeneficiarioDescuentoJudicialQuery,listPersonalInfoContratoQuery);
			this.getSessionContext().setAttribute("ConceptoPersonalQueryList",null);
			this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",null);
			
			this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",null);
			
			this.getSessionContext().setAttribute("SuspensionCuartaCategoriaQueryList",null);
			this.getSessionContext().setAttribute("BeneficiarioDescuentoJudicialQueryList",null);
			
			this.getSessionContext().setAttribute("PersonalInfoContratoQueryList",null);
			
			this.success(gestionarAsignarConceptoQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoPersonalQueryList(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery;
		List<ConceptoPersonalQuery> subListConceptoPersonalQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		}else if(idpersonal.equals("-1")){
			listConceptoPersonalQuery = new ArrayList<ConceptoPersonalQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listConceptoPersonalQuery = this.gestionarAsignarConceptoService.getListByQuery(ConceptoPersonalQueryMapper.class, paramMap);
		}

		if(listConceptoPersonalQuery == null){
			listConceptoPersonalQuery = new ArrayList<ConceptoPersonalQuery>();
		}
		this.getSessionContext(true).setAttribute("ConceptoPersonalQueryList",listConceptoPersonalQuery);
		int size = listConceptoPersonalQuery.size();
		subListConceptoPersonalQuery = this.getSubList(listConceptoPersonalQuery, start, limit);
		
		this.success(subListConceptoPersonalQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoPersonalQueryAdd(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		int randomInt = this.getNegativeIdRandom();
		conceptoPersonalQuery.setSrl_id_personal_concepto(randomInt);
		conceptoPersonalQuery.setListPersonalConceptoFrecuenciaQuery(listPersonalConceptoFrecuenciaQuery);
		conceptoPersonalQuery.setListPersonalConceptoAfectoQuery(listPersonalConceptoAfectoQuery);
		listConceptoPersonalQuery.add(conceptoPersonalQuery);	
		this.getSessionContext().setAttribute("ConceptoPersonalQueryList",listConceptoPersonalQuery);
		this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",null);
		this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",null);
		this.success(conceptoPersonalQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoPersonalQueryUpdate(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		int index = -1;
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		
		for (int i = 0; i < listConceptoPersonalQuery.size(); i++) {
			if(listConceptoPersonalQuery.get(i).getSrl_id_personal_concepto().equals(conceptoPersonalQuery.getSrl_id_personal_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			conceptoPersonalQuery.setListPersonalConceptoFrecuenciaQuery(listPersonalConceptoFrecuenciaQuery);
			conceptoPersonalQuery.setListPersonalConceptoAfectoQuery(listPersonalConceptoAfectoQuery);
			listConceptoPersonalQuery.set(index, conceptoPersonalQuery);
		}
		
		this.getSessionContext().setAttribute("ConceptoPersonalQueryList",listConceptoPersonalQuery);
		this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",null);
		this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",null);
		this.success(conceptoPersonalQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String ConceptoPersonalQueryDelete(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		int index = -1;
		for (int i = 0; i < listConceptoPersonalQuery.size(); i++) {
			if(listConceptoPersonalQuery.get(i).getSrl_id_personal_concepto().equals(conceptoPersonalQuery.getSrl_id_personal_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listConceptoPersonalQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("ConceptoPersonalQueryList",listConceptoPersonalQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String PersonalConceptoFrecuenciaQueryList(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery;
		List<PersonalConceptoFrecuenciaQuery> subListPersonalConceptoFrecuenciaQuery;
		Integer srl_id_personal_concepto = this.getIntegerParameter("srl_id_personal_concepto");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_personal_concepto == null){
			listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		}else if(srl_id_personal_concepto.equals("-1")){
			listPersonalConceptoFrecuenciaQuery = new ArrayList<PersonalConceptoFrecuenciaQuery>();
		}else{
			
			ConceptoPersonalQuery conceptoPersonalQuery = null;
			for(ConceptoPersonalQuery x : listConceptoPersonalQuery){
				if(x.getSrl_id_personal_concepto().intValue() == srl_id_personal_concepto.intValue()){
					conceptoPersonalQuery = x;
				}
			}
			
			if(conceptoPersonalQuery == null){
				listPersonalConceptoFrecuenciaQuery = new ArrayList<PersonalConceptoFrecuenciaQuery>();
			}else{
				listPersonalConceptoFrecuenciaQuery = conceptoPersonalQuery.getListPersonalConceptoFrecuenciaQuery();
				if(listPersonalConceptoFrecuenciaQuery == null){
					
					Map<String, Object> paramMap = this.getParamMap();
					paramMap.put("srl_id_personal_concepto", srl_id_personal_concepto);
					listPersonalConceptoFrecuenciaQuery = this.gestionarAsignarConceptoService.getListByQuery(PersonalConceptoFrecuenciaQueryMapper.class, paramMap);

				}
			}
			
		}

		if(listPersonalConceptoFrecuenciaQuery == null){
			listPersonalConceptoFrecuenciaQuery = new ArrayList<PersonalConceptoFrecuenciaQuery>();
		}
		this.getSessionContext(true).setAttribute("PersonalConceptoFrecuenciaQueryList",listPersonalConceptoFrecuenciaQuery);
		int size = listPersonalConceptoFrecuenciaQuery.size();
		subListPersonalConceptoFrecuenciaQuery = this.getSubList(listPersonalConceptoFrecuenciaQuery, start, limit);
		
		this.success(subListPersonalConceptoFrecuenciaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoFrecuenciaQueryAdd(){
		
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		int randomInt = this.getNegativeIdRandom();
		personalConceptoFrecuenciaQuery.setSrl_id_frecuencia(randomInt);
		listPersonalConceptoFrecuenciaQuery.add(personalConceptoFrecuenciaQuery);	
		this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",listPersonalConceptoFrecuenciaQuery);
		this.success(personalConceptoFrecuenciaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoFrecuenciaQueryUpdate(){
		
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		int index = -1;
		
		for (int i = 0; i < listPersonalConceptoFrecuenciaQuery.size(); i++) {
			if(listPersonalConceptoFrecuenciaQuery.get(i).getSrl_id_frecuencia().equals(personalConceptoFrecuenciaQuery.getSrl_id_frecuencia())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonalConceptoFrecuenciaQuery.set(index, personalConceptoFrecuenciaQuery);
		}
		
		this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",listPersonalConceptoFrecuenciaQuery);
		this.success(personalConceptoFrecuenciaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoFrecuenciaQueryDelete(){
		
		List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery = (List<PersonalConceptoFrecuenciaQuery>) this.getSessionContext().getAttribute("PersonalConceptoFrecuenciaQueryList");
		int index = -1;
		for (int i = 0; i < listPersonalConceptoFrecuenciaQuery.size(); i++) {
			if(listPersonalConceptoFrecuenciaQuery.get(i).getSrl_id_frecuencia().equals(personalConceptoFrecuenciaQuery.getSrl_id_frecuencia())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonalConceptoFrecuenciaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("PersonalConceptoFrecuenciaQueryList",listPersonalConceptoFrecuenciaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
//	////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoAfectoQueryList(){
		
		List<ConceptoPersonalQuery> listConceptoPersonalQuery = (List<ConceptoPersonalQuery>) this.getSessionContext().getAttribute("ConceptoPersonalQueryList");
		
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery;
		List<PersonalConceptoAfectoQuery> subListPersonalConceptoAfectoQuery;
		Integer srl_id_personal_concepto = this.getIntegerParameter("srl_id_personal_concepto");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_personal_concepto == null){
			listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		}else if(srl_id_personal_concepto.equals("-1")){
			listPersonalConceptoAfectoQuery = new ArrayList<PersonalConceptoAfectoQuery>();
		}else{
			
			ConceptoPersonalQuery conceptoPersonalQuery = null;
			for(ConceptoPersonalQuery x : listConceptoPersonalQuery){
				if(x.getSrl_id_personal_concepto().intValue() == srl_id_personal_concepto.intValue()){
					conceptoPersonalQuery = x;
				}
			}
			
			if(conceptoPersonalQuery == null){
				listPersonalConceptoAfectoQuery = new ArrayList<PersonalConceptoAfectoQuery>();
			}else{
				listPersonalConceptoAfectoQuery = conceptoPersonalQuery.getListPersonalConceptoAfectoQuery();
				if(listPersonalConceptoAfectoQuery == null){
					
					Map<String, Object> paramMap = this.getParamMap();
					paramMap.put("srl_id_personal_concepto", srl_id_personal_concepto);
					listPersonalConceptoAfectoQuery = this.gestionarAsignarConceptoService.getListByQuery(PersonalConceptoAfectoQueryMapper.class, paramMap);

				}
			}
			
		}

		if(listPersonalConceptoAfectoQuery == null){
			listPersonalConceptoAfectoQuery = new ArrayList<PersonalConceptoAfectoQuery>();
		}
		this.getSessionContext(true).setAttribute("PersonalConceptoAfectoQueryList",listPersonalConceptoAfectoQuery);
		int size = listPersonalConceptoAfectoQuery.size();
		subListPersonalConceptoAfectoQuery = this.getSubList(listPersonalConceptoAfectoQuery, start, limit);
		
		this.success(subListPersonalConceptoAfectoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoAfectoQueryAdd(){
		
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		int randomInt = this.getNegativeIdRandom();
		personalConceptoAfectoQuery.setSrl_id_personal_concepto_afecto(randomInt);
		listPersonalConceptoAfectoQuery.add(personalConceptoAfectoQuery);	
		this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",listPersonalConceptoAfectoQuery);
		this.success(personalConceptoAfectoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoAfectoQueryUpdate(){
		
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		int index = -1;
		
		for (int i = 0; i < listPersonalConceptoAfectoQuery.size(); i++) {
			if(listPersonalConceptoAfectoQuery.get(i).getSrl_id_personal_concepto_afecto().equals(personalConceptoAfectoQuery.getSrl_id_personal_concepto_afecto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonalConceptoAfectoQuery.set(index, personalConceptoAfectoQuery);
		}
		
		this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",listPersonalConceptoAfectoQuery);
		this.success(personalConceptoAfectoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalConceptoAfectoQueryDelete(){
		
		List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery = (List<PersonalConceptoAfectoQuery>) this.getSessionContext().getAttribute("PersonalConceptoAfectoQueryList");
		int index = -1;
		for (int i = 0; i < listPersonalConceptoAfectoQuery.size(); i++) {
			if(listPersonalConceptoAfectoQuery.get(i).getSrl_id_personal_concepto_afecto().equals(personalConceptoAfectoQuery.getSrl_id_personal_concepto_afecto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonalConceptoAfectoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("PersonalConceptoAfectoQueryList",listPersonalConceptoAfectoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	////////////////////
	
	@SuppressWarnings("unchecked")
	public String SuspensionCuartaCategoriaQueryList(){
		
		List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery;
		List<SuspensionCuartaCategoriaQuery> subListSuspensionCuartaCategoriaQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listSuspensionCuartaCategoriaQuery = (List<SuspensionCuartaCategoriaQuery>) this.getSessionContext().getAttribute("SuspensionCuartaCategoriaQueryList");
		}else if(idpersonal.equals("-1")){
			listSuspensionCuartaCategoriaQuery = new ArrayList<SuspensionCuartaCategoriaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listSuspensionCuartaCategoriaQuery = this.gestionarAsignarConceptoService.getListByQuery(SuspensionCuartaCategoriaQueryMapper.class, paramMap);
		}

		if(listSuspensionCuartaCategoriaQuery == null){
			listSuspensionCuartaCategoriaQuery = new ArrayList<SuspensionCuartaCategoriaQuery>();
		}
		this.getSessionContext(true).setAttribute("SuspensionCuartaCategoriaQueryList",listSuspensionCuartaCategoriaQuery);
		int size = listSuspensionCuartaCategoriaQuery.size();
		subListSuspensionCuartaCategoriaQuery = this.getSubList(listSuspensionCuartaCategoriaQuery, start, limit);
		
		this.success(subListSuspensionCuartaCategoriaQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SuspensionCuartaCategoriaQueryAdd(){
		
		List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery = (List<SuspensionCuartaCategoriaQuery>) this.getSessionContext().getAttribute("SuspensionCuartaCategoriaQueryList");
		int randomInt = this.getNegativeIdRandom();
		suspensionCuartaCategoriaQuery.setSrl_id_suspension_cuarta_categoria(randomInt);
		listSuspensionCuartaCategoriaQuery.add(suspensionCuartaCategoriaQuery);	
		this.getSessionContext().setAttribute("SuspensionCuartaCategoriaQueryList",listSuspensionCuartaCategoriaQuery);
		this.success(suspensionCuartaCategoriaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SuspensionCuartaCategoriaQueryUpdate(){
		
		List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery = (List<SuspensionCuartaCategoriaQuery>) this.getSessionContext().getAttribute("SuspensionCuartaCategoriaQueryList");
		int index = -1;
		
		for (int i = 0; i < listSuspensionCuartaCategoriaQuery.size(); i++) {
			if(listSuspensionCuartaCategoriaQuery.get(i).getSrl_id_suspension_cuarta_categoria().equals(suspensionCuartaCategoriaQuery.getSrl_id_suspension_cuarta_categoria())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSuspensionCuartaCategoriaQuery.set(index, suspensionCuartaCategoriaQuery);
		}
		
		this.getSessionContext().setAttribute("SuspensionCuartaCategoriaQueryList",listSuspensionCuartaCategoriaQuery);
		this.success(suspensionCuartaCategoriaQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String SuspensionCuartaCategoriaQueryDelete(){
		
		List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery = (List<SuspensionCuartaCategoriaQuery>) this.getSessionContext().getAttribute("SuspensionCuartaCategoriaQueryList");
		int index = -1;
		for (int i = 0; i < listSuspensionCuartaCategoriaQuery.size(); i++) {
			if(listSuspensionCuartaCategoriaQuery.get(i).getSrl_id_suspension_cuarta_categoria().equals(suspensionCuartaCategoriaQuery.getSrl_id_suspension_cuarta_categoria())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listSuspensionCuartaCategoriaQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("SuspensionCuartaCategoriaQueryList",listSuspensionCuartaCategoriaQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String BeneficiarioDescuentoJudicialQueryList(){
		
		List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery;
		List<BeneficiarioDescuentoJudicialQuery> subListBeneficiarioDescuentoJudicialQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listBeneficiarioDescuentoJudicialQuery = (List<BeneficiarioDescuentoJudicialQuery>) this.getSessionContext().getAttribute("BeneficiarioDescuentoJudicialQueryList");
		}else if(idpersonal.equals("-1")){
			listBeneficiarioDescuentoJudicialQuery = new ArrayList<BeneficiarioDescuentoJudicialQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listBeneficiarioDescuentoJudicialQuery = this.gestionarAsignarConceptoService.getListByQuery(BeneficiarioDescuentoJudicialQueryMapper.class, paramMap);
		}

		if(listBeneficiarioDescuentoJudicialQuery == null){
			listBeneficiarioDescuentoJudicialQuery = new ArrayList<BeneficiarioDescuentoJudicialQuery>();
		}
		this.getSessionContext(true).setAttribute("BeneficiarioDescuentoJudicialQueryList",listBeneficiarioDescuentoJudicialQuery);
		int size = listBeneficiarioDescuentoJudicialQuery.size();
		subListBeneficiarioDescuentoJudicialQuery = this.getSubList(listBeneficiarioDescuentoJudicialQuery, start, limit);
		
		this.success(subListBeneficiarioDescuentoJudicialQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String BeneficiarioDescuentoJudicialQueryAdd(){
		
		List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery = (List<BeneficiarioDescuentoJudicialQuery>) this.getSessionContext().getAttribute("BeneficiarioDescuentoJudicialQueryList");
		int randomInt = this.getNegativeIdRandom();
		beneficiarioDescuentoJudicialQuery.setSrl_id_beneficiario_descuento_judicial(randomInt);
		listBeneficiarioDescuentoJudicialQuery.add(beneficiarioDescuentoJudicialQuery);	
		this.getSessionContext().setAttribute("BeneficiarioDescuentoJudicialQueryList",listBeneficiarioDescuentoJudicialQuery);
		this.success(beneficiarioDescuentoJudicialQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String BeneficiarioDescuentoJudicialQueryUpdate(){
		
		List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery = (List<BeneficiarioDescuentoJudicialQuery>) this.getSessionContext().getAttribute("BeneficiarioDescuentoJudicialQueryList");
		int index = -1;
		
		for (int i = 0; i < listBeneficiarioDescuentoJudicialQuery.size(); i++) {
			if(listBeneficiarioDescuentoJudicialQuery.get(i).getSrl_id_beneficiario_descuento_judicial().equals(beneficiarioDescuentoJudicialQuery.getSrl_id_beneficiario_descuento_judicial())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listBeneficiarioDescuentoJudicialQuery.set(index, beneficiarioDescuentoJudicialQuery);
		}
		
		this.getSessionContext().setAttribute("BeneficiarioDescuentoJudicialQueryList",listBeneficiarioDescuentoJudicialQuery);
		this.success(beneficiarioDescuentoJudicialQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String BeneficiarioDescuentoJudicialQueryDelete(){
		
		List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery = (List<BeneficiarioDescuentoJudicialQuery>) this.getSessionContext().getAttribute("BeneficiarioDescuentoJudicialQueryList");
		int index = -1;
		for (int i = 0; i < listBeneficiarioDescuentoJudicialQuery.size(); i++) {
			if(listBeneficiarioDescuentoJudicialQuery.get(i).getSrl_id_beneficiario_descuento_judicial().equals(beneficiarioDescuentoJudicialQuery.getSrl_id_beneficiario_descuento_judicial())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listBeneficiarioDescuentoJudicialQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("BeneficiarioDescuentoJudicialQueryList",listBeneficiarioDescuentoJudicialQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalInfoContratoQueryList(){
		
		List<PersonalInfoContratoQuery> listPersonalInfoContratoQuery;
		List<PersonalInfoContratoQuery> subListPersonalInfoContratoQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listPersonalInfoContratoQuery = (List<PersonalInfoContratoQuery>) this.getSessionContext().getAttribute("PersonalInfoContratoQueryList");
		}else if(idpersonal.equals("-1")){
			listPersonalInfoContratoQuery = new ArrayList<PersonalInfoContratoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listPersonalInfoContratoQuery = this.gestionarAsignarConceptoService.getListByQuery(PersonalInfoContratoQueryMapper.class, paramMap);
		}

		if(listPersonalInfoContratoQuery == null){
			listPersonalInfoContratoQuery = new ArrayList<PersonalInfoContratoQuery>();
		}
		this.getSessionContext(true).setAttribute("PersonalInfoContratoQueryList",listPersonalInfoContratoQuery);
		int size = listPersonalInfoContratoQuery.size();
		subListPersonalInfoContratoQuery = this.getSubList(listPersonalInfoContratoQuery, start, limit);
		
		this.success(subListPersonalInfoContratoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalInfoFormacionQueryList(){
		
		List<PersonalInfoFormacionQuery> listPersonalInfoFormacionQuery;
		List<PersonalInfoFormacionQuery> subListPersonalInfoFormacionQuery;
		Integer idpersonal = this.getIntegerParameter("idpersonal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(idpersonal == null){
			listPersonalInfoFormacionQuery = (List<PersonalInfoFormacionQuery>) this.getSessionContext().getAttribute("PersonalInfoFormacionQueryList");
		}else if(idpersonal.equals("-1")){
			listPersonalInfoFormacionQuery = new ArrayList<PersonalInfoFormacionQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("idpersonal", idpersonal);
			listPersonalInfoFormacionQuery = this.gestionarAsignarConceptoService.getListByQuery(PersonalInfoFormacionQueryMapper.class, paramMap);
		}

		if(listPersonalInfoFormacionQuery == null){
			listPersonalInfoFormacionQuery = new ArrayList<PersonalInfoFormacionQuery>();
		}
		this.getSessionContext(true).setAttribute("PersonalInfoFormacionQueryList",listPersonalInfoFormacionQuery);
		int size = listPersonalInfoFormacionQuery.size();
		subListPersonalInfoFormacionQuery = this.getSubList(listPersonalInfoFormacionQuery, start, limit);
		
		this.success(subListPersonalInfoFormacionQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalInfoAdendasPorContratoQueryList(){
		
		List<PersonalInfoAdendasPorContratoQuery> listPersonalInfoAdendasPorContratoQuery;
		List<PersonalInfoAdendasPorContratoQuery> subListPersonalInfoAdendasPorContratoQuery;
		Integer srl_id_contrato_padre = this.getIntegerParameter("srl_id_contrato_padre");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_contrato_padre == null){
			listPersonalInfoAdendasPorContratoQuery = (List<PersonalInfoAdendasPorContratoQuery>) this.getSessionContext().getAttribute("PersonalInfoAdendasPorContratoQueryList");
		}else if(srl_id_contrato_padre.equals("-1")){
			listPersonalInfoAdendasPorContratoQuery = new ArrayList<PersonalInfoAdendasPorContratoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_contrato_padre", srl_id_contrato_padre);
			listPersonalInfoAdendasPorContratoQuery = this.gestionarAsignarConceptoService.getListByQuery(PersonalInfoAdendasPorContratoQueryMapper.class, paramMap);
		}

		if(listPersonalInfoAdendasPorContratoQuery == null){
			listPersonalInfoAdendasPorContratoQuery = new ArrayList<PersonalInfoAdendasPorContratoQuery>();
		}
		this.getSessionContext(true).setAttribute("PersonalInfoAdendasPorContratoQueryList",listPersonalInfoAdendasPorContratoQuery);
		int size = listPersonalInfoAdendasPorContratoQuery.size();
		subListPersonalInfoAdendasPorContratoQuery = this.getSubList(listPersonalInfoAdendasPorContratoQuery, start, limit);
		
		this.success(subListPersonalInfoAdendasPorContratoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String PersonalInfoContratoQueryUpdate(){
		
		List<PersonalInfoContratoQuery> listPersonalInfoContratoQuery = (List<PersonalInfoContratoQuery>) this.getSessionContext().getAttribute("PersonalInfoContratoQueryList");
		int index = -1;
		
		for (int i = 0; i < listPersonalInfoContratoQuery.size(); i++) {
			if(listPersonalInfoContratoQuery.get(i).getSrl_id_contrato().equals(personalInfoContratoQuery.getSrl_id_contrato())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			PersonalInfoContratoQuery obj = listPersonalInfoContratoQuery.get(index);
			obj.setVar_ubicacion_fisica(personalInfoContratoQuery.getVar_ubicacion_fisica());
			listPersonalInfoContratoQuery.set(index, obj);
		}
		
		this.getSessionContext().setAttribute("PersonalInfoContratoQueryList",listPersonalInfoContratoQuery);
		this.success(personalInfoContratoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionarAsignarConceptoService getGestionarAsignarConceptoService() {
		return gestionarAsignarConceptoService;
	}

	public void setGestionarAsignarConceptoService(GestionarAsignarConceptoService gestionarAsignarConceptoService) {
		this.gestionarAsignarConceptoService = gestionarAsignarConceptoService;
	}
	
	public GestionarAsignarConceptoQuery getGestionarAsignarConceptoQuery() {
		return gestionarAsignarConceptoQuery;
	}

	public void setGestionarAsignarConceptoQuery(GestionarAsignarConceptoQuery gestionarAsignarConceptoQuery) {
		this.gestionarAsignarConceptoQuery = gestionarAsignarConceptoQuery;
	}
	public ConceptoPersonalQuery getConceptoPersonalQuery() {
		return conceptoPersonalQuery;
	}

	public void setConceptoPersonalQuery(ConceptoPersonalQuery conceptoPersonalQuery) {
		this.conceptoPersonalQuery = conceptoPersonalQuery;
	}
	public PersonalConceptoFrecuenciaQuery getPersonalConceptoFrecuenciaQuery() {
		return personalConceptoFrecuenciaQuery;
	}

	public void setPersonalConceptoFrecuenciaQuery(PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery) {
		this.personalConceptoFrecuenciaQuery = personalConceptoFrecuenciaQuery;
	}
	public SuspensionCuartaCategoriaQuery getSuspensionCuartaCategoriaQuery() {
		return suspensionCuartaCategoriaQuery;
	}

	public void setSuspensionCuartaCategoriaQuery(SuspensionCuartaCategoriaQuery suspensionCuartaCategoriaQuery) {
		this.suspensionCuartaCategoriaQuery = suspensionCuartaCategoriaQuery;
	}
	public BeneficiarioDescuentoJudicialQuery getBeneficiarioDescuentoJudicialQuery() {
		return beneficiarioDescuentoJudicialQuery;
	}

	public void setBeneficiarioDescuentoJudicialQuery(BeneficiarioDescuentoJudicialQuery beneficiarioDescuentoJudicialQuery) {
		this.beneficiarioDescuentoJudicialQuery = beneficiarioDescuentoJudicialQuery;
	}

	public PersonalConceptoAfectoQuery getPersonalConceptoAfectoQuery() {
		return personalConceptoAfectoQuery;
	}

	public void setPersonalConceptoAfectoQuery(
			PersonalConceptoAfectoQuery personalConceptoAfectoQuery) {
		this.personalConceptoAfectoQuery = personalConceptoAfectoQuery;
	}

	public PersonalInfoContratoQuery getPersonalInfoContratoQuery() {
		return personalInfoContratoQuery;
	}

	public void setPersonalInfoContratoQuery(
			PersonalInfoContratoQuery personalInfoContratoQuery) {
		this.personalInfoContratoQuery = personalInfoContratoQuery;
	}

	public PersonalInfoFormacionQuery getPersonalInfoFormacionQuery() {
		return personalInfoFormacionQuery;
	}

	public void setPersonalInfoFormacionQuery(
			PersonalInfoFormacionQuery personalInfoFormacionQuery) {
		this.personalInfoFormacionQuery = personalInfoFormacionQuery;
	}

	public PersonalInfoAdendasPorContratoQuery getPersonalInfoAdendasPorContratoQuery() {
		return personalInfoAdendasPorContratoQuery;
	}

	public void setPersonalInfoAdendasPorContratoQuery(
			PersonalInfoAdendasPorContratoQuery personalInfoAdendasPorContratoQuery) {
		this.personalInfoAdendasPorContratoQuery = personalInfoAdendasPorContratoQuery;
	}
	
	

/*
<!-- Start Actions GestionarAsignarConcepto -->
<action name="GestionarAsignarConceptoView" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="view">
		<result type="json" />
</action>

<action name="GestionarAsignarConceptoCreate" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="create">
		<result type="json" />
</action>

<action name="GestionarAsignarConceptoSave" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="save">
		<result type="json" />
</action>

<action name="GestionarAsignarConceptoRemove" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model ConceptoPersonalQuery Actions -->
<action name="ConceptoPersonalQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="ConceptoPersonalQueryList">
		<result type="json" />
</action>

<action name="ConceptoPersonalQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="ConceptoPersonalQueryAdd">
		<result type="json" />
</action>

<action name="ConceptoPersonalQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="ConceptoPersonalQueryUpdate">
		<result type="json" />
</action>

<action name="ConceptoPersonalQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="ConceptoPersonalQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model ConceptoPersonalQuery Actions -->
<!-- Start Sub Model PersonalConceptoFrecuenciaQuery Actions -->
<action name="PersonalConceptoFrecuenciaQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="PersonalConceptoFrecuenciaQueryList">
		<result type="json" />
</action>

<action name="PersonalConceptoFrecuenciaQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="PersonalConceptoFrecuenciaQueryAdd">
		<result type="json" />
</action>

<action name="PersonalConceptoFrecuenciaQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="PersonalConceptoFrecuenciaQueryUpdate">
		<result type="json" />
</action>

<action name="PersonalConceptoFrecuenciaQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="PersonalConceptoFrecuenciaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model PersonalConceptoFrecuenciaQuery Actions -->
<!-- Start Sub Model SuspensionCuartaCategoriaQuery Actions -->
<action name="SuspensionCuartaCategoriaQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="SuspensionCuartaCategoriaQueryList">
		<result type="json" />
</action>

<action name="SuspensionCuartaCategoriaQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="SuspensionCuartaCategoriaQueryAdd">
		<result type="json" />
</action>

<action name="SuspensionCuartaCategoriaQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="SuspensionCuartaCategoriaQueryUpdate">
		<result type="json" />
</action>

<action name="SuspensionCuartaCategoriaQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="SuspensionCuartaCategoriaQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model SuspensionCuartaCategoriaQuery Actions -->
<!-- Start Sub Model BeneficiarioDescuentoJudicialQuery Actions -->
<action name="BeneficiarioDescuentoJudicialQueryList" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="BeneficiarioDescuentoJudicialQueryList">
		<result type="json" />
</action>

<action name="BeneficiarioDescuentoJudicialQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="BeneficiarioDescuentoJudicialQueryAdd">
		<result type="json" />
</action>

<action name="BeneficiarioDescuentoJudicialQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="BeneficiarioDescuentoJudicialQueryUpdate">
		<result type="json" />
</action>

<action name="BeneficiarioDescuentoJudicialQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionarAsignarConceptoAction" method="BeneficiarioDescuentoJudicialQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model BeneficiarioDescuentoJudicialQuery Actions -->

<!-- End Actions GestionarAsignarConcepto -->
*/
}
