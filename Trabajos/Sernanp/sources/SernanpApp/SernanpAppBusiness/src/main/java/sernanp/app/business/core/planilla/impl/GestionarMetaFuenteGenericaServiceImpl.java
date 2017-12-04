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
* DATE CREATE : 19/04/2015 06:16:31
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.planilla.service.GestionarMetaFuenteGenericaService;
import sernanp.app.dao.query.domain.GestionarMetaFuenteGenericaQuery;

import sernanp.app.dao.domain.TMetaFuenteGenerica;
import sernanp.app.dao.mapper.TMetaFuenteGenericaMapper;

@Service
public class GestionarMetaFuenteGenericaServiceImpl extends HelperServiceMybatisImpl implements GestionarMetaFuenteGenericaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarMetaFuenteGenericaQuery model) throws BusinessException {
	
		Integer lastId = null;

		TMetaFuenteGenerica tMetaFuenteGenerica = beanUtil.copyBean(model, TMetaFuenteGenerica.class);
		this.insertSelective(TMetaFuenteGenericaMapper.class, tMetaFuenteGenerica);

		lastId = tMetaFuenteGenerica.getSrl_id_meta_fuente_generica();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarMetaFuenteGenericaQuery model) throws BusinessException {

		TMetaFuenteGenerica tMetaFuenteGenerica = beanUtil.copyBean(model, TMetaFuenteGenerica.class);
		this.updateByPrimaryKeySelective(TMetaFuenteGenericaMapper.class, tMetaFuenteGenerica);
		
	}

	@Transactional
	@Override
	public void remove(GestionarMetaFuenteGenericaQuery model) throws BusinessException {

		TMetaFuenteGenerica tMetaFuenteGenerica = beanUtil.copyBean(model, TMetaFuenteGenerica.class);
		this.deleteByPrimaryKey(TMetaFuenteGenericaMapper.class, tMetaFuenteGenerica);
	}

}
