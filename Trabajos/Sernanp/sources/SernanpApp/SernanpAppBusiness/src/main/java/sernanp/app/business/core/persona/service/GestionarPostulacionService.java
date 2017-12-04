package sernanp.app.business.core.persona.service;

import sernanp.app.business.dto.PostulanteDto;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface GestionarPostulacionService extends IHelperService {
	void registrarPostulacion(PostulanteDto dto) throws BusinessException;
	void actualizarPostulacion(PostulanteDto dto) throws BusinessException;
}
