package com.acme.commons.business.service;

import com.acme.mybatis.query.model.ClienteQuery;
import com.acme.mybatis.query.model.ClienteQueryCriteria;
import com.acme.mybatis.query.model.CotizacionQuery;
import com.acme.mybatis.query.model.CotizacionQueryCriteria;
import com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

/**
 * Created by JRaffo on 16/10/15.
 */
public interface IGestionarCotizacionService extends IMybatisRepositoryHelper {

    Integer create(CotizacionQuery cotizacionQuery) throws Exception;
    void save(CotizacionQuery cotizacionQuery) throws Exception;
    void remove(CotizacionQuery cotizacionQuery) throws Exception;
    <T> List<T> list(Class mapperClass, CotizacionQueryCriteria cotizacionQueryCriteria, boolean pagination) throws Exception;

}
