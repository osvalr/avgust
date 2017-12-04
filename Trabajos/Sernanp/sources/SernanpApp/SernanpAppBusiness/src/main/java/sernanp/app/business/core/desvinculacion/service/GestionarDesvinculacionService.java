package sernanp.app.business.core.desvinculacion.service;

import sernanp.app.business.dto.PersonalDesvinculacionDto;
import sernanp.app.dao.query.domain.ResultadoVacacionesQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;


public interface GestionarDesvinculacionService extends IHelperService {

	void registrarDesvinculacion(PersonalDesvinculacionDto record) throws BusinessException;
	void eliminarDesvinculacion(Integer idDesvinculacion, Integer idPersonal) throws BusinessException;
	ResultadoVacacionesQuery sinPendientesVacaciones(Integer idPersonal);
	void actualizar(PersonalDesvinculacionDto desvinculacion);
	
}
