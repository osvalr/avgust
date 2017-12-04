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
* DATE CREATE : 07/05/2015 22:38:06
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.planilla.service.RpNominaCASMesAnioFuenteMetaService;
import sernanp.app.dao.query.domain.RpNominaCASMesAnioFuenteMetaQuery;

import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.mapper.PersonalMapper;

@Service
public class RpNominaCASMesAnioFuenteMetaServiceImpl extends HelperServiceMybatisImpl implements RpNominaCASMesAnioFuenteMetaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpNominaCASMesAnioFuenteMetaQuery model) throws BusinessException {
	
		Integer lastId = null;

		Personal personal = beanUtil.copyBean(model, Personal.class);
		this.insertSelective(PersonalMapper.class, personal);

		lastId = personal.getIdpersonal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpNominaCASMesAnioFuenteMetaQuery model) throws BusinessException {

		Personal personal = beanUtil.copyBean(model, Personal.class);
		this.updateByPrimaryKeySelective(PersonalMapper.class, personal);
		
	}

	@Transactional
	@Override
	public void remove(RpNominaCASMesAnioFuenteMetaQuery model) throws BusinessException {

		Personal personal = beanUtil.copyBean(model, Personal.class);
		this.deleteByPrimaryKey(PersonalMapper.class, personal);
	}

}
