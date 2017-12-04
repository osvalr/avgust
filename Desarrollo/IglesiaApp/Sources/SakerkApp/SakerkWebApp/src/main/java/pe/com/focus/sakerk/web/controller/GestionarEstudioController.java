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
* DATE CREATE : 03/12/2014 15:04:40
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.sakerk.business.service.GestionarEstudioService;
import pe.com.focus.sakerk.repository.custom.mapper.EstudioQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.EstudioQuery;
import pe.com.focus.sakerk.repository.custom.model.EstudioQueryWrapper;
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJSReturn;

@Controller
@RequestMapping("/")
public class GestionarEstudioController extends ControllerHelper {

	@Autowired
	private GestionarEstudioService gestionarEstudioService;
	
	@RequestMapping(value="GestionarEstudioView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) {
		try{
			Map<String, Object> paramMap = this.loadParamMap(request);
			List<EstudioQuery> listEstudioQuery = gestionarEstudioService.getListByQuery(EstudioQueryMapper.class, paramMap, start, limit);
			int total = gestionarEstudioService.getCountRowsByQuery(EstudioQueryMapper.class, paramMap);
			return ExtJSReturn.success(listEstudioQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarEstudioCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody EstudioQueryWrapper estudioQueryWrapper) {
		try{
			gestionarEstudioService.create(estudioQueryWrapper.getData());
			return ExtJSReturn.success(estudioQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarEstudioSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody EstudioQueryWrapper estudioQueryWrapper) {
		try{
			gestionarEstudioService.save(estudioQueryWrapper.getData());
			return ExtJSReturn.success(estudioQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarEstudioRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody EstudioQueryWrapper estudioQueryWrapper) {
		try{
			gestionarEstudioService.remove(estudioQueryWrapper.getData());
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
}
