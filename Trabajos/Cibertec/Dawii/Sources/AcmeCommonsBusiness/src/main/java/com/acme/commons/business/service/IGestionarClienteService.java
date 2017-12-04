package com.acme.commons.business.service;

import com.acme.mybatis.query.model.CatalogoQuery;
import com.acme.mybatis.query.model.CatalogoQueryCriteria;
import com.acme.mybatis.query.model.ClienteQuery;
import com.acme.mybatis.query.model.ClienteQueryCriteria;
import com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

/**
 * Created by JRaffo on 16/10/15.
 */
public interface IGestionarClienteService extends IMybatisRepositoryHelper {

    Integer create(ClienteQuery clienteQuery) throws Exception;
    void save(ClienteQuery clienteQuery) throws Exception;
    void remove(ClienteQuery clienteQuery) throws Exception;
    <T> List<T> list(Class mapperClass, ClienteQueryCriteria clienteQueryCriteria, boolean pagination) throws Exception;

}
