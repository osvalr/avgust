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
* DATE CREATE : 03/12/2014 15:04:40
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.repository.mybatis.mapper.EstudioMapper;
import pe.com.focus.repository.mybatis.model.Estudio;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;
import pe.com.focus.sakerk.business.service.GestionarEstudioService;
import pe.com.focus.sakerk.repository.custom.model.EstudioQuery;
import pe.com.focus.util.BeanUtil;

@Service
public class GestionarEstudioServiceImpl extends HelperServiceImpl implements GestionarEstudioService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(EstudioQuery model) throws BusinessException {
		Integer lastId = null;
		Estudio estudio = beanUtil.copyBean(model, Estudio.class);
		this.insertSelective(EstudioMapper.class, estudio);
		lastId = estudio.getId_estudio();
		
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(EstudioQuery model) throws BusinessException {
		Estudio estudio = beanUtil.copyBean(model, Estudio.class);
		this.updateByPrimaryKeySelective(EstudioMapper.class, estudio);
	}

	@Transactional
	@Override
	public void remove(EstudioQuery model) throws BusinessException {
		Estudio estudio = beanUtil.copyBean(model, Estudio.class);
		this.deleteByPrimaryKey(EstudioMapper.class, estudio);
	}

}
