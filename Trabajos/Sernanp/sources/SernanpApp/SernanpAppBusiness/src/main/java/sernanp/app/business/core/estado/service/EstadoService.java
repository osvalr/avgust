package sernanp.app.business.core.estado.service;

import java.util.Date;

import sernanp.app.dao.domain.TEstadoTabla;
import sernanp.app.dao.query.domain.ObtenerUltimoEstadoQuery;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface EstadoService  extends IHelperService{
	ObtenerUltimoEstadoQuery obtenerUltimoEstado(String nombreTabla, Integer idRegistro,Date fechaCorte) throws BusinessException;
	TEstadoTabla obtenerEstadoTabla(String nombreTabla) throws BusinessException;
	void registrarEstado(String nomTabla, Integer idRegistro, String codEstado) throws BusinessException;
}
