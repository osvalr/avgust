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
* DATE CREATE : 07/04/2015 14:31:08
* VERSION : 1.0 
*/

package sernanp.rrhh.web.action.planilla;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.app.business.core.planilla.service.GestionaNominaService;
import sernanp.app.dao.query.domain.AportesNominaConceptoQuery;
import sernanp.app.dao.query.domain.DescuentoJudicialesNominaConceptoQuery;
import sernanp.app.dao.query.domain.DescuentosNominaConceptoQuery;
import sernanp.app.dao.query.domain.GestionarNominaQuery;
import sernanp.app.dao.query.domain.GestionarNominaQueryCriteria;
import sernanp.app.dao.query.domain.GestionarNominaTotalesQuery;
import sernanp.app.dao.query.domain.GestionarNominaTotalesQueryCriteria;
import sernanp.app.dao.query.domain.IngresosNominaConceptoQuery;
import sernanp.app.dao.query.mapper.AportesNominaConceptoQueryMapper;
import sernanp.app.dao.query.mapper.DescuentoJudicialesNominaConceptoQueryMapper;
import sernanp.app.dao.query.mapper.DescuentosNominaConceptoQueryMapper;
import sernanp.app.dao.query.mapper.GestionarNominaQueryMapper;
import sernanp.app.dao.query.mapper.GestionarNominaTotalesQueryMapper;
import sernanp.app.dao.query.mapper.IngresosNominaConceptoQueryMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.ExtJsStrutsUtil;
import sernanp.rrhh.web.action.helper.ActionHelperExtjs;

public class GestionaNominaAction extends ActionHelperExtjs {


	private Object record;
	private static final long serialVersionUID = 1L;
	
	private final int TIPO_DOCUMENTO_RUC = 123;

	@Autowired
	private GestionaNominaService gestionaNominaService;
	private GestionarNominaQuery gestionarNominaQuery;
	private IngresosNominaConceptoQuery ingresosNominaConceptoQuery;
	private DescuentosNominaConceptoQuery descuentosNominaConceptoQuery;
	private DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery;
	private AportesNominaConceptoQuery aportesNominaConceptoQuery;


