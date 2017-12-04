package sernanp.app.business.core.planilla.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import sernanp.app.business.core.planilla.service.GenerarJORService;
import sernanp.app.business.dto.RptJORBean;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaKey;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.query.domain.RptJORDetalle;
import sernanp.app.dao.query.domain.RptJORDetalleCriteria;
import sernanp.app.dao.query.mapper.RptJORDetalleMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GenerarJORServiceImpl extends HelperServiceMybatisImpl implements GenerarJORService {

	@Override
	public RptJORBean generarJOR(Integer int_anio, Integer int_id_periodo_mes, Integer srl_id_regimen_contractual) throws BusinessException {
		
		RptJORBean rptJORBean = new RptJORBean();
		String detalleJOR = "";
		String nombreArchivo = "";
		
			RptJORDetalleCriteria rptJORDetalleCriteria = new RptJORDetalleCriteria();
			rptJORDetalleCriteria.setInt_anio(int_anio);
			rptJORDetalleCriteria.setInt_id_periodo_mes(int_id_periodo_mes);
			rptJORDetalleCriteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
						
			List<RptJORDetalle> listRptJORDetalle = this.getListByQuery(RptJORDetalleMapper.class, rptJORDetalleCriteria);
			
			for (RptJORDetalle rptJORDetalle : listRptJORDetalle) {
				detalleJOR += rptJORDetalle.getIdtipodocumento() + "|";
				detalleJOR += rptJORDetalle.getNumerodoc() + "|";
				detalleJOR += 240 + "|";//numero de horas ordinarias trabajadas
				detalleJOR += 0 + "|";
				detalleJOR += 0 + "|";
				detalleJOR += 0 + "|" + "\r\n";
				
				
			}
	
			
			String RUC_sernanp = "20478053178";
			
			nombreArchivo = "0601"+int_anio.toString()+""+String.format("%02d", int_id_periodo_mes.intValue())+RUC_sernanp+".jor";


		rptJORBean.setNombreArchivo(nombreArchivo);
		rptJORBean.setContenido(detalleJOR);
		
		return rptJORBean;
	}

}
