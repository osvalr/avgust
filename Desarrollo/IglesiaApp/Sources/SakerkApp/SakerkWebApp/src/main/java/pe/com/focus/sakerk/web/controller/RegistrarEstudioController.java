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
* DATE CREATE : 01/01/2015 21:59:41
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.web.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.util.ControllerHelper;
import pe.com.focus.util.ExtJSReturn;
import pe.com.focus.sakerk.business.service.RegistrarEstudioService;
import pe.com.focus.sakerk.repository.custom.model.RegistroEstudioQueryWrapper;

@Controller
@RequestMapping("/")
public class RegistrarEstudioController extends ControllerHelper {

	@Autowired
	private RegistrarEstudioService registrarEstudioService;
		
	@RequestMapping(value="RegistrarEstudioExecute.action")
	public @ResponseBody Map<String,? extends Object> execute(@RequestBody RegistroEstudioQueryWrapper registroEstudioQueryWrapper) {
		try{
			Integer lastId = registrarEstudioService.execute(registroEstudioQueryWrapper.getData());
			return ExtJSReturn.success(registroEstudioQueryWrapper.getData(), lastId);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
}
