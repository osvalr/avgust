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

package pe.com.focus.sakerk.business.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.util.BeanUtil;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;

import pe.com.focus.sakerk.business.service.GestionarCongregacionLocalService;
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQuery;


import pe.com.focus.repository.mybatis.model.Persona;
import pe.com.focus.repository.mybatis.mapper.PersonaMapper;
import pe.com.focus.repository.mybatis.model.PersonaJuridica;
import pe.com.focus.repository.mybatis.mapper.PersonaJuridicaMapper;
import pe.com.focus.repository.mybatis.model.CongregacionLocal;
import pe.com.focus.repository.mybatis.mapper.CongregacionLocalMapper;
import pe.com.focus.repository.mybatis.model.UbicacionGeografica;
import pe.com.focus.repository.mybatis.mapper.UbicacionGeograficaMapper;
import pe.com.focus.repository.mybatis.model.PersonaUbicacionGeografica;
import pe.com.focus.repository.mybatis.mapper.PersonaUbicacionGeograficaMapper;

import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;
import pe.com.focus.repository.mybatis.model.NumeroTelefonico;
import pe.com.focus.repository.mybatis.mapper.NumeroTelefonicoMapper;
import pe.com.focus.repository.mybatis.model.NumeroTelefonicoExample;

@Service
public class GestionarCongregacionLocalServiceImpl extends HelperServiceImpl implements GestionarCongregacionLocalService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException {
		
		Integer lastId = null;

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		personaJuridica.setId_persona_juridica(persona.getId_persona());
		this.insertSelective(PersonaJuridicaMapper.class, personaJuridica);

		CongregacionLocal congregacionLocal = beanUtil.copyBean(model, CongregacionLocal.class);
		congregacionLocal.setId_congregacion_local(personaJuridica.getId_persona_juridica());
		this.insertSelective(CongregacionLocalMapper.class, congregacionLocal);

		UbicacionGeografica ubicacionGeografica = beanUtil.copyBean(model, UbicacionGeografica.class);
		this.insertSelective(UbicacionGeograficaMapper.class, ubicacionGeografica);

		PersonaUbicacionGeografica personaUbicacionGeografica = beanUtil.copyBean(model, PersonaUbicacionGeografica.class);
		personaUbicacionGeografica.setId_ubicacion_geografica(ubicacionGeografica.getId_ubicacion_geografica());
		personaUbicacionGeografica.setId_persona(persona.getId_persona());
		this.insertSelective(PersonaUbicacionGeograficaMapper.class, personaUbicacionGeografica);
		
		/*
		if(listNumeroTelefonicoQuery == null){
			throw new BusinessException("Error, no existen registros en NumeroTelefonico.");
		}else if(listNumeroTelefonicoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en NumeroTelefonico.");
		}
		*/

