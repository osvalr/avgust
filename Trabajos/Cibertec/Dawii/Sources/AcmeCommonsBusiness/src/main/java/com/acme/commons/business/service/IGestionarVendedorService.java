package com.acme.commons.business.service;

import com.acme.mybatis.query.model.VendedorQuery;
import com.acme.mybatis.query.model.VendedorQueryCriteria;
import com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

/**
 * Created by JRaffo on 16/10/15.
 */
public interface IGestionarVendedorService extends IMybatisRepositoryHelper {

    Integer create(VendedorQuery vendedorQuery) throws Exception;

    void save(VendedorQuery vendedorQuery) throws Exception;

    void remove(VendedorQuery vendedorQuery) throws Exception;

    <T> List<T> list(Class mapperClass, VendedorQueryCriteria vendedorQueryCriteria, boolean pagination) throws Exception;

}
