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
* DATE CREATE : 22/01/2015 18:47:38
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.service;

import java.util.List;

import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperService;

import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQuery;
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;

public interface GestionarCongregacionLocalService extends HelperService {
	Integer create(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException;
	void save(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException;
	void remove(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException;
}