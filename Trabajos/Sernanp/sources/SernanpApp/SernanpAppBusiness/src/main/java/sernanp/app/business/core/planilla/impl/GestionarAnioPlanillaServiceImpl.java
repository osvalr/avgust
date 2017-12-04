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
* DATE CREATE : 18/03/2015 23:43:06
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;
import sernanp.app.business.core.planilla.service.GestionarAnioPlanillaService;
import sernanp.app.dao.query.domain.GestionarAnioPlanillaQuery;


import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaExample;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.query.domain.GestionarAnioParametroPlanillaQuery;
import sernanp.app.dao.domain.TAnioParametroPlanilla;
import sernanp.app.dao.mapper.TAnioParametroPlanillaMapper;
import sernanp.app.dao.domain.TAnioParametroPlanillaExample;
import sernanp.app.dao.query.domain.GestionarAnioPeriodoPlanillaQuery;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaExample;

@Service
public class GestionarAnioPlanillaServiceImpl extends HelperServiceMybatisImpl implements GestionarAnioPlanillaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Transactional
	@Override
	public Integer create(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException {
		
		Integer lastId = null;

		TAnioPlanilla tAnioPlanilla = beanUtil.copyBean(model, TAnioPlanilla.class);
		tAnioPlanilla.setTsp_fecha_registro(new Date());
		tAnioPlanilla.setVar_nombre_anio(tAnioPlanilla.getVar_nombre_anio().toUpperCase());
		
			TAnioPlanillaExample example = new TAnioPlanillaExample();
				example.createCriteria().andInt_anioEqualTo(tAnioPlanilla.getInt_anio());
				List<TAnioParametroPlanilla> list = this.selectByExample(TAnioPlanillaMapper.class, example);
		
				if(!list.isEmpty()){
					throw new BusinessException("Error, Año ya existe.");
				}
		this.insertSelective(TAnioPlanillaMapper.class, tAnioPlanilla);
		
		
		for (GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery : listGestionarAnioParametroPlanillaQuery) {
			gestionarAnioParametroPlanillaQuery.setSrl_id_anio_parametro_planilla(null);
			gestionarAnioParametroPlanillaQuery.setSrl_id_anio_planilla(tAnioPlanilla.getSrl_id_anio_planilla());
			TAnioParametroPlanilla tAnioParametroPlanilla = beanUtil.copyBean(gestionarAnioParametroPlanillaQuery, TAnioParametroPlanilla.class);
			tAnioParametroPlanilla.setTsp_fecha_registro(new Date());
			
				TAnioParametroPlanillaExample tAnioParametroPlanillaExampleUpdate = new TAnioParametroPlanillaExample();
				tAnioParametroPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_anio_planilla()).
				andSrl_id_parametro_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_parametro_planilla());
			
					List<TAnioParametroPlanilla> TAnioParametroPlanillaList = this.selectByExample(TAnioParametroPlanillaMapper.class, tAnioParametroPlanillaExampleUpdate);
			
					if (!TAnioParametroPlanillaList.isEmpty()) {
						throw new BusinessException("Error, Ya existe este Parámetro registrado.");
					}
						
			this.insertSelective(TAnioParametroPlanillaMapper.class, tAnioParametroPlanilla);
		}
		

		for (GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery : listGestionarAnioPeriodoPlanillaQuery) {
			gestionarAnioPeriodoPlanillaQuery.setSrl_id_anio_periodo_planilla(null);
			gestionarAnioPeriodoPlanillaQuery.setSrl_id_anio_planilla(tAnioPlanilla.getSrl_id_anio_planilla());
			TAnioPeriodoPlanilla tAnioPeriodoPlanilla = beanUtil.copyBean(gestionarAnioPeriodoPlanillaQuery, TAnioPeriodoPlanilla.class);
			
				TAnioPeriodoPlanillaExample TAnioPeriodoPlanillaExampleUpdate = new TAnioPeriodoPlanillaExample();
			
				TAnioPeriodoPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioPeriodoPlanilla.getSrl_id_anio_planilla()).
				andInt_id_periodo_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes());
			
				List<TAnioPeriodoPlanilla> TAnioPeriodoPlanillaList = this.selectByExample(TAnioPeriodoPlanillaMapper.class, TAnioPeriodoPlanillaExampleUpdate);
				if(!TAnioPeriodoPlanillaList.isEmpty()){
					throw new BusinessException("Error, Ya existe este mes registrado.");
				}
						
			tAnioPeriodoPlanilla.setTsp_fecha_registro(new Date());
			this.insertSelective(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanilla);
		}
		lastId = tAnioPlanilla.getSrl_id_anio_planilla();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException {
	
		TAnioPlanilla tAnioPlanilla = beanUtil.copyBean(model, TAnioPlanilla.class);
		TAnioPlanillaExample example = new TAnioPlanillaExample();
		example.createCriteria().andInt_anioEqualTo(tAnioPlanilla.getInt_anio()).andSrl_id_anio_planillaNotEqualTo(tAnioPlanilla.getSrl_id_anio_planilla());		
		List<TAnioParametroPlanilla> list = this.selectByExample(TAnioPlanillaMapper.class, example);

		if (!list.isEmpty()) {
			throw new BusinessException("Error, Año ya existe.");
		}

		tAnioPlanilla.setVar_nombre_anio(tAnioPlanilla.getVar_nombre_anio().toUpperCase());
		this.updateByPrimaryKeySelective(TAnioPlanillaMapper.class,tAnioPlanilla);
		
		/* Start TAnioParametroPlanilla */
		

		TAnioParametroPlanillaExample tAnioParametroPlanillaExample = new TAnioParametroPlanillaExample();
		tAnioParametroPlanillaExample.createCriteria().andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla());
		List<TAnioParametroPlanilla> listTAnioParametroPlanillaCurrent = this.selectByExample(TAnioParametroPlanillaMapper.class, tAnioParametroPlanillaExample);
		List<TAnioParametroPlanilla> listTAnioParametroPlanillaDeleted = new ArrayList<TAnioParametroPlanilla>();
		
		for (TAnioParametroPlanilla tAnioParametroPlanilla : listTAnioParametroPlanillaCurrent) {
			boolean noExists = true;
			for (GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery : listGestionarAnioParametroPlanillaQuery) {
			if(gestionarAnioParametroPlanillaQuery.getSrl_id_anio_parametro_planilla().equals(tAnioParametroPlanilla.getSrl_id_anio_parametro_planilla())){
			noExists = false;
			break;
			}
			}
			if(noExists){
				listTAnioParametroPlanillaDeleted.add(tAnioParametroPlanilla);
			}
		}
		
		this.deleteByPrimaryKey(TAnioParametroPlanillaMapper.class, listTAnioParametroPlanillaDeleted);
		
		for (GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery : listGestionarAnioParametroPlanillaQuery) {
			if(gestionarAnioParametroPlanillaQuery.getSrl_id_anio_parametro_planilla() < 1){

				TAnioParametroPlanilla tAnioParametroPlanilla = beanUtil.copyBean(gestionarAnioParametroPlanillaQuery, TAnioParametroPlanilla.class);				
				tAnioParametroPlanilla.setSrl_id_anio_planilla(tAnioPlanilla.getSrl_id_anio_planilla());
							
				TAnioParametroPlanillaExample tAnioParametroPlanillaExampleUpdate = new TAnioParametroPlanillaExample();
				tAnioParametroPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_anio_planilla()).
				andSrl_id_parametro_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_parametro_planilla());
					
				List<TAnioParametroPlanilla> tAnioParametroPlanillaList = this.selectByExample(TAnioParametroPlanillaMapper.class, tAnioParametroPlanillaExampleUpdate);				
				if (!tAnioParametroPlanillaList.isEmpty()) {
				throw new BusinessException("Error, Ya existe este Parámetro registrado.");	
				}			
				tAnioParametroPlanilla.setSrl_id_anio_parametro_planilla(null);
				tAnioParametroPlanilla.setTsp_fecha_registro(new Date());				
				this.insertSelective(TAnioParametroPlanillaMapper.class, tAnioParametroPlanilla);
			}else{
				TAnioParametroPlanilla tAnioParametroPlanilla = beanUtil.copyBean(gestionarAnioParametroPlanillaQuery, TAnioParametroPlanilla.class);				
				
				TAnioParametroPlanillaExample tAnioParametroPlanillaExampleUpdate = new TAnioParametroPlanillaExample();
				tAnioParametroPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_anio_planilla()).
				andSrl_id_parametro_planillaEqualTo(tAnioParametroPlanilla.getSrl_id_parametro_planilla()).
				andSrl_id_anio_parametro_planillaNotEqualTo(tAnioParametroPlanilla.getSrl_id_anio_parametro_planilla());									
				List<TAnioParametroPlanilla> tAnioParametroPlanillaList = this.selectByExample(TAnioParametroPlanillaMapper.class, tAnioParametroPlanillaExampleUpdate);				
				if (!tAnioParametroPlanillaList.isEmpty()) {
				throw new BusinessException("Error, Ya existe este Parámetro registrado.");
				}				
				this.updateByPrimaryKeySelective(TAnioParametroPlanillaMapper.class, tAnioParametroPlanilla);
			}
		}
		/* End TAnioParametroPlanilla */	
		/* Start TAnioPeriodoPlanilla */
		

		TAnioPeriodoPlanillaExample tAnioPeriodoPlanillaExample = new TAnioPeriodoPlanillaExample();
		tAnioPeriodoPlanillaExample.createCriteria().andSrl_id_anio_planillaEqualTo(tAnioPlanilla.getSrl_id_anio_planilla());
		List<TAnioPeriodoPlanilla> listTAnioPeriodoPlanillaCurrent = this.selectByExample(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanillaExample);
		List<TAnioPeriodoPlanilla> listTAnioPeriodoPlanillaDeleted = new ArrayList<TAnioPeriodoPlanilla>();
		
		for (TAnioPeriodoPlanilla tAnioPeriodoPlanilla : listTAnioPeriodoPlanillaCurrent) {
			boolean noExists = true;
			for (GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery : listGestionarAnioPeriodoPlanillaQuery) {
			if(gestionarAnioPeriodoPlanillaQuery.getSrl_id_anio_periodo_planilla().equals(tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla())){
			noExists = false;
			break;
			}
			}
			if(noExists){
			listTAnioPeriodoPlanillaDeleted.add(tAnioPeriodoPlanilla);
			}
		}
		
		this.deleteByPrimaryKey(TAnioPeriodoPlanillaMapper.class, listTAnioPeriodoPlanillaDeleted);
		
		for (GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery : listGestionarAnioPeriodoPlanillaQuery) {
			if(gestionarAnioPeriodoPlanillaQuery.getSrl_id_anio_periodo_planilla() < 1){
				
				TAnioPeriodoPlanilla tAnioPeriodoPlanilla = beanUtil.copyBean(gestionarAnioPeriodoPlanillaQuery, TAnioPeriodoPlanilla.class);
				tAnioPeriodoPlanilla.setSrl_id_anio_planilla(tAnioPlanilla.getSrl_id_anio_planilla());	
				
				TAnioPeriodoPlanillaExample TAnioPeriodoPlanillaExampleUpdate = new TAnioPeriodoPlanillaExample();			
				TAnioPeriodoPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioPeriodoPlanilla.getSrl_id_anio_planilla()).
				andInt_id_periodo_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes());
				
				List<TAnioPeriodoPlanilla> TAnioPeriodoPlanillaList = this.selectByExample(TAnioPeriodoPlanillaMapper.class, TAnioPeriodoPlanillaExampleUpdate);
				if(!TAnioPeriodoPlanillaList.isEmpty()){
					throw new BusinessException("Error, Ya existe este mes registrado.");
				}
								
				tAnioPeriodoPlanilla.setSrl_id_anio_periodo_planilla(null);			
				tAnioPeriodoPlanilla.setTsp_fecha_registro(new Date());
				this.insertSelective(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanilla);
			}else{
				TAnioPeriodoPlanilla tAnioPeriodoPlanilla = beanUtil.copyBean(gestionarAnioPeriodoPlanillaQuery, TAnioPeriodoPlanilla.class);
				
				TAnioPeriodoPlanillaExample TAnioPeriodoPlanillaExampleUpdate = new TAnioPeriodoPlanillaExample();
				TAnioPeriodoPlanillaExampleUpdate.createCriteria().
				andSrl_id_anio_planillaEqualTo(tAnioPeriodoPlanilla.getSrl_id_anio_planilla()).
				andInt_id_periodo_mesEqualTo(tAnioPeriodoPlanilla.getInt_id_periodo_mes()).
				andSrl_id_anio_periodo_planillaNotEqualTo(tAnioPeriodoPlanilla.getSrl_id_anio_periodo_planilla());
								
				List<TAnioPeriodoPlanilla> TAnioPeriodoPlanillaList = this.selectByExample(TAnioPeriodoPlanillaMapper.class, TAnioPeriodoPlanillaExampleUpdate);
				if(!TAnioPeriodoPlanillaList.isEmpty()){
					throw new BusinessException("Error, Ya existe este mes registrado.");
				}							
				this.updateByPrimaryKeySelective(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanilla);
			}
		}
		/* End TAnioPeriodoPlanilla */	
		
	}

	@Transactional
	@Override
	public void remove(GestionarAnioPlanillaQuery model, List<GestionarAnioParametroPlanillaQuery> listGestionarAnioParametroPlanillaQuery, List<GestionarAnioPeriodoPlanillaQuery> listGestionarAnioPeriodoPlanillaQuery) throws BusinessException {
	
		
	 TAnioPlanilla tAnioPlanilla = beanUtil.copyBean(model, TAnioPlanilla.class);
		
		for (GestionarAnioParametroPlanillaQuery gestionarAnioParametroPlanillaQuery : listGestionarAnioParametroPlanillaQuery) {
			TAnioParametroPlanilla tAnioParametroPlanilla = beanUtil.copyBean(gestionarAnioParametroPlanillaQuery, TAnioParametroPlanilla.class);
			this.deleteByPrimaryKey(TAnioParametroPlanillaMapper.class, tAnioParametroPlanilla);
		}
		for (GestionarAnioPeriodoPlanillaQuery gestionarAnioPeriodoPlanillaQuery : listGestionarAnioPeriodoPlanillaQuery) {
			TAnioPeriodoPlanilla tAnioPeriodoPlanilla = beanUtil.copyBean(gestionarAnioPeriodoPlanillaQuery, TAnioPeriodoPlanilla.class);
			this.deleteByPrimaryKey(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanilla);
		}

		this.deleteByPrimaryKey(TAnioPlanillaMapper.class, tAnioPlanilla);
	}

}
