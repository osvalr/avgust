package sernanp.app.business.core.planilla.service;

import sernanp.app.business.dto.RptPlameBean;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface GenerarPlameService extends HelperServiceMybatis {
	RptPlameBean generarPlame(Integer srl_id_anio_periodo_planilla, Integer srl_id_regimen_contractual, Integer srl_id_fuente_financiamiento) throws BusinessException;
}
