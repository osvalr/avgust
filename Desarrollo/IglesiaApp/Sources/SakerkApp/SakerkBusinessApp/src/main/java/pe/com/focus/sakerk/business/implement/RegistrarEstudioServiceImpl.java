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
* DATE CREATE : 01/01/2015 21:59:41
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.util.BeanUtil;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;

import pe.com.focus.sakerk.business.service.RegistrarEstudioService;
import pe.com.focus.sakerk.repository.custom.model.RegistroEstudioQuery;

import pe.com.focus.repository.mybatis.model.Estudio;
import pe.com.focus.repository.mybatis.mapper.EstudioMapper;

@Service
public class RegistrarEstudioServiceImpl extends HelperServiceImpl implements RegistrarEstudioService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer execute(RegistroEstudioQuery model) throws BusinessException {
		Integer lastId = null;
		Estudio estudio = beanUtil.copyBean(model, Estudio.class);
		estudio.setId_estado(1); // Activo
		this.insertSelective(EstudioMapper.class, estudio);
		lastId = estudio.getId_estudio();
		
		return lastId;
	}
	
}
