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
* DATE CREATE : 18/12/2014 22:25:38
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
import pe.com.focus.sakerk.business.service.RegistrarItemTablaGeneralService;
import pe.com.focus.sakerk.repository.custom.model.ItemTablaGeneralQueryWrapper;

@Controller
@RequestMapping("/")
public class RegistrarItemTablaGeneralController extends ControllerHelper {

	@Autowired
	private RegistrarItemTablaGeneralService registrarItemTablaGeneralService;
		
	@RequestMapping(value="RegistrarItemTablaGeneralExecute.action")
	public @ResponseBody Map<String,? extends Object> execute(@RequestBody ItemTablaGeneralQueryWrapper itemTablaGeneralQueryWrapper) {
		try{
			Integer lastId = registrarItemTablaGeneralService.execute(itemTablaGeneralQueryWrapper.getData());
			return ExtJSReturn.success(itemTablaGeneralQueryWrapper.getData(), lastId);
		} catch (BusinessException e) {
			return ExtJSReturn.exception(e.getMessage());
		}
	}
	
}
