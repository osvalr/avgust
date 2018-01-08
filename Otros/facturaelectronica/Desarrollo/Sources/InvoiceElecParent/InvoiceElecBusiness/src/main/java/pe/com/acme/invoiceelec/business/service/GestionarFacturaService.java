package pe.com.acme.invoiceelec.business.service;

import java.util.List;

import pe.com.acme.inoiceelec.util.GeneratedDocInfoDto;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.FacturaWebQueryCriteria;
import pe.com.acme.util.IMybatisRepositoryHelper;

/**
 * Created by JRaffo on 23/06/16.
 */
public interface GestionarFacturaService extends IMybatisRepositoryHelper {
	
	GeneratedDocInfoDto generarDocumentoElectronico(FacturaQuery facturaQuery) throws Exception;
    List<FacturaWebQuery> list(FacturaWebQueryCriteria criteria) throws Exception;
    int countRecords(FacturaWebQueryCriteria criteria) throws Exception;
    
}
