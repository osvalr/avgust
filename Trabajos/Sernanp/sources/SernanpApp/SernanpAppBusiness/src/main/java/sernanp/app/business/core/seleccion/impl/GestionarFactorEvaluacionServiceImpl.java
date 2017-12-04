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
* DATE CREATE : 18/04/2015 17:45:06
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.seleccion.service.GestionarFactorEvaluacionService;
import sernanp.app.dao.query.domain.GestionarConfigFactorEvalQuery;


import sernanp.app.dao.domain.TConfiguracionFactorEvaluacion;
import sernanp.app.dao.mapper.TConfiguracionFactorEvaluacionMapper;

import sernanp.app.dao.query.domain.FactorEvaluacionQuery;
import sernanp.app.dao.domain.TFactorEvaluacion;
import sernanp.app.dao.mapper.TFactorEvaluacionMapper;
import sernanp.app.dao.domain.TFactorEvaluacionExample;

@Service
public class GestionarFactorEvaluacionServiceImpl extends HelperServiceMybatisImpl implements GestionarFactorEvaluacionService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarConfigFactorEvalQuery model, List<FactorEvaluacionQuery> listFactorEvaluacionQuery) throws BusinessException {
		
		Integer lastId = null;

		TConfiguracionFactorEvaluacion tConfiguracionFactorEvaluacion = beanUtil.copyBean(model, TConfiguracionFactorEvaluacion.class);
		this.insertSelective(TConfiguracionFactorEvaluacionMapper.class, tConfiguracionFactorEvaluacion);
		
		/*
		if(listFactorEvaluacionQuery == null){
			throw new BusinessException("Error, no existen registros en TFactorEvaluacion.");
		}else if(listFactorEvaluacionQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TFactorEvaluacion.");
		}
		*/

		for (FactorEvaluacionQuery factorEvaluacionQuery : listFactorEvaluacionQuery) {
			factorEvaluacionQuery.setSrl_id_factor_evaluacion(null);
			factorEvaluacionQuery.setSrl_id_configuracion_factor_evaluacion(tConfiguracionFactorEvaluacion.getSrl_id_configuracion_factor_evaluacion());
			TFactorEvaluacion tFactorEvaluacion = beanUtil.copyBean(factorEvaluacionQuery, TFactorEvaluacion.class);
			this.insertSelective(TFactorEvaluacionMapper.class, tFactorEvaluacion);
		}
		lastId = tConfiguracionFactorEvaluacion.getSrl_id_configuracion_factor_evaluacion();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarConfigFactorEvalQuery model, List<FactorEvaluacionQuery> listFactorEvaluacionQuery) throws BusinessException {
	
		TConfiguracionFactorEvaluacion tConfiguracionFactorEvaluacion = beanUtil.copyBean(model, TConfiguracionFactorEvaluacion.class);
		this.updateByPrimaryKeySelective(TConfiguracionFactorEvaluacionMapper.class, tConfiguracionFactorEvaluacion);
		
		/* Start TFactorEvaluacion */
		/*
		if(listFactorEvaluacionQuery == null){
			throw new BusinessException("Error, no existen registros en TFactorEvaluacion.");
		}else if(listFactorEvaluacionQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TFactorEvaluacion.");
		}
		*/

		TFactorEvaluacionExample tFactorEvaluacionExample = new TFactorEvaluacionExample();
		tFactorEvaluacionExample.createCriteria().andSrl_id_configuracion_factor_evaluacionEqualTo(tConfiguracionFactorEvaluacion.getSrl_id_configuracion_factor_evaluacion());
		List<TFactorEvaluacion> listTFactorEvaluacionCurrent = this.selectByExample(TFactorEvaluacionMapper.class, tFactorEvaluacionExample);
		List<TFactorEvaluacion> listTFactorEvaluacionDeleted = new ArrayList<TFactorEvaluacion>();
		
		for (TFactorEvaluacion tFactorEvaluacion : listTFactorEvaluacionCurrent) {
			boolean noExists = true;
			for (FactorEvaluacionQuery factorEvaluacionQuery : listFactorEvaluacionQuery) {
				if(factorEvaluacionQuery.getSrl_id_factor_evaluacion().equals(tFactorEvaluacion.getSrl_id_factor_evaluacion())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTFactorEvaluacionDeleted.add(tFactorEvaluacion);
			}
		}
		
		this.deleteByPrimaryKey(TFactorEvaluacionMapper.class, listTFactorEvaluacionDeleted);
		
		for (FactorEvaluacionQuery factorEvaluacionQuery : listFactorEvaluacionQuery) {
			if(factorEvaluacionQuery.getSrl_id_factor_evaluacion() < 1){
				factorEvaluacionQuery.setSrl_id_factor_evaluacion(null);
				factorEvaluacionQuery.setSrl_id_configuracion_factor_evaluacion(tConfiguracionFactorEvaluacion.getSrl_id_configuracion_factor_evaluacion());
				TFactorEvaluacion tFactorEvaluacion = beanUtil.copyBean(factorEvaluacionQuery, TFactorEvaluacion.class);
				this.insertSelective(TFactorEvaluacionMapper.class, tFactorEvaluacion);
			}else{
				TFactorEvaluacion tFactorEvaluacion = beanUtil.copyBean(factorEvaluacionQuery, TFactorEvaluacion.class);
				this.updateByPrimaryKeySelective(TFactorEvaluacionMapper.class, tFactorEvaluacion);
			}
		}
		/* End TFactorEvaluacion */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarConfigFactorEvalQuery model, List<FactorEvaluacionQuery> listFactorEvaluacionQuery) throws BusinessException {
	
		for (FactorEvaluacionQuery factorEvaluacionQuery : listFactorEvaluacionQuery) {
			TFactorEvaluacion tFactorEvaluacion = beanUtil.copyBean(factorEvaluacionQuery, TFactorEvaluacion.class);
			this.deleteByPrimaryKey(TFactorEvaluacionMapper.class, tFactorEvaluacion);
		}

		TConfiguracionFactorEvaluacion tConfiguracionFactorEvaluacion = beanUtil.copyBean(model, TConfiguracionFactorEvaluacion.class);
		this.deleteByPrimaryKey(TConfiguracionFactorEvaluacionMapper.class, tConfiguracionFactorEvaluacion);
	}

}
