package pe.com.acme.invoiceelec.business.service;

import pe.com.acme.util.IMybatisRepositoryHelper;

public interface CommonService extends IMybatisRepositoryHelper {
	String obtenerCorrelativo(String id_empresa, String tipoDoc, String serie ) throws Exception;
}
