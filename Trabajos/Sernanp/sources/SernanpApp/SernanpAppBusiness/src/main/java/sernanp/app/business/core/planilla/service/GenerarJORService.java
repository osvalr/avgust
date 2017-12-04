package sernanp.app.business.core.planilla.service;

import sernanp.app.business.dto.RptJORBean;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface GenerarJORService extends HelperServiceMybatis {
	RptJORBean generarJOR(Integer int_anio, Integer int_id_periodo_mes ,Integer srl_id_regimen_contractual) throws BusinessException;
}
