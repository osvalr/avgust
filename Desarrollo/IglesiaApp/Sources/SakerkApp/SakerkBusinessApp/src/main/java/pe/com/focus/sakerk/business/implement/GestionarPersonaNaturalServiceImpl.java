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
* DATE CREATE : 20/01/2015 13:20:36
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

import pe.com.focus.sakerk.business.service.GestionarPersonaNaturalService;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQuery;


import pe.com.focus.repository.mybatis.model.Persona;
import pe.com.focus.repository.mybatis.mapper.PersonaMapper;
import pe.com.focus.repository.mybatis.model.PersonaNatural;
import pe.com.focus.repository.mybatis.mapper.PersonaNaturalMapper;
import pe.com.focus.repository.mybatis.model.UbicacionGeografica;
import pe.com.focus.repository.mybatis.mapper.UbicacionGeograficaMapper;
import pe.com.focus.repository.mybatis.model.PersonaUbicacionGeografica;
import pe.com.focus.repository.mybatis.mapper.PersonaUbicacionGeograficaMapper;

import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery;
import pe.com.focus.repository.mybatis.model.NumeroTelefonico;
import pe.com.focus.repository.mybatis.mapper.NumeroTelefonicoMapper;
import pe.com.focus.repository.mybatis.model.NumeroTelefonicoExample;
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQuery;
import pe.com.focus.repository.mybatis.model.InformacionAcademica;
import pe.com.focus.repository.mybatis.mapper.InformacionAcademicaMapper;
import pe.com.focus.repository.mybatis.model.InformacionAcademicaExample;
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQuery;
import pe.com.focus.repository.mybatis.model.InformacionLaboral;
import pe.com.focus.repository.mybatis.mapper.InformacionLaboralMapper;
import pe.com.focus.repository.mybatis.model.InformacionLaboralExample;
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQuery;
import pe.com.focus.repository.mybatis.model.InformacionEclesiastica;
import pe.com.focus.repository.mybatis.mapper.InformacionEclesiasticaMapper;
import pe.com.focus.repository.mybatis.model.InformacionEclesiasticaExample;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQuery;
import pe.com.focus.repository.mybatis.model.PersonaParentesco;
import pe.com.focus.repository.mybatis.mapper.PersonaParentescoMapper;
import pe.com.focus.repository.mybatis.model.PersonaParentescoExample;
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQuery;
import pe.com.focus.repository.mybatis.model.PersonaNaturalRol;
import pe.com.focus.repository.mybatis.mapper.PersonaNaturalRolMapper;
import pe.com.focus.repository.mybatis.model.PersonaNaturalRolExample;

@Service
public class GestionarPersonaNaturalServiceImpl extends HelperServiceImpl implements GestionarPersonaNaturalService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException {
		
		Integer lastId = null;

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		PersonaNatural personaNatural = beanUtil.copyBean(model, PersonaNatural.class);
		personaNatural.setId_persona_natural(persona.getId_persona());
		this.insertSelective(PersonaNaturalMapper.class, personaNatural);

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
		/*
		if(listInformacionAcademicaQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionAcademica.");
		}else if(listInformacionAcademicaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionAcademica.");
		}
		*/

		for (InformacionAcademicaQuery informacionAcademicaQuery : listInformacionAcademicaQuery) {
			informacionAcademicaQuery.setId_informacion_academica(null);
			informacionAcademicaQuery.setId_persona_natural(personaNatural.getId_persona_natural());
			InformacionAcademica informacionAcademica = beanUtil.copyBean(informacionAcademicaQuery, InformacionAcademica.class);
			this.insertSelective(InformacionAcademicaMapper.class, informacionAcademica);
		}
		/*
		if(listInformacionLaboralQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionLaboral.");
		}else if(listInformacionLaboralQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionLaboral.");
		}
		*/

		for (InformacionLaboralQuery informacionLaboralQuery : listInformacionLaboralQuery) {
			informacionLaboralQuery.setId_informacion_laboral(null);
			informacionLaboralQuery.setId_persona_natural(personaNatural.getId_persona_natural());
			InformacionLaboral informacionLaboral = beanUtil.copyBean(informacionLaboralQuery, InformacionLaboral.class);
			this.insertSelective(InformacionLaboralMapper.class, informacionLaboral);
		}
		/*
		if(listInformacionEclesiasticaQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionEclesiastica.");
		}else if(listInformacionEclesiasticaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionEclesiastica.");
		}
		*/

