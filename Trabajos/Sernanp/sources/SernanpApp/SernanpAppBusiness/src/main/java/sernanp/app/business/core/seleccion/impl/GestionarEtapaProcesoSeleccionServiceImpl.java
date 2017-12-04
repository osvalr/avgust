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
* DATE CREATE : 18/04/2015 18:55:24
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

import sernanp.app.business.core.seleccion.service.GestionarEtapaProcesoSeleccionService;
import sernanp.app.dao.query.domain.GestionarEtapasProcesoSeleccionQuery;


import sernanp.app.dao.domain.TEtapaProcesoSeleccion;
import sernanp.app.dao.mapper.TEtapaProcesoSeleccionMapper;

import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQuery;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccion;
import sernanp.app.dao.mapper.TSubetapaProcesoSeleccionMapper;
import sernanp.app.dao.domain.TSubetapaProcesoSeleccionExample;

@Service
public class GestionarEtapaProcesoSeleccionServiceImpl extends HelperServiceMybatisImpl implements GestionarEtapaProcesoSeleccionService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarEtapasProcesoSeleccionQuery model, List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery) throws BusinessException {
		
		Integer lastId = null;

		TEtapaProcesoSeleccion tEtapaProcesoSeleccion = beanUtil.copyBean(model, TEtapaProcesoSeleccion.class);
		this.insertSelective(TEtapaProcesoSeleccionMapper.class, tEtapaProcesoSeleccion);
		
		/*
		if(listSubEtapaProcesoSelecionQuery == null){
			throw new BusinessException("Error, no existen registros en TSubetapaProcesoSeleccion.");
		}else if(listSubEtapaProcesoSelecionQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TSubetapaProcesoSeleccion.");
		}
		*/

		for (SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery : listSubEtapaProcesoSelecionQuery) {
			subEtapaProcesoSelecionQuery.setSrl_id_subetapa_proceso_seleccion(null);
			subEtapaProcesoSelecionQuery.setSrl_id_etapa_proceso_seleccion(tEtapaProcesoSeleccion.getSrl_id_etapa_proceso_seleccion());
			TSubetapaProcesoSeleccion tSubetapaProcesoSeleccion = beanUtil.copyBean(subEtapaProcesoSelecionQuery, TSubetapaProcesoSeleccion.class);
			this.insertSelective(TSubetapaProcesoSeleccionMapper.class, tSubetapaProcesoSeleccion);
		}
		lastId = tEtapaProcesoSeleccion.getSrl_id_etapa_proceso_seleccion();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarEtapasProcesoSeleccionQuery model, List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery) throws BusinessException {
	
		TEtapaProcesoSeleccion tEtapaProcesoSeleccion = beanUtil.copyBean(model, TEtapaProcesoSeleccion.class);
		this.updateByPrimaryKeySelective(TEtapaProcesoSeleccionMapper.class, tEtapaProcesoSeleccion);
		
		/* Start TSubetapaProcesoSeleccion */
		/*
		if(listSubEtapaProcesoSelecionQuery == null){
			throw new BusinessException("Error, no existen registros en TSubetapaProcesoSeleccion.");
		}else if(listSubEtapaProcesoSelecionQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TSubetapaProcesoSeleccion.");
		}
		*/

		TSubetapaProcesoSeleccionExample tSubetapaProcesoSeleccionExample = new TSubetapaProcesoSeleccionExample();
		tSubetapaProcesoSeleccionExample.createCriteria().andSrl_id_etapa_proceso_seleccionEqualTo(tEtapaProcesoSeleccion.getSrl_id_etapa_proceso_seleccion());
		List<TSubetapaProcesoSeleccion> listTSubetapaProcesoSeleccionCurrent = this.selectByExample(TSubetapaProcesoSeleccionMapper.class, tSubetapaProcesoSeleccionExample);
		List<TSubetapaProcesoSeleccion> listTSubetapaProcesoSeleccionDeleted = new ArrayList<TSubetapaProcesoSeleccion>();
		
		for (TSubetapaProcesoSeleccion tSubetapaProcesoSeleccion : listTSubetapaProcesoSeleccionCurrent) {
			boolean noExists = true;
			for (SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery : listSubEtapaProcesoSelecionQuery) {
				if(subEtapaProcesoSelecionQuery.getSrl_id_subetapa_proceso_seleccion().equals(tSubetapaProcesoSeleccion.getSrl_id_subetapa_proceso_seleccion())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTSubetapaProcesoSeleccionDeleted.add(tSubetapaProcesoSeleccion);
			}
		}
		
		this.deleteByPrimaryKey(TSubetapaProcesoSeleccionMapper.class, listTSubetapaProcesoSeleccionDeleted);
		
		for (SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery : listSubEtapaProcesoSelecionQuery) {
			if(subEtapaProcesoSelecionQuery.getSrl_id_subetapa_proceso_seleccion() < 1){
				subEtapaProcesoSelecionQuery.setSrl_id_subetapa_proceso_seleccion(null);
				subEtapaProcesoSelecionQuery.setSrl_id_etapa_proceso_seleccion(tEtapaProcesoSeleccion.getSrl_id_etapa_proceso_seleccion());
				TSubetapaProcesoSeleccion tSubetapaProcesoSeleccion = beanUtil.copyBean(subEtapaProcesoSelecionQuery, TSubetapaProcesoSeleccion.class);
				this.insertSelective(TSubetapaProcesoSeleccionMapper.class, tSubetapaProcesoSeleccion);
			}else{
				TSubetapaProcesoSeleccion tSubetapaProcesoSeleccion = beanUtil.copyBean(subEtapaProcesoSelecionQuery, TSubetapaProcesoSeleccion.class);
				this.updateByPrimaryKeySelective(TSubetapaProcesoSeleccionMapper.class, tSubetapaProcesoSeleccion);
			}
		}
		/* End TSubetapaProcesoSeleccion */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarEtapasProcesoSeleccionQuery model, List<SubEtapaProcesoSelecionQuery> listSubEtapaProcesoSelecionQuery) throws BusinessException {
	
		for (SubEtapaProcesoSelecionQuery subEtapaProcesoSelecionQuery : listSubEtapaProcesoSelecionQuery) {
			TSubetapaProcesoSeleccion tSubetapaProcesoSeleccion = beanUtil.copyBean(subEtapaProcesoSelecionQuery, TSubetapaProcesoSeleccion.class);
			this.deleteByPrimaryKey(TSubetapaProcesoSeleccionMapper.class, tSubetapaProcesoSeleccion);
		}

		TEtapaProcesoSeleccion tEtapaProcesoSeleccion = beanUtil.copyBean(model, TEtapaProcesoSeleccion.class);
		this.deleteByPrimaryKey(TEtapaProcesoSeleccionMapper.class, tEtapaProcesoSeleccion);
	}

}
