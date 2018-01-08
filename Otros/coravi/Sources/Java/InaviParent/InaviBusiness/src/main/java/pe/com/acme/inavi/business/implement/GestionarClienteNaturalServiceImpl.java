/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   01/03/2016 21:35:12
*/

package pe.com.acme.inavi.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import pe.com.acme.util.DtoUtil;
import pe.com.acme.util.MybatisRepositoryHelper;

import pe.com.acme.inavi.business.service.GestionarClienteNaturalService;
import pe.com.acme.inavi.business.util.InaviConstantes;
import pe.com.acme.query.mybatis.model.ClienteNaturalQuery;
import pe.com.acme.query.mybatis.model.ClienteNaturalQueryCriteria;
import pe.com.acme.query.mybatis.mapper.ClienteNaturalQueryMapper;

import pe.com.acme.domain.mybatis.model.Persona;
import pe.com.acme.domain.mybatis.model.PersonaExample;
import pe.com.acme.domain.mybatis.model.PersonaTipo;
import pe.com.acme.domain.mybatis.model.PersonaTipoExample;
import pe.com.acme.domain.mybatis.model.PersonaTipoKey;
import pe.com.acme.domain.mybatis.mapper.PersonaMapper;
import pe.com.acme.domain.mybatis.mapper.PersonaTipoMapper;

@Service
public class GestionarClienteNaturalServiceImpl extends MybatisRepositoryHelper implements GestionarClienteNaturalService {

	@Autowired
	InaviCommonServiceImpl inaviCommonServiceImpl;
	
	@Autowired
	private DtoUtil dtoUtil;
	
	@Autowired
	private PersonaTipoMapper personaTipoMapper;
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(ClienteNaturalQuery model) throws Exception {
	
		Integer lastId = null;

		Persona persona = dtoUtil.copyBean(model, Persona.class);
		
		if(persona.getId_tipo_doc() != null && persona.getNum_tipo_doc() != null){
			if(inaviCommonServiceImpl.buscarPersonaPorTipoNumDoc(persona.getId_tipo_doc(),persona.getNum_tipo_doc(), null) != null){
				throw new Exception("El tipo y número de documento de identidad ya existe.");
			}
		}else{
			persona.setNum_tipo_doc(null);
			persona.setId_tipo_doc(null);
		}
		
		if(persona.getEmail() != null){
			if(this.buscarPersonaPorEmail(persona.getEmail(), null) != null){
				throw new Exception("El email: " + model.getEmail() +" ya existe.");
			}
		}
		
		this.insertSelective(PersonaMapper.class, persona);
		
		PersonaTipo personaTipo = new PersonaTipo();
		personaTipo.setId_persona(persona.getId_persona());
		personaTipo.setId_tipo_persona(InaviConstantes.TIPO_PERSONA_NATURAL);
		personaTipo.setId_sub_tipo_persona(InaviConstantes.SUB_TIPO_PERSONA_CLIENTE);
		
		this.insertSelective(PersonaTipoMapper.class, personaTipo);
		
		lastId = persona.getId_persona();
		return lastId;
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void update(ClienteNaturalQuery model) throws Exception {

		Persona persona = dtoUtil.copyBean(model, Persona.class);
		
		if(persona.getId_tipo_doc() != null && persona.getNum_tipo_doc() != null){
			if(inaviCommonServiceImpl.buscarPersonaPorTipoNumDoc(persona.getId_tipo_doc(),persona.getNum_tipo_doc(), persona.getId_persona()) != null){
				throw new Exception("El tipo y número de documento de identidad ya existe.");
			}
		}else{
			persona.setNum_tipo_doc(null);
			persona.setId_tipo_doc(null);
		}
		
		if(persona.getEmail() != null){
			if(this.buscarPersonaPorEmail(persona.getEmail(), persona.getId_persona()) != null){
				throw new Exception("El email: " + model.getEmail() +" ya existe.");
			}
		}
		
		PersonaTipoKey personaTipoKey = new PersonaTipoKey();
		personaTipoKey.setId_persona(persona.getId_persona());
		personaTipoKey.setId_tipo_persona(InaviConstantes.TIPO_PERSONA_NATURAL);
		personaTipoKey.setId_sub_tipo_persona(InaviConstantes.SUB_TIPO_PERSONA_CLIENTE);
		
		PersonaTipo personaTipo = this.selectByPrimaryKey(PersonaTipoMapper.class, personaTipoKey);
		
		if(persona.getId_estado().intValue() != personaTipo.getId_estado().intValue()){
			
			int id_estado = persona.getId_estado().intValue();
			persona.setId_estado(InaviConstantes.ESTADO_GENERICO_ACTIVO);
			
			PersonaTipoExample example = new PersonaTipoExample();
			example.createCriteria()
			.andId_personaEqualTo(model.getId_persona())
			.andId_tipo_personaEqualTo(InaviConstantes.TIPO_PERSONA_NATURAL)
			.andId_sub_tipo_personaEqualTo(InaviConstantes.SUB_TIPO_PERSONA_CLIENTE);
			
			personaTipo.setId_estado(id_estado);
			
			personaTipoMapper.updateByExample(personaTipo, example);
			
		}

		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void destroy(ClienteNaturalQuery model) throws Exception {

		PersonaTipoExample example = new PersonaTipoExample();
		example.createCriteria()
		.andId_personaEqualTo(model.getId_persona())
		.andId_tipo_personaEqualTo(InaviConstantes.TIPO_PERSONA_NATURAL)
		.andId_sub_tipo_personaEqualTo(InaviConstantes.SUB_TIPO_PERSONA_CLIENTE);
		
		personaTipoMapper.deleteByExample(example);
		
		Persona persona = dtoUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public List<ClienteNaturalQuery> list(ClienteNaturalQueryCriteria criteria) throws Exception {
		List<ClienteNaturalQuery> list = this.selectByQuery(ClienteNaturalQueryMapper.class, criteria, criteria.getStart(), criteria.getLimit());
		return list;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public int countRecords(ClienteNaturalQueryCriteria criteria) throws Exception {
		int count = this.selectCountByQuery(ClienteNaturalQueryMapper.class, criteria);
		return count;
	}
	
	public Persona buscarPersonaPorEmail(String email, Integer id) throws Exception{
		
		PersonaExample example = new PersonaExample();
		
		if(id == null){
			example.createCriteria().andEmailEqualTo(email);
		}else{
			example.createCriteria().andEmailEqualTo(email).andId_personaNotEqualTo(id);
		}
		
		Persona persona = this.selectOneByExample(PersonaMapper.class, example);
		
		return persona;
	}
}
