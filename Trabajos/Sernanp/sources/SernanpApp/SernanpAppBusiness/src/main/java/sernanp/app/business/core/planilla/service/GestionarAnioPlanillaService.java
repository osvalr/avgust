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
* DATE CREATE : 18/03/2015 23:43:06
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.service;

import java.util.List;

import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

import sernanp.app.dao.query.domain.GestionarAnioPlanillaQuery;
import sernanp.app.dao.query.domain.GestionarAnioParametroPlanillaQuery;
import sernanp.app.dao.query.domain.GestionarAnioPeriodoPlanillaQuery;

public interface GestionarAnioPlanillaService extends HelperServiceMybatis {
	Integer create(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException;
	void save(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException;
	void remove(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException;
}