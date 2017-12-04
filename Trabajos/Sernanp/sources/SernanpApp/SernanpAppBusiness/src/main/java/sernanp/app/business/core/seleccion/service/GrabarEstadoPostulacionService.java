package sernanp.app.business.core.seleccion.service;

import sernanp.app.util.BusinessException;
import sernanp.app.util.HelperServiceMybatis;

public interface GrabarEstadoPostulacionService extends HelperServiceMybatis {
	void grabarEstado(Integer srl_id_postulante_conv_area_org, Integer int_orden_merito, Integer int_id_estado) throws BusinessException;
	void seleccionarGanadores(Integer srl_id_conv_area_org) throws BusinessException;
}
