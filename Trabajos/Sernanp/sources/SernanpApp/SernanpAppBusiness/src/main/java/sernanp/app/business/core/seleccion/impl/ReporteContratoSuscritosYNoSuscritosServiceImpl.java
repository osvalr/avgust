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
* DATE CREATE : 25/06/2015 14:27:10
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.seleccion.service.ReporteContratoSuscritosYNoSuscritosService;
import sernanp.app.dao.query.domain.RpSeleccionContratosSuscritosNoSuscritosQuery;

import sernanp.app.dao.domain.Persona;
import sernanp.app.dao.mapper.PersonaMapper;

@Service
public class ReporteContratoSuscritosYNoSuscritosServiceImpl extends HelperServiceMybatisImpl implements ReporteContratoSuscritosYNoSuscritosService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpSeleccionContratosSuscritosNoSuscritosQuery model) throws BusinessException {
	
		Integer lastId = null;

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		lastId = persona.getIdpersona();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpSeleccionContratosSuscritosNoSuscritosQuery model) throws BusinessException {

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
	}

	@Transactional
	@Override
	public void remove(RpSeleccionContratosSuscritosNoSuscritosQuery model) throws BusinessException {

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

}