		for (InformacionEclesiasticaQuery informacionEclesiasticaQuery : listInformacionEclesiasticaQuery) {
			informacionEclesiasticaQuery.setId_info_eclesiastica(null);
			informacionEclesiasticaQuery.setId_persona_natural(personaNatural.getId_persona_natural());
			InformacionEclesiastica informacionEclesiastica = beanUtil.copyBean(informacionEclesiasticaQuery, InformacionEclesiastica.class);
			this.insertSelective(InformacionEclesiasticaMapper.class, informacionEclesiastica);
		}
		/*
		if(listPersonaNaturalParentescoQuery == null){
			throw new BusinessException("Error, no existen registros en PersonaParentesco.");
		}else if(listPersonaNaturalParentescoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en PersonaParentesco.");
		}
		*/

		for (PersonaNaturalParentescoQuery personaNaturalParentescoQuery : listPersonaNaturalParentescoQuery) {
			personaNaturalParentescoQuery.setId_persona_parentesco(null);
			personaNaturalParentescoQuery.setId_persona_natural(personaNatural.getId_persona_natural());
			PersonaParentesco personaParentesco = beanUtil.copyBean(personaNaturalParentescoQuery, PersonaParentesco.class);
			this.insertSelective(PersonaParentescoMapper.class, personaParentesco);
		}
		/*
		if(listPersonaNaturalRolQuery == null){
			throw new BusinessException("Error, no existen registros en PersonaNaturalRol.");
		}else if(listPersonaNaturalRolQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en PersonaNaturalRol.");
		}
		*/

