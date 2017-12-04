package sernanp.app.business.core.persona.service;

import java.util.List;

import sernanp.app.business.dto.PersonalDto;
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface GestionarPersonalService extends IHelperService {
	void actualizarPersonal(PersonalDto dto, List<FormacionAcademicaPersonalQuery> listFormacion) throws BusinessException; 
}