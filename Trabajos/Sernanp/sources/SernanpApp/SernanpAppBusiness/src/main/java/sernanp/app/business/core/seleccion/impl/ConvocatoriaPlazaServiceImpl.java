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
* DATE CREATE : 21/04/2015 20:40:38
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.ls.LSInput;

import sernanp.app.business.cons.Tablas;
import sernanp.app.business.core.common.service.CommonService;
import sernanp.app.business.core.seleccion.service.ConvocatoriaPlazaService;
import sernanp.app.dao.domain.TConfiguracionEtapa;
import sernanp.app.dao.domain.TConfiguracionEtapaExample;
import sernanp.app.dao.domain.TConvAreaOrgEtapa;
import sernanp.app.dao.domain.TConvAreaOrgEtapaExample;
import sernanp.app.dao.domain.TConvFechaEtapaConfig;
import sernanp.app.dao.domain.TConvFechaEtapaConfigExample;
import sernanp.app.dao.domain.TConvocatoria;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;
import sernanp.app.dao.domain.TConvocatoriaExample;
import sernanp.app.dao.domain.TConvocatoriaKey;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgExample;
import sernanp.app.dao.domain.TRequerimientoPersonal;
import sernanp.app.dao.domain.TRequerimientoPersonalExample;
import sernanp.app.dao.domain.TRequerimientoPersonalKey;
import sernanp.app.dao.mapper.TConfiguracionEtapaMapper;
import sernanp.app.dao.mapper.TConvAreaOrgEtapaMapper;
import sernanp.app.dao.mapper.TConvFechaEtapaConfigMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TConvocatoriaMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TRequerimientoPersonalMapper;
import sernanp.app.dao.mapper.TSubetapaProcesoSeleccionMapper;
import sernanp.app.dao.query.domain.ConsultaExisteNotasPlazaQuery;
import sernanp.app.dao.query.domain.ConsultaExisteNotasPlazaQueryCriteria;
import sernanp.app.dao.query.domain.ConvocatoriaEtapaQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaFactorQuery;
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQuery;
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQuery;
import sernanp.app.dao.query.domain.ObtenerListaConfiguracionEtapasQuery;
import sernanp.app.dao.query.domain.ObtenerListaConfiguracionEtapasQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerUltimaActivacionPlazaQuery;
import sernanp.app.dao.query.domain.ObtenerUltimaActivacionPlazaQueryCriteria;
import sernanp.app.dao.query.domain.RequerimientoDisponibleQueryCriteria;
import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQuery;
import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQueryCriteria;
import sernanp.app.dao.query.mapper.ConsultaExisteNotasPlazaQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerListaConfiguracionEtapasQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerUltimaActivacionPlazaQueryMapper;
import sernanp.app.dao.query.mapper.SubEtapaProcesoSelecionQueryMapper;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class ConvocatoriaPlazaServiceImpl extends HelperServiceMybatisImpl implements ConvocatoriaPlazaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	private TConvAreaOrgEtapaMapper tConvAreaOrgEtapaMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TSubetapaProcesoSeleccionMapper tSubetapaProcesoSeleccionMapper;
	
	@Autowired
	private TConvocatoriaMapper tConvocatoriaMapper;
	
	@Autowired
	private TConvocatoriaAreaOrgMapper tConvocatoriaAreaOrgMapper;
	
	@Autowired
	private TRequerimientoPersonalMapper tRequerimientoPersonalMapper;
	
	@Transactional
	@Override
	public Integer create(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException {
		
		Integer lastId = null;
		
		String numSecuencia = commonService.obtenerSecuencia(Tablas.T_CONVOCATORIA, true, true);
        model.setVar_num_convocatoria(numSecuencia);
        
//        TConvocatoriaExample criteria = new TConvocatoriaExample();
//        criteria.createCriteria().andVar_num_convocatoriaEqualTo(model.getVar_num_convocatoria());
//        
//        List<TConvocatoria> list = tConvocatoriaMapper.selectByExample(criteria);
//        
//        if(!list.isEmpty()){
//			throw new BusinessException("Error, El código de la convocatoria ya se encuentra registrado.");
//		}

		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		tConvocatoria.setTsp_fecha_registro(new Date());
		tConvocatoria.setInt_num_activacion(1);
		this.insertSelective(TConvocatoriaMapper.class, tConvocatoria);
		
		
		for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery : listConvocatoriaPlazaQuery) {
			
			convocatoriaPlazaQuery.setSrl_id_conv_area_org(null);
			convocatoriaPlazaQuery.setSrl_id_convocatoria(tConvocatoria.getSrl_id_convocatoria());
			
			TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(convocatoriaPlazaQuery, TConvocatoriaAreaOrg.class);
			tConvocatoriaAreaOrg.setIdarea(convocatoriaPlazaQuery.getIdarea_solicitante());
			tConvocatoriaAreaOrg.setIdunidad(convocatoriaPlazaQuery.getIdunidad_solicitante());
			tConvocatoriaAreaOrg.setInt_num_puestos(convocatoriaPlazaQuery.getInt_cantidad_requerida());

			this.insertSelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
			
			TConfiguracionEtapaExample example = new TConfiguracionEtapaExample();
			example.createCriteria().andSrl_id_configuracion_evaluacion_personalEqualTo(convocatoriaPlazaQuery.getSrl_id_configuracion_evaluacion_personal());
			example.setOrderByClause("int_orden");
			
			List<TConfiguracionEtapa> list = this.selectByExample(TConfiguracionEtapaMapper.class, example);

				for(TConfiguracionEtapa obj : list){
					
					for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
					
					if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().equals(obj.getSrl_id_subetapa_proceso_seleccion())){
						TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(convocatoriaEtapaQuery, TConvAreaOrgEtapa.class);
						tConvAreaOrgEtapa.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
						
						//si la subetapa es entrevista personal
						if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().intValue() == 7){
							
							TRequerimientoPersonalKey rk = new TRequerimientoPersonal();
							rk.setSrl_id_requerimiento_personal(tConvocatoriaAreaOrg.getSrl_id_requerimiento_personal());
							
							TRequerimientoPersonal r = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, rk);
							
							tConvAreaOrgEtapa.setIdarea(r.getIdarea_solicitante());
							tConvAreaOrgEtapa.setIdunidad(r.getIdunidad_solicitante());
							
						}else{
							
							SubEtapaProcesoSelecionQueryCriteria criteria = new SubEtapaProcesoSelecionQueryCriteria();
							criteria.setSrl_id_subetapa_proceso_seleccion(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion());
							
							SubEtapaProcesoSelecionQuery record = this.getRecordByQuery(SubEtapaProcesoSelecionQueryMapper.class, criteria);
							tConvAreaOrgEtapa.setIdarea(record.getIdarea());
							tConvAreaOrgEtapa.setIdunidad(record.getIdunidad());
						}
						
						this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);	
					}
					
				}
				
			}
			
		}
		
		for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
		
			convocatoriaEtapaQuery.setSrl_id_conv_fecha_etapa_config(null);
			convocatoriaEtapaQuery.setSrl_id_convocatoria(tConvocatoria.getSrl_id_convocatoria());
			TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(convocatoriaEtapaQuery, TConvFechaEtapaConfig.class);
			this.insertSelective(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
			
		}
		
		lastId = tConvocatoria.getSrl_id_convocatoria();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException {
	    
		
//		List<ConvocatoriaPlazaQuery> listCPQ  = new ArrayList<ConvocatoriaPlazaQuery>();
		
		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		tConvocatoria.setTsp_fecha_registro(new Date());
		this.updateByPrimaryKeySelective(TConvocatoriaMapper.class, tConvocatoria);
		
		TConvocatoriaAreaOrgExample tConvocatoriaAreaOrgExample = new TConvocatoriaAreaOrgExample();
		tConvocatoriaAreaOrgExample.createCriteria().andSrl_id_convocatoriaEqualTo(tConvocatoria.getSrl_id_convocatoria());
		List<TConvocatoriaAreaOrg> listTConvocatoriaAreaOrgCurrent = this.selectByExample(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgExample);
		List<TConvocatoriaAreaOrg> listTConvocatoriaAreaOrgDeleted = new ArrayList<TConvocatoriaAreaOrg>();
		
		for (TConvocatoriaAreaOrg tConvocatoriaAreaOrg : listTConvocatoriaAreaOrgCurrent) {
			boolean noExists = true;
			for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery : listConvocatoriaPlazaQuery) {
				if(convocatoriaPlazaQuery.getSrl_id_conv_area_org().equals(tConvocatoriaAreaOrg.getSrl_id_conv_area_org()) ){
					noExists = false;
					break;
				}
			} 
			if(noExists){
				listTConvocatoriaAreaOrgDeleted.add(tConvocatoriaAreaOrg);
			}
		}
		
