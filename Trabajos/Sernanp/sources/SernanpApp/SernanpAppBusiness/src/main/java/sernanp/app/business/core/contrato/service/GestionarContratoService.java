package sernanp.app.business.core.contrato.service;

import sernanp.app.business.dto.ContratoDto;
import sernanp.app.business.dto.GenerateDocDto;
import sernanp.app.dao.domain.TPersonalContrato;
import sernanp.app.util.BusinessException;
import sernanp.app.util.IHelperService;

public interface GestionarContratoService extends IHelperService {
	void registrarContrato(ContratoDto record, String tipoReg) throws BusinessException;
	void actualizar(ContratoDto record, String tipoReg) throws BusinessException;
	GenerateDocDto generarContratoPdf(Integer idContrato) throws BusinessException;
	GenerateDocDto generarAdendaPdf(Integer idAdenda) throws BusinessException;
	void suscribirContrato(TPersonalContrato pc, Integer idContrato) throws BusinessException;
	void noSuscribirContrato(TPersonalContrato pc) throws BusinessException;
	void suscribirAdenda(Integer idContrato) throws BusinessException;
	void noSuscribirAdenda(Integer idContrato) throws BusinessException;
}
