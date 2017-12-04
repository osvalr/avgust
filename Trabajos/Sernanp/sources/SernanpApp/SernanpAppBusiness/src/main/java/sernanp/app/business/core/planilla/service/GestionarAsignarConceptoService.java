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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.service;

import java.util.List;

import sernanp.app.dao.query.domain.BeneficiarioDescuentoJudicialQuery;
import sernanp.app.dao.query.domain.ConceptoPersonalQuery;
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQuery;
import sernanp.app.dao.query.domain.PersonalConceptoAfectoQuery;
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.PersonalInfoContratoQuery;
import sernanp.app.dao.query.domain.SuspensionCuartaCategoriaQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface GestionarAsignarConceptoService extends HelperServiceMybatis {
	void save(GestionarAsignarConceptoQuery model, List<ConceptoPersonalQuery> listConceptoPersonalQuery, List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery, List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery, List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery, List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery, List<PersonalInfoContratoQuery> listPersonalInfoContratoQuery) throws BusinessException;
}