/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 01/12/2014 19:55:03
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
import pe.com.focus.sakerk.business.service.GestionarTablaGeneralService;
import pe.com.focus.sakerk.repository.custom.mapper.TablaGeneralDetalleQueryMapper;
import pe.com.focus.sakerk.repository.custom.mapper.TablaGeneralQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQuery;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQueryWrapper;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQuery;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQueryWrapper;
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJSReturn;

@Controller
@RequestMapping("/")
public class GestionarTablaGeneralController extends ControllerHelper{

	@Autowired
	private GestionarTablaGeneralService gestionarTablaGeneralService;

	@RequestMapping(value="GestionarTablaGeneralView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) throws Exception {
		try{
			Map<String, Object> paramMap = this.loadParamMap(request);
			List<TablaGeneralQuery> listTablaGeneralQuery = gestionarTablaGeneralService.getListByQuery(TablaGeneralQueryMapper.class, paramMap, start, limit);
			int total = gestionarTablaGeneralService.getCountRowsByQuery(TablaGeneralQueryMapper.class, paramMap);
			return ExtJSReturn.success(listTablaGeneralQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarTablaGeneralCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody TablaGeneralQueryWrapper tablaGeneralQueryWrapper, HttpSession session) throws Exception {
		try{
		
			List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
			gestionarTablaGeneralService.create(tablaGeneralQueryWrapper.getData(),listTablaGeneralDetalleQuery);
			session.setAttribute("TablaGeneralDetalleQueryList",null);
			return ExtJSReturn.success(tablaGeneralQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="GestionarTablaGeneralSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody TablaGeneralQueryWrapper tablaGeneralQueryWrapper, HttpSession session) throws Exception {
		try{
			List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
			gestionarTablaGeneralService.save(tablaGeneralQueryWrapper.getData(),listTablaGeneralDetalleQuery);
			session.setAttribute("TablaGeneralDetalleQueryList",null);
			return ExtJSReturn.success(tablaGeneralQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarTablaGeneralRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody TablaGeneralQueryWrapper tablaGeneralQueryWrapper, HttpSession session) {
		try{
			Map<String, Object> paramMap = null;
			paramMap = this.getParamMap();
			paramMap.put("id_tabla_general", tablaGeneralQueryWrapper.getData().getId_tabla_general());
			List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = this.gestionarTablaGeneralService.getListByQuery(TablaGeneralDetalleQueryMapper.class, paramMap);
			gestionarTablaGeneralService.remove(tablaGeneralQueryWrapper.getData(),listTablaGeneralDetalleQuery);
			session.setAttribute("TablaGeneralDetalleQueryList",null);
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="TablaGeneralDetalleQueryList.action")
	public @ResponseBody Map<String,? extends Object> TablaGeneralDetalleQuerylist(Integer id_tabla_general, int start, int limit, HttpSession session) throws Exception {
		
		List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery;
		List<TablaGeneralDetalleQuery> subListTablaGeneralDetalleQuery;

		if(id_tabla_general == null){
			listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
		}else if(id_tabla_general.equals(-1)){
			listTablaGeneralDetalleQuery = new ArrayList<TablaGeneralDetalleQuery>();
		}else{
			Map<String, Object> paramMap = this.getParamMap();
			paramMap.put("id_tabla_general", id_tabla_general);
			listTablaGeneralDetalleQuery = this.gestionarTablaGeneralService.getListByQuery(TablaGeneralDetalleQueryMapper.class, paramMap);
		}

		if(listTablaGeneralDetalleQuery == null){
			listTablaGeneralDetalleQuery = new ArrayList<TablaGeneralDetalleQuery>();
		}
		session.setAttribute("TablaGeneralDetalleQueryList",listTablaGeneralDetalleQuery);
		int size = listTablaGeneralDetalleQuery.size();
		
		subListTablaGeneralDetalleQuery = this.getSubList(listTablaGeneralDetalleQuery, start, limit);
		
		return ExtJSReturn.success(subListTablaGeneralDetalleQuery,size);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="TablaGeneralDetalleQueryAdd.action")
	public @ResponseBody Map<String,? extends Object> add(@RequestBody TablaGeneralDetalleQueryWrapper tablaGeneralDetalleQueryWrapper, HttpSession session) {
		
		List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
		int randomInt = this.getNegativeIdRandom();
		tablaGeneralDetalleQueryWrapper.getData().setId_tabla_general_detalle(randomInt);
		if(listTablaGeneralDetalleQuery == null){
			listTablaGeneralDetalleQuery = new ArrayList<TablaGeneralDetalleQuery>();
		}
		listTablaGeneralDetalleQuery.add(tablaGeneralDetalleQueryWrapper.getData());	
		session.setAttribute("TablaGeneralDetalleQueryList",listTablaGeneralDetalleQuery);

		return ExtJSReturn.success(tablaGeneralDetalleQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="TablaGeneralDetalleQueryUpdate.action")
	public @ResponseBody Map<String,? extends Object> update(@RequestBody TablaGeneralDetalleQueryWrapper tablaGeneralDetalleQueryWrapper, HttpSession session) {
		
		List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
		int index = -1;
		
		for (int i = 0; i < listTablaGeneralDetalleQuery.size(); i++) {
			if(listTablaGeneralDetalleQuery.get(i).getId_tabla_general_detalle().equals(tablaGeneralDetalleQueryWrapper.getData().getId_tabla_general_detalle())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listTablaGeneralDetalleQuery.set(index, tablaGeneralDetalleQueryWrapper.getData());
		}
		
		session.setAttribute("TablaGeneralDetalleQueryList",listTablaGeneralDetalleQuery);

		return ExtJSReturn.success(tablaGeneralDetalleQueryWrapper.getData(), "Operation Success.");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="TablaGeneralDetalleQueryDelete.action")
	public @ResponseBody Map<String,? extends Object> delete(@RequestBody TablaGeneralDetalleQueryWrapper tablaGeneralDetalleQueryWrapper, HttpSession session) {
		
		List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery = (List<TablaGeneralDetalleQuery>) session.getAttribute("TablaGeneralDetalleQueryList");
		int index = -1;
		for (int i = 0; i < listTablaGeneralDetalleQuery.size(); i++) {
			if(listTablaGeneralDetalleQuery.get(i).getId_tabla_general_detalle().equals(tablaGeneralDetalleQueryWrapper.getData().getId_tabla_general_detalle())){
				index = i;
				break;
			}
		}
		
		if(index > -1){
			listTablaGeneralDetalleQuery.remove(index);
		}
		
		session.setAttribute("TablaGeneralDetalleQueryList",listTablaGeneralDetalleQuery);
	
		Map<String,Object> modelMap = new HashMap<String,Object>(1);
		modelMap.put("success", true);
		return modelMap;
	}
}