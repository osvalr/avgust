/**
* Copyright «©» 2014, FOCUS CONSULTORES ASOCIADOS SAC. All rights reserved.
*
* This file is part of SakerkApp.
*
* SakerkApp is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SakerkApp is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SakerkApp.  If not, see <http://www.gnu.org/licenses/>.
*/	 

/**
* GENERATOR CRUD EXT JS 5            
* BY FOCUS CONSULTORES ASOCIADOS SAC  
* DATE CREATE : 20/12/2014 22:23:10
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.util.BeanUtil;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;

import pe.com.focus.sakerk.business.service.GestionarCongregacionService;
import pe.com.focus.sakerk.repository.custom.model.CongregacionQuery;

import pe.com.focus.repository.mybatis.model.CongregacionGeneral;
import pe.com.focus.repository.mybatis.mapper.CongregacionGeneralMapper;

@Service
public class GestionarCongregacionServiceImpl extends HelperServiceImpl implements GestionarCongregacionService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(CongregacionQuery model) throws BusinessException {
	
		Integer lastId = null;

		CongregacionGeneral congregacionGeneral = beanUtil.copyBean(model, CongregacionGeneral.class);
		this.insertSelective(CongregacionGeneralMapper.class, congregacionGeneral);

		lastId = congregacionGeneral.getId_congregacion_general();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(CongregacionQuery model) throws BusinessException {

		CongregacionGeneral congregacionGeneral = beanUtil.copyBean(model, CongregacionGeneral.class);
		this.updateByPrimaryKeySelective(CongregacionGeneralMapper.class, congregacionGeneral);
		
	}

	@Transactional
	@Override
	public void remove(CongregacionQuery model) throws BusinessException {

		CongregacionGeneral congregacionGeneral = beanUtil.copyBean(model, CongregacionGeneral.class);
		this.deleteByPrimaryKey(CongregacionGeneralMapper.class, congregacionGeneral);
	}

}