		for (PersonaNaturalRolQuery personaNaturalRolQuery : listPersonaNaturalRolQuery) {
			personaNaturalRolQuery.setId_persona_natural_rol(null);
			personaNaturalRolQuery.setId_persona_natural(personaNatural.getId_persona_natural());
			PersonaNaturalRol personaNaturalRol = beanUtil.copyBean(personaNaturalRolQuery, PersonaNaturalRol.class);
			this.insertSelective(PersonaNaturalRolMapper.class, personaNaturalRol);
		}
		lastId = persona.getId_persona();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException {
	
		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
		PersonaNatural personaNatural = beanUtil.copyBean(model, PersonaNatural.class);
		this.updateByPrimaryKeySelective(PersonaNaturalMapper.class, personaNatural);
		
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
		/* Start InformacionAcademica */
		/*
		if(listInformacionAcademicaQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionAcademica.");
		}else if(listInformacionAcademicaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionAcademica.");
		}
		*/

		InformacionAcademicaExample informacionAcademicaExample = new InformacionAcademicaExample();
		informacionAcademicaExample.createCriteria().andId_persona_naturalEqualTo(personaNatural.getId_persona_natural());
		List<InformacionAcademica> listInformacionAcademicaCurrent = this.selectByExample(InformacionAcademicaMapper.class, informacionAcademicaExample);
		List<InformacionAcademica> listInformacionAcademicaDeleted = new ArrayList<InformacionAcademica>();
		
		for (InformacionAcademica informacionAcademica : listInformacionAcademicaCurrent) {
			boolean noExists = true;
			for (InformacionAcademicaQuery informacionAcademicaQuery : listInformacionAcademicaQuery) {
				if(informacionAcademicaQuery.getId_informacion_academica().equals(informacionAcademica.getId_informacion_academica())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listInformacionAcademicaDeleted.add(informacionAcademica);
			}
		}
		
		this.deleteByPrimaryKey(InformacionAcademicaMapper.class, listInformacionAcademicaDeleted);
		
		for (InformacionAcademicaQuery informacionAcademicaQuery : listInformacionAcademicaQuery) {
			if(informacionAcademicaQuery.getId_informacion_academica() < 1){
				informacionAcademicaQuery.setId_informacion_academica(null);
				informacionAcademicaQuery.setId_persona_natural(personaNatural.getId_persona_natural());
				InformacionAcademica informacionAcademica = beanUtil.copyBean(informacionAcademicaQuery, InformacionAcademica.class);
				this.insertSelective(InformacionAcademicaMapper.class, informacionAcademica);
			}else{
				InformacionAcademica informacionAcademica = beanUtil.copyBean(informacionAcademicaQuery, InformacionAcademica.class);
				this.updateByPrimaryKeySelective(InformacionAcademicaMapper.class, informacionAcademica);
			}
		}
		/* End InformacionAcademica */	
		/* Start InformacionLaboral */
		/*
		if(listInformacionLaboralQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionLaboral.");
		}else if(listInformacionLaboralQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionLaboral.");
		}
		*/

		InformacionLaboralExample informacionLaboralExample = new InformacionLaboralExample();
		informacionLaboralExample.createCriteria().andId_persona_naturalEqualTo(personaNatural.getId_persona_natural());
		List<InformacionLaboral> listInformacionLaboralCurrent = this.selectByExample(InformacionLaboralMapper.class, informacionLaboralExample);
		List<InformacionLaboral> listInformacionLaboralDeleted = new ArrayList<InformacionLaboral>();
		
		for (InformacionLaboral informacionLaboral : listInformacionLaboralCurrent) {
			boolean noExists = true;
			for (InformacionLaboralQuery informacionLaboralQuery : listInformacionLaboralQuery) {
				if(informacionLaboralQuery.getId_informacion_laboral().equals(informacionLaboral.getId_informacion_laboral())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listInformacionLaboralDeleted.add(informacionLaboral);
			}
		}
		
		this.deleteByPrimaryKey(InformacionLaboralMapper.class, listInformacionLaboralDeleted);
		
		for (InformacionLaboralQuery informacionLaboralQuery : listInformacionLaboralQuery) {
			if(informacionLaboralQuery.getId_informacion_laboral() < 1){
				informacionLaboralQuery.setId_informacion_laboral(null);
				informacionLaboralQuery.setId_persona_natural(personaNatural.getId_persona_natural());
				InformacionLaboral informacionLaboral = beanUtil.copyBean(informacionLaboralQuery, InformacionLaboral.class);
				this.insertSelective(InformacionLaboralMapper.class, informacionLaboral);
			}else{
				InformacionLaboral informacionLaboral = beanUtil.copyBean(informacionLaboralQuery, InformacionLaboral.class);
				this.updateByPrimaryKeySelective(InformacionLaboralMapper.class, informacionLaboral);
			}
		}
		/* End InformacionLaboral */	
		/* Start InformacionEclesiastica */
		/*
		if(listInformacionEclesiasticaQuery == null){
			throw new BusinessException("Error, no existen registros en InformacionEclesiastica.");
		}else if(listInformacionEclesiasticaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en InformacionEclesiastica.");
		}
		*/

		InformacionEclesiasticaExample informacionEclesiasticaExample = new InformacionEclesiasticaExample();
		informacionEclesiasticaExample.createCriteria().andId_persona_naturalEqualTo(personaNatural.getId_persona_natural());
		List<InformacionEclesiastica> listInformacionEclesiasticaCurrent = this.selectByExample(InformacionEclesiasticaMapper.class, informacionEclesiasticaExample);
		List<InformacionEclesiastica> listInformacionEclesiasticaDeleted = new ArrayList<InformacionEclesiastica>();
		
		for (InformacionEclesiastica informacionEclesiastica : listInformacionEclesiasticaCurrent) {
			boolean noExists = true;
			for (InformacionEclesiasticaQuery informacionEclesiasticaQuery : listInformacionEclesiasticaQuery) {
				if(informacionEclesiasticaQuery.getId_info_eclesiastica().equals(informacionEclesiastica.getId_info_eclesiastica())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listInformacionEclesiasticaDeleted.add(informacionEclesiastica);
			}
		}
		
		this.deleteByPrimaryKey(InformacionEclesiasticaMapper.class, listInformacionEclesiasticaDeleted);
		
		for (InformacionEclesiasticaQuery informacionEclesiasticaQuery : listInformacionEclesiasticaQuery) {
			if(informacionEclesiasticaQuery.getId_info_eclesiastica() < 1){
				informacionEclesiasticaQuery.setId_info_eclesiastica(null);
				informacionEclesiasticaQuery.setId_persona_natural(personaNatural.getId_persona_natural());
				InformacionEclesiastica informacionEclesiastica = beanUtil.copyBean(informacionEclesiasticaQuery, InformacionEclesiastica.class);
				this.insertSelective(InformacionEclesiasticaMapper.class, informacionEclesiastica);
			}else{
				InformacionEclesiastica informacionEclesiastica = beanUtil.copyBean(informacionEclesiasticaQuery, InformacionEclesiastica.class);
				this.updateByPrimaryKeySelective(InformacionEclesiasticaMapper.class, informacionEclesiastica);
			}
		}
		/* End InformacionEclesiastica */	
		/* Start PersonaParentesco */
		/*
		if(listPersonaNaturalParentescoQuery == null){
			throw new BusinessException("Error, no existen registros en PersonaParentesco.");
		}else if(listPersonaNaturalParentescoQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en PersonaParentesco.");
		}
		*/

		PersonaParentescoExample personaParentescoExample = new PersonaParentescoExample();
		personaParentescoExample.createCriteria().andId_persona_naturalEqualTo(personaNatural.getId_persona_natural());
		List<PersonaParentesco> listPersonaParentescoCurrent = this.selectByExample(PersonaParentescoMapper.class, personaParentescoExample);
		List<PersonaParentesco> listPersonaParentescoDeleted = new ArrayList<PersonaParentesco>();
		
		for (PersonaParentesco personaParentesco : listPersonaParentescoCurrent) {
			boolean noExists = true;
			for (PersonaNaturalParentescoQuery personaNaturalParentescoQuery : listPersonaNaturalParentescoQuery) {
				if(personaNaturalParentescoQuery.getId_persona_parentesco().equals(personaParentesco.getId_persona_parentesco())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listPersonaParentescoDeleted.add(personaParentesco);
			}
		}
		
		this.deleteByPrimaryKey(PersonaParentescoMapper.class, listPersonaParentescoDeleted);
		
		for (PersonaNaturalParentescoQuery personaNaturalParentescoQuery : listPersonaNaturalParentescoQuery) {
			if(personaNaturalParentescoQuery.getId_persona_parentesco() < 1){
				personaNaturalParentescoQuery.setId_persona_parentesco(null);
				personaNaturalParentescoQuery.setId_persona_natural(personaNatural.getId_persona_natural());
				PersonaParentesco personaParentesco = beanUtil.copyBean(personaNaturalParentescoQuery, PersonaParentesco.class);
				this.insertSelective(PersonaParentescoMapper.class, personaParentesco);
			}else{
				PersonaParentesco personaParentesco = beanUtil.copyBean(personaNaturalParentescoQuery, PersonaParentesco.class);
				this.updateByPrimaryKeySelective(PersonaParentescoMapper.class, personaParentesco);
			}
		}
		/* End PersonaParentesco */	
		/* Start PersonaNaturalRol */
		/*
		if(listPersonaNaturalRolQuery == null){
			throw new BusinessException("Error, no existen registros en PersonaNaturalRol.");
		}else if(listPersonaNaturalRolQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en PersonaNaturalRol.");
		}
		*/

		PersonaNaturalRolExample personaNaturalRolExample = new PersonaNaturalRolExample();
		personaNaturalRolExample.createCriteria().andId_persona_naturalEqualTo(personaNatural.getId_persona_natural());
		List<PersonaNaturalRol> listPersonaNaturalRolCurrent = this.selectByExample(PersonaNaturalRolMapper.class, personaNaturalRolExample);
		List<PersonaNaturalRol> listPersonaNaturalRolDeleted = new ArrayList<PersonaNaturalRol>();
		
		for (PersonaNaturalRol personaNaturalRol : listPersonaNaturalRolCurrent) {
			boolean noExists = true;
			for (PersonaNaturalRolQuery personaNaturalRolQuery : listPersonaNaturalRolQuery) {
				if(personaNaturalRolQuery.getId_persona_natural_rol().equals(personaNaturalRol.getId_persona_natural_rol())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listPersonaNaturalRolDeleted.add(personaNaturalRol);
			}
		}
		
		this.deleteByPrimaryKey(PersonaNaturalRolMapper.class, listPersonaNaturalRolDeleted);
		
		for (PersonaNaturalRolQuery personaNaturalRolQuery : listPersonaNaturalRolQuery) {
			if(personaNaturalRolQuery.getId_persona_natural_rol() < 1){
				personaNaturalRolQuery.setId_persona_natural_rol(null);
				personaNaturalRolQuery.setId_persona_natural(personaNatural.getId_persona_natural());
				PersonaNaturalRol personaNaturalRol = beanUtil.copyBean(personaNaturalRolQuery, PersonaNaturalRol.class);
				this.insertSelective(PersonaNaturalRolMapper.class, personaNaturalRol);
			}else{
				PersonaNaturalRol personaNaturalRol = beanUtil.copyBean(personaNaturalRolQuery, PersonaNaturalRol.class);
				this.updateByPrimaryKeySelective(PersonaNaturalRolMapper.class, personaNaturalRol);
			}
		}
		/* End PersonaNaturalRol */	
		
	}

	@Transactional
	@Override
	public void remove(PersonaNaturalQuery model, List<NumeroTelefonicoQuery> listNumeroTelefonicoQuery, List<InformacionAcademicaQuery> listInformacionAcademicaQuery, List<InformacionLaboralQuery> listInformacionLaboralQuery, List<InformacionEclesiasticaQuery> listInformacionEclesiasticaQuery, List<PersonaNaturalParentescoQuery> listPersonaNaturalParentescoQuery, List<PersonaNaturalRolQuery> listPersonaNaturalRolQuery) throws BusinessException {
	
		for (NumeroTelefonicoQuery numeroTelefonicoQuery : listNumeroTelefonicoQuery) {
			NumeroTelefonico numeroTelefonico = beanUtil.copyBean(numeroTelefonicoQuery, NumeroTelefonico.class);
			this.deleteByPrimaryKey(NumeroTelefonicoMapper.class, numeroTelefonico);
		}
		for (InformacionAcademicaQuery informacionAcademicaQuery : listInformacionAcademicaQuery) {
			InformacionAcademica informacionAcademica = beanUtil.copyBean(informacionAcademicaQuery, InformacionAcademica.class);
			this.deleteByPrimaryKey(InformacionAcademicaMapper.class, informacionAcademica);
		}
		for (InformacionLaboralQuery informacionLaboralQuery : listInformacionLaboralQuery) {
			InformacionLaboral informacionLaboral = beanUtil.copyBean(informacionLaboralQuery, InformacionLaboral.class);
			this.deleteByPrimaryKey(InformacionLaboralMapper.class, informacionLaboral);
		}
		for (InformacionEclesiasticaQuery informacionEclesiasticaQuery : listInformacionEclesiasticaQuery) {
			InformacionEclesiastica informacionEclesiastica = beanUtil.copyBean(informacionEclesiasticaQuery, InformacionEclesiastica.class);
			this.deleteByPrimaryKey(InformacionEclesiasticaMapper.class, informacionEclesiastica);
		}
		for (PersonaNaturalParentescoQuery personaNaturalParentescoQuery : listPersonaNaturalParentescoQuery) {
			PersonaParentesco personaParentesco = beanUtil.copyBean(personaNaturalParentescoQuery, PersonaParentesco.class);
			this.deleteByPrimaryKey(PersonaParentescoMapper.class, personaParentesco);
		}
		for (PersonaNaturalRolQuery personaNaturalRolQuery : listPersonaNaturalRolQuery) {
			PersonaNaturalRol personaNaturalRol = beanUtil.copyBean(personaNaturalRolQuery, PersonaNaturalRol.class);
			this.deleteByPrimaryKey(PersonaNaturalRolMapper.class, personaNaturalRol);
		}

		PersonaUbicacionGeografica personaUbicacionGeografica = beanUtil.copyBean(model, PersonaUbicacionGeografica.class);
		this.deleteByPrimaryKey(PersonaUbicacionGeograficaMapper.class, personaUbicacionGeografica);

		UbicacionGeografica ubicacionGeografica = beanUtil.copyBean(model, UbicacionGeografica.class);
		this.deleteByPrimaryKey(UbicacionGeograficaMapper.class, ubicacionGeografica);

		PersonaNatural personaNatural = beanUtil.copyBean(model, PersonaNatural.class);
		this.deleteByPrimaryKey(PersonaNaturalMapper.class, personaNatural);

		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.deleteByPrimaryKey(PersonaMapper.class, persona);
	}

}
