package com.acme.commons.business.service;

import com.acme.mybatis.query.model.CotizacionQuery;
import com.acme.mybatis.query.model.CotizacionQueryCriteria;
import com.acme.mybatis.query.model.ProductoQuery;
import com.acme.mybatis.query.model.ProductoQueryCriteria;
import com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

/**
 * Created by JRaffo on 16/10/15.
 */
public interface IGestionarProductoService extends IMybatisRepositoryHelper {

    Integer create(ProductoQuery productoQuery) throws Exception;
    void save(ProductoQuery productoQuery) throws Exception;
    void remove(ProductoQuery productoQuery) throws Exception;
    <T> List<T> list(Class mapperClass, ProductoQueryCriteria productoQueryCriteria, boolean pagination) throws Exception;

}
