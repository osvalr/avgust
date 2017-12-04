/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/01/2015 13:20:36
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJSReturn;

import pe.com.focus.sakerk.business.service.GestionarPersonaNaturalService;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQuery;
import pe.com.focus.sakerk.repository.custom.mapper.PersonaNaturalQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryWrapper;

import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.NumeroTelefonicoQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.InformacionAcademicaQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.InformacionLaboralQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.InformacionEclesiasticaQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.PersonaNaturalParentescoQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.PersonaNaturalRolQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQueryWrapper;

@Controller
@RequestMapping("/")
public class GestionarPersonaNaturalController extends ControllerHelper{

	@Autowired
	private GestionarPersonaNaturalService gestionarPersonaNaturalService;

	@RequestMapping(value="GestionarPersonaNaturalView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) throws Exception {
		try{
			PersonaNaturalQueryCriteria personaNaturalQueryCriteria = this.loadCriteria(request, PersonaNaturalQueryCriteria.class);
			List<PersonaNaturalQuery> listPersonaNaturalQuery = gestionarPersonaNaturalService.getListByQuery(PersonaNaturalQueryMapper.class, personaNaturalQueryCriteria, start, limit);
			int total = gestionarPersonaNaturalService.getCountRowsByQuery(PersonaNaturalQueryMapper.class, personaNaturalQueryCriteria);
			return ExtJSReturn.success(listPersonaNaturalQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarPersonaNaturalCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody PersonaNaturalQueryWrapper personaNaturalQueryWrapper, HttpSession session) throws Exception {
		try{
		
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
			List<InformacionAcademicaQuery> listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
			List<InformacionLaboralQuery> listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
			List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
			List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
			List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
			gestionarPersonaNaturalService.create(personaNaturalQueryWrapper.getData(),listNumeroTelefonicoQuery, listInformacionAcademicaQuery, listInformacionLaboralQuery, listInformacionEclesiasticaQuery, listPersonaNaturalParentescoQuery, listPersonaNaturalRolQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			session.setAttribute("InformacionAcademicaQueryList",null);
			session.setAttribute("InformacionLaboralQueryList",null);
			session.setAttribute("InformacionEclesiasticaQueryList",null);
			session.setAttribute("PersonaNaturalParentescoQueryList",null);
			session.setAttribute("PersonaNaturalRolQueryList",null);
			return ExtJSReturn.success(personaNaturalQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarPersonaNaturalSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody PersonaNaturalQueryWrapper personaNaturalQueryWrapper, HttpSession session) throws Exception {
		try{
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
			List<InformacionAcademicaQuery> listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
			List<InformacionLaboralQuery> listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
			List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
			List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
			List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
			gestionarPersonaNaturalService.save(personaNaturalQueryWrapper.getData(),listNumeroTelefonicoQuery, listInformacionAcademicaQuery, listInformacionLaboralQuery, listInformacionEclesiasticaQuery, listPersonaNaturalParentescoQuery, listPersonaNaturalRolQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			session.setAttribute("InformacionAcademicaQueryList",null);
			session.setAttribute("InformacionLaboralQueryList",null);
			session.setAttribute("InformacionEclesiasticaQueryList",null);
			session.setAttribute("PersonaNaturalParentescoQueryList",null);
			session.setAttribute("PersonaNaturalRolQueryList",null);
			return ExtJSReturn.success(personaNaturalQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarPersonaNaturalRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody PersonaNaturalQueryWrapper personaNaturalQueryWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_persona", personaNaturalQueryWrapper.getData().getId_persona());
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = this.gestionarPersonaNaturalService.getListByQuery(NumeroTelefonicoQueryMapper.class, paramMap);
			paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", personaNaturalQueryWrapper.getData().getId_persona_natural());
			List<InformacionAcademicaQuery> listInformacionAcademicaQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionAcademicaQueryMapper.class, paramMap);
			paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", personaNaturalQueryWrapper.getData().getId_persona_natural());
			List<InformacionLaboralQuery> listInformacionLaboralQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionLaboralQueryMapper.class, paramMap);
			paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", personaNaturalQueryWrapper.getData().getId_persona_natural());
			List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionEclesiasticaQueryMapper.class, paramMap);
			paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", personaNaturalQueryWrapper.getData().getId_persona_natural());
			List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = this.gestionarPersonaNaturalService.getListByQuery(PersonaNaturalParentescoQueryMapper.class, paramMap);
			paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", personaNaturalQueryWrapper.getData().getId_persona_natural());
			List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = this.gestionarPersonaNaturalService.getListByQuery(PersonaNaturalRolQueryMapper.class, paramMap);
			gestionarPersonaNaturalService.remove(personaNaturalQueryWrapper.getData(),listNumeroTelefonicoQuery, listInformacionAcademicaQuery, listInformacionLaboralQuery, listInformacionEclesiasticaQuery, listPersonaNaturalParentescoQuery, listPersonaNaturalRolQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			session.setAttribute("InformacionAcademicaQueryList",null);
			session.setAttribute("InformacionLaboralQueryList",null);
			session.setAttribute("InformacionEclesiasticaQueryList",null);
			session.setAttribute("PersonaNaturalParentescoQueryList",null);
			session.setAttribute("PersonaNaturalRolQueryList",null);
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="NumeroTelefonicoQueryList.action")
	public @ResponseBody Map<String,? extends Object> NumeroTelefonicoQuerylist(Integer id_persona, int start, int limit, HttpSession session) throws Exception {
		
		List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery;
		List<NumeroTelefonicoQuery> subListNumeroTelefonicoQuery;

		if(id_persona == null){
			listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
		}else if(id_persona.equals(-1)){
			listNumeroTelefonicoQuery = new ArrayList<NumeroTelefonicoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona", id_persona);
			listNumeroTelefonicoQuery = this.gestionarPersonaNaturalService.getListByQuery(NumeroTelefonicoQueryMapper.class, paramMap);
		}

		if(listNumeroTelefonicoQuery == null){
			listNumeroTelefonicoQuery = new ArrayList<NumeroTelefonicoQuery>();
		}
		session.setAttribute("NumeroTelefonicoQueryList",listNumeroTelefonicoQuery);
		int size = listNumeroTelefonicoQuery.size();
		
		subListNumeroTelefonicoQuery = this.getSubList(listNumeroTelefonicoQuery, start, limit);
		
		return ExtJSReturn.success(subListNumeroTelefonicoQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="NumeroTelefonicoQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody NumeroTelefonicoQueryWrapper numeroTelefonicoQueryWrapper, HttpSession session) {
		
		List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
		int randomInt = this.getNegativeIdRandom();
		numeroTelefonicoQueryWrapper.getData().setId_numero_telefonico(randomInt);
		if(listNumeroTelefonicoQuery == null){
			listNumeroTelefonicoQuery = new ArrayList<NumeroTelefonicoQuery>();
		}
		listNumeroTelefonicoQuery.add(numeroTelefonicoQueryWrapper.getData());	
		session.setAttribute("NumeroTelefonicoQueryList",listNumeroTelefonicoQuery);

		return ExtJSReturn.success(numeroTelefonicoQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="NumeroTelefonicoQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody NumeroTelefonicoQueryWrapper numeroTelefonicoQueryWrapper, HttpSession session) {
		
		List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
		int index = -1;
		
		for (int i = 0; i < listNumeroTelefonicoQuery.size(); i++) {
			if(listNumeroTelefonicoQuery.get(i).getId_numero_telefonico().equals(numeroTelefonicoQueryWrapper.getData().getId_numero_telefonico())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listNumeroTelefonicoQuery.set(index, numeroTelefonicoQueryWrapper.getData());
		}
		
		session.setAttribute("NumeroTelefonicoQueryList",listNumeroTelefonicoQuery);

		return ExtJSReturn.success(numeroTelefonicoQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="NumeroTelefonicoQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody NumeroTelefonicoQueryWrapper numeroTelefonicoQueryWrapper, HttpSession session) {
		
		List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
		int index = -1;
		for (int i = 0; i < listNumeroTelefonicoQuery.size(); i++) {
			if(listNumeroTelefonicoQuery.get(i).getId_numero_telefonico().equals(numeroTelefonicoQueryWrapper.getData().getId_numero_telefonico())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listNumeroTelefonicoQuery.remove(index);
		}
		
		session.setAttribute("NumeroTelefonicoQueryList",listNumeroTelefonicoQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionAcademicaQueryList.action")
	public @ResponseBody Map<String,? extends Object> InformacionAcademicaQuerylist(Integer id_persona_natural, int start, int limit, HttpSession session) throws Exception {
		
		List<InformacionAcademicaQuery> listInformacionAcademicaQuery;
		List<InformacionAcademicaQuery> subListInformacionAcademicaQuery;

		if(id_persona_natural == null){
			listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
		}else if(id_persona_natural.equals(-1)){
			listInformacionAcademicaQuery = new ArrayList<InformacionAcademicaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", id_persona_natural);
			listInformacionAcademicaQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionAcademicaQueryMapper.class, paramMap);
		}

		if(listInformacionAcademicaQuery == null){
			listInformacionAcademicaQuery = new ArrayList<InformacionAcademicaQuery>();
		}
		session.setAttribute("InformacionAcademicaQueryList",listInformacionAcademicaQuery);
		int size = listInformacionAcademicaQuery.size();
		
		subListInformacionAcademicaQuery = this.getSubList(listInformacionAcademicaQuery, start, limit);
		
		return ExtJSReturn.success(subListInformacionAcademicaQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionAcademicaQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody InformacionAcademicaQueryWrapper informacionAcademicaQueryWrapper, HttpSession session) {
		
		List<InformacionAcademicaQuery> listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
		int randomInt = this.getNegativeIdRandom();
		informacionAcademicaQueryWrapper.getData().setId_informacion_academica(randomInt);
		if(listInformacionAcademicaQuery == null){
			listInformacionAcademicaQuery = new ArrayList<InformacionAcademicaQuery>();
		}
		listInformacionAcademicaQuery.add(informacionAcademicaQueryWrapper.getData());	
		session.setAttribute("InformacionAcademicaQueryList",listInformacionAcademicaQuery);

		return ExtJSReturn.success(informacionAcademicaQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionAcademicaQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody InformacionAcademicaQueryWrapper informacionAcademicaQueryWrapper, HttpSession session) {
		
		List<InformacionAcademicaQuery> listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
		int index = -1;
		
		for (int i = 0; i < listInformacionAcademicaQuery.size(); i++) {
			if(listInformacionAcademicaQuery.get(i).getId_informacion_academica().equals(informacionAcademicaQueryWrapper.getData().getId_informacion_academica())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionAcademicaQuery.set(index, informacionAcademicaQueryWrapper.getData());
		}
		
		session.setAttribute("InformacionAcademicaQueryList",listInformacionAcademicaQuery);

		return ExtJSReturn.success(informacionAcademicaQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionAcademicaQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody InformacionAcademicaQueryWrapper informacionAcademicaQueryWrapper, HttpSession session) {
		
		List<InformacionAcademicaQuery> listInformacionAcademicaQuery = (List<InformacionAcademicaQuery>) session.getAttribute("InformacionAcademicaQueryList");
		int index = -1;
		for (int i = 0; i < listInformacionAcademicaQuery.size(); i++) {
			if(listInformacionAcademicaQuery.get(i).getId_informacion_academica().equals(informacionAcademicaQueryWrapper.getData().getId_informacion_academica())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionAcademicaQuery.remove(index);
		}
		
		session.setAttribute("InformacionAcademicaQueryList",listInformacionAcademicaQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionLaboralQueryList.action")
	public @ResponseBody Map<String,? extends Object> InformacionLaboralQuerylist(Integer id_persona_natural, int start, int limit, HttpSession session) throws Exception {
		
		List<InformacionLaboralQuery> listInformacionLaboralQuery;
		List<InformacionLaboralQuery> subListInformacionLaboralQuery;

		if(id_persona_natural == null){
			listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
		}else if(id_persona_natural.equals(-1)){
			listInformacionLaboralQuery = new ArrayList<InformacionLaboralQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", id_persona_natural);
			listInformacionLaboralQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionLaboralQueryMapper.class, paramMap);
		}

		if(listInformacionLaboralQuery == null){
			listInformacionLaboralQuery = new ArrayList<InformacionLaboralQuery>();
		}
		session.setAttribute("InformacionLaboralQueryList",listInformacionLaboralQuery);
		int size = listInformacionLaboralQuery.size();
		
		subListInformacionLaboralQuery = this.getSubList(listInformacionLaboralQuery, start, limit);
		
		return ExtJSReturn.success(subListInformacionLaboralQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionLaboralQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody InformacionLaboralQueryWrapper informacionLaboralQueryWrapper, HttpSession session) {
		
		List<InformacionLaboralQuery> listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
		int randomInt = this.getNegativeIdRandom();
		informacionLaboralQueryWrapper.getData().setId_informacion_laboral(randomInt);
		if(listInformacionLaboralQuery == null){
			listInformacionLaboralQuery = new ArrayList<InformacionLaboralQuery>();
		}
		listInformacionLaboralQuery.add(informacionLaboralQueryWrapper.getData());	
		session.setAttribute("InformacionLaboralQueryList",listInformacionLaboralQuery);

		return ExtJSReturn.success(informacionLaboralQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionLaboralQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody InformacionLaboralQueryWrapper informacionLaboralQueryWrapper, HttpSession session) {
		
		List<InformacionLaboralQuery> listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
		int index = -1;
		
		for (int i = 0; i < listInformacionLaboralQuery.size(); i++) {
			if(listInformacionLaboralQuery.get(i).getId_informacion_laboral().equals(informacionLaboralQueryWrapper.getData().getId_informacion_laboral())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionLaboralQuery.set(index, informacionLaboralQueryWrapper.getData());
		}
		
		session.setAttribute("InformacionLaboralQueryList",listInformacionLaboralQuery);

		return ExtJSReturn.success(informacionLaboralQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionLaboralQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody InformacionLaboralQueryWrapper informacionLaboralQueryWrapper, HttpSession session) {
		
		List<InformacionLaboralQuery> listInformacionLaboralQuery = (List<InformacionLaboralQuery>) session.getAttribute("InformacionLaboralQueryList");
		int index = -1;
		for (int i = 0; i < listInformacionLaboralQuery.size(); i++) {
			if(listInformacionLaboralQuery.get(i).getId_informacion_laboral().equals(informacionLaboralQueryWrapper.getData().getId_informacion_laboral())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionLaboralQuery.remove(index);
		}
		
		session.setAttribute("InformacionLaboralQueryList",listInformacionLaboralQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionEclesiasticaQueryList.action")
	public @ResponseBody Map<String,? extends Object> InformacionEclesiasticaQuerylist(Integer id_persona_natural, int start, int limit, HttpSession session) throws Exception {
		
		List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery;
		List<InformacionEclesiasticaQuery> subListInformacionEclesiasticaQuery;

		if(id_persona_natural == null){
			listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
		}else if(id_persona_natural.equals(-1)){
			listInformacionEclesiasticaQuery = new ArrayList<InformacionEclesiasticaQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", id_persona_natural);
			listInformacionEclesiasticaQuery = this.gestionarPersonaNaturalService.getListByQuery(InformacionEclesiasticaQueryMapper.class, paramMap);
		}

		if(listInformacionEclesiasticaQuery == null){
			listInformacionEclesiasticaQuery = new ArrayList<InformacionEclesiasticaQuery>();
		}
		session.setAttribute("InformacionEclesiasticaQueryList",listInformacionEclesiasticaQuery);
		int size = listInformacionEclesiasticaQuery.size();
		
		subListInformacionEclesiasticaQuery = this.getSubList(listInformacionEclesiasticaQuery, start, limit);
		
		return ExtJSReturn.success(subListInformacionEclesiasticaQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionEclesiasticaQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody InformacionEclesiasticaQueryWrapper informacionEclesiasticaQueryWrapper, HttpSession session) {
		
		List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
		int randomInt = this.getNegativeIdRandom();
		informacionEclesiasticaQueryWrapper.getData().setId_info_eclesiastica(randomInt);
		if(listInformacionEclesiasticaQuery == null){
			listInformacionEclesiasticaQuery = new ArrayList<InformacionEclesiasticaQuery>();
		}
		listInformacionEclesiasticaQuery.add(informacionEclesiasticaQueryWrapper.getData());	
		session.setAttribute("InformacionEclesiasticaQueryList",listInformacionEclesiasticaQuery);

		return ExtJSReturn.success(informacionEclesiasticaQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionEclesiasticaQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody InformacionEclesiasticaQueryWrapper informacionEclesiasticaQueryWrapper, HttpSession session) {
		
		List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
		int index = -1;
		
		for (int i = 0; i < listInformacionEclesiasticaQuery.size(); i++) {
			if(listInformacionEclesiasticaQuery.get(i).getId_info_eclesiastica().equals(informacionEclesiasticaQueryWrapper.getData().getId_info_eclesiastica())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionEclesiasticaQuery.set(index, informacionEclesiasticaQueryWrapper.getData());
		}
		
		session.setAttribute("InformacionEclesiasticaQueryList",listInformacionEclesiasticaQuery);

		return ExtJSReturn.success(informacionEclesiasticaQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="InformacionEclesiasticaQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody InformacionEclesiasticaQueryWrapper informacionEclesiasticaQueryWrapper, HttpSession session) {
		
		List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery = (List<InformacionEclesiasticaQuery>) session.getAttribute("InformacionEclesiasticaQueryList");
		int index = -1;
		for (int i = 0; i < listInformacionEclesiasticaQuery.size(); i++) {
			if(listInformacionEclesiasticaQuery.get(i).getId_info_eclesiastica().equals(informacionEclesiasticaQueryWrapper.getData().getId_info_eclesiastica())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listInformacionEclesiasticaQuery.remove(index);
		}
		
		session.setAttribute("InformacionEclesiasticaQueryList",listInformacionEclesiasticaQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalParentescoQueryList.action")
	public @ResponseBody Map<String,? extends Object> PersonaNaturalParentescoQuerylist(Integer id_persona_natural, int start, int limit, HttpSession session) throws Exception {
		
		List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery;
		List<PersonaNaturalParentescoQuery> subListPersonaNaturalParentescoQuery;

		if(id_persona_natural == null){
			listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
		}else if(id_persona_natural.equals(-1)){
			listPersonaNaturalParentescoQuery = new ArrayList<PersonaNaturalParentescoQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", id_persona_natural);
			listPersonaNaturalParentescoQuery = this.gestionarPersonaNaturalService.getListByQuery(PersonaNaturalParentescoQueryMapper.class, paramMap);
		}

		if(listPersonaNaturalParentescoQuery == null){
			listPersonaNaturalParentescoQuery = new ArrayList<PersonaNaturalParentescoQuery>();
		}
		session.setAttribute("PersonaNaturalParentescoQueryList",listPersonaNaturalParentescoQuery);
		int size = listPersonaNaturalParentescoQuery.size();
		
		subListPersonaNaturalParentescoQuery = this.getSubList(listPersonaNaturalParentescoQuery, start, limit);
		
		return ExtJSReturn.success(subListPersonaNaturalParentescoQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalParentescoQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody PersonaNaturalParentescoQueryWrapper personaNaturalParentescoQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
		int randomInt = this.getNegativeIdRandom();
		personaNaturalParentescoQueryWrapper.getData().setId_persona_parentesco(randomInt);
		if(listPersonaNaturalParentescoQuery == null){
			listPersonaNaturalParentescoQuery = new ArrayList<PersonaNaturalParentescoQuery>();
		}
		listPersonaNaturalParentescoQuery.add(personaNaturalParentescoQueryWrapper.getData());	
		session.setAttribute("PersonaNaturalParentescoQueryList",listPersonaNaturalParentescoQuery);

		return ExtJSReturn.success(personaNaturalParentescoQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalParentescoQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody PersonaNaturalParentescoQueryWrapper personaNaturalParentescoQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
		int index = -1;
		
		for (int i = 0; i < listPersonaNaturalParentescoQuery.size(); i++) {
			if(listPersonaNaturalParentescoQuery.get(i).getId_persona_parentesco().equals(personaNaturalParentescoQueryWrapper.getData().getId_persona_parentesco())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonaNaturalParentescoQuery.set(index, personaNaturalParentescoQueryWrapper.getData());
		}
		
		session.setAttribute("PersonaNaturalParentescoQueryList",listPersonaNaturalParentescoQuery);

		return ExtJSReturn.success(personaNaturalParentescoQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalParentescoQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody PersonaNaturalParentescoQueryWrapper personaNaturalParentescoQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery = (List<PersonaNaturalParentescoQuery>) session.getAttribute("PersonaNaturalParentescoQueryList");
		int index = -1;
		for (int i = 0; i < listPersonaNaturalParentescoQuery.size(); i++) {
			if(listPersonaNaturalParentescoQuery.get(i).getId_persona_parentesco().equals(personaNaturalParentescoQueryWrapper.getData().getId_persona_parentesco())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonaNaturalParentescoQuery.remove(index);
		}
		
		session.setAttribute("PersonaNaturalParentescoQueryList",listPersonaNaturalParentescoQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalRolQueryList.action")
	public @ResponseBody Map<String,? extends Object> PersonaNaturalRolQuerylist(Integer id_persona_natural, int start, int limit, HttpSession session) throws Exception {
		
		List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery;
		List<PersonaNaturalRolQuery> subListPersonaNaturalRolQuery;

		if(id_persona_natural == null){
			listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
		}else if(id_persona_natural.equals(-1)){
			listPersonaNaturalRolQuery = new ArrayList<PersonaNaturalRolQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_persona_natural", id_persona_natural);
			listPersonaNaturalRolQuery = this.gestionarPersonaNaturalService.getListByQuery(PersonaNaturalRolQueryMapper.class, paramMap);
		}

		if(listPersonaNaturalRolQuery == null){
			listPersonaNaturalRolQuery = new ArrayList<PersonaNaturalRolQuery>();
		}
		session.setAttribute("PersonaNaturalRolQueryList",listPersonaNaturalRolQuery);
		int size = listPersonaNaturalRolQuery.size();
		
		subListPersonaNaturalRolQuery = this.getSubList(listPersonaNaturalRolQuery, start, limit);
		
		return ExtJSReturn.success(subListPersonaNaturalRolQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalRolQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody PersonaNaturalRolQueryWrapper personaNaturalRolQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
		int randomInt = this.getNegativeIdRandom();
		personaNaturalRolQueryWrapper.getData().setId_persona_natural_rol(randomInt);
		if(listPersonaNaturalRolQuery == null){
			listPersonaNaturalRolQuery = new ArrayList<PersonaNaturalRolQuery>();
		}
		listPersonaNaturalRolQuery.add(personaNaturalRolQueryWrapper.getData());	
		session.setAttribute("PersonaNaturalRolQueryList",listPersonaNaturalRolQuery);

		return ExtJSReturn.success(personaNaturalRolQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalRolQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody PersonaNaturalRolQueryWrapper personaNaturalRolQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
		int index = -1;
		
		for (int i = 0; i < listPersonaNaturalRolQuery.size(); i++) {
			if(listPersonaNaturalRolQuery.get(i).getId_persona_natural_rol().equals(personaNaturalRolQueryWrapper.getData().getId_persona_natural_rol())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonaNaturalRolQuery.set(index, personaNaturalRolQueryWrapper.getData());
		}
		
		session.setAttribute("PersonaNaturalRolQueryList",listPersonaNaturalRolQuery);

		return ExtJSReturn.success(personaNaturalRolQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="PersonaNaturalRolQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody PersonaNaturalRolQueryWrapper personaNaturalRolQueryWrapper, HttpSession session) {
		
		List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery = (List<PersonaNaturalRolQuery>) session.getAttribute("PersonaNaturalRolQueryList");
		int index = -1;
		for (int i = 0; i < listPersonaNaturalRolQuery.size(); i++) {
			if(listPersonaNaturalRolQuery.get(i).getId_persona_natural_rol().equals(personaNaturalRolQueryWrapper.getData().getId_persona_natural_rol())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listPersonaNaturalRolQuery.remove(index);
		}
		
		session.setAttribute("PersonaNaturalRolQueryList",listPersonaNaturalRolQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
}