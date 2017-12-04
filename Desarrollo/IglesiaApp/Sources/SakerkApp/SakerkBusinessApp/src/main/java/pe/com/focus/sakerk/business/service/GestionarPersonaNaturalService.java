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
* DATE CREATE : 20/01/2015 13:20:36
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.service;

import java.util.List;

import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperService;

import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQuery;
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQuery;
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQuery;
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQuery;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQuery;

public interface GestionarPersonaNaturalService extends HelperService {
	Integer create(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException;
	void save(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException;
	void remove(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException;
}