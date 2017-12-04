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
* DATE CREATE : 21/04/2015 20:40:38
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.service;

import java.util.List;

import sernanp.app.dao.query.domain.ConvocatoriaEtapaQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaFactorQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQuery;
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface ConvocatoriaPlazaService extends HelperServiceMybatis {
	Integer create(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException;
	void save(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException;
	void remove(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException;
	List<ConvocatoriaEtapaQuery> obtenerListaConfiguracionEtapas() throws BusinessException;
	Integer relanzar(Integer srl_id_convocatoria) throws BusinessException;
}