package sernanp.app.business.core.planilla.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import sernanp.app.business.core.planilla.service.GenerarREMService;
import sernanp.app.business.dto.RptREMBean;
import sernanp.app.dao.domain.TAnioPeriodoPlanilla;
import sernanp.app.dao.domain.TAnioPeriodoPlanillaKey;
import sernanp.app.dao.domain.TAnioPlanilla;
import sernanp.app.dao.domain.TAnioPlanillaKey;
import sernanp.app.dao.mapper.TAnioPeriodoPlanillaMapper;
import sernanp.app.dao.mapper.TAnioPlanillaMapper;
import sernanp.app.dao.query.domain.RptREMDetalle;
import sernanp.app.dao.query.domain.RptREMDetalleCriteria;
import sernanp.app.dao.query.mapper.RptREMDetalleMapper;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatisImpl;

@Service
public class GenerarREMServiceImpl extends HelperServiceMybatisImpl implements GenerarREMService {

	@Override
	public RptREMBean generarREM(Integer int_anio, Integer int_id_periodo_mes, Integer srl_id_regimen_contractual) throws BusinessException {
		
		RptREMBean rptREMBean = new RptREMBean();
		String detalleREM = "";
		String nombreArchivo = "";
		
			RptREMDetalleCriteria rptREMDetalleCriteria = new RptREMDetalleCriteria();
			rptREMDetalleCriteria.setInt_anio(int_anio);
			rptREMDetalleCriteria.setInt_id_periodo_mes(int_id_periodo_mes);
			rptREMDetalleCriteria.setSrl_id_regimen_contractual(srl_id_regimen_contractual);
						
			List<RptREMDetalle> listRptREMDetalle = this.getListByQuery(RptREMDetalleMapper.class, rptREMDetalleCriteria);
			
			
			
			for (RptREMDetalle rptREMDetalle : listRptREMDetalle) {
				detalleREM += rptREMDetalle.getIdtipodocumento() + "|";
				detalleREM += rptREMDetalle.getNumerodoc() + "|";
				detalleREM += rptREMDetalle.getVar_cod_pdt_concepto() + "|";
				detalleREM += new BigDecimal(rptREMDetalle.getDec_monto_calculado()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|";
				detalleREM += new BigDecimal(rptREMDetalle.getDec_monto_calculado()).setScale(2, BigDecimal.ROUND_HALF_DOWN) + "|" + "\r\n";

				
			}
	
			String RUC_sernanp = "20478053178";
			nombreArchivo = "0601"+ int_anio.toString()+""+String.format("%02d", int_id_periodo_mes.intValue())+RUC_sernanp+".rem";
		

		rptREMBean.setNombreArchivo(nombreArchivo);
		rptREMBean.setContenido(detalleREM);
		
		return rptREMBean;
	}

	

}
