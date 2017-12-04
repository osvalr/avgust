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
* DATE CREATE : 20/01/2015 13:21:31
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

import pe.com.focus.sakerk.business.service.GestionarPersonaJuridicaService;
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQueryCriteria;
import pe.com.focus.sakerk.repository.custom.mapper.PersonaJuridicaQueryMapper;
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQueryWrapper;

@Controller
@RequestMapping("/")
public class GestionarPersonaJuridicaController extends ControllerHelper {

	@Autowired
	private GestionarPersonaJuridicaService gestionarPersonaJuridicaService;
	
	@RequestMapping(value="GestionarPersonaJuridicaView.action")
	public @ResponseBody Map<String,? extends Object> view(@RequestParam int start, @RequestParam int limit, HttpServletRequest request) {
		try{
			PersonaJuridicaQueryCriteria personaJuridicaQueryCriteria = this.loadCriteria(request, PersonaJuridicaQueryCriteria.class);
			List<PersonaJuridicaQuery> listPersonaJuridicaQuery = gestionarPersonaJuridicaService.getListByQuery(PersonaJuridicaQueryMapper.class, personaJuridicaQueryCriteria, start, limit);
			int total = gestionarPersonaJuridicaService.getCountRowsByQuery(PersonaJuridicaQueryMapper.class, personaJuridicaQueryCriteria);
			return ExtJSReturn.success(listPersonaJuridicaQuery,total);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarPersonaJuridicaCreate.action")
	public @ResponseBody Map<String,? extends Object> create(@RequestBody PersonaJuridicaQueryWrapper personaJuridicaQueryWrapper) {
		try{
			gestionarPersonaJuridicaService.create(personaJuridicaQueryWrapper.getData());
			return ExtJSReturn.success(personaJuridicaQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarPersonaJuridicaSave.action")
	public @ResponseBody Map<String,? extends Object> save(@RequestBody PersonaJuridicaQueryWrapper personaJuridicaQueryWrapper) {
		try{
			gestionarPersonaJuridicaService.save(personaJuridicaQueryWrapper.getData());
			return ExtJSReturn.success(personaJuridicaQueryWrapper.getData(), "Operation Success.");
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
	@RequestMapping(value="GestionarPersonaJuridicaRemove.action")
	public @ResponseBody Map<String,? extends Object> remove(@RequestBody PersonaJuridicaQueryWrapper personaJuridicaQueryWrapper) {
		try{
			gestionarPersonaJuridicaService.remove(personaJuridicaQueryWrapper.getData());
			Map<String,Object> modelMap = new HashMap<String,Object>(1);
			modelMap.put("success", true);
			return modelMap;
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
}
