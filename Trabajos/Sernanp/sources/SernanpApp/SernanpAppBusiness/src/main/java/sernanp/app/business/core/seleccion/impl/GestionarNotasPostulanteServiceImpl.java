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
* DATE CREATE : 20/04/2015 14:52:17
* VERSION : 1.0 
*/

package sernanp.app.business.core.seleccion.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.seleccion.service.GestionarNotasPostulanteService;
import sernanp.app.dao.domain.TConvAreaOrgFactorEval;
import sernanp.app.dao.domain.TConvAreaOrgFactorEvalExample;
import sernanp.app.dao.domain.TConvocatoriaAreaOrg;
import sernanp.app.dao.domain.TConvocatoriaAreaOrgKey;
import sernanp.app.dao.domain.TFactorEvaluacion;
import sernanp.app.dao.domain.TFactorEvaluacionExample;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrg;
import sernanp.app.dao.domain.TPostulanteCnvAreaOrgKey;
import sernanp.app.dao.domain.TPostulantePersonal;
import sernanp.app.dao.domain.TPostulantePersonalKey;
import sernanp.app.dao.mapper.TConvAreaOrgFactorEvalMapper;
import sernanp.app.dao.mapper.TConvocatoriaAreaOrgMapper;
import sernanp.app.dao.mapper.TFactorEvaluacionMapper;
import sernanp.app.dao.mapper.TPostulanteCnvAreaOrgMapper;
import sernanp.app.dao.mapper.TPostulantePersonalMapper;
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQuery;
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQueryCriteria;
import sernanp.app.dao.query.domain.ObtenerFactorPorConfiguracionQuery;
import sernanp.app.dao.query.domain.ObtenerFactorPorConfiguracionQueryCriteria;
import sernanp.app.dao.query.mapper.GestionarNotasPostulanteQueryMapper;
import sernanp.app.dao.query.mapper.ObtenerFactorPorConfiguracionQueryMapper;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionarNotasPostulanteServiceImpl extends HelperServiceMybatisImpl implements GestionarNotasPostulanteService {

	@Autowired
	private BeanUtil beanUtil;
	
	private int ESTADO_CLASIFICACION_APROBADO = 1;
	private int ESTADO_CLASIFICACION_DESAPROBADO = 2;
	private int ESTADO_CLASIFICACION_NO_RINDIO = 3;
	
	private int ESTADO_ASISTENCIA_PRESENTE = 1;
	private int ESTADO_ASISTENCIA_AUSENTE = 2;
	
	private int TIPO_FACTOR_ENTREVISTA = 5;
	
	private int PERTENECE_FFAA = 1;
	
	private int ESTADO_POSTULACION_APROBADO = 7;
	private int ESTADO_POSTULACION_DESAPROBADO = 8;
	
	
	@Transactional
	@Override
	public Integer create(GestionarNotasPostulanteQuery model) throws BusinessException {
	
		Integer lastId = null;

		TConvAreaOrgFactorEval tConvAreaOrgFactorEval = beanUtil.copyBean(model, TConvAreaOrgFactorEval.class);
		this.insertSelective(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEval);

		lastId = tConvAreaOrgFactorEval.getSrl_conv_area_org_factor_eval();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarNotasPostulanteQuery model) throws BusinessException {

		boolean factorDesaprobado = false;
		Integer idFactorDesaprobado = null;
		if(model.getDec_puntaje_obtenido() == null){
			model.setDec_puntaje_obtenido(new Double(0));
		}
		
		/* 
		  
		 * SE HA COMENTADO A SOLICITU DEL USUARIO - 18-02-2016 DAVID
		 
		if(model.getInt_id_estado_asistencia().intValue() != ESTADO_ASISTENCIA_AUSENTE){
			if(this.existeFactorDesaprobado(model)){
				throw new BusinessException("Ya existen factores desaprobados.");
			}
		}
		*/
		
		TConvAreaOrgFactorEval tConvAreaOrgFactorEval = beanUtil.copyBean(model, TConvAreaOrgFactorEval.class);
		this.calcularEstadoClasificacion(model, tConvAreaOrgFactorEval);
		this.updateByPrimaryKey(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEval);
		
		/*

		 * SE HA COMENTADO A SOLICITU DEL USUARIO - 18-02-2016 DAVID
 
		if(tConvAreaOrgFactorEval.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_DESAPROBADO 
				|| 
				tConvAreaOrgFactorEval.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_NO_RINDIO){
			
			idFactorDesaprobado = tConvAreaOrgFactorEval.getSrl_conv_area_org_factor_eval();
		}
		
		if(idFactorDesaprobado != null){
			TConvAreaOrgFactorEvalExample example = new TConvAreaOrgFactorEvalExample();
			example.createCriteria().andSrl_id_postulante_conv_area_orgEqualTo(tConvAreaOrgFactorEval.getSrl_id_postulante_conv_area_org());
			example.setOrderByClause("srl_conv_area_org_factor_eval");
			List<TConvAreaOrgFactorEval> list = this.selectByExample(TConvAreaOrgFactorEvalMapper.class, example);
			
			for (TConvAreaOrgFactorEval x : list) {
				if(x.getSrl_conv_area_org_factor_eval().equals(idFactorDesaprobado)){
					factorDesaprobado = true;
					continue;
				}
				if(factorDesaprobado){
					x.setDec_puntaje_obtenido(null);
					x.setDec_puntaje_calculado(null);
					x.setInt_id_estado_asistencia(null);
					x.setInt_id_estado_clasificacion(null);
					this.updateByPrimaryKey(TConvAreaOrgFactorEvalMapper.class, x);
				}
			}
		}
		
		*/
		
		if(model.getInt_id_tipo_factor_padre() != null){
			TConvAreaOrgFactorEval tConvAreaOrgFactorEvalPadre = this.calcularEstadoClasificacionFactorPadre(model);
			this.updateByPrimaryKey(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEvalPadre);
		}
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.calcularTotales(model);
		if(tPostulanteCnvAreaOrg != null){
			this.updateByPrimaryKeySelective(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
			TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
			tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(tPostulanteCnvAreaOrg.getSrl_id_postulante_conv_area_org());
			tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
			tPostulanteCnvAreaOrg.setInt_orden_merito(null);
			this.updateByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrg);
		}
	}

	@Transactional
	@Override
	public void remove(GestionarNotasPostulanteQuery model) throws BusinessException {

		TConvAreaOrgFactorEval tConvAreaOrgFactorEval = beanUtil.copyBean(model, TConvAreaOrgFactorEval.class);
		this.deleteByPrimaryKey(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEval);
	}
	
	@Transactional
	@Override
	public void agregarFactores(Integer srl_id_postulante_conv_area_org) throws BusinessException {
		
		TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
		tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
		
		TConvocatoriaAreaOrgKey  tConvocatoriaAreaOrgKey = new TConvocatoriaAreaOrgKey();
		tConvocatoriaAreaOrgKey.setSrl_id_conv_area_org(tPostulanteCnvAreaOrg.getSrl_id_conv_area_org());
		
		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgKey);
		
		ObtenerFactorPorConfiguracionQueryCriteria criteria = new ObtenerFactorPorConfiguracionQueryCriteria();
		criteria.setSrl_id_configuracion_factor_evaluacion(tConvocatoriaAreaOrg.getSrl_id_configuracion_factor_evaluacion());
		
		List<ObtenerFactorPorConfiguracionQuery> listObtenerFactorPorConfiguracionQuery = this.getListByQuery(ObtenerFactorPorConfiguracionQueryMapper.class, criteria);
		
		for(ObtenerFactorPorConfiguracionQuery obtenerFactorPorConfiguracionQuery : listObtenerFactorPorConfiguracionQuery){
			TConvAreaOrgFactorEval tConvAreaOrgFactorEval = new TConvAreaOrgFactorEval();
			tConvAreaOrgFactorEval.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
			tConvAreaOrgFactorEval.setSrl_id_factor_evaluacion(obtenerFactorPorConfiguracionQuery.getSrl_id_factor_evaluacion());
			tConvAreaOrgFactorEval.setInt_id_estado(1);
			this.insertSelective(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEval);
		}
		
	}
	
	public TFactorEvaluacion obtenerFactorEvaluacion(Integer srl_id_postulante_conv_area_org, Integer int_id_tipo_factor) throws BusinessException {
		
		TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
		tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
		
		TConvocatoriaAreaOrgKey  tConvocatoriaAreaOrgKey = new TConvocatoriaAreaOrgKey();
		tConvocatoriaAreaOrgKey.setSrl_id_conv_area_org(tPostulanteCnvAreaOrg.getSrl_id_conv_area_org());
		
		TConvocatoriaAreaOrg tConvocatoriaAreaOrg = this.selectByPrimaryKey(TConvocatoriaAreaOrgMapper.class, tConvocatoriaAreaOrgKey);
		
		TFactorEvaluacionExample example = new TFactorEvaluacionExample();
		example.createCriteria().andSrl_id_configuracion_factor_evaluacionEqualTo(tConvocatoriaAreaOrg.getSrl_id_configuracion_factor_evaluacion()).
		andInt_id_tipo_factorEqualTo(int_id_tipo_factor);
		
		List<TFactorEvaluacion> list = this.selectByExample(TFactorEvaluacionMapper.class, example);
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;

	}
	
	public boolean existeFactorDesaprobado(GestionarNotasPostulanteQuery model) throws BusinessException {
		
		GestionarNotasPostulanteQueryCriteria criteria = new GestionarNotasPostulanteQueryCriteria();
		criteria.setSrl_id_postulante_conv_area_org(model.getSrl_id_postulante_conv_area_org());
		
		List<GestionarNotasPostulanteQuery> listGestionarNotasPostulanteQuery = this.getListByQuery(GestionarNotasPostulanteQueryMapper.class, criteria);
		
		for(GestionarNotasPostulanteQuery gestionarNotasPostulanteQuery : listGestionarNotasPostulanteQuery){
			if(!gestionarNotasPostulanteQuery.getSrl_conv_area_org_factor_eval().equals(model.getSrl_conv_area_org_factor_eval())){
				if(gestionarNotasPostulanteQuery.getInt_id_tipo_factor_padre() == null){
					if(!this.contieneSubItems(listGestionarNotasPostulanteQuery, gestionarNotasPostulanteQuery.getInt_id_tipo_factor())){
						if(gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion() != null){
							if(gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_DESAPROBADO || gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_NO_RINDIO){
								return true;
							}
						}
						
					}
				}else{
					if(gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion() != null){
						if(gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_DESAPROBADO || gestionarNotasPostulanteQuery.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_NO_RINDIO){
							return true;
						}
					}
					
				}
			}
		}
		return false;
	}
	
	public boolean contieneSubItems(List<GestionarNotasPostulanteQuery> listGestionarNotasPostulanteQuery, Integer int_id_tipo_factor){
		for(GestionarNotasPostulanteQuery gestionarNotasPostulanteQuery : listGestionarNotasPostulanteQuery){
			
			if(gestionarNotasPostulanteQuery.getInt_id_tipo_factor_padre() != null){
				if(gestionarNotasPostulanteQuery.getInt_id_tipo_factor_padre().equals(int_id_tipo_factor)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	public TPostulantePersonal obtenerPostulante(Integer srl_id_postulante_conv_area_org){
		
		TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
		tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(srl_id_postulante_conv_area_org);
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
		
		TPostulantePersonalKey tPostulantePersonalKey = new TPostulantePersonalKey();
		tPostulantePersonalKey.setInt_id_postulante(tPostulanteCnvAreaOrg.getInt_id_postulante());
		
		TPostulantePersonal tPostulantePersonal = this.selectByPrimaryKey(TPostulantePersonalMapper.class, tPostulantePersonalKey);
		
		return tPostulantePersonal;
	}
	
	public void calcularEstadoClasificacion(GestionarNotasPostulanteQuery model, TConvAreaOrgFactorEval tConvAreaOrgFactorEval) throws BusinessException {
		
		TFactorEvaluacion tFactorEvaluacion = this.obtenerFactorEvaluacion(model.getSrl_id_postulante_conv_area_org(),model.getInt_id_tipo_factor());
		TFactorEvaluacion tFactorEvaluacionPadre = null;
		
		if(model.getInt_id_tipo_factor_padre() != null){
			tFactorEvaluacionPadre = this.obtenerFactorEvaluacion(model.getSrl_id_postulante_conv_area_org(),model.getInt_id_tipo_factor_padre());
		}
		
		double puntajeCalculado = model.getDec_puntaje_obtenido().doubleValue();
		
		if(model.getInt_id_estado_asistencia().intValue() == ESTADO_ASISTENCIA_AUSENTE){
			tConvAreaOrgFactorEval.setInt_id_estado_clasificacion(ESTADO_CLASIFICACION_NO_RINDIO);
			tConvAreaOrgFactorEval.setDec_puntaje_calculado(new BigDecimal(0));
			tConvAreaOrgFactorEval.setDec_puntaje_obtenido(new BigDecimal(0));
		}else{
			
			if(tFactorEvaluacionPadre != null){
				puntajeCalculado = tFactorEvaluacionPadre.getDec_peso().doubleValue() * puntajeCalculado;
			}
			
			puntajeCalculado = tFactorEvaluacion.getDec_peso().doubleValue() * puntajeCalculado;  
			
			TPostulantePersonal tPostulantePersonal = this.obtenerPostulante(model.getSrl_id_postulante_conv_area_org());
			
			if(tPostulantePersonal.getInt_pertenece_ffaa() != null){
				if(tPostulantePersonal.getInt_pertenece_ffaa().intValue() == PERTENECE_FFAA){
					if(model.getInt_id_tipo_factor().intValue() == TIPO_FACTOR_ENTREVISTA){
						puntajeCalculado = puntajeCalculado * 1.1;
					}
				}
			}
			
			if(puntajeCalculado >= tFactorEvaluacion.getDec_puntaje_min().doubleValue()){
				tConvAreaOrgFactorEval.setInt_id_estado_clasificacion(ESTADO_CLASIFICACION_APROBADO);
			}else{
				tConvAreaOrgFactorEval.setInt_id_estado_clasificacion(ESTADO_CLASIFICACION_DESAPROBADO);
			}
			
			if(puntajeCalculado > tFactorEvaluacion.getDec_puntaje_max().doubleValue()){
				puntajeCalculado = tFactorEvaluacion.getDec_puntaje_max().doubleValue();
			}

			tConvAreaOrgFactorEval.setDec_puntaje_calculado(new BigDecimal(puntajeCalculado));
			
		}
		
	}
	
	public TConvAreaOrgFactorEval calcularEstadoClasificacionFactorPadre(GestionarNotasPostulanteQuery model){
		
		GestionarNotasPostulanteQueryCriteria criteria = new GestionarNotasPostulanteQueryCriteria();
		criteria.setSrl_id_postulante_conv_area_org(model.getSrl_id_postulante_conv_area_org());
		
		TFactorEvaluacion tFactorEvaluacion = this.obtenerFactorEvaluacion(model.getSrl_id_postulante_conv_area_org(), model.getInt_id_tipo_factor_padre());
		
		TConvAreaOrgFactorEvalExample tConvAreaOrgFactorEvalExample = new TConvAreaOrgFactorEvalExample();
		tConvAreaOrgFactorEvalExample.createCriteria().andSrl_id_factor_evaluacionEqualTo(tFactorEvaluacion.getSrl_id_factor_evaluacion()).
		andSrl_id_postulante_conv_area_orgEqualTo(model.getSrl_id_postulante_conv_area_org());
		
		TConvAreaOrgFactorEval tConvAreaOrgFactorEval = null;
		List<TConvAreaOrgFactorEval> listTConvAreaOrgFactorEval = this.selectByExample(TConvAreaOrgFactorEvalMapper.class, tConvAreaOrgFactorEvalExample);
		
		if(!listTConvAreaOrgFactorEval.isEmpty()){
			tConvAreaOrgFactorEval = listTConvAreaOrgFactorEval.get(0);
		}
		
		List<GestionarNotasPostulanteQuery> list = this.getListByQuery(GestionarNotasPostulanteQueryMapper.class, criteria);
		
		int cantidad = 0;
		boolean incompleto = false;
		double totalPuntajeObtenido = 0;
		double totalPuntajeCalculado = 0;
		boolean estadoClasificacionDesaprobado = false;
		
		for(GestionarNotasPostulanteQuery obj : list){
			if(tFactorEvaluacion.getInt_id_tipo_factor().equals(obj.getInt_id_tipo_factor_padre())){
				cantidad++;
				if(obj.getDec_puntaje_calculado() == null){
					
//					SE HA COMENTADO A SOLICITU DEL USUARIO - 18-02-2016 DAVID
//					incompleto = true;
					
				}else{
					
					
					totalPuntajeObtenido = totalPuntajeObtenido + obj.getDec_puntaje_obtenido();
					totalPuntajeCalculado = totalPuntajeCalculado + obj.getDec_puntaje_calculado();
					
					TFactorEvaluacion fe = this.obtenerFactorEvaluacion(obj.getSrl_id_postulante_conv_area_org(), obj.getInt_id_tipo_factor());
					
					if(obj.getInt_id_estado_asistencia().intValue() == ESTADO_ASISTENCIA_AUSENTE){
						estadoClasificacionDesaprobado = true;
					}else{
						
						if(obj.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_DESAPROBADO){
							estadoClasificacionDesaprobado = true;
						}else{
							if(totalPuntajeCalculado < fe.getDec_puntaje_min().doubleValue()){
								estadoClasificacionDesaprobado = true;
							}
						}

					}
					
				}
			}
		}
		
		if(!incompleto){
			tConvAreaOrgFactorEval.setDec_puntaje_obtenido(new BigDecimal(totalPuntajeObtenido / cantidad));
			tConvAreaOrgFactorEval.setDec_puntaje_calculado(new BigDecimal(totalPuntajeCalculado));
			if(estadoClasificacionDesaprobado){
				tConvAreaOrgFactorEval.setInt_id_estado_clasificacion(ESTADO_CLASIFICACION_DESAPROBADO);
			}else{
				tConvAreaOrgFactorEval.setInt_id_estado_clasificacion(ESTADO_CLASIFICACION_APROBADO);
			}
			tConvAreaOrgFactorEval.setInt_id_estado_asistencia(ESTADO_ASISTENCIA_PRESENTE);
			
		}
		
		return tConvAreaOrgFactorEval;
	}
	
	public TPostulanteCnvAreaOrg calcularTotales(GestionarNotasPostulanteQuery model){
		
		GestionarNotasPostulanteQueryCriteria criteria = new GestionarNotasPostulanteQueryCriteria();
		criteria.setSrl_id_postulante_conv_area_org(model.getSrl_id_postulante_conv_area_org());
		
		List<GestionarNotasPostulanteQuery> list = this.getListByQuery(GestionarNotasPostulanteQueryMapper.class, criteria);
		
		double totalPuntajeCalculado = 0;
		boolean estadoClasificacionDesaprobado = false;
		
		for(GestionarNotasPostulanteQuery obj : list){
			if(obj.getInt_id_tipo_factor_padre() == null){
				if(obj.getDec_puntaje_calculado() != null){
					totalPuntajeCalculado = totalPuntajeCalculado + obj.getDec_puntaje_calculado();
				}
				if(obj.getInt_id_estado_clasificacion() != null){
					if(obj.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_DESAPROBADO 
							|| obj.getInt_id_estado_clasificacion().intValue() == ESTADO_CLASIFICACION_NO_RINDIO){
						estadoClasificacionDesaprobado = true;
					}
				}
				
			}
		}
		
		TPostulanteCnvAreaOrgKey tPostulanteCnvAreaOrgKey = new TPostulanteCnvAreaOrgKey();
		tPostulanteCnvAreaOrgKey.setSrl_id_postulante_conv_area_org(model.getSrl_id_postulante_conv_area_org());
		
		TPostulanteCnvAreaOrg tPostulanteCnvAreaOrg = this.selectByPrimaryKey(TPostulanteCnvAreaOrgMapper.class, tPostulanteCnvAreaOrgKey);
		tPostulanteCnvAreaOrg.setDec_puntaje_total(new BigDecimal(totalPuntajeCalculado));
		tPostulanteCnvAreaOrg.setInt_orden_merito(null);
		
		if(estadoClasificacionDesaprobado){
			tPostulanteCnvAreaOrg.setInt_id_estado(ESTADO_POSTULACION_DESAPROBADO);
		}else{
			if(totalPuntajeCalculado >= 80){
				tPostulanteCnvAreaOrg.setInt_id_estado(ESTADO_POSTULACION_APROBADO);
			}else{
				tPostulanteCnvAreaOrg.setInt_id_estado(ESTADO_POSTULACION_DESAPROBADO);
			}
		}
		
		return tPostulanteCnvAreaOrg;
			
	}

}
