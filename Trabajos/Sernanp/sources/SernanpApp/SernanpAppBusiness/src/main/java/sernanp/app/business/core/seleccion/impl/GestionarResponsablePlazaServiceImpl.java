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
* DATE CREATE : 17/04/2015 16:51:57
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

import sernanp.app.business.core.seleccion.service.GestionarResponsablePlazaService;
import sernanp.app.dao.query.domain.GestionarAsignarResponsableQuery;


import sernanp.app.dao.domain.Personal;
import sernanp.app.dao.mapper.PersonalMapper;

import sernanp.app.dao.query.domain.ResponsablePlazaQuery;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgExample;

@Service
public class GestionarResponsablePlazaServiceImpl extends HelperServiceMybatisImpl implements GestionarResponsablePlazaService {

	@Autowired
	private BeanUtil beanUtil;
		
	@Transactional
	@Override
	public void save(GestionarAsignarResponsableQuery model, List<ResponsablePlazaQuery> listResponsablePlazaQuery) throws BusinessException {
	
		Personal personal = beanUtil.copyBean(model, Personal.class);
		this.updateByPrimaryKeySelective(PersonalMapper.class, personal);
		
		/* Start TConvocatoriaAreaOrg */
		/*
		if(listResponsablePlazaQuery == null){
			throw new BusinessException("Error, no existen registros en TConvocatoriaAreaOrg.");
		}else if(listResponsablePlazaQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TConvocatoriaAreaOrg.");
		}
		*/

		TConvocatoriaAreaOrgExample tConvocatoriaAreaOrgExample = new TConvocatoriaAreaOrgExample();
		tConvocatoriaAreaOrgExample.createCriteria().andIdpersonalEqualTo(personal.getIdpersonal());
		List<TConvocatoriaAreaOrg> listTConvocatoriaAreaOrgCurrent = this.selectByExample(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgExample);
		List<TConvocatoriaAreaOrg> listTConvocatoriaAreaOrgDeleted = new ArrayList<TConvocatoriaAreaOrg>();
		
		for (TConvocatoriaAreaOrg tConvocatoriaAreaOrg : listTConvocatoriaAreaOrgCurrent) {
			boolean noExists = true;
			for (ResponsablePlazaQuery responsablePlazaQuery : listResponsablePlazaQuery) {
				if(responsablePlazaQuery.getSrl_id_conv_area_org().equals(tConvocatoriaAreaOrg.getSrl_id_conv_area_org())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConvocatoriaAreaOrgDeleted.add(tConvocatoriaAreaOrg);
			}
		}
		
//		this.deleteByPrimaryKey(TConvocatoriaAreaOrgMapper.class, listTConvocatoriaAreaOrgDeleted);
		for (TConvocatoriaAreaOrg tConvocatoriaAreaOrg : listTConvocatoriaAreaOrgDeleted) {
			tConvocatoriaAreaOrg.setIdpersonal(null);
			this.updateByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
		}
		
		for (ResponsablePlazaQuery responsablePlazaQuery : listResponsablePlazaQuery) {
			TConvocatoriaAreaOrg tConvocatoriaAreaOrg = new TConvocatoriaAreaOrg();
			tConvocatoriaAreaOrg.setSrl_id_conv_area_org(responsablePlazaQuery.getSrl_id_conv_area_org());
			tConvocatoriaAreaOrg.setIdpersonal(model.getIdpersonal());
			this.updateByPrimaryKeySelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
			
		}
		/* End TConvocatoriaAreaOrg */	
		
	}

}
