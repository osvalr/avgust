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
* DATE CREATE : 01/12/2014 19:55:03
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.repository.mybatis.mapper.TablaGeneralDetalleMapper;
import pe.com.focus.repository.mybatis.mapper.TablaGeneralMapper;
import pe.com.focus.repository.mybatis.model.TablaGeneral;
import pe.com.focus.repository.mybatis.model.TablaGeneralDetalle;
import pe.com.focus.repository.mybatis.model.TablaGeneralDetalleExample;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;
import pe.com.focus.sakerk.business.service.GestionarTablaGeneralService;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQuery;
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQuery;
import pe.com.focus.util.BeanUtil;

@Service
public class GestionarTablaGeneralServiceImpl extends HelperServiceImpl implements GestionarTablaGeneralService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException {
		
		Integer lastId = null;
		TablaGeneral tablaGeneral = beanUtil.copyBean(model, TablaGeneral.class);
		this.insertSelective(TablaGeneralMapper.class, tablaGeneral);
		lastId = tablaGeneral.getId_tabla_general();
		
		if(listTablaGeneralDetalleQuery == null){
			throw new BusinessException("Error, no existen registros en TablaGeneralDetalle.");
		}else if(listTablaGeneralDetalleQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TablaGeneralDetalle.");
		}
		
		for (TablaGeneralDetalleQuery tablaGeneralDetalleQuery : listTablaGeneralDetalleQuery) {
			tablaGeneralDetalleQuery.setId_tabla_general_detalle(null);
			tablaGeneralDetalleQuery.setId_tabla_general(lastId);
			TablaGeneralDetalle tablaGeneralDetalle = beanUtil.copyBean(tablaGeneralDetalleQuery, TablaGeneralDetalle.class);
			this.insertSelective(TablaGeneralDetalleMapper.class, tablaGeneralDetalle);
		}
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException {
	
		TablaGeneral tablaGeneral = beanUtil.copyBean(model, TablaGeneral.class);
		this.updateByPrimaryKeySelective(TablaGeneralMapper.class, tablaGeneral);

		/* Start TablaGeneralDetalle */
		if(listTablaGeneralDetalleQuery == null){
			throw new BusinessException("Error, no existen registros en TablaGeneralDetalle.");
		}else if(listTablaGeneralDetalleQuery.isEmpty()){
			throw new BusinessException("Error, no existen registros en TablaGeneralDetalle.");
		}
		
		TablaGeneralDetalleExample tablaGeneralDetalleExample = new TablaGeneralDetalleExample();
		tablaGeneralDetalleExample.createCriteria().andId_tabla_generalEqualTo(tablaGeneral.getId_tabla_general());
		List<TablaGeneralDetalle> listTablaGeneralDetalleCurrent = this.selectByExample(TablaGeneralDetalleMapper.class, tablaGeneralDetalleExample);
		List<TablaGeneralDetalle> listTablaGeneralDetalleDeleted = new ArrayList<TablaGeneralDetalle>();
		
		for (TablaGeneralDetalle tablaGeneralDetalle : listTablaGeneralDetalleCurrent) {
			boolean noExists = true;
			for (TablaGeneralDetalleQuery tablaGeneralDetalleQuery : listTablaGeneralDetalleQuery) {
				if(tablaGeneralDetalleQuery.getId_tabla_general_detalle().equals(tablaGeneralDetalle.getId_tabla_general_detalle())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTablaGeneralDetalleDeleted.add(tablaGeneralDetalle);
			}
		}
		
		this.deleteByPrimaryKey(TablaGeneralDetalleMapper.class, listTablaGeneralDetalleDeleted);
		
		for (TablaGeneralDetalleQuery tablaGeneralDetalleQuery : listTablaGeneralDetalleQuery) {
			if(tablaGeneralDetalleQuery.getId_tabla_general_detalle() < 1){
				tablaGeneralDetalleQuery.setId_tabla_general_detalle(null);
				tablaGeneralDetalleQuery.setId_tabla_general(tablaGeneral.getId_tabla_general());
				TablaGeneralDetalle tablaGeneralDetalle = beanUtil.copyBean(tablaGeneralDetalleQuery, TablaGeneralDetalle.class);
				this.insertSelective(TablaGeneralDetalleMapper.class, tablaGeneralDetalle);
			}else{
				TablaGeneralDetalle tablaGeneralDetalle = beanUtil.copyBean(tablaGeneralDetalleQuery, TablaGeneralDetalle.class);
				this.updateByPrimaryKeySelective(TablaGeneralDetalleMapper.class, tablaGeneralDetalle);
			}
		}
		/* End TablaGeneralDetalle */	
		
	}

	@Transactional
	@Override
	public void remove(TablaGeneralQuery model, List<TablaGeneralDetalleQuery> listTablaGeneralDetalleQuery) throws BusinessException {
	
		for (TablaGeneralDetalleQuery tablaGeneralDetalleQuery : listTablaGeneralDetalleQuery) {
			TablaGeneralDetalle tablaGeneralDetalle = beanUtil.copyBean(tablaGeneralDetalleQuery, TablaGeneralDetalle.class);
			this.deleteByPrimaryKey(TablaGeneralDetalleMapper.class, tablaGeneralDetalle);
		}
		
		TablaGeneral tablaGeneral = beanUtil.copyBean(model, TablaGeneral.class);
		this.deleteByPrimaryKey(TablaGeneralMapper.class, tablaGeneral);
	}

}
