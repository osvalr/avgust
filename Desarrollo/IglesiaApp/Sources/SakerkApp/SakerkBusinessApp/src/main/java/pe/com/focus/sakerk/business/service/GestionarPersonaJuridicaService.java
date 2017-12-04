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

package pe.com.focus.sakerk.business.service;

import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQuery;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperService;

public interface GestionarPersonaJuridicaService extends HelperService {
	Integer create(PersonaJuridicaQuery model) throws BusinessException;
	void save(PersonaJuridicaQuery model) throws BusinessException;
	void remove(PersonaJuridicaQuery model) throws BusinessException;
}