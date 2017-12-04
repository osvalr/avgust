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
* DATE CREATE : 20/01/2015 13:21:31
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.util.BeanUtil;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;

import pe.com.focus.sakerk.business.service.GestionarPersonaJuridicaService;
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQuery;

import pe.com.focus.repository.mybatis.model.Persona;
import pe.com.focus.repository.mybatis.mapper.PersonaMapper;
import pe.com.focus.repository.mybatis.model.PersonaJuridica;
import pe.com.focus.repository.mybatis.mapper.PersonaJuridicaMapper;

@Service
public class GestionarPersonaJuridicaServiceImpl extends HelperServiceImpl implements GestionarPersonaJuridicaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(PersonaJuridicaQuery model) throws BusinessException {
	
		Integer lastId = null;

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		personaJuridica.setId_persona_juridica(persona.getId_persona());
		this.insertSelective(PersonaJuridicaMapper.class, personaJuridica);

		lastId = persona.getId_persona();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(PersonaJuridicaQuery model) throws BusinessException {

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		this.updateByPrimaryKeySelective(PersonaJuridicaMapper.class, personaJuridica);
		
	}

	@Transactional
	@Override
	public void remove(PersonaJuridicaQuery model) throws BusinessException {

		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		this.deleteByPrimaryKey(PersonaJuridicaMapper.class, personaJuridica);

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

}
