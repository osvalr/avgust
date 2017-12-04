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
* DATE CREATE : 31/05/2015 14:56:55
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.service;

import sernanp.app.dao.query.domain.ReporteResumenPlanilla728Query;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface ReporteResumenPlanilla728Service extends HelperServiceMybatis {
	Integer create(ReporteResumenPlanilla728Query model) throws BusinessException;
	void save(ReporteResumenPlanilla728Query model) throws BusinessException;
	void remove(ReporteResumenPlanilla728Query model) throws BusinessException;
}