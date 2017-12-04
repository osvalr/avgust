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
* DATE CREATE : 02/04/2015 11:57:25
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;
import sernanp.app.business.core.planilla.service.GestionarConceptoService;
import sernanp.app.dao.query.domain.GestionarConceptoQuery;
import sernanp.app.dao.domain.TConceptoPlanilla;
import sernanp.app.dao.domain.TConceptoPlanillaExample;
import sernanp.app.dao.domain.TFrecuencia;
import sernanp.app.dao.domain.TFrecuenciaKey;
import sernanp.app.dao.mapper.TConceptoPlanillaMapper;
import sernanp.app.dao.mapper.TFrecuenciaMapper;
import sernanp.app.dao.query.domain.ConceptoAfectoQuery;
import sernanp.app.dao.domain.TAfectoConcepto;
import sernanp.app.dao.mapper.TAfectoConceptoMapper;
import sernanp.app.dao.domain.TAfectoConceptoExample;
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQuery;
import sernanp.app.dao.domain.TConceptoFrecuencia;
import sernanp.app.dao.mapper.TConceptoFrecuenciaMapper;
import sernanp.app.dao.domain.TConceptoFrecuenciaExample;

@Service
public class GestionarConceptoServiceImpl extends HelperServiceMybatisImpl implements GestionarConceptoService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	private TAfectoConceptoMapper tAfectoConceptoMapper;
	
	@Transactional
	@Override
	public Integer create(GestionarConceptoQuery model, List<ConceptoAfectoQuery> listConceptoAfectoQuery, List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery) throws BusinessException {
		
		Integer lastId = null;

		TConceptoPlanilla tConceptoPlanilla = beanUtil.copyBean(model, TConceptoPlanilla.class);
		
		TConceptoPlanillaExample tConceptoPlanillaExample = new TConceptoPlanillaExample();
		tConceptoPlanillaExample.createCriteria().andVar_descrip_conceptoEqualTo(tConceptoPlanilla.getVar_descrip_concepto());
		
		List<TConceptoPlanilla> listTConceptoPlanilla = this.selectByExample(TConceptoPlanillaMapper.class, tConceptoPlanillaExample);
		
		if(!listTConceptoPlanilla.isEmpty()){
			throw new BusinessException("Error, ya existe un CONCEPTO con la descripción enviada.");
		}
		
		this.insertSelective(TConceptoPlanillaMapper.class, tConceptoPlanilla);
		
		
		for (ConceptoAfectoQuery conceptoAfectoQuery : listConceptoAfectoQuery) {
			conceptoAfectoQuery.setSrl_id_afecto_concepto(null);
			conceptoAfectoQuery.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
			TAfectoConcepto tAfectoConcepto = beanUtil.copyBean(conceptoAfectoQuery, TAfectoConcepto.class);
			this.insertSelective(TAfectoConceptoMapper.class, tAfectoConcepto);

			tAfectoConcepto.setSrl_id_afecto_concepto(null);
			tAfectoConcepto.setSrl_id_concepto_planilla(conceptoAfectoQuery.getSrl_id_concepto_planilla_afecto());
			tAfectoConcepto.setSrl_id_concepto_planilla_afecto(conceptoAfectoQuery.getSrl_id_concepto_planilla());
			this.insertSelective(TAfectoConceptoMapper.class, tAfectoConcepto);

		}
		

		for (ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery) {
			conceptoFrecuenciaQuery.setSrl_id_frecuencia(null);
			conceptoFrecuenciaQuery.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
			TFrecuencia tFrecuencia = beanUtil.copyBean(conceptoFrecuenciaQuery, TFrecuencia.class);
			this.insertSelective(TFrecuenciaMapper.class, tFrecuencia);
			TConceptoFrecuencia tConceptoFrecuencia = new TConceptoFrecuencia();
			tConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
			tConceptoFrecuencia.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
			this.insertSelective(TConceptoFrecuenciaMapper.class, tConceptoFrecuencia);

		}
		lastId = tConceptoPlanilla.getSrl_id_concepto_planilla();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarConceptoQuery model, List<ConceptoAfectoQuery> listConceptoAfectoQuery, List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery) throws BusinessException {
	
		TConceptoPlanilla tConceptoPlanilla = beanUtil.copyBean(model, TConceptoPlanilla.class);
		
		TConceptoPlanillaExample tConceptoPlanillaExample = new TConceptoPlanillaExample();
		tConceptoPlanillaExample.createCriteria().andVar_descrip_conceptoEqualTo(tConceptoPlanilla.getVar_descrip_concepto()).
		andSrl_id_concepto_planillaNotEqualTo(tConceptoPlanilla.getSrl_id_concepto_planilla());
		
		List<TConceptoPlanilla> listTConceptoPlanilla = this.selectByExample(TConceptoPlanillaMapper.class, tConceptoPlanillaExample);
		
		if(!listTConceptoPlanilla.isEmpty()){
			throw new BusinessException("Error, ya existe un CONCEPTO con la descripción enviada.");
		}
		
		this.updateByPrimaryKeySelective(TConceptoPlanillaMapper.class, tConceptoPlanilla);
		
		/* Start TAfectoConcepto */
		
		TAfectoConceptoExample tAfectoConceptoExample = new TAfectoConceptoExample();
		tAfectoConceptoExample.createCriteria().andSrl_id_concepto_planillaEqualTo(tConceptoPlanilla.getSrl_id_concepto_planilla());
		List<TAfectoConcepto> listTAfectoConceptoCurrent = this.selectByExample(TAfectoConceptoMapper.class, tAfectoConceptoExample);
		List<TAfectoConcepto> listTAfectoConceptoDeleted = new ArrayList<TAfectoConcepto>();
		
		for (TAfectoConcepto tAfectoConcepto : listTAfectoConceptoCurrent) {
			boolean noExists = true;
			for (ConceptoAfectoQuery conceptoAfectoQuery : listConceptoAfectoQuery) {
				if(conceptoAfectoQuery.getSrl_id_afecto_concepto().equals(tAfectoConcepto.getSrl_id_afecto_concepto())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTAfectoConceptoDeleted.add(tAfectoConcepto);
			}
		}
		

//		this.deleteByPrimaryKey(TAfectoConceptoMapper.class, listTAfectoConceptoDeleted);
		for (TAfectoConcepto ta : listTAfectoConceptoDeleted) {
			this.deleteByPrimaryKey(TAfectoConceptoMapper.class, ta);
			TAfectoConceptoExample example = new TAfectoConceptoExample();
			example.createCriteria().
			andSrl_id_concepto_planilla_afectoEqualTo(ta.getSrl_id_concepto_planilla()).
			andSrl_id_concepto_planillaEqualTo(ta.getSrl_id_concepto_planilla_afecto());
			tAfectoConceptoMapper.deleteByExample(example);
		}

		for (ConceptoAfectoQuery conceptoAfectoQuery : listConceptoAfectoQuery) {
			if(conceptoAfectoQuery.getSrl_id_afecto_concepto() < 1){
				conceptoAfectoQuery.setSrl_id_afecto_concepto(null);
				conceptoAfectoQuery.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
				TAfectoConcepto tAfectoConcepto = beanUtil.copyBean(conceptoAfectoQuery, TAfectoConcepto.class);
				this.insertSelective(TAfectoConceptoMapper.class, tAfectoConcepto);

				tAfectoConcepto.setSrl_id_afecto_concepto(null);
				tAfectoConcepto.setSrl_id_concepto_planilla(conceptoAfectoQuery.getSrl_id_concepto_planilla_afecto());
				tAfectoConcepto.setSrl_id_concepto_planilla_afecto(conceptoAfectoQuery.getSrl_id_concepto_planilla());
				this.insertSelective(TAfectoConceptoMapper.class, tAfectoConcepto);

			}else{
				TAfectoConcepto tAfectoConcepto = beanUtil.copyBean(conceptoAfectoQuery, TAfectoConcepto.class);
				this.updateByPrimaryKeySelective(TAfectoConceptoMapper.class, tAfectoConcepto);

				TAfectoConcepto tau = beanUtil.copyBean(tAfectoConcepto, TAfectoConcepto.class);
				tau.setSrl_id_afecto_concepto(null);
				tau.setSrl_id_concepto_planilla(conceptoAfectoQuery.getSrl_id_concepto_planilla_afecto());
				tau.setSrl_id_concepto_planilla_afecto(conceptoAfectoQuery.getSrl_id_concepto_planilla());

				TAfectoConceptoExample example = new TAfectoConceptoExample();
				example.createCriteria().
				andSrl_id_concepto_planilla_afectoEqualTo(tAfectoConcepto.getSrl_id_concepto_planilla()).
				andSrl_id_concepto_planillaEqualTo(tAfectoConcepto.getSrl_id_concepto_planilla_afecto());
				tAfectoConceptoMapper.updateByExampleSelective(tau, example);

			}
		}
		/* End TAfectoConcepto */	
		/* Start TConceptoFrecuencia */
		
		TConceptoFrecuenciaExample tFrecuenciaConceptoExample = new TConceptoFrecuenciaExample();
		tFrecuenciaConceptoExample.createCriteria().andSrl_id_concepto_planillaEqualTo(tConceptoPlanilla.getSrl_id_concepto_planilla());
		List<TConceptoFrecuencia> listTConceptoFrecuenciaCurrent = this.selectByExample(TConceptoFrecuenciaMapper.class, tFrecuenciaConceptoExample);
		List<TConceptoFrecuencia> listTConceptoFrecuenciaDeleted = new ArrayList<TConceptoFrecuencia>();
		
		for (TConceptoFrecuencia tFrecuenciaConcepto : listTConceptoFrecuenciaCurrent) {
			boolean noExists = true;
			for (ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery) {
				if(conceptoFrecuenciaQuery.getSrl_id_frecuencia().equals(tFrecuenciaConcepto.getSrl_id_frecuencia())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConceptoFrecuenciaDeleted.add(tFrecuenciaConcepto);
			}
		}

//		this.deleteByPrimaryKey(TConceptoFrecuenciaMapper.class, listTConceptoFrecuenciaDeleted);
		for (TConceptoFrecuencia tConceptoFrecuencia : listTConceptoFrecuenciaDeleted) {
			this.deleteByPrimaryKey(TConceptoFrecuenciaMapper.class, tConceptoFrecuencia);
			TFrecuenciaKey tFrecuenciaKey = new TFrecuenciaKey();
			tFrecuenciaKey.setSrl_id_frecuencia(tConceptoFrecuencia.getSrl_id_frecuencia());
			this.deleteByPrimaryKey(TFrecuenciaMapper.class, tFrecuenciaKey);
		}
	
		for (ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery) {
			if(conceptoFrecuenciaQuery.getSrl_id_frecuencia() < 1){
				conceptoFrecuenciaQuery.setSrl_id_frecuencia(null);
				conceptoFrecuenciaQuery.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());

				TFrecuencia tFrecuencia = beanUtil.copyBean(conceptoFrecuenciaQuery, TFrecuencia.class);
				this.insertSelective(TFrecuenciaMapper.class, tFrecuencia);
				TConceptoFrecuencia tConceptoFrecuencia = new TConceptoFrecuencia();
				tConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
				tConceptoFrecuencia.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
				this.insertSelective(TConceptoFrecuenciaMapper.class, tConceptoFrecuencia);

			}else{

				TFrecuencia tFrecuencia = beanUtil.copyBean(conceptoFrecuenciaQuery, TFrecuencia.class);
				this.updateByPrimaryKeySelective(TFrecuenciaMapper.class, tFrecuencia);
				TConceptoFrecuencia tConceptoFrecuencia = new TConceptoFrecuencia();
				tConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
				tConceptoFrecuencia.setSrl_id_concepto_planilla(tConceptoPlanilla.getSrl_id_concepto_planilla());
				this.updateByPrimaryKeySelective(TConceptoFrecuenciaMapper.class, tConceptoFrecuencia);

			}
		}
		/* End TConceptoFrecuencia */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarConceptoQuery model, List<ConceptoAfectoQuery> listConceptoAfectoQuery, List<ConceptoFrecuenciaQuery> listConceptoFrecuenciaQuery) throws BusinessException {
	
		for (ConceptoAfectoQuery conceptoAfectoQuery : listConceptoAfectoQuery) {
			TAfectoConcepto tAfectoConcepto = beanUtil.copyBean(conceptoAfectoQuery, TAfectoConcepto.class);
			this.deleteByPrimaryKey(TAfectoConceptoMapper.class, tAfectoConcepto);

			TAfectoConceptoExample example = new TAfectoConceptoExample();
			example.createCriteria().
			andSrl_id_concepto_planilla_afectoEqualTo(tAfectoConcepto.getSrl_id_concepto_planilla()).
			andSrl_id_concepto_planillaEqualTo(tAfectoConcepto.getSrl_id_concepto_planilla_afecto());
			tAfectoConceptoMapper.deleteByExample(example);

		}
		for (ConceptoFrecuenciaQuery conceptoFrecuenciaQuery : listConceptoFrecuenciaQuery) {

			TConceptoFrecuencia tConceptoFrecuencia = new TConceptoFrecuencia();
			tConceptoFrecuencia.setSrl_id_frecuencia(conceptoFrecuenciaQuery.getSrl_id_frecuencia());
			tConceptoFrecuencia.setSrl_id_concepto_planilla(conceptoFrecuenciaQuery.getSrl_id_concepto_planilla());
			this.deleteByPrimaryKey(TConceptoFrecuenciaMapper.class, tConceptoFrecuencia);
			TFrecuencia tFrecuencia = beanUtil.copyBean(conceptoFrecuenciaQuery, TFrecuencia.class);
			this.deleteByPrimaryKey(TFrecuenciaMapper.class, tFrecuencia);

		}

		TConceptoPlanilla tConceptoPlanilla = beanUtil.copyBean(model, TConceptoPlanilla.class);
		this.deleteByPrimaryKey(TConceptoPlanillaMapper.class, tConceptoPlanilla);
	}

}
