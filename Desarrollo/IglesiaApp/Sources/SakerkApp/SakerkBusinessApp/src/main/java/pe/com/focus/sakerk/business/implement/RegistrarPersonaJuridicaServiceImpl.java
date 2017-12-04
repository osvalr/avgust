/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
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
* DATE CREATE : 31/12/2014 13:25:15
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.util.BeanUtil;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;
import pe.com.focus.sakerk.business.service.RegistrarPersonaJuridicaService;
import pe.com.focus.sakerk.repository.custom.model.RegistroPersonaJuridicaQuery;
import pe.com.focus.repository.mybatis.model.Persona;
import pe.com.focus.repository.mybatis.model.PersonaJuridica;
import pe.com.focus.repository.mybatis.mapper.PersonaJuridicaMapper;
import pe.com.focus.repository.mybatis.mapper.PersonaMapper;

@Service
public class RegistrarPersonaJuridicaServiceImpl extends HelperServiceImpl implements RegistrarPersonaJuridicaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer execute(RegistroPersonaJuridicaQuery model) throws BusinessException {
		Integer lastId = null;
		Persona persona = beanUtil.copyBean(model, Persona.class);
		persona.setId_pais(136); //Perú
		persona.setId_estado(1); // Activo
		persona.setId_tipo_persona(2); // Juridica
		this.insertSelective(PersonaMapper.class, persona);
		
		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		personaJuridica.setId_persona_juridica(persona.getId_persona());
		this.insertSelective(PersonaJuridicaMapper.class, personaJuridica);
		
		lastId = persona.getId_persona();
		
		return lastId;
	}
	
}
