package sernanp.app.business.core.planilla.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import sernanp.app.business.core.planilla.service.GenerarPlameService;
import sernanp.app.business.dto.RptPlameBean;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaKey;
import sernanp.app.dao.domain.TFuenteFinanciamiento;
import sernanp.app.dao.domain.TFuenteFinanciamientoKey;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.mapper.TFuenteFinanciamientoMapper;
import sernanp.app.dao.query.domain.ObtenerTipoYClasePlanillaQuery;
import sernanp.app.dao.query.domain.ObtenerTipoYClasePlanillaQueryCriteria;
import sernanp.app.dao.query.domain.RptPlameDetalle;
import sernanp.app.dao.query.domain.RptPlameDetalleCriteria;
import sernanp.app.dao.query.domain.RptPlameMaestro;
import sernanp.app.dao.query.domain.RptPlameMaestroCriteria;
import sernanp.app.dao.query.mapper.ObtenerTipoYClasePlanillaQueryMapper;
import sernanp.app.dao.query.mapper.RptPlameDetalleMapper;
import sernanp.app.dao.query.mapper.RptPlameMaestroMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GenerarPlameServiceImpl extends HelperServiceMybatisImpl implements GenerarPlameService {
	
	@Override
	public RptPlameBean generarPlame(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer srl_id_fuente_financiamiento) throws BusinessException {
		
		RptPlameBean rptPlameBean = new RptPlameBean();
		String detallePlame = "";
		String nombreArchivo = "";
		
		int correlativo = 0;
		String str_correlativo = null;
		String tipoPlanilla = null;
		String clasePlanilla = null;
		String c_fte_fto = null;
		
			ObtenerTipoYClasePlanillaQueryCriteria criteria = new ObtenerTipoYClasePlanillaQueryCriteria();
			criteria.setSrl_id_fuente_financiamiento(srl_id_fuente_financiamiento);
			criteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
			
			List<ObtenerTipoYClasePlanillaQuery> list = this.getListByQuery(ObtenerTipoYClasePlanillaQueryMapper.class, criteria);
			ObtenerTipoYClasePlanillaQuery obtenerTipoYClasePlanillaQuery = null;
			if(!list.isEmpty()){
				obtenerTipoYClasePlanillaQuery = list.get(0);
			}
			
			if(obtenerTipoYClasePlanillaQuery != null){
				tipoPlanilla = obtenerTipoYClasePlanillaQuery.getVar_cod_tipo_planilla();
				correlativo = obtenerTipoYClasePlanillaQuery.getInt_correlativo().intValue();
				clasePlanilla = obtenerTipoYClasePlanillaQuery.getVar_cod_clase_planilla();
				str_correlativo = String.format("%04d", correlativo);	

				TFuenteFinanciamientoKey key = new TFuenteFinanciamientoKey();
				key.setSrl_id_fuente_financiamiento(srl_id_fuente_financiamiento);
				
				TFuenteFinanciamiento fte = this.selectByPrimaryKey(TFuenteFinanciamientoMapper.class, key);
				
				c_fte_fto = fte.getVar_rubro_fte_fto();
				
			RptPlameMaestroCriteria rptPlameMaestroCriteria = new RptPlameMaestroCriteria();
			rptPlameMaestroCriteria.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
			rptPlameMaestroCriteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
			rptPlameMaestroCriteria.setC_fte_fto(c_fte_fto);
			
			RptPlameMaestro rptPlameMaestro = this.getRecordByQuery(RptPlameMaestroMapper.class, rptPlameMaestroCriteria);
			
			if(rptPlameMaestro != null){
				RptPlameDetalleCriteria rptPlameDetalleCriteria = new RptPlameDetalleCriteria();
				rptPlameDetalleCriteria.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
				rptPlameDetalleCriteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
				rptPlameDetalleCriteria.setC_fte_fto(c_fte_fto);
				
				List<RptPlameDetalle> listRptPlameDetalle = this.getListByQuery(RptPlameDetalleMapper.class, rptPlameDetalleCriteria);
				
				rptPlameMaestro.setCantidad_registros_cargados(listRptPlameDetalle.size());
				
				detallePlame += rptPlameMaestro.getCodigo_unidad_ejecutora() + ";";
				detallePlame += rptPlameMaestro.getInt_anio().toString() + ";";
				detallePlame += rptPlameMaestro.getInt_id_periodo_mes() + ";";
				detallePlame += tipoPlanilla + ";";
				detallePlame += clasePlanilla + ";";
				detallePlame += str_correlativo + ";";
				detallePlame += rptPlameMaestro.getCantidad_registros_cargados().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_ingresos().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_descuentos().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_aportes().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_reintegros().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_encargaturas().toString() + ";";
				detallePlame += rptPlameMaestro.getDec_total_otros_ingresos().toString() + "\r\n";
				
				for (RptPlameDetalle rptPlameDetalle : listRptPlameDetalle) {
					detallePlame += rptPlameDetalle.getIdtipodocumento() + ";";
					detallePlame += rptPlameDetalle.getNumerodoc() + ";";
					detallePlame += (rptPlameDetalle.getC_fte_fto() == null ? "" : rptPlameDetalle.getC_fte_fto()) + ";";
					detallePlame += rptPlameDetalle.getInt_id_tipo_concepto().toString() + ";";
					detallePlame += rptPlameDetalle.getVar_cod_siaf_concepto() + ";";
					detallePlame += rptPlameDetalle.getVar_descrip_concepto() + ";";
					detallePlame += rptPlameDetalle.getDec_monto_calculado().toString() + "\r\n";
				}
				
				TAnioPeriodoPlanillaKey tAnioPeriodoPlanillaKey = new TAnioPeriodoPlanillaKey();
				tAnioPeriodoPlanillaKey.setSrl_id_anio_periodo_planilla(srl_id_anio_periodo_planilla);
				
				TAnioPeriodoPlanilla tAnioPeriodoPlanilla = this.selectByPrimaryKey(TAnioPeriodoPlanillaMapper.class, tAnioPeriodoPlanillaKey);
				
				TAnioPlanillaKey tAnioPlanillaKey = new TAnioPlanillaKey();
				tAnioPlanillaKey.setSrl_id_anio_planilla(tAnioPeriodoPlanilla.getSrl_id_anio_planilla());
				
				TAnioPlanilla tAnioPlanilla = this.selectByPrimaryKey(TAnioPlanillaMapper.class, tAnioPlanillaKey);
				
				String periodo = String.format("%02d", tAnioPeriodoPlanilla.getInt_id_periodo_mes().intValue());
				String anho = tAnioPlanilla.getInt_anio().toString();
				
				nombreArchivo = "PLL001309"+anho+periodo+tipoPlanilla+clasePlanilla+str_correlativo+".TXT";

			}
			
			}
			
			rptPlameBean.setNombreArchivo(nombreArchivo);
			rptPlameBean.setContenido(detallePlame);
		
		return rptPlameBean;
	}

}
