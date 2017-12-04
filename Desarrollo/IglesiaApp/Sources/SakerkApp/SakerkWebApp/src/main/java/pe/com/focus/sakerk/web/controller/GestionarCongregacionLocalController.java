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
* DATE CREATE : 22/01/2015 18:47:38
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

import pe.com.focus.sakerk.business.service.GestionarCongregacionLocalService;
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQuery;
import pe.com.focus.sakerk.repository.custom.mapper.CongregacionLocalQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQueryWrapper;

import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.NumeroTelefonicoQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQueryWrapper;

@Controller
@RequestMapping("/")
public class GestionarCongregacionLocalController extends ControllerHelper{

	@Autowired
	private GestionarCongregacionLocalService gestionarCongregacionLocalService;

	@RequestMapping(value="GestionarCongregacionLocalView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) throws Exception {
		try{
			CongregacionLocalQueryCriteria congregacionLocalQueryCriteria = this.loadCriteria(request, CongregacionLocalQueryCriteria.class);
			List<CongregacionLocalQuery> listCongregacionLocalQuery = gestionarCongregacionLocalService.getListByQuery(CongregacionLocalQueryMapper.class, congregacionLocalQueryCriteria, start, limit);
			int total = gestionarCongregacionLocalService.getCountRowsByQuery(CongregacionLocalQueryMapper.class, congregacionLocalQueryCriteria);
			return ExtJSReturn.success(listCongregacionLocalQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarCongregacionLocalCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody CongregacionLocalQueryWrapper congregacionLocalQueryWrapper, HttpSession session) throws Exception {
		try{
		
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
			gestionarCongregacionLocalService.create(congregacionLocalQueryWrapper.getData(),listNumeroTelefonicoQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			return ExtJSReturn.success(congregacionLocalQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarCongregacionLocalSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody CongregacionLocalQueryWrapper congregacionLocalQueryWrapper, HttpSession session) throws Exception {
		try{
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = (List<NumeroTelefonicoQuery>) session.getAttribute("NumeroTelefonicoQueryList");
			gestionarCongregacionLocalService.save(congregacionLocalQueryWrapper.getData(),listNumeroTelefonicoQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			return ExtJSReturn.success(congregacionLocalQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarCongregacionLocalRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody CongregacionLocalQueryWrapper congregacionLocalQueryWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_persona", congregacionLocalQueryWrapper.getData().getId_persona());
			List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery = this.gestionarCongregacionLocalService.getListByQuery(NumeroTelefonicoQueryMapper.class, paramMap);
			gestionarCongregacionLocalService.remove(congregacionLocalQueryWrapper.getData(),listNumeroTelefonicoQuery);
			session.setAttribute("NumeroTelefonicoQueryList",null);
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="CongregacionLocalNumeroTelefonicoQueryList.action")
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
			listNumeroTelefonicoQuery = this.gestionarCongregacionLocalService.getListByQuery(NumeroTelefonicoQueryMapper.class, paramMap);
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
	@RequestMapping(value="CongregacionLocalNumeroTelefonicoQueryAdd.action")
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
	@RequestMapping(value="CongregacionLocalNumeroTelefonicoQueryUpdate.action")
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
	@RequestMapping(value="CongregacionLocalNumeroTelefonicoQueryDelete.action")
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
}