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
* DATE CREATE : 18/12/2014 22:25:38
* VERSION : 1.0 
*/

package pe.com.focus.sakerk.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.focus.repository.mybatis.mapper.TablaGeneralDetalleMapper;
import pe.com.focus.repository.mybatis.model.TablaGeneralDetalle;
import pe.com.focus.repository.mybatis.util.BusinessException;
import pe.com.focus.repository.mybatis.util.HelperServiceImpl;
import pe.com.focus.sakerk.business.service.RegistrarItemTablaGeneralService;
import pe.com.focus.sakerk.repository.custom.mapper.ObtenerMaximoValorTablaGeneralMapper;
import pe.com.focus.sakerk.repository.custom.model.ItemTablaGeneralQuery;
import pe.com.focus.sakerk.repository.custom.model.ObtenerMaximoValorTablaGeneral;
import pe.com.focus.sakerk.repository.custom.model.ObtenerMaximoValorTablaGeneralCriteria;
import pe.com.focus.util.BeanUtil;

@Service
public class RegistrarItemTablaGeneralServiceImpl extends HelperServiceImpl implements RegistrarItemTablaGeneralService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer execute(ItemTablaGeneralQuery model) throws BusinessException {
		
		Integer lastId = null;
		TablaGeneralDetalle tablaGeneralDetalle = beanUtil.copyBean(model, TablaGeneralDetalle.class);
		
		// Start JRaffo 29/12/2014
		ObtenerMaximoValorTablaGeneralCriteria criteria = new ObtenerMaximoValorTablaGeneralCriteria();
		criteria.setId_tabla_general(tablaGeneralDetalle.getId_tabla_general());
		
		ObtenerMaximoValorTablaGeneral max = this.getRecordByQuery(ObtenerMaximoValorTablaGeneralMapper.class, criteria);
		Integer newValorGeneral = max.getMax_valor_general().intValue() + 1;
		
		tablaGeneralDetalle.setValor_general(newValorGeneral);
		tablaGeneralDetalle.setOrden(newValorGeneral);
		tablaGeneralDetalle.setId_estado(1); //Estado generico activo
		// End JRaffo 29/12/2014
		
		this.insertSelective(TablaGeneralDetalleMapper.class, tablaGeneralDetalle);
		lastId = newValorGeneral;
		
		return lastId;
	}
	
}
