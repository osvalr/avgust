package sernanp.app.business.core.planilla.service;

import sernanp.app.business.dto.RptREMBean;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface GenerarREMService extends HelperServiceMybatis {
	
	RptREMBean generarREM(Integer int_anio,	Integer int_id_periodo_mes, Integer srl_id_regimen_contractual) throws BusinessException;
}
