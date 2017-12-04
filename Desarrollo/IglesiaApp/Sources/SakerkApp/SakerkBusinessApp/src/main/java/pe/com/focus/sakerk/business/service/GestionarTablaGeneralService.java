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

package pe.com.focus.sakerk.business.service;

import java.util.List;

import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperService;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQuery;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQuery;

public interface GestionarTablaGeneralService extends HelperService {
	Integer create(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException;
	void save(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException;
	void remove(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException;
}