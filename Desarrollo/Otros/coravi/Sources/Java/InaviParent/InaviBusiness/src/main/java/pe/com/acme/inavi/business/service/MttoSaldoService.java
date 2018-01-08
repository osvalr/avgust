package pe.com.acme.inavi.business.service;

import java.util.List;

import pe.com.acme.query.mybatis.model.GuiaQuery;
import pe.com.acme.query.mybatis.model.GuiaQueryCriteria;
import pe.com.acme.query.mybatis.model.SaldoPorGuiaQuery;
import pe.com.acme.util.IMybatisRepositoryHelper;

public interface MttoSaldoService extends IMybatisRepositoryHelper {
	void update(SaldoPorGuiaQuery model) throws Exception;
    List<GuiaQuery> list(GuiaQueryCriteria criteria) throws Exception;
    int countRecords(GuiaQueryCriteria criteria) throws Exception;
}
