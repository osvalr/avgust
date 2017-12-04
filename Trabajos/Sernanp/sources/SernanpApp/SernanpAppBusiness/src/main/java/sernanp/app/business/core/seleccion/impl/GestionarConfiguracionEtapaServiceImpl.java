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
* DATE CREATE : 18/04/2015 19:13:57
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

import sernanp.app.business.core.seleccion.service.GestionarConfiguracionEtapaService;
import sernanp.app.dao.query.domain.GestionarConfiguarionEtapaQuery;


import sernanp.app.dao.domain.TConfiguracionEvaluacionPersonal;
import sernanp.app.dao.mapper.TConfiguracionEvaluacionPersonalMapper;

import sernanp.app.dao.query.domain.ConfiguracionEtapaQuery;
import sernanp.app.dao.domain.TConfiguracionEtapa;
import sernanp.app.dao.mapper.TConfiguracionEtapaMapper;
import sernanp.app.dao.domain.TConfiguracionEtapaExample;

@Service
public class GestionarConfiguracionEtapaServiceImpl extends HelperServiceMybatisImpl implements GestionarConfiguracionEtapaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarConfiguarionEtapaQuery model, List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery) throws BusinessException {
		
		Integer lastId = null;

		TConfiguracionEvaluacionPersonal tConfiguracionEvaluacionPersonal = beanUtil.copyBean(model, TConfiguracionEvaluacionPersonal.class);
		this.insertSelective(TConfiguracionEvaluacionPersonalMapper.class, tConfiguracionEvaluacionPersonal);
		
		/*
		if(listConfiguracionEtapaQuery == null){
			throw new BusinessException("Error, no existen registros en TConfiguracionEtapa.");
		}else if(listConfiguracionEtapaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TConfiguracionEtapa.");
		}
		*/

		for (ConfiguracionEtapaQuery configuracionEtapaQuery : listConfiguracionEtapaQuery) {
			configuracionEtapaQuery.setSrl_id_configuracion_etapa(null);
			configuracionEtapaQuery.setSrl_id_configuracion_evaluacion_personal(tConfiguracionEvaluacionPersonal.getSrl_id_configuracion_evaluacion_personal());
			TConfiguracionEtapa tConfiguracionEtapa = beanUtil.copyBean(configuracionEtapaQuery, TConfiguracionEtapa.class);
			this.insertSelective(TConfiguracionEtapaMapper.class, tConfiguracionEtapa);
		}
		lastId = tConfiguracionEvaluacionPersonal.getSrl_id_configuracion_evaluacion_personal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarConfiguarionEtapaQuery model, List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery) throws BusinessException {
	
		TConfiguracionEvaluacionPersonal tConfiguracionEvaluacionPersonal = beanUtil.copyBean(model, TConfiguracionEvaluacionPersonal.class);
		this.updateByPrimaryKeySelective(TConfiguracionEvaluacionPersonalMapper.class, tConfiguracionEvaluacionPersonal);
		
		/* Start TConfiguracionEtapa */
		/*
		if(listConfiguracionEtapaQuery == null){
			throw new BusinessException("Error, no existen registros en TConfiguracionEtapa.");
		}else if(listConfiguracionEtapaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TConfiguracionEtapa.");
		}
		*/

		TConfiguracionEtapaExample tConfiguracionEtapaExample = new TConfiguracionEtapaExample();
		tConfiguracionEtapaExample.createCriteria().andSrl_id_configuracion_evaluacion_personalEqualTo(tConfiguracionEvaluacionPersonal.getSrl_id_configuracion_evaluacion_personal());
		List<TConfiguracionEtapa> listTConfiguracionEtapaCurrent = this.selectByExample(TConfiguracionEtapaMapper.class, tConfiguracionEtapaExample);
		List<TConfiguracionEtapa> listTConfiguracionEtapaDeleted = new ArrayList<TConfiguracionEtapa>();
		
		for (TConfiguracionEtapa tConfiguracionEtapa : listTConfiguracionEtapaCurrent) {
			boolean noExists = true;
			for (ConfiguracionEtapaQuery configuracionEtapaQuery : listConfiguracionEtapaQuery) {
				if(configuracionEtapaQuery.getSrl_id_configuracion_etapa().equals(tConfiguracionEtapa.getSrl_id_configuracion_etapa())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConfiguracionEtapaDeleted.add(tConfiguracionEtapa);
			}
		}
		
		this.deleteByPrimaryKey(TConfiguracionEtapaMapper.class, listTConfiguracionEtapaDeleted);
		
		for (ConfiguracionEtapaQuery configuracionEtapaQuery : listConfiguracionEtapaQuery) {
			if(configuracionEtapaQuery.getSrl_id_configuracion_etapa() < 1){
				configuracionEtapaQuery.setSrl_id_configuracion_etapa(null);
				configuracionEtapaQuery.setSrl_id_configuracion_evaluacion_personal(tConfiguracionEvaluacionPersonal.getSrl_id_configuracion_evaluacion_personal());
				TConfiguracionEtapa tConfiguracionEtapa = beanUtil.copyBean(configuracionEtapaQuery, TConfiguracionEtapa.class);
				this.insertSelective(TConfiguracionEtapaMapper.class, tConfiguracionEtapa);
			}else{
				TConfiguracionEtapa tConfiguracionEtapa = beanUtil.copyBean(configuracionEtapaQuery, TConfiguracionEtapa.class);
				this.updateByPrimaryKeySelective(TConfiguracionEtapaMapper.class, tConfiguracionEtapa);
			}
		}
		/* End TConfiguracionEtapa */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarConfiguarionEtapaQuery model, List<ConfiguracionEtapaQuery> listConfiguracionEtapaQuery) throws BusinessException {
	
		for (ConfiguracionEtapaQuery configuracionEtapaQuery : listConfiguracionEtapaQuery) {
			TConfiguracionEtapa tConfiguracionEtapa = beanUtil.copyBean(configuracionEtapaQuery, TConfiguracionEtapa.class);
			this.deleteByPrimaryKey(TConfiguracionEtapaMapper.class, tConfiguracionEtapa);
		}

		TConfiguracionEvaluacionPersonal tConfiguracionEvaluacionPersonal = beanUtil.copyBean(model, TConfiguracionEvaluacionPersonal.class);
		this.deleteByPrimaryKey(TConfiguracionEvaluacionPersonalMapper.class, tConfiguracionEvaluacionPersonal);
	}

}
