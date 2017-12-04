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
* DATE CREATE : 13/03/2015 01:37:59
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;
import sernanp.app.business.core.planilla.service.GestionarParametroPlanillaService;
import sernanp.app.dao.query.domain.GestionarParametroPlanillaQuery;
import sernanp.app.dao.domain.TAnioParametroPlanilla;
import sernanp.app.dao.domain.TAnioParametroPlanillaExample;
import sernanp.app.dao.domain.TParametroPlanilla;
import sernanp.app.dao.domain.TParametroPlanillaExample;
import sernanp.app.dao.mapper.TAnioParametroPlanillaMapper;
import sernanp.app.dao.mapper.TParametroPlanillaMapper;




@Service
public class GestionarParametroPlanillaServiceImpl extends HelperServiceMybatisImpl implements GestionarParametroPlanillaService {

    public static final String SUCCESS = "success";
    
	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarParametroPlanillaQuery model) throws BusinessException {
	
		Integer lastId = null;		
		TParametroPlanilla tParametroPlanilla = beanUtil.copyBean(model, TParametroPlanilla.class);
		tParametroPlanilla.setTsp_fecha_registro(new Date());
		tParametroPlanilla.setVar_descrip_parametro(tParametroPlanilla.getVar_descrip_parametro().toUpperCase());
				
				TParametroPlanillaExample example = new TParametroPlanillaExample();
				example.createCriteria().andVar_descrip_parametroEqualTo(tParametroPlanilla.getVar_descrip_parametro());		
				List<TParametroPlanilla> list = this.selectByExample(TParametroPlanillaMapper.class, example);		
				if(!list.isEmpty()){
				throw new BusinessException("Error, Nombre del Parámetro ya existe.");
				}

		this.insertSelective(TParametroPlanillaMapper.class, tParametroPlanilla);
		lastId = tParametroPlanilla.getSrl_id_parametro_planilla();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarParametroPlanillaQuery model) throws BusinessException {

		TParametroPlanilla tParametroPlanilla = beanUtil.copyBean(model, TParametroPlanilla.class);
		
				TParametroPlanillaExample example = new TParametroPlanillaExample();
				example.createCriteria()
				.andVar_descrip_parametroEqualTo(tParametroPlanilla.getVar_descrip_parametro()).
				andSrl_id_parametro_planillaNotEqualTo(tParametroPlanilla.getSrl_id_parametro_planilla());		
				List<TParametroPlanilla> list = this.selectByExample(TParametroPlanillaMapper.class, example);				
				if(!list.isEmpty()){
					throw new BusinessException("Error, Nombre del Parámetro ya existe.");
				}
		tParametroPlanilla.setVar_descrip_parametro(tParametroPlanilla.getVar_descrip_parametro().toUpperCase());
		this.updateByPrimaryKeySelective(TParametroPlanillaMapper.class, tParametroPlanilla);
				
	}

	@Transactional
	@Override
	public void remove(GestionarParametroPlanillaQuery model ) throws BusinessException {
		
		TParametroPlanilla tParametroPlanilla = beanUtil.copyBean(model, TParametroPlanilla.class);
		
		TAnioParametroPlanillaExample example = new TAnioParametroPlanillaExample();
		example.createCriteria().andSrl_id_parametro_planillaEqualTo(tParametroPlanilla.getSrl_id_parametro_planilla());
		List<TAnioParametroPlanilla> list = this.selectByExample(TAnioParametroPlanillaMapper.class, example);
		
		if (!list.isEmpty()){
			throw new BusinessException("Error, Existen registros vinculados.");	
		}
		
		this.deleteByPrimaryKey(TParametroPlanillaMapper.class, tParametroPlanilla);		
	}
	
}
