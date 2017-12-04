package sernanp.app.business.core.asistencia.service;

import sernanp.app.business.dto.DiasNoLaborablesDTO;
import sernanp.app.dao.domain.TDiasNoLaborables;
import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;
import sernanp.app.util.IHelperService;

public interface GestionarDiasNoLaborablesService extends HelperServiceMybatis{
	void registrarDiaNoLaborable(DiasNoLaborablesDTO tDiasNoLaborables) throws BusinessException;
	void eliminarDiaNoLaborable(DiasNoLaborablesDTO tDiasNoLaborablesDTO) throws BusinessException;
}
