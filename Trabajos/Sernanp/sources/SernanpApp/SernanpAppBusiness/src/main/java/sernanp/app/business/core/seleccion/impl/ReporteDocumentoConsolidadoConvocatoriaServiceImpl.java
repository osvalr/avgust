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
* DATE CREATE : 23/05/2015 14:01:52
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.seleccion.service.ReporteDocumentoConsolidadoConvocatoriaService;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaQuery;

import sernanp.app.dao.domain.TConvocatoria;
import sernanp.app.dao.mapper.TConvocatoriaMapper;

@Service
public class ReporteDocumentoConsolidadoConvocatoriaServiceImpl extends HelperServiceMybatisImpl implements ReporteDocumentoConsolidadoConvocatoriaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpDocumentoConsolidadoConvocatoriaQuery model) throws BusinessException {
	
		Integer lastId = null;

		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		this.insertSelective(TConvocatoriaMapper.class, tConvocatoria);

		lastId = tConvocatoria.getSrl_id_convocatoria();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpDocumentoConsolidadoConvocatoriaQuery model) throws BusinessException {

		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		this.updateByPrimaryKeySelective(TConvocatoriaMapper.class, tConvocatoria);
		
	}

	@Transactional
	@Override
	public void remove(RpDocumentoConsolidadoConvocatoriaQuery model) throws BusinessException {

		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		this.deleteByPrimaryKey(TConvocatoriaMapper.class, tConvocatoria);
	}

}