//		this.deleteByPrimaryKey(TConvocatoriaAreaOrgMapper.class, listTConvocatoriaAreaOrgDeleted);
		
		for(TConvocatoriaAreaOrg tConvocatoriaAreaOrg : listTConvocatoriaAreaOrgDeleted){
			
			TPostulanteCnvAreaOrgExample tPostulanteCnvAreaOrgExample = new TPostulanteCnvAreaOrgExample();
			tPostulanteCnvAreaOrgExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
			
			List<TPostulanteCnvAreaOrg> listPostulanteCnvAreaOrgs = this.selectByExample(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgExample);
			
			if(!listPostulanteCnvAreaOrgs.isEmpty()){
				throw new BusinessException("La Plaza: "+ tConvocatoriaAreaOrg.getVar_codigo_postulacion() + " ya tiene postulantes registados, no se puede eliminar.");
			}
			
			TConvAreaOrgEtapaExample example = new TConvAreaOrgEtapaExample();
			example.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
			
			List<TConvAreaOrgEtapa> listTConvAreaOrgEtapa = this.selectByExample(TConvAreaOrgEtapaMapper.class, example);
			
			this.deleteByPrimaryKey(TConvAreaOrgEtapaMapper.class, listTConvAreaOrgEtapa);
			this.deleteByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
		}
		
		
		for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery : listConvocatoriaPlazaQuery) {
			
			if(convocatoriaPlazaQuery.getSrl_id_conv_area_org() < 1){
			
					convocatoriaPlazaQuery.setSrl_id_conv_area_org(null);
					convocatoriaPlazaQuery.setSrl_id_convocatoria(tConvocatoria.getSrl_id_convocatoria());
					
					System.out.println("Fecha Inicio : " + convocatoriaPlazaQuery.getDte_fecha_inicio_contrato());
					System.out.println("Fecha Fín : " + convocatoriaPlazaQuery.getDte_fecha_fin_contrato());
					
					TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(convocatoriaPlazaQuery, TConvocatoriaAreaOrg.class);
					tConvocatoriaAreaOrg.setIdarea(convocatoriaPlazaQuery.getIdarea_solicitante());
					tConvocatoriaAreaOrg.setIdunidad(convocatoriaPlazaQuery.getIdunidad_solicitante());
					tConvocatoriaAreaOrg.setInt_num_puestos(convocatoriaPlazaQuery.getInt_cantidad_requerida());

					this.insertSelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
					
					TConfiguracionEtapaExample example = new TConfiguracionEtapaExample();
					example.createCriteria().andSrl_id_configuracion_evaluacion_personalEqualTo(convocatoriaPlazaQuery.getSrl_id_configuracion_evaluacion_personal());
					example.setOrderByClause("int_orden");
					
					List<TConfiguracionEtapa> list = this.selectByExample(TConfiguracionEtapaMapper.class, example);

						for(TConfiguracionEtapa obj : list){
							
							for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
							
							if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().equals(obj.getSrl_id_subetapa_proceso_seleccion())){
								TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(convocatoriaEtapaQuery, TConvAreaOrgEtapa.class);
								tConvAreaOrgEtapa.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
								
								//si la subetapa es entrevista personal
								if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().intValue() == 7){
									
									TRequerimientoPersonalKey rk = new TRequerimientoPersonal();
									rk.setSrl_id_requerimiento_personal(tConvocatoriaAreaOrg.getSrl_id_requerimiento_personal());
									
									TRequerimientoPersonal r = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, rk);
									
									tConvAreaOrgEtapa.setIdarea(r.getIdarea_solicitante());
									tConvAreaOrgEtapa.setIdunidad(r.getIdunidad_solicitante());
									
								}else{
									
									SubEtapaProcesoSelecionQueryCriteria criteria = new SubEtapaProcesoSelecionQueryCriteria();
									criteria.setSrl_id_subetapa_proceso_seleccion(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion());
									
									SubEtapaProcesoSelecionQuery record = this.getRecordByQuery(SubEtapaProcesoSelecionQueryMapper.class, criteria);
									tConvAreaOrgEtapa.setIdarea(record.getIdarea());
									tConvAreaOrgEtapa.setIdunidad(record.getIdunidad());
								}
								
								this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);	
							}
							
						}

				}
				
								 
			}else{
				
				TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(convocatoriaPlazaQuery, TConvocatoriaAreaOrg.class);
				tConvocatoriaAreaOrg.setIdarea(convocatoriaPlazaQuery.getIdarea_solicitante());
				tConvocatoriaAreaOrg.setIdunidad(convocatoriaPlazaQuery.getIdunidad_solicitante());
				tConvocatoriaAreaOrg.setInt_num_puestos(convocatoriaPlazaQuery.getInt_cantidad_requerida());
				
				TConvocatoriaAreaOrgKey tConvocatoriaAreaOrgKey = new TConvocatoriaAreaOrgKey();
				tConvocatoriaAreaOrgKey.setSrl_id_conv_area_org(convocatoriaPlazaQuery.getSrl_id_conv_area_org());
				
				TConvocatoriaAreaOrg tConvocatoriaAreaOrgCurrent = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgKey);
				
				
				if(!tConvocatoriaAreaOrg.getSrl_id_configuracion_evaluacion_personal().equals(tConvocatoriaAreaOrgCurrent.getSrl_id_configuracion_evaluacion_personal())){
					
					TConvAreaOrgEtapaExample tConvAreaOrgEtapaExample = new TConvAreaOrgEtapaExample();
					tConvAreaOrgEtapaExample.createCriteria().andSrl_id_conv_area_orgEqualTo(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
					
					List<TConvAreaOrgEtapa> listTConvAreaOrgEtapa = this.selectByExample(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapaExample);
					
					this.deleteByPrimaryKey(TConvAreaOrgEtapaMapper.class, listTConvAreaOrgEtapa);
					
					TConfiguracionEtapaExample example = new TConfiguracionEtapaExample();
					example.createCriteria().andSrl_id_configuracion_evaluacion_personalEqualTo(convocatoriaPlazaQuery.getSrl_id_configuracion_evaluacion_personal());
					example.setOrderByClause("int_orden");
					
					List<TConfiguracionEtapa> list = this.selectByExample(TConfiguracionEtapaMapper.class, example);

						for(TConfiguracionEtapa obj : list){
							
							for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
							
							if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().equals(obj.getSrl_id_subetapa_proceso_seleccion())){
								TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(convocatoriaEtapaQuery, TConvAreaOrgEtapa.class);
								tConvAreaOrgEtapa.setSrl_id_conv_area_org(tConvocatoriaAreaOrg.getSrl_id_conv_area_org());
								
								//si la subetapa es entrevista personal
								if(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion().intValue() == 7){
									
									TRequerimientoPersonalKey rk = new TRequerimientoPersonal();
									rk.setSrl_id_requerimiento_personal(tConvocatoriaAreaOrg.getSrl_id_requerimiento_personal());
									
									TRequerimientoPersonal r = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, rk);
									
									tConvAreaOrgEtapa.setIdarea(r.getIdarea_solicitante());
									tConvAreaOrgEtapa.setIdunidad(r.getIdunidad_solicitante());
									
								}else{
									
									SubEtapaProcesoSelecionQueryCriteria criteria = new SubEtapaProcesoSelecionQueryCriteria();
									criteria.setSrl_id_subetapa_proceso_seleccion(convocatoriaEtapaQuery.getSrl_id_subetapa_proceso_seleccion());
									
									SubEtapaProcesoSelecionQuery record = this.getRecordByQuery(SubEtapaProcesoSelecionQueryMapper.class, criteria);
									tConvAreaOrgEtapa.setIdarea(record.getIdarea());
									tConvAreaOrgEtapa.setIdunidad(record.getIdunidad());
								}
								
								this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);	
							}
							
						}
						
					}
				}
				
				if(!convocatoriaPlazaQuery.getSrl_id_configuracion_factor_evaluacion().equals(tConvocatoriaAreaOrgCurrent.getSrl_id_configuracion_factor_evaluacion())){
					ConsultaExisteNotasPlazaQueryCriteria criteria = new ConsultaExisteNotasPlazaQueryCriteria();
					criteria.setSrl_id_conv_area_org(convocatoriaPlazaQuery.getSrl_id_conv_area_org());
					
					List<ConsultaExisteNotasPlazaQuery> list = this.getListByQuery(ConsultaExisteNotasPlazaQueryMapper.class, criteria);
					
					if(!list.isEmpty()){
						throw new BusinessException("La Plaza: "+ tConvocatoriaAreaOrg.getVar_codigo_postulacion() + " ya tiene notas registradas, no se puede cambiar los factores de evauluación.");
					}
				}
				
				this.updateByPrimaryKeySelective(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
			}
		}
		
		
		/* End TConvocatoriaAreaOrg */	
		/* Start TConvFechaEtapaConfig */
		
		TConvFechaEtapaConfigExample tConvFechaEtapaConfigExample = new TConvFechaEtapaConfigExample();
		tConvFechaEtapaConfigExample.createCriteria().andSrl_id_convocatoriaEqualTo(tConvocatoria.getSrl_id_convocatoria());
		List<TConvFechaEtapaConfig> listTConvFechaEtapaConfigCurrent = this.selectByExample(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfigExample);
		List<TConvFechaEtapaConfig> listTConvFechaEtapaConfigDeleted = new ArrayList<TConvFechaEtapaConfig>();
		
		for (TConvFechaEtapaConfig tConvFechaEtapaConfig : listTConvFechaEtapaConfigCurrent) {
			boolean noExists = true;
			for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
				if(convocatoriaEtapaQuery.getSrl_id_conv_fecha_etapa_config().equals(tConvFechaEtapaConfig.getSrl_id_conv_fecha_etapa_config())){
					noExists = false;
					break;
				}
			}
			if(noExists){
				listTConvFechaEtapaConfigDeleted.add(tConvFechaEtapaConfig);
			}
		}
		
		this.deleteByPrimaryKey(TConvFechaEtapaConfigMapper.class, listTConvFechaEtapaConfigDeleted);
		
		for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
			if(convocatoriaEtapaQuery.getSrl_id_conv_fecha_etapa_config() < 1){
				convocatoriaEtapaQuery.setSrl_id_conv_fecha_etapa_config(null);
				convocatoriaEtapaQuery.setSrl_id_convocatoria(tConvocatoria.getSrl_id_convocatoria());
				TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(convocatoriaEtapaQuery, TConvFechaEtapaConfig.class);
				this.insertSelective(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
				

			}else{
				TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(convocatoriaEtapaQuery, TConvFechaEtapaConfig.class);
				this.updateByPrimaryKeySelective(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
				

			}
		}
		
//		for (ConvocatoriaPlazaQuery listaConvocatoriapq : listCPQ) {
//			  
//					TConvAreaOrgEtapaExample criteria = new TConvAreaOrgEtapaExample();
//					criteria.createCriteria().andSrl_id_conv_area_orgEqualTo(listaConvocatoriapq.getSrl_id_conv_area_org());
//					
//					List<TConvAreaOrgEtapa> list = tConvAreaOrgEtapaMapper.selectByExample(criteria);
//					
//					if(!list.isEmpty()){ 
//						
//						for (ConvocatoriaEtapaQuery ceq : listConvocatoriaEtapaQuery) {
//												
//							TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(ceq, TConvAreaOrgEtapa.class);
//							tConvAreaOrgEtapa.setSrl_id_conv_area_org(listaConvocatoriapq.getSrl_id_conv_area_org());
//							this.updateByPrimaryKeySelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
//						}	
//						
//					}else{
//						
//						for (ConvocatoriaEtapaQuery ceq : listConvocatoriaEtapaQuery) {
//						
//							TConvAreaOrgEtapa tConvAreaOrgEtapa = beanUtil.copyBean(ceq, TConvAreaOrgEtapa.class);
//							tConvAreaOrgEtapa.setSrl_id_conv_area_org(listaConvocatoriapq.getSrl_id_conv_area_org());
//							this.insertSelective(TConvAreaOrgEtapaMapper.class, tConvAreaOrgEtapa);
//						
//						}
//					}
//			
//			
//
//		}

		/* End TConvFechaEtapaConfig */	
		
		
		
		/* ADD 25-01-2016 DAVID        UPDATE FECHA APROBACION DEL REQUERIMIENTO POR OA*/
		List<TRequerimientoPersonal> fecha_apro_oa_rq = new ArrayList<TRequerimientoPersonal>();
		
		
		
		
		SimpleDateFormat sdf = null; 
		java.util.Date dt    = null;
		java.sql.Date dte    = null;
		sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery : listConvocatoriaPlazaQuery) {
			
			TRequerimientoPersonalKey pk = new TRequerimientoPersonalKey();
			pk.setSrl_id_requerimiento_personal(convocatoriaPlazaQuery.getSrl_id_requerimiento_personal());
			TRequerimientoPersonal obj = this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, pk);							
			
			try {
				dt  = sdf.parse(convocatoriaPlazaQuery.getDte_fec_aprobacion_oa());
				dte = new java.sql.Date(dt.getTime());	
			} catch (Exception e) {
				e.printStackTrace();
			}			
			
			obj.setDte_fec_aprobacion_oa(dte );
			
			fecha_apro_oa_rq.add(obj);
		}
		
		this.updateByPrimaryKey(TRequerimientoPersonalMapper.class, fecha_apro_oa_rq);
		/* END  */
		
	}

	@Transactional
	@Override
	public void remove(GestionarConvocatoriaPersonalQuery model, List<ConvocatoriaPlazaQuery> listConvocatoriaPlazaQuery, List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery, List<ConvocatoriaPlazaFactorQuery> listConvocatoriaPlazaFactorQuery) throws BusinessException {
	
		for (ConvocatoriaPlazaQuery convocatoriaPlazaQuery : listConvocatoriaPlazaQuery) {
			TConvocatoriaAreaOrg tConvocatoriaAreaOrg = beanUtil.copyBean(convocatoriaPlazaQuery, TConvocatoriaAreaOrg.class);
			this.deleteByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrg);
		}
		for (ConvocatoriaEtapaQuery convocatoriaEtapaQuery : listConvocatoriaEtapaQuery) {
			TConvFechaEtapaConfig tConvFechaEtapaConfig = beanUtil.copyBean(convocatoriaEtapaQuery, TConvFechaEtapaConfig.class);
			this.deleteByPrimaryKey(TConvFechaEtapaConfigMapper.class, tConvFechaEtapaConfig);
		}

		TConvocatoria tConvocatoria = beanUtil.copyBean(model, TConvocatoria.class);
		this.deleteByPrimaryKey(TConvocatoriaMapper.class, tConvocatoria);
	}
	
	public List<ConvocatoriaEtapaQuery> relanzarConvocatoria(){

		ObtenerListaConfiguracionEtapasQueryCriteria criteria = new ObtenerListaConfiguracionEtapasQueryCriteria();
		criteria.setInt_id_estado(1);
		List<ObtenerListaConfiguracionEtapasQuery> lista = getListByQuery(ObtenerListaConfiguracionEtapasQueryMapper.class,criteria);
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery  = new ArrayList<ConvocatoriaEtapaQuery>();
		
		
		
	   for (ObtenerListaConfiguracionEtapasQuery obtenerListaConfiguracionEtapasQuery : lista) {
		
		   ConvocatoriaEtapaQuery convQuery = new ConvocatoriaEtapaQuery();
		   convQuery.setSrl_id_etapa_proceso_seleccion(obtenerListaConfiguracionEtapasQuery.getSrl_id_etapa_proceso_seleccion());
		   convQuery.setSrl_id_subetapa_proceso_seleccion(obtenerListaConfiguracionEtapasQuery.getSrl_id_subetapa_proceso_seleccion());
		   convQuery.setVar_nombre_etapa(obtenerListaConfiguracionEtapasQuery.getVar_nombre_etapa());
		   convQuery.setVar_descrip_subetapa(obtenerListaConfiguracionEtapasQuery.getVar_descrip_subetapa());
		   convQuery.setInt_id_estado(obtenerListaConfiguracionEtapasQuery.getInt_id_estado());
		   listConvocatoriaEtapaQuery.add(convQuery);

	   }
				
		return listConvocatoriaEtapaQuery;
			
   }
	
	public List<ConvocatoriaEtapaQuery> obtenerListaConfiguracionEtapas(){

		ObtenerListaConfiguracionEtapasQueryCriteria criteria = new ObtenerListaConfiguracionEtapasQueryCriteria();
		criteria.setInt_id_estado(1);
		List<ObtenerListaConfiguracionEtapasQuery> lista = getListByQuery(ObtenerListaConfiguracionEtapasQueryMapper.class,criteria);
		List<ConvocatoriaEtapaQuery> listConvocatoriaEtapaQuery  = new ArrayList<ConvocatoriaEtapaQuery>();
		
		
		
	   for (ObtenerListaConfiguracionEtapasQuery obtenerListaConfiguracionEtapasQuery : lista) {
		
		   ConvocatoriaEtapaQuery convQuery = new ConvocatoriaEtapaQuery();
		   convQuery.setSrl_id_etapa_proceso_seleccion(obtenerListaConfiguracionEtapasQuery.getSrl_id_etapa_proceso_seleccion());
		   convQuery.setSrl_id_subetapa_proceso_seleccion(obtenerListaConfiguracionEtapasQuery.getSrl_id_subetapa_proceso_seleccion());
		   convQuery.setVar_nombre_etapa(obtenerListaConfiguracionEtapasQuery.getVar_nombre_etapa());
		   convQuery.setVar_descrip_subetapa(obtenerListaConfiguracionEtapasQuery.getVar_descrip_subetapa());
		   convQuery.setInt_id_estado(obtenerListaConfiguracionEtapasQuery.getInt_id_estado());
		   listConvocatoriaEtapaQuery.add(convQuery);

	   }
				
		return listConvocatoriaEtapaQuery;
			
   }
	
	@Transactional
	@Override
	public Integer relanzar(Integer srl_id_convocatoria) throws BusinessException {
		
		Integer lastId = null;
		
		TConvocatoriaKey pk = new TConvocatoriaKey();
		pk.setSrl_id_convocatoria(srl_id_convocatoria);
		
		TConvocatoria tConvocatoriaPadre = this.selectByPrimaryKey(TConvocatoriaMapper.class, pk);
        
		ObtenerUltimaActivacionPlazaQueryCriteria criteria = new ObtenerUltimaActivacionPlazaQueryCriteria();
		criteria.setVar_num_convocatoria(tConvocatoriaPadre.getVar_num_convocatoria());
		
		ObtenerUltimaActivacionPlazaQuery obj = this.getRecordByQuery(ObtenerUltimaActivacionPlazaQueryMapper.class, criteria);
		
		
		
		TConvocatoria tConvocatoria = new TConvocatoria();
		tConvocatoria.setVar_num_convocatoria(tConvocatoriaPadre.getVar_num_convocatoria());
		tConvocatoria.setTsp_fecha_registro(new Date());
		tConvocatoria.setInt_num_activacion(obj.getInt_ultima_activacion().intValue() + 1);
		tConvocatoria.setInt_id_estado(1);
		
		/* STAR */
		
		List<TConvocatoriaAreaOrg> list_conv_area_org 	= new ArrayList<TConvocatoriaAreaOrg>();
		
		List<TPostulanteCnvAreaOrg> list_post_area_org 	= null;	
		
		List<TConvAreaOrgEtapa> list_etapa_plaza 		= null;
		
		List<TConvFechaEtapaConfig> list_fec_eta_conv	= null;
		
		TConvocatoriaAreaOrgExample example  = new TConvocatoriaAreaOrgExample();
		example.createCriteria().andSrl_id_convocatoriaEqualTo(srl_id_convocatoria);
		
		list_conv_area_org = this.selectByExample(TConvocatoriaAreaOrgMapper.class, example);	

		
		this.insertSelective(TConvocatoriaMapper.class, tConvocatoria);
		
		lastId = tConvocatoria.getSrl_id_convocatoria();
		
		for(TConvocatoriaAreaOrg x : list_conv_area_org){
			
			Integer req_cant_solicitad 		= 0;
			Integer cant_suscrito_x_req 	= 0;
			Integer cant_disponible_x_req 	= 0;			
			
			TRequerimientoPersonalKey pkrp 	= new TRequerimientoPersonalKey();			
			pkrp.setSrl_id_requerimiento_personal(x.getSrl_id_requerimiento_personal());
			
			TRequerimientoPersonal rp 		= this.selectByPrimaryKey(TRequerimientoPersonalMapper.class, pkrp);
			
			req_cant_solicitad 				= rp.getInt_cantidad_requerida();
			
			
			TPostulanteCnvAreaOrgExample ex = new TPostulanteCnvAreaOrgExample();
			ex.createCriteria().andSrl_id_conv_area_orgEqualTo(x.getSrl_id_conv_area_org()).andInt_id_estadoEqualTo(3);
			
			list_post_area_org 				= this.selectByExample(TPostulanteCnvAreaOrgMapper.class, ex);
			
			cant_suscrito_x_req 			= list_post_area_org.size();
			
			cant_disponible_x_req 			= req_cant_solicitad - cant_suscrito_x_req;		
		
			
			if(cant_disponible_x_req > 0){			
				
				//Select etapas
				
				TConvAreaOrgEtapaExample exetapas = new TConvAreaOrgEtapaExample();
				exetapas.createCriteria().andSrl_id_conv_area_orgEqualTo(x.getSrl_id_conv_area_org());
				
				list_etapa_plaza				= this.selectByExample(TConvAreaOrgEtapaMapper.class, exetapas);
				
				//Select fecha_etapa_config
				if(list_fec_eta_conv == null ){
					
					TConvFechaEtapaConfigExample exampleFE = new TConvFechaEtapaConfigExample();
					exampleFE.createCriteria().andSrl_id_convocatoriaEqualTo(x.getSrl_id_convocatoria());
					
					list_fec_eta_conv			= this.selectByExample(TConvFechaEtapaConfigMapper.class, exampleFE);
					
					if(list_fec_eta_conv.size() > 0 ){
						
						for(TConvFechaEtapaConfig z : list_fec_eta_conv){
							
							z.setSrl_id_convocatoria(lastId);
							z.setDte_fecha_inicio(null);
							z.setDte_fecha_termino(null);
							z.setTsp_fecha_registro(new Date());
							
							this.insertSelective(TConvFechaEtapaConfigMapper.class, z);
							
						}
					}
					
				}				
				
				x.setSrl_id_convocatoria(lastId);
				x.setInt_num_puestos(cant_disponible_x_req);
				x.setInt_id_estado(1);
				x.setInt_num_activacion(1);
				x.setTsp_fecha_registro(new Date());
				x.setDte_fecha_inicio_contrato(null);
				x.setDte_fecha_fin_contrato(null);	
				
				
				if(list_etapa_plaza.size() > 0){
					
					this.insertSelective(TConvocatoriaAreaOrgMapper.class, x);
					
					for(TConvAreaOrgEtapa j : list_etapa_plaza){
						j.setSrl_id_conv_area_org(x.getSrl_id_conv_area_org());
						j.setDte_fecha_inicio(null);
						j.setDte_fecha_termino(null);
						j.setTsp_fecha_registro(new Date());
						
						this.insert(TConvAreaOrgEtapaMapper.class, j);
					}					
				}				
				
			}
			

						
			
		}
				
		/* END */
		
		return lastId;
		
	}


}
