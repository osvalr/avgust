package sernanp.app.business.core.persona.service;

import java.util.List;

import sernanp.app.business.dto.PersonalDto;
import sernanp.app.business.dto.PostulanteDto;
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQuery;
import sernanp.app.dao.query.domain.UltimaDireccionDomicilioQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface GestionarPersonaService extends IHelperService {
	Integer registrarPostulante(PostulanteDto dto) throws BusinessException;
	void actualizarPostulante(PostulanteDto dto) throws BusinessException;
	void actualizarPersonal(PersonalDto dto, List<FormacionAcademicaPersonalQuery> listFormacion) throws BusinessException;
	boolean existePostulante(Integer idPostulante) throws BusinessException;
	boolean existeDireccionHistorica(Integer idPersonaNatural) throws BusinessException;
	UltimaDireccionDomicilioQuery obtenerUltimaDirecionDomiciliaria(Integer idPersonaNatural) throws BusinessException;
}
