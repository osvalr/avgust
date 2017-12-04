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
* DATE CREATE : 12/04/2015 20:29:10
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.planilla.service.GestionarAsignarConceptoService;
import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicial;
import sernanp.app.dao.domain.TBeneficiarioDescuentoJudicialExample;
import sernanp.app.dao.domain.TFrecuencia;
import sernanp.app.dao.domain.TFrecuenciaKey;
import sernanp.app.dao.domain.TPersonalConcepto;
import sernanp.app.dao.domain.TPersonalConceptoAfecto;
import sernanp.app.dao.domain.TPersonalConceptoAfectoExample;
import sernanp.app.dao.domain.TPersonalConceptoExample;
import sernanp.app.dao.domain.TPersonalConceptoFrecuencia;
import sernanp.app.dao.domain.TPersonalConceptoFrecuenciaExample;
import sernanp.app.dao.domain.TPersonalConceptoFrecuenciaKey;
import sernanp.app.dao.domain.TPersonalConceptoKey;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.domain.TPersonalContratoKey;
import sernanp.app.dao.domain.TSuspensionCuartaCategoria;
import sernanp.app.dao.domain.TSuspensionCuartaCategoriaExample;
import sernanp.app.dao.mapper.PersonalMapper;
import sernanp.app.dao.mapper.TBeneficiarioDescuentoJudicialMapper;
import sernanp.app.dao.mapper.TFrecuenciaMapper;
import sernanp.app.dao.mapper.TPersonalConceptoAfectoMapper;
import sernanp.app.dao.mapper.TPersonalConceptoFrecuenciaMapper;
import sernanp.app.dao.mapper.TPersonalConceptoMapper;
import sernanp.app.dao.mapper.TPersonalContratoMapper;
import sernanp.app.dao.mapper.TSuspensionCuartaCategoriaMapper;
import sernanp.app.dao.query.domain.BeneficiarioDescuentoJudicialQuery;
import sernanp.app.dao.query.domain.ConceptoPersonalQuery;
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQuery;
import sernanp.app.dao.query.domain.PersonalConceptoAfectoQuery;
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQuery;
import sernanp.app.dao.query.domain.PersonalInfoContratoQuery;
import sernanp.app.dao.query.domain.SuspensionCuartaCategoriaQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarAsignarConceptoServiceImpl extends HelperServiceMybatisImpl implements GestionarAsignarConceptoService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public void save(GestionarAsignarConceptoQuery model, List<ConceptoPersonalQuery> listConceptoPersonalQuery, List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery,List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery, List<SuspensionCuartaCategoriaQuery> listSuspensionCuartaCategoriaQuery, List<BeneficiarioDescuentoJudicialQuery> listBeneficiarioDescuentoJudicialQuery,List<PersonalInfoContratoQuery> listPersonalInfoContratoQuery) throws BusinessException {
	
		Personal personal = beanUtil.copyBean(model, Personal.class);
		this.updateByPrimaryKeySelective(PersonalMapper.class, personal);
		
		/* Start TPersonalConcepto */
		TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
		tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personal.getIdpersonal());
		List<TPersonalConcepto> listTPersonalConceptoCurrent = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
		List<TPersonalConcepto> listTPersonalConceptoDeleted = new ArrayList<TPersonalConcepto>();
		
		for (TPersonalConcepto tPersonalConcepto : listTPersonalConceptoCurrent) {
			boolean noExists = true;
			for (ConceptoPersonalQuery conceptoPersonalQuery : listConceptoPersonalQuery) {
				if(conceptoPersonalQuery.getSrl_id_personal_concepto().equals(tPersonalConcepto.getSrl_id_personal_concepto())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTPersonalConceptoDeleted.add(tPersonalConcepto);
			}
		}
		
		for(TPersonalConcepto tPersonalConcepto: listTPersonalConceptoDeleted){
			this.removeFrecuencia(tPersonalConcepto);
			this.removeAfecto(tPersonalConcepto);
			this.deleteByPrimaryKey(TPersonalConceptoMapper.class, tPersonalConcepto);
		}
		
		for (ConceptoPersonalQuery conceptoPersonalQuery : listConceptoPersonalQuery) {
			
			if(conceptoPersonalQuery.getSrl_id_personal_concepto() < 1){
				
				conceptoPersonalQuery.setSrl_id_personal_concepto(null);
				conceptoPersonalQuery.setIdpersonal(personal.getIdpersonal());
				TPersonalConcepto tPersonalConcepto = beanUtil.copyBean(conceptoPersonalQuery, TPersonalConcepto.class);
				this.insertSelective(TPersonalConceptoMapper.class, tPersonalConcepto);
				this.createFrecuencia(tPersonalConcepto, conceptoPersonalQuery.getListPersonalConceptoFrecuenciaQuery());
				this.createAfecto(tPersonalConcepto, conceptoPersonalQuery.getListPersonalConceptoAfectoQuery());
				
			}else{
				
				TPersonalConceptoKey tPersonalConceptoKey = new TPersonalConceptoKey();
				tPersonalConceptoKey.setSrl_id_personal_concepto(conceptoPersonalQuery.getSrl_id_personal_concepto());
				
				TPersonalConcepto tPersonalConcepto = this.selectByPrimaryKey(TPersonalConceptoMapper.class, tPersonalConceptoKey);
				tPersonalConcepto = beanUtil.copyBean(conceptoPersonalQuery, TPersonalConcepto.class);
				this.updateByPrimaryKeySelective(TPersonalConceptoMapper.class, tPersonalConcepto);
				this.saveFrecuencia(tPersonalConcepto, conceptoPersonalQuery.getListPersonalConceptoFrecuenciaQuery());
				this.saveAfecto(tPersonalConcepto, conceptoPersonalQuery.getListPersonalConceptoAfectoQuery());
			}
			
		}
		/* End TPersonalConcepto */
	
		/* Start TSuspensionCuartaCategoria */
		
		TSuspensionCuartaCategoriaExample tSuspensionCuartaCategoriaExample = new TSuspensionCuartaCategoriaExample();
		tSuspensionCuartaCategoriaExample.createCriteria().andIdpersonalEqualTo(personal.getIdpersonal());
		List<TSuspensionCuartaCategoria> listTSuspensionCuartaCategoriaCurrent = this.selectByExample(TSuspensionCuartaCategoriaMapper.class, tSuspensionCuartaCategoriaExample);
		List<TSuspensionCuartaCategoria> listTSuspensionCuartaCategoriaDeleted = new ArrayList<TSuspensionCuartaCategoria>();
		
		for (TSuspensionCuartaCategoria tSuspensionCuartaCategoria : listTSuspensionCuartaCategoriaCurrent) {
			boolean noExists = true;
			for (SuspensionCuartaCategoriaQuery suspensionCuartaCategoriaQuery : listSuspensionCuartaCategoriaQuery) {
				if(suspensionCuartaCategoriaQuery.getSrl_id_suspension_cuarta_categoria().equals(tSuspensionCuartaCategoria.getSrl_id_suspension_cuarta_categoria())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTSuspensionCuartaCategoriaDeleted.add(tSuspensionCuartaCategoria);
			}
		}
		
		this.deleteByPrimaryKey(TSuspensionCuartaCategoriaMapper.class, listTSuspensionCuartaCategoriaDeleted);
		
		for (SuspensionCuartaCategoriaQuery suspensionCuartaCategoriaQuery : listSuspensionCuartaCategoriaQuery) {
			if(suspensionCuartaCategoriaQuery.getSrl_id_suspension_cuarta_categoria() < 1){
				suspensionCuartaCategoriaQuery.setSrl_id_suspension_cuarta_categoria(null);
				suspensionCuartaCategoriaQuery.setIdpersonal(personal.getIdpersonal());
				TSuspensionCuartaCategoria tSuspensionCuartaCategoria = beanUtil.copyBean(suspensionCuartaCategoriaQuery, TSuspensionCuartaCategoria.class);
				this.insertSelective(TSuspensionCuartaCategoriaMapper.class, tSuspensionCuartaCategoria);
			}else{
				TSuspensionCuartaCategoria tSuspensionCuartaCategoria = beanUtil.copyBean(suspensionCuartaCategoriaQuery, TSuspensionCuartaCategoria.class);
				this.updateByPrimaryKeySelective(TSuspensionCuartaCategoriaMapper.class, tSuspensionCuartaCategoria);
			}
		}
		/* End TSuspensionCuartaCategoria */
		
		/* Start TPersonalContrato */
		
		
		for (PersonalInfoContratoQuery personalInfoContratoQuery : listPersonalInfoContratoQuery) {
			
				TPersonalContratoKey pk = new TPersonalContratoKey();
				pk.setSrl_id_contrato(personalInfoContratoQuery.getSrl_id_contrato());
				
				TPersonalContrato tPersonalContrato = this.selectByPrimaryKey(TPersonalContratoMapper.class, pk);
				tPersonalContrato.setVar_ubicacion_fisica(personalInfoContratoQuery.getVar_ubicacion_fisica());
				
				this.updateByPrimaryKeySelective(TPersonalContratoMapper.class, tPersonalContrato);
			
		}
		/* End TPersonalContrato */
		
		/* Start TBeneficiarioDescuentoJudicial */
		

		TBeneficiarioDescuentoJudicialExample tBeneficiarioDescuentoJudicialExample = new TBeneficiarioDescuentoJudicialExample();
		tBeneficiarioDescuentoJudicialExample.createCriteria().andIdpersonalEqualTo(personal.getIdpersonal());
		List<TBeneficiarioDescuentoJudicial> listTBeneficiarioDescuentoJudicialCurrent = this.selectByExample(TBeneficiarioDescuentoJudicialMapper.class, tBeneficiarioDescuentoJudicialExample);
		List<TBeneficiarioDescuentoJudicial> listTBeneficiarioDescuentoJudicialDeleted = new ArrayList<TBeneficiarioDescuentoJudicial>();
		
		for (TBeneficiarioDescuentoJudicial tBeneficiarioDescuentoJudicial : listTBeneficiarioDescuentoJudicialCurrent) {
			boolean noExists = true;
			for (BeneficiarioDescuentoJudicialQuery beneficiarioDescuentoJudicialQuery : listBeneficiarioDescuentoJudicialQuery) {
				if(beneficiarioDescuentoJudicialQuery.getSrl_id_beneficiario_descuento_judicial().equals(tBeneficiarioDescuentoJudicial.getSrl_id_beneficiario_descuento_judicial())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTBeneficiarioDescuentoJudicialDeleted.add(tBeneficiarioDescuentoJudicial);
			}
		}
		
		this.deleteByPrimaryKey(TBeneficiarioDescuentoJudicialMapper.class, listTBeneficiarioDescuentoJudicialDeleted);
		
		for (BeneficiarioDescuentoJudicialQuery beneficiarioDescuentoJudicialQuery : listBeneficiarioDescuentoJudicialQuery) {
			if(beneficiarioDescuentoJudicialQuery.getSrl_id_beneficiario_descuento_judicial() < 1){
				beneficiarioDescuentoJudicialQuery.setSrl_id_beneficiario_descuento_judicial(null);
				beneficiarioDescuentoJudicialQuery.setIdpersonal(personal.getIdpersonal());
				TBeneficiarioDescuentoJudicial tBeneficiarioDescuentoJudicial = beanUtil.copyBean(beneficiarioDescuentoJudicialQuery, TBeneficiarioDescuentoJudicial.class);
				this.insertSelective(TBeneficiarioDescuentoJudicialMapper.class, tBeneficiarioDescuentoJudicial);
			}else{
				TBeneficiarioDescuentoJudicial tBeneficiarioDescuentoJudicial = beanUtil.copyBean(beneficiarioDescuentoJudicialQuery, TBeneficiarioDescuentoJudicial.class);
				this.updateByPrimaryKeySelective(TBeneficiarioDescuentoJudicialMapper.class, tBeneficiarioDescuentoJudicial);
			}
		}
		/* End TBeneficiarioDescuentoJudicial */	
		
	}
	
	@Transactional
	public void saveFrecuencia(TPersonalConcepto tPersonalConcepto, List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery){
		
		if(listPersonalConceptoFrecuenciaQuery != null){
			
			TPersonalConceptoFrecuenciaExample tPersonalConceptoFrecuenciaExample = new TPersonalConceptoFrecuenciaExample();
			tPersonalConceptoFrecuenciaExample.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto());
			List<TPersonalConceptoFrecuencia> listTPersonalConceptoFrecuenciaCurrent = this.selectByExample(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuenciaExample);
			List<TPersonalConceptoFrecuencia> listTPersonalConceptoFrecuenciaDeleted = new ArrayList<TPersonalConceptoFrecuencia>();
			
			for (TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia : listTPersonalConceptoFrecuenciaCurrent) {
				boolean noExists = true;
				for (PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery) {
					if(personalConceptoFrecuenciaQuery.getSrl_id_frecuencia().equals(tPersonalConceptoFrecuencia.getSrl_id_frecuencia())){
						noExists = false;
						break;
					}
				}
				if(noExists){
					listTPersonalConceptoFrecuenciaDeleted.add(tPersonalConceptoFrecuencia);
				}
			}
			
			this.deleteByPrimaryKey(TPersonalConceptoFrecuenciaMapper.class, listTPersonalConceptoFrecuenciaDeleted);
			for(TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia : listTPersonalConceptoFrecuenciaDeleted){
				TPersonalConceptoFrecuenciaKey tPersonalConceptoFrecuenciaKey = new TPersonalConceptoFrecuenciaKey();
				tPersonalConceptoFrecuenciaKey.setSrl_id_frecuencia(tPersonalConceptoFrecuencia.getSrl_id_frecuencia());
				this.deleteByPrimaryKey(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuenciaKey);
				TFrecuenciaKey tFrecuenciaKey = new TFrecuenciaKey();
				tFrecuenciaKey.setSrl_id_frecuencia(tPersonalConceptoFrecuencia.getSrl_id_frecuencia());
				this.deleteByPrimaryKey(TFrecuenciaMapper.class, tFrecuenciaKey);
			}
			
			for (PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery) {
				if(personalConceptoFrecuenciaQuery.getSrl_id_frecuencia() < 1){
					TFrecuencia tFrecuencia = beanUtil.copyBean(personalConceptoFrecuenciaQuery, TFrecuencia.class);
					this.insertSelective(TFrecuenciaMapper.class, tFrecuencia);
					TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia = new TPersonalConceptoFrecuencia();
					tPersonalConceptoFrecuencia.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
					tPersonalConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
					this.insertSelective(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuencia);
				}else{
					TFrecuencia tFrecuencia = beanUtil.copyBean(personalConceptoFrecuenciaQuery, TFrecuencia.class);
					this.updateByPrimaryKeySelective(TFrecuenciaMapper.class, tFrecuencia);
					TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia = new TPersonalConceptoFrecuencia();
					tPersonalConceptoFrecuencia.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
					tPersonalConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
					this.updateByPrimaryKeySelective(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuencia);
				}
			}
		}
		
	}
	
	@Transactional
	public void createFrecuencia(TPersonalConcepto tPersonalConcepto, List<PersonalConceptoFrecuenciaQuery> listPersonalConceptoFrecuenciaQuery){
		
		for (PersonalConceptoFrecuenciaQuery personalConceptoFrecuenciaQuery : listPersonalConceptoFrecuenciaQuery) {
			TFrecuencia tFrecuencia = beanUtil.copyBean(personalConceptoFrecuenciaQuery, TFrecuencia.class);
			this.insertSelective(TFrecuenciaMapper.class, tFrecuencia);
			TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia = new TPersonalConceptoFrecuencia();
			tPersonalConceptoFrecuencia.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
			tPersonalConceptoFrecuencia.setSrl_id_frecuencia(tFrecuencia.getSrl_id_frecuencia());
			this.insertSelective(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuencia);
		}
		
	}
	
	@Transactional
	public void removeFrecuencia(TPersonalConcepto tPersonalConcepto){
			
		TPersonalConceptoFrecuenciaExample example = new TPersonalConceptoFrecuenciaExample();
		example.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto());
			
		List<TPersonalConceptoFrecuencia> listTPersonalConceptoFrecuencia = this.selectByExample(TPersonalConceptoFrecuenciaMapper.class, example);
		for(TPersonalConceptoFrecuencia tPersonalConceptoFrecuencia : listTPersonalConceptoFrecuencia){
			this.deleteByPrimaryKey(TPersonalConceptoFrecuenciaMapper.class, tPersonalConceptoFrecuencia);
			TFrecuenciaKey tFrecuenciaKey = new TFrecuenciaKey();
			tFrecuenciaKey.setSrl_id_frecuencia(tPersonalConceptoFrecuencia.getSrl_id_frecuencia());
			this.deleteByPrimaryKey(TFrecuenciaMapper.class, tFrecuenciaKey);
		}
				
	}
	
	@Transactional
	public void saveAfecto(TPersonalConcepto tPersonalConcepto, List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery){
		
		if(listPersonalConceptoAfectoQuery != null){
			
			TPersonalConceptoAfectoExample tPersonalConceptoAfectoExample = new TPersonalConceptoAfectoExample();
			tPersonalConceptoAfectoExample.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto());
			List<TPersonalConceptoAfecto> listTPersonalConceptoAfectoCurrent = this.selectByExample(TPersonalConceptoAfectoMapper.class, tPersonalConceptoAfectoExample);
			List<TPersonalConceptoAfecto> listTPersonalConceptoAfectoDeleted = new ArrayList<TPersonalConceptoAfecto>();
			
			for (TPersonalConceptoAfecto tPersonalConceptoAfecto : listTPersonalConceptoAfectoCurrent) {
				boolean noExists = true;
				for (PersonalConceptoAfectoQuery personalConceptoAfectoQuery : listPersonalConceptoAfectoQuery) {
					if(personalConceptoAfectoQuery.getSrl_id_personal_concepto_afecto().equals(tPersonalConceptoAfecto.getSrl_id_personal_concepto_afecto())){
						noExists = false;
						break;
					}
				}
				if(noExists){
					listTPersonalConceptoAfectoDeleted.add(tPersonalConceptoAfecto);
				}
			}
			
			this.deleteByPrimaryKey(TPersonalConceptoAfectoMapper.class, listTPersonalConceptoAfectoDeleted);
			
			for (PersonalConceptoAfectoQuery personalConceptoAfectoQuery : listPersonalConceptoAfectoQuery) {
				if(personalConceptoAfectoQuery.getSrl_id_personal_concepto_afecto() < 1){
					TPersonalConceptoAfecto tPersonalConceptoAfecto  = beanUtil.copyBean(personalConceptoAfectoQuery, TPersonalConceptoAfecto.class);
					tPersonalConceptoAfecto.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
					this.insertSelective(TPersonalConceptoAfectoMapper.class, tPersonalConceptoAfecto);
				}else{
					TPersonalConceptoAfecto tPersonalConceptoAfecto = beanUtil.copyBean(personalConceptoAfectoQuery, TPersonalConceptoAfecto.class);
					tPersonalConceptoAfecto.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
					this.updateByPrimaryKeySelective(TPersonalConceptoAfectoMapper.class, tPersonalConceptoAfecto);
				}
			}
		}
		
	}
	
	@Transactional
	public void createAfecto(TPersonalConcepto tPersonalConcepto, List<PersonalConceptoAfectoQuery> listPersonalConceptoAfectoQuery){
		
		for (PersonalConceptoAfectoQuery personalConceptoAfectoQuery : listPersonalConceptoAfectoQuery) {
			TPersonalConceptoAfecto tPersonalConceptoAfecto = beanUtil.copyBean(personalConceptoAfectoQuery, TPersonalConceptoAfecto.class);
			tPersonalConceptoAfecto.setSrl_id_personal_concepto(tPersonalConcepto.getSrl_id_personal_concepto());
			this.insertSelective(TPersonalConceptoAfectoMapper.class, tPersonalConceptoAfecto);
		}
		
	}
	
	@Transactional
	public void removeAfecto(TPersonalConcepto tPersonalConcepto){
			
		TPersonalConceptoAfectoExample example = new TPersonalConceptoAfectoExample();
		example.createCriteria().andSrl_id_personal_conceptoEqualTo(tPersonalConcepto.getSrl_id_personal_concepto());
			
		List<TPersonalConceptoAfecto> listTPersonalConceptoAfecto = this.selectByExample(TPersonalConceptoAfectoMapper.class, example);
		for(TPersonalConceptoAfecto tPersonalConceptoAfecto : listTPersonalConceptoAfecto){
			this.deleteByPrimaryKey(TPersonalConceptoAfectoMapper.class, tPersonalConceptoAfecto);
		}
				
	}
}
