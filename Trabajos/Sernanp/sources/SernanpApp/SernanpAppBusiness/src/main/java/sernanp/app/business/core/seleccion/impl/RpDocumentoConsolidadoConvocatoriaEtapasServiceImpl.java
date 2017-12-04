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
* DATE CREATE : 23/05/2015 14:15:27
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.seleccion.service.RpDocumentoConsolidadoConvocatoriaEtapasService;
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery;

import sernanp.app.dao.domain.TConvFechaEtapaConfig;
import sernanp.app.dao.mapper.TConvFechaEtapaConfigMapper;

@Service
public class RpDocumentoConsolidadoConvocatoriaEtapasServiceImpl extends HelperServiceMybatisImpl implements RpDocumentoConsolidadoConvocatoriaEtapasService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery model) throws BusinessException {
	
		Integer lastId = null;

		TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(model, TConvFechaEtapaConfig.class);
		this.insertSelective(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);

		lastId = tConvFechaEtapaConfig.getSrl_id_conv_fecha_etapa_config();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery model) throws BusinessException {

		TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(model, TConvFechaEtapaConfig.class);
		this.updateByPrimaryKeySelective(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
		
	}

	@Transactional
	@Override
	public void remove(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery model) throws BusinessException {

		TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(model, TConvFechaEtapaConfig.class);
		this.deleteByPrimaryKey(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
	}

}
