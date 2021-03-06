/*
* Copyright «©» 2016, J.R Totem. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [GeneratorCrud v.1.0] by JRaffo 
*/

/**
* @author  Javier Raffo
* @version 1.0
* @since   13/03/2016 16:05:57
*/

package pe.com.acme.inavi.business.service;

import java.util.List;
import pe.com.acme.query.mybatis.model.GuiaCompraQuery;
import pe.com.acme.query.mybatis.model.GuiaCompraQueryCriteria;
import pe.com.acme.util.IMybatisRepositoryHelper;

public interface GestionarGuiaCompraService extends IMybatisRepositoryHelper {
    Integer create(GuiaCompraQuery model) throws Exception;
    void update(GuiaCompraQuery model) throws Exception;
    void destroy(GuiaCompraQuery model) throws Exception;
    List<GuiaCompraQuery> list(GuiaCompraQueryCriteria criteria) throws Exception;
    int countRecords(GuiaCompraQueryCriteria criteria) throws Exception;
}