/**
* Copyright «©» 2015, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SernanpApp.
*
* SernanpApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SernanpApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SernanpApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 08/06/2015 18:38:03
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.service;

import sernanp.app.dao.query.domain.RpPostulantesInscritosQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface ReportePostulantesInscritosService extends HelperServiceMybatis {
	Integer create(RpPostulantesInscritosQuery model) throws BusinessException;
	void save(RpPostulantesInscritosQuery model) throws BusinessException;
	void remove(RpPostulantesInscritosQuery model) throws BusinessException;
}