package pe.com.acme.invoiceelec.business.service;

import pe.com.acme.inoiceelec.util.GeneratedDocInfoDto;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaAnuladaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQueryCriteria;
import pe.com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

public interface GestionarBoletaService extends IMybatisRepositoryHelper {

	GeneratedDocInfoDto generarDocumentoElectronico(BoletaQuery boletaQuery) throws Exception;
    List<BoletaWebQuery> list(BoletaWebQueryCriteria criteria) throws Exception;
    int countRecords(BoletaWebQueryCriteria criteria) throws Exception;

    GeneratedDocInfoDto generarResumen(BoletaAnuladaQuery boletaAnuladaQuery) throws Exception;
}
