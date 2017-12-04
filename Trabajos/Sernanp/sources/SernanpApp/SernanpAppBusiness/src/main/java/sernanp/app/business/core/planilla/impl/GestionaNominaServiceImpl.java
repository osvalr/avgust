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
* DATE CREATE : 07/04/2015 14:31:08
* VERSION : 1.0 
*/

package sernanp.app.business.core.planilla.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sernanp.app.business.core.planilla.service.GestionaNominaService;
import sernanp.app.business.core.planilla.service.ProcesoNominaService;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;
import sernanp.app.dao.domain.TConceptoPlanilla;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonal;
import sernanp.app.dao.domain.TNominaAnioPeriodoPersonalKey;
import sernanp.app.dao.domain.TNominaConcepto;
import sernanp.app.dao.domain.TNominaConceptoExample;
import sernanp.app.dao.domain.TPersonalConcepto;
import sernanp.app.dao.domain.TPersonalConceptoExample;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TNominaAnioPeriodoPersonalMapper;
import sernanp.app.dao.mapper.TNominaConceptoMapper;
import sernanp.app.dao.mapper.TPersonalConceptoMapper;
import sernanp.app.dao.query.domain.AportesNominaConceptoQuery;
import sernanp.app.dao.query.domain.DescuentoJudicialesNominaConceptoQuery;
import sernanp.app.dao.query.domain.DescuentosNominaConceptoQuery;
import sernanp.app.dao.query.domain.GestionarNominaQuery;
import sernanp.app.dao.query.domain.IngresosNominaConceptoQuery;
import sernanp.app.dao.query.domain.PersonalContratoNominaQuery;
import sernanp.app.dao.query.domain.PersonalNominaQuery;
import sernanp.app.util.BeanUtil;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GestionaNominaServiceImpl extends HelperServiceMybatisImpl implements GestionaNominaService {

	@Autowired
	private BeanUtil beanUtil;
	
	@Autowired
	ProcesoNominaService procesoNominaService;
	
	private final int CONCEPTO_TIPO_INGRESO = 1;
	private final int CONCEPTO_TIPO_DESCUENTO = 2;
	private final int CONCEPTO_TIPO_APORTE = 3;
	private final int CONCEPTO_SUB_TIPO_DESCUENTO_JUDICIAL = 6;
	private final int TIPO_ESTADO_GENERICO_ACTIVO = 1;
	
	private final int CONCEPTO_OTROS_DESCUENTO = 30;
	private final int CONCEPTO_INASISTENCIA = 77;
	private final int CONCEPTO_TARDANZA = 41;
	private final int CONCEPTO_SIN_GOCE_HABER = 76;
	
	private final int TIPO_ESTADO_GENERICO_INACTIVO = 2;

	//ADD 28-09-2015 DAVID
	private final int TIPO_ESTADO_GENERICO_MODIFICADO = 3;
	
	@Transactional
	@Override
	public Integer create(GestionarNominaQuery model, List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery, List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery, List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery, List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery) throws BusinessException {
		
		Integer lastId = null;

		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.insertSelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
		
		
		for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
			ingresosNominaConceptoQuery.setSrl_id_nomina_concepto(null);
			ingresosNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(ingresosNominaConceptoQuery, TNominaConcepto.class);
			this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
		}
		

		for (DescuentosNominaConceptoQuery descuentosNominaConceptoQuery : listDescuentosNominaConceptoQuery) {
			descuentosNominaConceptoQuery.setSrl_id_nomina_concepto(null);
			descuentosNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentosNominaConceptoQuery, TNominaConcepto.class);
			this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
		}
		

		for (DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery : listDescuentoJudicialesNominaConceptoQuery) {
			descuentoJudicialesNominaConceptoQuery.setSrl_id_nomina_concepto(null);
			descuentoJudicialesNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentoJudicialesNominaConceptoQuery, TNominaConcepto.class);
			this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
		}
		

		for (AportesNominaConceptoQuery aportesNominaConceptoQuery : listAportesNominaConceptoQuery) {
			aportesNominaConceptoQuery.setSrl_id_nomina_concepto(null);
			aportesNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(aportesNominaConceptoQuery, TNominaConcepto.class);
			this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
		}
		lastId = tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal();
		return lastId;
	}
	
	@Transactional
	@Override
	public void save(GestionarNominaQuery model, List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery, List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery, List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery, List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery) throws BusinessException, IOException {
		
		TNominaAnioPeriodoPersonalKey tNominaAnioPeriodoPersonalKey = new TNominaAnioPeriodoPersonalKey();
		tNominaAnioPeriodoPersonalKey.setSrl_id_nomina_anio_periodo_personal(model.getSrl_id_nomina_anio_periodo_personal());
		
		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = this.selectByPrimaryKey(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonalKey);
		
		TAnioPeriodoPlanillaKey tAnioPeriodoPlanillaKey = new TAnioPeriodoPlanillaKey();
		tAnioPeriodoPlanillaKey.setSrl_id_anio_periodo_planilla(tNominaAnioPeriodoPersonal.getSrl_id_anio_periodo_planilla());
		
		TAnioPeriodoPlanilla tAnioPeriodoPlanilla = this.selectByPrimaryKey(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanillaKey);
		
		if(tAnioPeriodoPlanilla.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El periodo seleccionado no esta activo.");
		}
		
		double totalIngresos = 0.0;
		double totalDescuentos = 0.0;
		double totalDescuentosJudiciales = 0.0;
		double totalAportes = 0.0;
		double totalIngresosActuales = 0;
		double totalIngresosEnviados = 0;
		
		TNominaConceptoExample example = new TNominaConceptoExample();
		example.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
		
		List<TNominaConcepto> listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, example);
		for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
			int tipoConcepto = procesoNominaService.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
			if(tipoConcepto == CONCEPTO_TIPO_INGRESO){
				totalIngresosActuales += tNominaConcepto.getDec_monto_calculado().doubleValue();
			}
		}
		
		for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
			int tipoConcepto = procesoNominaService.obtenerTipoConcepto(ingresosNominaConceptoQuery.getSrl_id_concepto_planilla());
			if(tipoConcepto == CONCEPTO_TIPO_INGRESO){
				totalIngresosEnviados += ingresosNominaConceptoQuery.getDec_monto_calculado().doubleValue();
			}
		}
		
		if(totalIngresosEnviados != totalIngresosActuales){
			
			for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
				
				int tipoConcepto = procesoNominaService.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
				
				if(tipoConcepto == CONCEPTO_TIPO_DESCUENTO){
					
					int idConcepto = tNominaConcepto.getSrl_id_concepto_planilla().intValue();
					
					if( idConcepto != CONCEPTO_OTROS_DESCUENTO && idConcepto != CONCEPTO_INASISTENCIA && idConcepto != CONCEPTO_TARDANZA && idConcepto != CONCEPTO_SIN_GOCE_HABER){
						this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
					}
					
				}else if(tipoConcepto == CONCEPTO_TIPO_APORTE){
					
					this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
					
				}else if(tipoConcepto == CONCEPTO_TIPO_INGRESO){
					
					
					this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
					
				}
							
			}
			
			for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
				ingresosNominaConceptoQuery.setSrl_id_nomina_concepto(null);
				ingresosNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				TNominaConcepto tNominaConcepto = beanUtil.copyBean(ingresosNominaConceptoQuery, TNominaConcepto.class);
				this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
			}
			
			procesoNominaService.precargarInfo(tNominaAnioPeriodoPersonal.getSrl_id_anio_periodo_planilla());
			
			listTNominaConcepto = this.selectByExample(TNominaConceptoMapper.class, example);
			
			PersonalNominaQuery personalNominaQuery = procesoNominaService.obtenerInfoPersonal(tNominaAnioPeriodoPersonal.getIdpersonal());
			PersonalContratoNominaQuery personalContratoNominaQuery = procesoNominaService.obtenerInfoContrato(tNominaAnioPeriodoPersonal.getIdpersonal());
			TPersonalContrato tPersonalContrato = procesoNominaService.obtenerContrato(personalContratoNominaQuery.getSrl_id_contrato());
			
			TPersonalConceptoExample tPersonalConceptoExample = new TPersonalConceptoExample();
			tPersonalConceptoExample.createCriteria().andIdpersonalEqualTo(personalNominaQuery.getIdpersonal());
			
			List<TPersonalConcepto> listTPersonalConcepto = this.selectByExample(TPersonalConceptoMapper.class, tPersonalConceptoExample);
			
			
			if(totalIngresosEnviados > 0){
				
				procesoNominaService.calcularDescuentos(tNominaAnioPeriodoPersonal.getSrl_id_anio_periodo_planilla(),listTPersonalConcepto,tNominaAnioPeriodoPersonal,listTNominaConcepto,tPersonalContrato,personalNominaQuery,tNominaAnioPeriodoPersonal.getInt_id_estado());
				procesoNominaService.calcularAportes(tNominaAnioPeriodoPersonal, listTNominaConcepto, tPersonalContrato,0, false);
			
			}
			
			for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
				if(tNominaConcepto.getSrl_id_nomina_concepto() == null){
					this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);	
				}
			}
			
			for (TNominaConcepto tNominaConcepto : listTNominaConcepto) {
				
				int tipoConcepto = procesoNominaService.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
				
				if(tipoConcepto == CONCEPTO_TIPO_INGRESO){
					totalIngresos += tNominaConcepto.getDec_monto_calculado().doubleValue();
				}
				
				if(tipoConcepto == CONCEPTO_TIPO_DESCUENTO){
					totalDescuentos += tNominaConcepto.getDec_monto_calculado().doubleValue();
				}
				
				if(tipoConcepto == CONCEPTO_TIPO_APORTE){
					totalAportes += tNominaConcepto.getDec_monto_calculado().doubleValue();
				}
				
			}
			
			tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
			tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos));
			tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
			tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalIngresos - (totalDescuentos)));
			
			this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
			
		}else{
			/* Start TNominaConcepto */
			
			{
			TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
			tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			List<TNominaConcepto> listTNominaConceptoCurrent = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
			List<TNominaConcepto> listTNominaConceptoDeleted = new ArrayList<TNominaConcepto>();
			
			for (TNominaConcepto tNominaConcepto : listTNominaConceptoCurrent) {
				boolean noExists = true;
				Integer tipoConcepto = procesoNominaService.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
				if(tipoConcepto.intValue() == CONCEPTO_TIPO_INGRESO){
					for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
						if(ingresosNominaConceptoQuery.getSrl_id_nomina_concepto().equals(tNominaConcepto.getSrl_id_nomina_concepto())){
							noExists = false;
							break;
						}
					}
					if(noExists){
						listTNominaConceptoDeleted.add(tNominaConcepto);
					}
				}
			}
			
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, listTNominaConceptoDeleted);
			}
			
			
			for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
				if(ingresosNominaConceptoQuery.getSrl_id_nomina_concepto() < 1){
					ingresosNominaConceptoQuery.setSrl_id_nomina_concepto(null);
					ingresosNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(ingresosNominaConceptoQuery, TNominaConcepto.class);
					this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
				}else{
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(ingresosNominaConceptoQuery, TNominaConcepto.class);
					this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
				}
				//ADD 28-09-2015 DAVID
