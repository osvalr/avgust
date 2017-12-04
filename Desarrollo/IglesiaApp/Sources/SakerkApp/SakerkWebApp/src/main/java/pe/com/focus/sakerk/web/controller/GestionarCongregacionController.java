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
* DATE CREATE : 20/12/2014 22:23:10
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
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJSReturn;

import pe.com.focus.sakerk.business.service.GestionarCongregacionService;
import pe.com.focus.sakerk.repository.custom.model.CongregacionQuery;
import pe.com.focus.sakerk.repository.custom.model.CongregacionQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.CongregacionQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.CongregacionQueryWrapper;

@Controller
@RequestMapping("/")
public class GestionarCongregacionController extends ControllerHelper {

	@Autowired
	private GestionarCongregacionService gestionarCongregacionService;
	
	@RequestMapping(value="GestionarCongregacionView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) {
		try{
			CongregacionQueryCriteria congregacionQueryCriteria = this.loadCriteria(request, CongregacionQueryCriteria.class);
			List<CongregacionQuery> listCongregacionQuery = gestionarCongregacionService.getListByQuery(CongregacionQueryMapper.class, congregacionQueryCriteria, start, limit);
			int total = gestionarCongregacionService.getCountRowsByQuery(CongregacionQueryMapper.class, congregacionQueryCriteria);
			return ExtJSReturn.success(listCongregacionQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarCongregacionCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody CongregacionQueryWrapper congregacionQueryWrapper) {
		try{
			gestionarCongregacionService.create(congregacionQueryWrapper.getData());
			return ExtJSReturn.success(congregacionQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarCongregacionSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody CongregacionQueryWrapper congregacionQueryWrapper) {
		try{
			gestionarCongregacionService.save(congregacionQueryWrapper.getData());
			return ExtJSReturn.success(congregacionQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarCongregacionRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody CongregacionQueryWrapper congregacionQueryWrapper) {
		try{
			gestionarCongregacionService.remove(congregacionQueryWrapper.getData());
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
}