		for (NumeroTelefonicoQuery numeroTelefonicoQuery : listNumeroTelefonicoQuery) {
			numeroTelefonicoQuery.setId_numero_telefonico(null);
			numeroTelefonicoQuery.setId_persona(persona.getId_persona());
			NumeroTelefonico numeroTelefonico = beanUtil.copyBean(numeroTelefonicoQuery, NumeroTelefonico.class);
			this.insertSelective(NumeroTelefonicoMapper.class, numeroTelefonico);
		}
		lastId = persona.getId_persona();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException {
	
		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		this.updateByPrimaryKeySelective(PersonaJuridicaMapper.class, personaJuridica);
		
		CongregacionLocal congregacionLocal = beanUtil.copyBean(model, CongregacionLocal.class);
		this.updateByPrimaryKeySelective(CongregacionLocalMapper.class, congregacionLocal);
		
		UbicacionGeografica ubicacionGeografica = beanUtil.copyBean(model, UbicacionGeografica.class);
		this.updateByPrimaryKeySelective(UbicacionGeograficaMapper.class, ubicacionGeografica);
		
		PersonaUbicacionGeografica personaUbicacionGeografica = beanUtil.copyBean(model, PersonaUbicacionGeografica.class);
		this.updateByPrimaryKeySelective(PersonaUbicacionGeograficaMapper.class, personaUbicacionGeografica);
		
		/* Start NumeroTelefonico */
		/*
		if(listNumeroTelefonicoQuery == null){
			throw new BusinessException("Error, no existen registros en NumeroTelefonico.");
		}else if(listNumeroTelefonicoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en NumeroTelefonico.");
		}
		*/

		NumeroTelefonicoExample numeroTelefonicoExample = new NumeroTelefonicoExample();
		numeroTelefonicoExample.createCriteria().andId_personaEqualTo(persona.getId_persona());
		List<NumeroTelefonico> listNumeroTelefonicoCurrent = this.selectByExample(NumeroTelefonicoMapper.class, numeroTelefonicoExample);
		List<NumeroTelefonico> listNumeroTelefonicoDeleted = new ArrayList<NumeroTelefonico>();
		
		for (NumeroTelefonico numeroTelefonico : listNumeroTelefonicoCurrent) {
			boolean noExists = true;
			for (NumeroTelefonicoQuery numeroTelefonicoQuery : listNumeroTelefonicoQuery) {
				if(numeroTelefonicoQuery.getId_numero_telefonico().equals(numeroTelefonico.getId_numero_telefonico())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listNumeroTelefonicoDeleted.add(numeroTelefonico);
			}
		}
		
		this.deleteByPrimaryKey(NumeroTelefonicoMapper.class, listNumeroTelefonicoDeleted);
		
		for (NumeroTelefonicoQuery numeroTelefonicoQuery : listNumeroTelefonicoQuery) {
			if(numeroTelefonicoQuery.getId_numero_telefonico() < 1){
				numeroTelefonicoQuery.setId_numero_telefonico(null);
				numeroTelefonicoQuery.setId_persona(persona.getId_persona());
				NumeroTelefonico numeroTelefonico = beanUtil.copyBean(numeroTelefonicoQuery, NumeroTelefonico.class);
				this.insertSelective(NumeroTelefonicoMapper.class, numeroTelefonico);
			}else{
				NumeroTelefonico numeroTelefonico = beanUtil.copyBean(numeroTelefonicoQuery, NumeroTelefonico.class);
				this.updateByPrimaryKeySelective(NumeroTelefonicoMapper.class, numeroTelefonico);
			}
		}
		/* End NumeroTelefonico */	
		
	}

	@Transactional
	@Override
	public void remove(CongregacionLocalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery) throws BusinessException {
	
		for (NumeroTelefonicoQuery numeroTelefonicoQuery : listNumeroTelefonicoQuery) {
			NumeroTelefonico numeroTelefonico = beanUtil.copyBean(numeroTelefonicoQuery, NumeroTelefonico.class);
			this.deleteByPrimaryKey(NumeroTelefonicoMapper.class, numeroTelefonico);
		}

		PersonaUbicacionGeografica personaUbicacionGeografica = beanUtil.copyBean(model, PersonaUbicacionGeografica.class);
		this.deleteByPrimaryKey(PersonaUbicacionGeograficaMapper.class, personaUbicacionGeografica);

		UbicacionGeografica ubicacionGeografica = beanUtil.copyBean(model, UbicacionGeografica.class);
		this.deleteByPrimaryKey(UbicacionGeograficaMapper.class, ubicacionGeografica);

		CongregacionLocal congregacionLocal = beanUtil.copyBean(model, CongregacionLocal.class);
		this.deleteByPrimaryKey(CongregacionLocalMapper.class, congregacionLocal);

		PersonaJuridica personaJuridica = beanUtil.copyBean(model, PersonaJuridica.class);
		this.deleteByPrimaryKey(PersonaJuridicaMapper.class, personaJuridica);

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

}
