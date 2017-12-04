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
* DATE CREATE : 19/05/2015 22:46:28
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.seleccion.service.ReporteRequerimientoPersonalMINTRAService;
import sernanp.app.dao.query.domain.RpOficioMintraQuery;

import sernanp.app.dao.domain.TRequerimientoPersonal;
import sernanp.app.dao.mapper.TRequerimientoPersonalMapper;

@Service
public class ReporteRequerimientoPersonalMINTRAServiceImpl extends HelperServiceMybatisImpl implements ReporteRequerimientoPersonalMINTRAService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpOficioMintraQuery model) throws BusinessException {
	
		Integer lastId = null;

		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		this.insertSelective(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);

		lastId = tRequerimientoPersonal.getSrl_id_requerimiento_personal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpOficioMintraQuery model) throws BusinessException {

		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		this.updateByPrimaryKeySelective(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);
		
	}

	@Transactional
	@Override
	public void remove(RpOficioMintraQuery model) throws BusinessException {

		TRequerimientoPersonal tRequerimientoPersonal = beanUtil.copyBean(model, TRequerimientoPersonal.class);
		this.deleteByPrimaryKey(TRequerimientoPersonalMapper.class, tRequerimientoPersonal);
	}

}
