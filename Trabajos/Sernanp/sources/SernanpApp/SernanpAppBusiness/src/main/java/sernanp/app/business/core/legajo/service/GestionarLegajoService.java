package sernanp.app.business.core.legajo.service;

import sernanp.app.business.dto.PersonalLegajoDto;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;


public interface GestionarLegajoService extends IHelperService {

	void registrarLegajo(PersonalLegajoDto record) throws BusinessException , Exception;
	void actualizarLegajo(PersonalLegajoDto record) throws BusinessException , Exception;
	void grabarFotoPersonal(PersonalLegajoDto record) throws BusinessException , Exception;
	
}
