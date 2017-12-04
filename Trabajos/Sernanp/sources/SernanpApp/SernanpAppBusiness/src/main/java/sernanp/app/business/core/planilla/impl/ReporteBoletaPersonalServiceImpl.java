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
* DATE CREATE : 18/05/2015 01:24:16
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

import sernanp.app.business.core.planilla.service.ReporteBoletaPersonalService;
import sernanp.app.dao.query.domain.RpBoletasPersonalQuery;

import sernanp.app.dao.domain.TNominaAnioPeriodoPersonal;
import sernanp.app.dao.mapper.TNominaAnioPeriodoPersonalMapper;

@Service
public class ReporteBoletaPersonalServiceImpl extends HelperServiceMybatisImpl implements ReporteBoletaPersonalService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(RpBoletasPersonalQuery model) throws BusinessException {
	
		Integer lastId = null;

		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.insertSelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);

		lastId = tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(RpBoletasPersonalQuery model) throws BusinessException {

		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
		
	}

	@Transactional
	@Override
	public void remove(RpBoletasPersonalQuery model) throws BusinessException {

		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.deleteByPrimaryKey(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
	}

}
