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
* DATE CREATE : 27/05/2015 04:42:23
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.planilla.service.GestionarTrabajadoresService;
import sernanp.app.dao.domain.Persona;
import sernanp.app.dao.domain.Personanatural;
import sernanp.app.dao.domain.TPersonalMetaFteFto;
import sernanp.app.dao.domain.TPersonalMetaFteFtoExample;
import sernanp.app.dao.mapper.PersonaMapper;
import sernanp.app.dao.mapper.PersonanaturalMapper;
import sernanp.app.dao.mapper.TPersonalMetaFteFtoMapper;
import sernanp.app.dao.query.domain.GestionarTrabajadoresPresupuestoQuery;
import sernanp.app.dao.query.domain.GestionarTrabajadoresQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarTrabajadoresServiceImpl extends HelperServiceMybatisImpl implements GestionarTrabajadoresService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarTrabajadoresQuery model, List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery) throws BusinessException {
		
		Integer lastId = null;
		
		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.insertSelective(PersonaMapper.class, persona);

		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		personanatural.setIdpersona(persona.getIdpersona());
		this.insertSelective(PersonanaturalMapper.class, personanatural);

		
		for (GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery : listGestionarTrabajadoresPresupuestoQuery) {
			
			TPersonalMetaFteFto tPersonalMetaFteFto = beanUtil.copyBean(gestionarTrabajadoresPresupuestoQuery, TPersonalMetaFteFto.class);
			tPersonalMetaFteFto.setSrl_id_anio_planilla(gestionarTrabajadoresPresupuestoQuery.getSrl_id_anio_planilla());
			tPersonalMetaFteFto.setIdpersonanatural(personanatural.getIdpersonanatural());
			tPersonalMetaFteFto.setC_meta(gestionarTrabajadoresPresupuestoQuery.getVar_cod_meta_presupuestaria());
			tPersonalMetaFteFto.setC_fte_fto(gestionarTrabajadoresPresupuestoQuery.getVar_rubro_fte_fto());
			tPersonalMetaFteFto.setInt_id_estado(gestionarTrabajadoresPresupuestoQuery.getInt_id_estado());
			this.insertSelective(TPersonalMetaFteFtoMapper.class, tPersonalMetaFteFto);
		}
		lastId = personanatural.getIdpersonanatural();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarTrabajadoresQuery model, List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery) throws BusinessException {
	    
		
		Persona persona = beanUtil.copyBean(model, Persona.class);
		this.updateByPrimaryKeySelective(PersonaMapper.class, persona);
		
		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		this.updateByPrimaryKeySelective(PersonanaturalMapper.class, personanatural);


		TPersonalMetaFteFtoExample tPersonalMetaFteFtoExample = new TPersonalMetaFteFtoExample();
		tPersonalMetaFteFtoExample.createCriteria().andIdpersonanaturalEqualTo(personanatural.getIdpersonanatural());
		
		List<TPersonalMetaFteFto> listTPersonalMetaFteFtoCurrent = this.selectByExample(TPersonalMetaFteFtoMapper.class, tPersonalMetaFteFtoExample);
		List<TPersonalMetaFteFto> listTPersonalMetaFteFtoDeleted = new ArrayList<TPersonalMetaFteFto>();
		
		for (TPersonalMetaFteFto tPersonalMetaFteFto : listTPersonalMetaFteFtoCurrent) {
			boolean noExists = true;
			for (GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery : listGestionarTrabajadoresPresupuestoQuery) {
				if(gestionarTrabajadoresPresupuestoQuery.getIdpersonanatural().equals(tPersonalMetaFteFto.getIdpersonanatural())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTPersonalMetaFteFtoDeleted.add(tPersonalMetaFteFto);
			}
		}
		
		
		
//		this.deleteByPrimaryKey(TPersonalMetaFteFtoMapper.class, listTPersonalMetaFteFtoDeleted);
		
		for (GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery : listGestionarTrabajadoresPresupuestoQuery) {
			if(gestionarTrabajadoresPresupuestoQuery.getIdpersonanatural() < 1){
				
				gestionarTrabajadoresPresupuestoQuery.setIdpersonanatural(personanatural.getIdpersonanatural());
				
				TPersonalMetaFteFto tPersonalMetaFteFto = beanUtil.copyBean(gestionarTrabajadoresPresupuestoQuery, TPersonalMetaFteFto.class);
//				tPersonalMetaFteFto.setSrl_id_anio_planilla(gestionarTrabajadoresPresupuestoQuery.getSrl_id_anio_planilla());
//				tPersonalMetaFteFto.setIdpersonanatural(personanatural.getIdpersonanatural());
//				tPersonalMetaFteFto.setC_meta(gestionarTrabajadoresPresupuestoQuery.getVar_cod_meta_presupuestaria());
//				tPersonalMetaFteFto.setC_fte_fto(gestionarTrabajadoresPresupuestoQuery.getVar_rubro_fte_fto());
//				tPersonalMetaFteFto.setInt_id_estado(gestionarTrabajadoresPresupuestoQuery.getInt_id_estado());
				this.insertSelective(TPersonalMetaFteFtoMapper.class, tPersonalMetaFteFto);
			}else{
				TPersonalMetaFteFto tPersonalMetaFteFto = beanUtil.copyBean(gestionarTrabajadoresPresupuestoQuery, TPersonalMetaFteFto.class);
//				tPersonalMetaFteFto.setSrl_id_anio_planilla(gestionarTrabajadoresPresupuestoQuery.getSrl_id_anio_planilla());
//				tPersonalMetaFteFto.setIdpersonanatural(personanatural.getIdpersonanatural());
//				tPersonalMetaFteFto.setC_meta(gestionarTrabajadoresPresupuestoQuery.getVar_cod_meta_presupuestaria());
//				tPersonalMetaFteFto.setC_fte_fto(gestionarTrabajadoresPresupuestoQuery.getVar_rubro_fte_fto());
//				tPersonalMetaFteFto.setInt_id_estado(gestionarTrabajadoresPresupuestoQuery.getInt_id_estado());
				this.updateByPrimaryKeySelective(TPersonalMetaFteFtoMapper.class, tPersonalMetaFteFto);
			}
		}
		/* End TPersonalMetaFteFto */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarTrabajadoresQuery model, List<GestionarTrabajadoresPresupuestoQuery> listGestionarTrabajadoresPresupuestoQuery) throws BusinessException {
	
		for (GestionarTrabajadoresPresupuestoQuery gestionarTrabajadoresPresupuestoQuery : listGestionarTrabajadoresPresupuestoQuery) {
			TPersonalMetaFteFto tPersonalMetaFteFto = beanUtil.copyBean(gestionarTrabajadoresPresupuestoQuery, TPersonalMetaFteFto.class);
			this.deleteByPrimaryKey(TPersonalMetaFteFtoMapper.class, tPersonalMetaFteFto);
		}

		Personanatural personanatural = beanUtil.copyBean(model, Personanatural.class);
		this.deleteByPrimaryKey(PersonanaturalMapper.class, personanatural);
	}

}
