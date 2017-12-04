package sernanp.app.business.core.convocatoria.service;

import sernanp.app.business.dto.ResultRegistroConvocatoriaDto;
import sernanp.app.business.dto.VacantesDto;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface GestionarConvocatoriaService extends IHelperService {
	ResultRegistroConvocatoriaDto registrarConvocatoriaConCodPostulacion(Integer idArea,Integer idUnidadOperativa,String codigoPostulacion,Integer cantidadVacantes) throws BusinessException;
	Integer registrarCodigoPostulacion(Integer idConvocatoria, Integer idArea,Integer idUnidadOperativa, String codigoPostulacion,Integer cantidadVacantes) throws BusinessException;
	Integer obtenerNumActivacionConvAreaOrg(Integer idConvAreaOrg) throws BusinessException;
	boolean verificarNumeroConvocatoria(Integer idPostulacion, Integer idConv) throws BusinessException; 
	Integer obtenerCantidadPostulacionesPorConvocatoria(Integer idPostulante, Integer idConv) throws BusinessException;
	VacantesDto obtenerInfoVacantes(Integer idConvocatoriaAreaOrganica, Integer idPostulacion) throws BusinessException;
}
