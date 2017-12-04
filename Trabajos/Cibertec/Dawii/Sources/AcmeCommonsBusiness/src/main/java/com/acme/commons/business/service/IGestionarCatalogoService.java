package com.acme.commons.business.service;

import com.acme.mybatis.query.model.CatalogoQuery;
import com.acme.mybatis.query.model.CatalogoQueryCriteria;
import com.acme.util.IMybatisRepositoryHelper;

import java.util.List;

public interface IGestionarCatalogoService extends IMybatisRepositoryHelper {

    Integer create(CatalogoQuery catalogoQuery) throws Exception;
    void save(CatalogoQuery catalogoQuery) throws Exception;
    void remove(CatalogoQuery catalogoQuery) throws Exception;
    <T>  List<T> list(Class mapperClass, CatalogoQueryCriteria catalogoQueryCriteria, boolean pagination) throws Exception;

}