//				if(ingresosNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO){
				if(ingresosNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO || ingresosNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_MODIFICADO){
				
					totalIngresos = totalIngresos + ingresosNominaConceptoQuery.getDec_monto_calculado().doubleValue();
				}
				
			}
			/* End TNominaConcepto */	
			/* Start TNominaConcepto */
			
			{
			TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
			tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			List<TNominaConcepto> listTNominaConceptoCurrent = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
			List<TNominaConcepto> listTNominaConceptoDeleted = new ArrayList<TNominaConcepto>();
			
			for (TNominaConcepto tNominaConcepto : listTNominaConceptoCurrent) {
				boolean noExists = true;
				TConceptoPlanilla concepto = procesoNominaService.obtenerConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
				if(concepto.getInt_id_tipo_concepto().intValue() == CONCEPTO_TIPO_DESCUENTO && concepto.getInt_id_sub_tipo_concepto().intValue() != CONCEPTO_SUB_TIPO_DESCUENTO_JUDICIAL){
					for (DescuentosNominaConceptoQuery descuentosNominaConceptoQuery : listDescuentosNominaConceptoQuery) {
						if(descuentosNominaConceptoQuery.getSrl_id_nomina_concepto().equals(tNominaConcepto.getSrl_id_nomina_concepto())){
							noExists = false;
							break;
						}
					}
					if(noExists){
						listTNominaConceptoDeleted.add(tNominaConcepto);
					}
				}
			}
			
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, listTNominaConceptoDeleted);
			}
			
			
			for (DescuentosNominaConceptoQuery descuentosNominaConceptoQuery : listDescuentosNominaConceptoQuery) {
				if(descuentosNominaConceptoQuery.getSrl_id_nomina_concepto() < 1){
					descuentosNominaConceptoQuery.setSrl_id_nomina_concepto(null);
					descuentosNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentosNominaConceptoQuery, TNominaConcepto.class);
					this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
				}else{
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentosNominaConceptoQuery, TNominaConcepto.class);
					this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
				}
				
				if(descuentosNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO || descuentosNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_MODIFICADO ){
					totalDescuentos = totalDescuentos + descuentosNominaConceptoQuery.getDec_monto_calculado().doubleValue();
				}
				
			}
			/* End TNominaConcepto */	
			/* Start TNominaConcepto */
			
			{
			TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
			tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
			List<TNominaConcepto> listTNominaConceptoCurrent = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
			List<TNominaConcepto> listTNominaConceptoDeleted = new ArrayList<TNominaConcepto>();
			
			for (TNominaConcepto tNominaConcepto : listTNominaConceptoCurrent) {
				boolean noExists = true;
				TConceptoPlanilla concepto = procesoNominaService.obtenerConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
				if(concepto.getInt_id_tipo_concepto().intValue() == CONCEPTO_TIPO_DESCUENTO && concepto.getInt_id_sub_tipo_concepto().intValue() == CONCEPTO_SUB_TIPO_DESCUENTO_JUDICIAL){
					for (DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery : listDescuentoJudicialesNominaConceptoQuery) {
						if(descuentoJudicialesNominaConceptoQuery.getSrl_id_nomina_concepto().equals(tNominaConcepto.getSrl_id_nomina_concepto())){
							noExists = false;
							break;
						}
					}
					if(noExists){
						listTNominaConceptoDeleted.add(tNominaConcepto);
					}
				}
			}
			
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, listTNominaConceptoDeleted);
			}
			
			
			for (DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery : listDescuentoJudicialesNominaConceptoQuery) {
				if(descuentoJudicialesNominaConceptoQuery.getSrl_id_nomina_concepto() < 1){
					descuentoJudicialesNominaConceptoQuery.setSrl_id_nomina_concepto(null);
					descuentoJudicialesNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentoJudicialesNominaConceptoQuery, TNominaConcepto.class);
					this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
				}else{
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentoJudicialesNominaConceptoQuery, TNominaConcepto.class);
					this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
				}
				
				if(descuentoJudicialesNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO || descuentoJudicialesNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_MODIFICADO){
					totalDescuentosJudiciales = totalDescuentosJudiciales + descuentoJudicialesNominaConceptoQuery.getDec_monto_calculado().doubleValue();
				}
				
			}
			/* End TNominaConcepto */	
			/* Start TNominaConcepto */
			
			{
				TNominaConceptoExample tNominaConceptoExample = new TNominaConceptoExample();
				tNominaConceptoExample.createCriteria().andSrl_id_nomina_anio_periodo_personalEqualTo(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
				List<TNominaConcepto> listTNominaConceptoCurrent = this.selectByExample(TNominaConceptoMapper.class, tNominaConceptoExample);
				List<TNominaConcepto> listTNominaConceptoDeleted = new ArrayList<TNominaConcepto>();
				
				for (TNominaConcepto tNominaConcepto : listTNominaConceptoCurrent) {
					boolean noExists = true;
					Integer tipoConcepto = procesoNominaService.obtenerTipoConcepto(tNominaConcepto.getSrl_id_concepto_planilla());
					if(tipoConcepto.intValue() == CONCEPTO_TIPO_APORTE){
						for (AportesNominaConceptoQuery aportesNominaConceptoQuery : listAportesNominaConceptoQuery) {
							if(aportesNominaConceptoQuery.getSrl_id_nomina_concepto().equals(tNominaConcepto.getSrl_id_nomina_concepto())){
								noExists = false;
								break;
							}
						}
						if(noExists){
							listTNominaConceptoDeleted.add(tNominaConcepto);
						}
					}
				}
				
				this.deleteByPrimaryKey(TNominaConceptoMapper.class, listTNominaConceptoDeleted);
			}
			for (AportesNominaConceptoQuery aportesNominaConceptoQuery : listAportesNominaConceptoQuery) {
				if(aportesNominaConceptoQuery.getSrl_id_nomina_concepto() < 1){
					aportesNominaConceptoQuery.setSrl_id_nomina_concepto(null);
					aportesNominaConceptoQuery.setSrl_id_nomina_anio_periodo_personal(tNominaAnioPeriodoPersonal.getSrl_id_nomina_anio_periodo_personal());
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(aportesNominaConceptoQuery, TNominaConcepto.class);
					this.insertSelective(TNominaConceptoMapper.class, tNominaConcepto);
				}else{
					TNominaConcepto tNominaConcepto = beanUtil.copyBean(aportesNominaConceptoQuery, TNominaConcepto.class);
					this.updateByPrimaryKeySelective(TNominaConceptoMapper.class, tNominaConcepto);
				}
				
				if(aportesNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_ACTIVO || aportesNominaConceptoQuery.getInt_id_estado() == TIPO_ESTADO_GENERICO_MODIFICADO){
					totalAportes = totalAportes + aportesNominaConceptoQuery.getDec_monto_calculado().doubleValue();
				}
			}
			/* End TNominaConcepto */	
			
			tNominaAnioPeriodoPersonal.setDec_total_ingresos(new Double(totalIngresos));
			tNominaAnioPeriodoPersonal.setDec_total_descuentos(new Double(totalDescuentos + totalDescuentosJudiciales));
			tNominaAnioPeriodoPersonal.setDec_total_aportes(new Double(totalAportes));
			tNominaAnioPeriodoPersonal.setDec_total_neto(new Double(totalIngresos - (totalDescuentos + totalDescuentosJudiciales)));

			// ADD 28-09-2015 DAVID
			if(!model.getC_fte_fto().equalsIgnoreCase(tNominaAnioPeriodoPersonal.getC_fte_fto())){
				tNominaAnioPeriodoPersonal.setC_fte_fto(model.getC_fte_fto());
			}
			
			if(!model.getC_meta().equalsIgnoreCase(tNominaAnioPeriodoPersonal.getC_meta())){
				tNominaAnioPeriodoPersonal.setC_meta(model.getC_meta());
			}
			// END DAVID
			
			this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
			
		}
		
	}

	@Transactional
	@Override
	public void remove(GestionarNominaQuery model, List<IngresosNominaConceptoQuery> listIngresosNominaConceptoQuery, List<DescuentosNominaConceptoQuery> listDescuentosNominaConceptoQuery, List<DescuentoJudicialesNominaConceptoQuery> listDescuentoJudicialesNominaConceptoQuery, List<AportesNominaConceptoQuery> listAportesNominaConceptoQuery) throws BusinessException {
	
		for (IngresosNominaConceptoQuery ingresosNominaConceptoQuery : listIngresosNominaConceptoQuery) {
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(ingresosNominaConceptoQuery, TNominaConcepto.class);
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
		}
		for (DescuentosNominaConceptoQuery descuentosNominaConceptoQuery : listDescuentosNominaConceptoQuery) {
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentosNominaConceptoQuery, TNominaConcepto.class);
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
		}
		for (DescuentoJudicialesNominaConceptoQuery descuentoJudicialesNominaConceptoQuery : listDescuentoJudicialesNominaConceptoQuery) {
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(descuentoJudicialesNominaConceptoQuery, TNominaConcepto.class);
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
		}
		for (AportesNominaConceptoQuery aportesNominaConceptoQuery : listAportesNominaConceptoQuery) {
			TNominaConcepto tNominaConcepto = beanUtil.copyBean(aportesNominaConceptoQuery, TNominaConcepto.class);
			this.deleteByPrimaryKey(TNominaConceptoMapper.class, tNominaConcepto);
		}

		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.deleteByPrimaryKey(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
	}

	@Transactional
	@Override
	public void changeState(GestionarNominaQuery model) throws BusinessException {
	
//		ADD 15-10-2015 DAVID
		
		TNominaAnioPeriodoPersonalKey tNominaAnioPeriodoPersonalKey = new TNominaAnioPeriodoPersonalKey();
		tNominaAnioPeriodoPersonalKey.setSrl_id_nomina_anio_periodo_personal(model.getSrl_id_nomina_anio_periodo_personal());
		
		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal1 = this.selectByPrimaryKey(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonalKey);
		
		TAnioPeriodoPlanillaKey tAnioPeriodoPlanillaKey = new TAnioPeriodoPlanillaKey();
		tAnioPeriodoPlanillaKey.setSrl_id_anio_periodo_planilla(tNominaAnioPeriodoPersonal1.getSrl_id_anio_periodo_planilla());
		
		TAnioPeriodoPlanilla tAnioPeriodoPlanilla = this.selectByPrimaryKey(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanillaKey);
		
		if(tAnioPeriodoPlanilla.getInt_id_estado().intValue() == TIPO_ESTADO_GENERICO_INACTIVO){
			throw new BusinessException("El periodo seleccionado no esta activo.");
		}
		
//		END
		
		TNominaAnioPeriodoPersonal tNominaAnioPeriodoPersonal = beanUtil.copyBean(model, TNominaAnioPeriodoPersonal.class);
		this.updateByPrimaryKeySelective(TNominaAnioPeriodoPersonalMapper.class, tNominaAnioPeriodoPersonal);
		
	}

}