	public String view(){
		
		try{
			
			int start = this.getIntegerParameter("start");
			int limit = this.getIntegerParameter("limit");
			
			GestionarNominaQueryCriteria gestionarNominaQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarNominaQueryCriteria.class);
			
			if(gestionarNominaQueryCriteria.getIdtipodocumento() != null){
				if(gestionarNominaQueryCriteria.getIdtipodocumento().intValue() == TIPO_DOCUMENTO_RUC){
					gestionarNominaQueryCriteria.setRuc(gestionarNominaQueryCriteria.getNumerodoc());
					gestionarNominaQueryCriteria.setNumerodoc(null);
					gestionarNominaQueryCriteria.setIdtipodocumento(null);
				}
			}
			
			//Estado final
			gestionarNominaQueryCriteria.setInt_id_estado(1);
			
			List<GestionarNominaQuery> listGestionarNominaQuery = gestionaNominaService.getListByQuery(GestionarNominaQueryMapper.class, gestionarNominaQueryCriteria, start, limit);
			int total = gestionaNominaService.getCountRowsByQuery(GestionarNominaQueryMapper.class, gestionarNominaQueryCriteria);
			
			this.success(listGestionarNominaQuery,total);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String viewTotales(){
		
		try{
			
			GestionarNominaTotalesQueryCriteria gestionarNominaTotalesQueryCriteria = this.loadCriteria(this.getHttpRequest(), GestionarNominaTotalesQueryCriteria.class);
			
			if(gestionarNominaTotalesQueryCriteria.getIdtipodocumento() != null){
				if(gestionarNominaTotalesQueryCriteria.getIdtipodocumento().intValue() == TIPO_DOCUMENTO_RUC){
					gestionarNominaTotalesQueryCriteria.setRuc(gestionarNominaTotalesQueryCriteria.getNumerodoc());
					gestionarNominaTotalesQueryCriteria.setNumerodoc(null);
					gestionarNominaTotalesQueryCriteria.setIdtipodocumento(null);
				}
			}
			
			List<GestionarNominaTotalesQuery> listGestionarNominaTotalesQuery = gestionaNominaService.getListByQuery(GestionarNominaTotalesQueryMapper.class, gestionarNominaTotalesQueryCriteria);
	
			this.record = listGestionarNominaTotalesQuery.get(0);
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String create(){
		
		try{
			List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
			List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
			List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
			List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
			gestionaNominaService.create(gestionarNominaQuery,listIngresosNominaConceptoQuery, listDescuentosNominaConceptoQuery, listDescuentoJudicialesNominaConceptoQuery, listAportesNominaConceptoQuery);
			this.getSessionContext().setAttribute("IngresosNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("DescuentosNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("DescuentoJudicialesNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("AportesNominaConceptoQueryList",null);
			this.success(gestionarNominaQuery, "Operation Success.");
			
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String save(){
		
		try{
			List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
			List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
			List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
			List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
			gestionaNominaService.save(gestionarNominaQuery,listIngresosNominaConceptoQuery, listDescuentosNominaConceptoQuery, listDescuentoJudicialesNominaConceptoQuery, listAportesNominaConceptoQuery);
			this.getSessionContext().setAttribute("IngresosNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("DescuentosNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("DescuentoJudicialesNominaConceptoQueryList",null);
			this.getSessionContext().setAttribute("AportesNominaConceptoQueryList",null);
			this.success(gestionarNominaQuery, "Operation Success.");
		}catch(BusinessException e){
			this.exception(e.getMessage());
		} catch (IOException e) {
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String remove(){
		
		try{
			
//			Map<String, Object> paramMap = this.getParamMap();
//			paramMap.put("srl_id_nomina_anio_periodo_personal", gestionarNominaQuery.getSrl_id_nomina_anio_periodo_personal());
//			List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = this.gestionaNominaService.getListByQuery(IngresosNominaConceptoQueryMapper.class, paramMap);
//			paramMap.put("srl_id_nomina_anio_periodo_personal", gestionarNominaQuery.getSrl_id_nomina_anio_periodo_personal());
//			List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = this.gestionaNominaService.getListByQuery(DescuentosNominaConceptoQueryMapper.class, paramMap);
//			paramMap.put("srl_id_nomina_anio_periodo_personal", gestionarNominaQuery.getSrl_id_nomina_anio_periodo_personal());
//			List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = this.gestionaNominaService.getListByQuery(DescuentoJudicialesNominaConceptoQueryMapper.class, paramMap);
//			paramMap.put("srl_id_nomina_anio_periodo_personal", gestionarNominaQuery.getSrl_id_nomina_anio_periodo_personal());
//			List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = this.gestionaNominaService.getListByQuery(AportesNominaConceptoQueryMapper.class, paramMap);
//			gestionaNominaService.remove(gestionarNominaQuery,listIngresosNominaConceptoQuery, listDescuentosNominaConceptoQuery, listDescuentoJudicialesNominaConceptoQuery, listAportesNominaConceptoQuery);
//			this.getSessionContext().removeAttribute("IngresosNominaConceptoQueryList");
//			this.getSessionContext().removeAttribute("DescuentosNominaConceptoQueryList");
//			this.getSessionContext().removeAttribute("DescuentoJudicialesNominaConceptoQueryList");
//			this.getSessionContext().removeAttribute("AportesNominaConceptoQueryList");
			
			//nomina inactiva
			gestionarNominaQuery.setInt_id_estado(2);
			gestionaNominaService.changeState(gestionarNominaQuery);
			
			this.extjsReturn.setSuccess(true);
		}catch(BusinessException e){
			this.exception(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String IngresosNominaConceptoQueryList(){
		
		List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery;
		List<IngresosNominaConceptoQuery> subListIngresosNominaConceptoQuery;
		Integer srl_id_nomina_anio_periodo_personal = this.getIntegerParameter("srl_id_nomina_anio_periodo_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_nomina_anio_periodo_personal == null){
			listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
		}else if(srl_id_nomina_anio_periodo_personal.equals("-1")){
			listIngresosNominaConceptoQuery = new ArrayList<IngresosNominaConceptoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_nomina_anio_periodo_personal", srl_id_nomina_anio_periodo_personal);
			listIngresosNominaConceptoQuery = this.gestionaNominaService.getListByQuery(IngresosNominaConceptoQueryMapper.class, paramMap);
		}

		if(listIngresosNominaConceptoQuery == null){
			listIngresosNominaConceptoQuery = new ArrayList<IngresosNominaConceptoQuery>();
		}
		this.getSessionContext(true).setAttribute("IngresosNominaConceptoQueryList",listIngresosNominaConceptoQuery);
		int size = listIngresosNominaConceptoQuery.size();
		subListIngresosNominaConceptoQuery = this.getSubList(listIngresosNominaConceptoQuery, start, limit);
		
		this.success(subListIngresosNominaConceptoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String IngresosNominaConceptoQueryAdd(){
		
		List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
		int randomInt = this.getNegativeIdRandom();
		ingresosNominaConceptoQuery.setSrl_id_nomina_concepto(randomInt);
		listIngresosNominaConceptoQuery.add(ingresosNominaConceptoQuery);	
		this.getSessionContext().setAttribute("IngresosNominaConceptoQueryList",listIngresosNominaConceptoQuery);
		this.success(ingresosNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String IngresosNominaConceptoQueryUpdate(){
		
		List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
		int index = -1;
		
		for (int i = 0; i < listIngresosNominaConceptoQuery.size(); i++) {
			if(listIngresosNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(ingresosNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listIngresosNominaConceptoQuery.set(index, ingresosNominaConceptoQuery);
		}
		
		this.getSessionContext().setAttribute("IngresosNominaConceptoQueryList",listIngresosNominaConceptoQuery);
		this.success(ingresosNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String IngresosNominaConceptoQueryDelete(){
		
		List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery = (List<IngresosNominaConceptoQuery>) this.getSessionContext().getAttribute("IngresosNominaConceptoQueryList");
		int index = -1;
		for (int i = 0; i < listIngresosNominaConceptoQuery.size(); i++) {
			if(listIngresosNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(ingresosNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listIngresosNominaConceptoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("IngresosNominaConceptoQueryList",listIngresosNominaConceptoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String DescuentosNominaConceptoQueryList(){
		
		List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery;
		List<DescuentosNominaConceptoQuery> subListDescuentosNominaConceptoQuery;
		Integer srl_id_nomina_anio_periodo_personal = this.getIntegerParameter("srl_id_nomina_anio_periodo_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_nomina_anio_periodo_personal == null){
			listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
		}else if(srl_id_nomina_anio_periodo_personal.equals("-1")){
			listDescuentosNominaConceptoQuery = new ArrayList<DescuentosNominaConceptoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_nomina_anio_periodo_personal", srl_id_nomina_anio_periodo_personal);
			listDescuentosNominaConceptoQuery = this.gestionaNominaService.getListByQuery(DescuentosNominaConceptoQueryMapper.class, paramMap);
		}

		if(listDescuentosNominaConceptoQuery == null){
			listDescuentosNominaConceptoQuery = new ArrayList<DescuentosNominaConceptoQuery>();
		}
		this.getSessionContext(true).setAttribute("DescuentosNominaConceptoQueryList",listDescuentosNominaConceptoQuery);
		int size = listDescuentosNominaConceptoQuery.size();
		subListDescuentosNominaConceptoQuery = this.getSubList(listDescuentosNominaConceptoQuery, start, limit);
		
		this.success(subListDescuentosNominaConceptoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentosNominaConceptoQueryAdd(){
		
		List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
		int randomInt = this.getNegativeIdRandom();
		descuentosNominaConceptoQuery.setSrl_id_nomina_concepto(randomInt);
		listDescuentosNominaConceptoQuery.add(descuentosNominaConceptoQuery);	
		this.getSessionContext().setAttribute("DescuentosNominaConceptoQueryList",listDescuentosNominaConceptoQuery);
		this.success(descuentosNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentosNominaConceptoQueryUpdate(){
		
		List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
		int index = -1;
		
		for (int i = 0; i < listDescuentosNominaConceptoQuery.size(); i++) {
			if(listDescuentosNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(descuentosNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listDescuentosNominaConceptoQuery.set(index, descuentosNominaConceptoQuery);
		}
		
		this.getSessionContext().setAttribute("DescuentosNominaConceptoQueryList",listDescuentosNominaConceptoQuery);
		this.success(descuentosNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentosNominaConceptoQueryDelete(){
		
		List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery = (List<DescuentosNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentosNominaConceptoQueryList");
		int index = -1;
		for (int i = 0; i < listDescuentosNominaConceptoQuery.size(); i++) {
			if(listDescuentosNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(descuentosNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listDescuentosNominaConceptoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("DescuentosNominaConceptoQueryList",listDescuentosNominaConceptoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String DescuentoJudicialesNominaConceptoQueryList(){
		
		List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery;
		List<DescuentoJudicialesNominaConceptoQuery> subListDescuentoJudicialesNominaConceptoQuery;
		Integer srl_id_nomina_anio_periodo_personal = this.getIntegerParameter("srl_id_nomina_anio_periodo_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_nomina_anio_periodo_personal == null){
			listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
		}else if(srl_id_nomina_anio_periodo_personal.equals("-1")){
			listDescuentoJudicialesNominaConceptoQuery = new ArrayList<DescuentoJudicialesNominaConceptoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_nomina_anio_periodo_personal", srl_id_nomina_anio_periodo_personal);
			listDescuentoJudicialesNominaConceptoQuery = this.gestionaNominaService.getListByQuery(DescuentoJudicialesNominaConceptoQueryMapper.class, paramMap);
		}

		if(listDescuentoJudicialesNominaConceptoQuery == null){
			listDescuentoJudicialesNominaConceptoQuery = new ArrayList<DescuentoJudicialesNominaConceptoQuery>();
		}
		this.getSessionContext(true).setAttribute("DescuentoJudicialesNominaConceptoQueryList",listDescuentoJudicialesNominaConceptoQuery);
		int size = listDescuentoJudicialesNominaConceptoQuery.size();
		subListDescuentoJudicialesNominaConceptoQuery = this.getSubList(listDescuentoJudicialesNominaConceptoQuery, start, limit);
		
		this.success(subListDescuentoJudicialesNominaConceptoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentoJudicialesNominaConceptoQueryAdd(){
		
		List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
		int randomInt = this.getNegativeIdRandom();
		descuentoJudicialesNominaConceptoQuery.setSrl_id_nomina_concepto(randomInt);
		listDescuentoJudicialesNominaConceptoQuery.add(descuentoJudicialesNominaConceptoQuery);	
		this.getSessionContext().setAttribute("DescuentoJudicialesNominaConceptoQueryList",listDescuentoJudicialesNominaConceptoQuery);
		this.success(descuentoJudicialesNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentoJudicialesNominaConceptoQueryUpdate(){
		
		List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
		int index = -1;
		
		for (int i = 0; i < listDescuentoJudicialesNominaConceptoQuery.size(); i++) {
			if(listDescuentoJudicialesNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(descuentoJudicialesNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listDescuentoJudicialesNominaConceptoQuery.set(index, descuentoJudicialesNominaConceptoQuery);
		}
		
		this.getSessionContext().setAttribute("DescuentoJudicialesNominaConceptoQueryList",listDescuentoJudicialesNominaConceptoQuery);
		this.success(descuentoJudicialesNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String DescuentoJudicialesNominaConceptoQueryDelete(){
		
		List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery = (List<DescuentoJudicialesNominaConceptoQuery>) this.getSessionContext().getAttribute("DescuentoJudicialesNominaConceptoQueryList");
		int index = -1;
		for (int i = 0; i < listDescuentoJudicialesNominaConceptoQuery.size(); i++) {
			if(listDescuentoJudicialesNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(descuentoJudicialesNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listDescuentoJudicialesNominaConceptoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("DescuentoJudicialesNominaConceptoQueryList",listDescuentoJudicialesNominaConceptoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String AportesNominaConceptoQueryList(){
		
		List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery;
		List<AportesNominaConceptoQuery> subListAportesNominaConceptoQuery;
		Integer srl_id_nomina_anio_periodo_personal = this.getIntegerParameter("srl_id_nomina_anio_periodo_personal");
		int start = this.getIntegerParameter("start");
		int limit = this.getIntegerParameter("limit");
		
		if(srl_id_nomina_anio_periodo_personal == null){
			listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
		}else if(srl_id_nomina_anio_periodo_personal.equals("-1")){
			listAportesNominaConceptoQuery = new ArrayList<AportesNominaConceptoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("srl_id_nomina_anio_periodo_personal", srl_id_nomina_anio_periodo_personal);
			listAportesNominaConceptoQuery = this.gestionaNominaService.getListByQuery(AportesNominaConceptoQueryMapper.class, paramMap);
		}

		if(listAportesNominaConceptoQuery == null){
			listAportesNominaConceptoQuery = new ArrayList<AportesNominaConceptoQuery>();
		}
		this.getSessionContext(true).setAttribute("AportesNominaConceptoQueryList",listAportesNominaConceptoQuery);
		int size = listAportesNominaConceptoQuery.size();
		subListAportesNominaConceptoQuery = this.getSubList(listAportesNominaConceptoQuery, start, limit);
		
		this.success(subListAportesNominaConceptoQuery,size);

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String AportesNominaConceptoQueryAdd(){
		
		List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
		int randomInt = this.getNegativeIdRandom();
		aportesNominaConceptoQuery.setSrl_id_nomina_concepto(randomInt);
		listAportesNominaConceptoQuery.add(aportesNominaConceptoQuery);	
		this.getSessionContext().setAttribute("AportesNominaConceptoQueryList",listAportesNominaConceptoQuery);
		this.success(aportesNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String AportesNominaConceptoQueryUpdate(){
		
		List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
		int index = -1;
		
		for (int i = 0; i < listAportesNominaConceptoQuery.size(); i++) {
			if(listAportesNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(aportesNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listAportesNominaConceptoQuery.set(index, aportesNominaConceptoQuery);
		}
		
		this.getSessionContext().setAttribute("AportesNominaConceptoQueryList",listAportesNominaConceptoQuery);
		this.success(aportesNominaConceptoQuery, "Operation Success.");
			
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String AportesNominaConceptoQueryDelete(){
		
		List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery = (List<AportesNominaConceptoQuery>) this.getSessionContext().getAttribute("AportesNominaConceptoQueryList");
		int index = -1;
		for (int i = 0; i < listAportesNominaConceptoQuery.size(); i++) {
			if(listAportesNominaConceptoQuery.get(i).getSrl_id_nomina_concepto().equals(aportesNominaConceptoQuery.getSrl_id_nomina_concepto())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listAportesNominaConceptoQuery.remove(index);
		}
		
		this.getSessionContext().setAttribute("AportesNominaConceptoQueryList",listAportesNominaConceptoQuery);
		this.extjsReturn.setSuccess(true);
			
		return SUCCESS;
	}
	
	
	@Override
	public ExtJsStrutsUtil getExtjsReturn() {
		return extjsReturn;
	}
	
	public GestionaNominaService getGestionaNominaService() {
		return gestionaNominaService;
	}

	public void setGestionaNominaService(GestionaNominaService gestionaNominaService) {
		this.gestionaNominaService = gestionaNominaService;
	}
	
	public GestionarNominaQuery getGestionarNominaQuery() {
		return gestionarNominaQuery;
	}

	public void setGestionarNominaQuery(GestionarNominaQuery gestionarNominaQuery) {
		this.gestionarNominaQuery = gestionarNominaQuery;
	}
	public IngresosNominaConceptoQuery getIngresosNominaConceptoQuery() {
		return ingresosNominaConceptoQuery;
	}

	public void setIngresosNominaConceptoQuery(IngresosNominaConceptoQuery ingresosNominaConceptoQuery) {
		this.ingresosNominaConceptoQuery = ingresosNominaConceptoQuery;
	}
	public DescuentosNominaConceptoQuery getDescuentosNominaConceptoQuery() {
		return descuentosNominaConceptoQuery;
	}

	public void setDescuentosNominaConceptoQuery(DescuentosNominaConceptoQuery descuentosNominaConceptoQuery) {
		this.descuentosNominaConceptoQuery = descuentosNominaConceptoQuery;
	}
	public DescuentoJudicialesNominaConceptoQuery getDescuentoJudicialesNominaConceptoQuery() {
		return descuentoJudicialesNominaConceptoQuery;
	}

	public void setDescuentoJudicialesNominaConceptoQuery(DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery) {
		this.descuentoJudicialesNominaConceptoQuery = descuentoJudicialesNominaConceptoQuery;
	}
	public AportesNominaConceptoQuery getAportesNominaConceptoQuery() {
		return aportesNominaConceptoQuery;
	}

	public void setAportesNominaConceptoQuery(AportesNominaConceptoQuery aportesNominaConceptoQuery) {
		this.aportesNominaConceptoQuery = aportesNominaConceptoQuery;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}


	

/*
<!-- Start Actions GestionaNomina -->
<action name="GestionaNominaView" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="view">
		<result type="json" />
</action>

<action name="GestionaNominaCreate" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="create">
		<result type="json" />
</action>

<action name="GestionaNominaSave" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="save">
		<result type="json" />
</action>

<action name="GestionaNominaRemove" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="remove">
		<result type="json" />
</action>

<!-- Start Sub Model IngresosNominaConceptoQuery Actions -->
<action name="IngresosNominaConceptoQueryList" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="IngresosNominaConceptoQueryList">
		<result type="json" />
</action>

<action name="IngresosNominaConceptoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="IngresosNominaConceptoQueryAdd">
		<result type="json" />
</action>

<action name="IngresosNominaConceptoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="IngresosNominaConceptoQueryUpdate">
		<result type="json" />
</action>

<action name="IngresosNominaConceptoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="IngresosNominaConceptoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model IngresosNominaConceptoQuery Actions -->
<!-- Start Sub Model DescuentosNominaConceptoQuery Actions -->
<action name="DescuentosNominaConceptoQueryList" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentosNominaConceptoQueryList">
		<result type="json" />
</action>

<action name="DescuentosNominaConceptoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentosNominaConceptoQueryAdd">
		<result type="json" />
</action>

<action name="DescuentosNominaConceptoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentosNominaConceptoQueryUpdate">
		<result type="json" />
</action>

<action name="DescuentosNominaConceptoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentosNominaConceptoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model DescuentosNominaConceptoQuery Actions -->
<!-- Start Sub Model DescuentoJudicialesNominaConceptoQuery Actions -->
<action name="DescuentoJudicialesNominaConceptoQueryList" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentoJudicialesNominaConceptoQueryList">
		<result type="json" />
</action>

<action name="DescuentoJudicialesNominaConceptoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentoJudicialesNominaConceptoQueryAdd">
		<result type="json" />
</action>

<action name="DescuentoJudicialesNominaConceptoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentoJudicialesNominaConceptoQueryUpdate">
		<result type="json" />
</action>

<action name="DescuentoJudicialesNominaConceptoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="DescuentoJudicialesNominaConceptoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model DescuentoJudicialesNominaConceptoQuery Actions -->
<!-- Start Sub Model AportesNominaConceptoQuery Actions -->
<action name="AportesNominaConceptoQueryList" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="AportesNominaConceptoQueryList">
		<result type="json" />
</action>

<action name="AportesNominaConceptoQueryAdd" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="AportesNominaConceptoQueryAdd">
		<result type="json" />
</action>

<action name="AportesNominaConceptoQueryUpdate" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="AportesNominaConceptoQueryUpdate">
		<result type="json" />
</action>

<action name="AportesNominaConceptoQueryDelete" class="sernanp.rrhh.web.action.planilla.GestionaNominaAction" method="AportesNominaConceptoQueryDelete">
		<result type="json" />
</action>
<!-- End Sub Model AportesNominaConceptoQuery Actions -->

<!-- End Actions GestionaNomina -->
*/
}
