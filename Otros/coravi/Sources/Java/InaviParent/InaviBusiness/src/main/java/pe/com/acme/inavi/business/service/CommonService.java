package pe.com.acme.inavi.business.service;

import pe.com.acme.inavi.business.bean.InfoNumeroSerieDocumentoBean;
import pe.com.acme.util.IMybatisRepositoryHelper;

public interface CommonService extends IMybatisRepositoryHelper {
	InfoNumeroSerieDocumentoBean obtenerNumDocVenta(String serie,Integer id_tipo_documento) throws Exception;
}
