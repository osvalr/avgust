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
* DATE CREATE : 13/03/2015 11:02:41
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.planilla.service.GestionarAfpService;
import sernanp.app.dao.domain.TAfp;
import sernanp.app.dao.domain.TAfpComision;
import sernanp.app.dao.domain.TAfpComisionExample;
import sernanp.app.dao.domain.TAfpExample;
import sernanp.app.dao.mapper.TAfpComisionMapper;
import sernanp.app.dao.mapper.TAfpMapper;
import sernanp.app.dao.query.domain.GestionarAfpPlanillaComisionQuery;
import sernanp.app.dao.query.domain.GestionarAfpPlanillaQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarAfpServiceImpl extends HelperServiceMybatisImpl implements GestionarAfpService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarAfpPlanillaQuery model, List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery) throws BusinessException {
		
		Integer lastId = null;

		TAfp tAfp = beanUtil.copyBean(model, TAfp.class);
		tAfp.setTsp_fecha_registro(new Date());	
		tAfp.setVar_cod_afp(tAfp.getVar_cod_afp().toUpperCase());
		tAfp.setVar_nombre_afp(tAfp.getVar_nombre_afp().toUpperCase());
		
			TAfpExample tAfpExample = new TAfpExample();
			tAfpExample.createCriteria().andVar_nombre_afpEqualTo(tAfp.getVar_nombre_afp());
			List<TAfp> list = this.selectByExample(TAfpMapper.class, tAfpExample);
				if(!list.isEmpty()){
					throw new BusinessException("Error, AFP ya existe.");
				}
		this.insertSelective(TAfpMapper.class, tAfp);
		
							
		for (GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery : listGestionarAfpPlanillaComisionQuery) {
			gestionarAfpPlanillaComisionQuery.setSrl_id_afp_comision(null);
			gestionarAfpPlanillaComisionQuery.setSrl_id_afp(tAfp.getSrl_id_afp());
				
					TAfpComision tAfpComision = beanUtil.copyBean(gestionarAfpPlanillaComisionQuery, TAfpComision.class);			
					TAfpComisionExample tAfpComisionExampleUpdate = new TAfpComisionExample();
					tAfpComisionExampleUpdate.createCriteria().
					andInt_id_tipo_comisionEqualTo(tAfpComision.getInt_id_tipo_comision()).
					andSrl_id_afpEqualTo(tAfpComision.getSrl_id_afp());										
					List<TAfpComision> tAfpComisionList = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExampleUpdate);		
					if(!tAfpComisionList.isEmpty()){
						throw new BusinessException("Error, Comisión ya existe para esta AFP.");				
					}
					
			tAfpComision.setTsp_fecha_registro(new Date());
			this.insertSelective(TAfpComisionMapper.class, tAfpComision);
		}
		
		lastId = tAfp.getSrl_id_afp();
		return lastId;
	}	


	@Transactional
	@Override
	public void save(GestionarAfpPlanillaQuery model, List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery) throws BusinessException {
	
		TAfp tAfp = beanUtil.copyBean(model, TAfp.class);
		
			TAfpExample tAfpExample = new TAfpExample();
			tAfpExample.createCriteria()
			.andVar_nombre_afpEqualTo(tAfp.getVar_nombre_afp())
			.andSrl_id_afpNotEqualTo(tAfp.getSrl_id_afp());
			
			List<TAfp> list = this.selectByExample(TAfpMapper.class, tAfpExample);
			if(!list.isEmpty()){
			throw new BusinessException("Error, AFP ya existe.");
			}
			tAfp.setVar_cod_afp(tAfp.getVar_cod_afp().toUpperCase());
			tAfp.setVar_nombre_afp(tAfp.getVar_nombre_afp().toUpperCase());		
			
		this.updateByPrimaryKeySelective(TAfpMapper.class, tAfp);
		
		/* Start TAfpComision */
		

		TAfpComisionExample tAfpComisionExample = new TAfpComisionExample();
		tAfpComisionExample.createCriteria().andSrl_id_afpEqualTo(tAfp.getSrl_id_afp());
		List<TAfpComision> listTAfpComisionCurrent = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExample);
		List<TAfpComision> listTAfpComisionDeleted = new ArrayList<TAfpComision>();
		
		for (TAfpComision tAfpComision : listTAfpComisionCurrent) {
			boolean noExists = true;
			for (GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery : listGestionarAfpPlanillaComisionQuery) {
				if(gestionarAfpPlanillaComisionQuery.getSrl_id_afp_comision().equals(tAfpComision.getSrl_id_afp_comision())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTAfpComisionDeleted.add(tAfpComision);
			}
		}
		
		this.deleteByPrimaryKey(TAfpComisionMapper.class, listTAfpComisionDeleted);
		
		for (GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery : listGestionarAfpPlanillaComisionQuery) {
			if(gestionarAfpPlanillaComisionQuery.getSrl_id_afp_comision() < 1){
				
				TAfpComision tAfpComision = beanUtil.copyBean(gestionarAfpPlanillaComisionQuery, TAfpComision.class);
				tAfpComision.setSrl_id_afp(tAfp.getSrl_id_afp());
				
				TAfpComisionExample tAfpComisionExampleUpdate = new TAfpComisionExample();
				tAfpComisionExampleUpdate.createCriteria().
				andInt_id_tipo_comisionEqualTo(tAfpComision.getInt_id_tipo_comision()).
				andSrl_id_afpEqualTo(tAfpComision.getSrl_id_afp());												
				List<TAfpComision> tAfpComisionList = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExampleUpdate);			
				if(!tAfpComisionList.isEmpty()){ 
					throw new BusinessException("Error, Comisión ya existe para esta AFP.");						
				}
								
				tAfpComision.setSrl_id_afp_comision(null);
				tAfpComision.setTsp_fecha_registro(new Date());	
				this.insertSelective(TAfpComisionMapper.class, tAfpComision);
			}
			
			
			else{
				TAfpComision tAfpComision = beanUtil.copyBean(gestionarAfpPlanillaComisionQuery, TAfpComision.class);	
				
				TAfpComisionExample tAfpComisionExampleUpdate = new TAfpComisionExample();
				tAfpComisionExampleUpdate.createCriteria().
				andInt_id_tipo_comisionEqualTo(tAfpComision.getInt_id_tipo_comision()).
				andSrl_id_afpEqualTo(tAfpComision.getSrl_id_afp()).
				andSrl_id_afp_comisionNotEqualTo(tAfpComision.getSrl_id_afp_comision());
								
				List<TAfpComision> tAfpComisionList = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExampleUpdate);
			
				if(!tAfpComisionList.isEmpty()){
					throw new BusinessException("Error, Comisión ya existe para esta AFP.");
				}
				
//				gestionarAfpPlanillaComisionQuery.setSrl_id_afp(tAfp.getSrl_id_afp());
			//	tAfpComision.setTsp_fecha_registro(new Date());	
				this.updateByPrimaryKeySelective(TAfpComisionMapper.class, tAfpComision);
			}			
		}
		/* End TAfpComision */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarAfpPlanillaQuery model, List<GestionarAfpPlanillaComisionQuery> listGestionarAfpPlanillaComisionQuery) throws BusinessException {
	
		TAfp tAfp = beanUtil.copyBean(model, TAfp.class);
		
			TAfpComisionExample tAfpComisionExample = new TAfpComisionExample();
			tAfpComisionExample.createCriteria().andSrl_id_afpEqualTo(tAfp.getSrl_id_afp());
			List<TAfpComision>  tAfpComisionList = this.selectByExample(TAfpComisionMapper.class, tAfpComisionExample);
			if (!tAfpComisionList.isEmpty()){
						throw new BusinessException("Error, Existen registros vinculados.");	
			}
					
			for (GestionarAfpPlanillaComisionQuery gestionarAfpPlanillaComisionQuery : listGestionarAfpPlanillaComisionQuery) {
				TAfpComision tAfpComision = beanUtil.copyBean(gestionarAfpPlanillaComisionQuery, TAfpComision.class);
				this.deleteByPrimaryKey(TAfpComisionMapper.class, tAfpComision);
			}


		this.deleteByPrimaryKey(TAfpMapper.class, tAfp);
	}
	
	
	
	
	

}
