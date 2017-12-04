/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ModelAvailableQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   21/02/2016 23:55:08
*/

package pe.com.jrtotem.app.generator.mybatis.query.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.jrtotem.app.generator.mybatis.query.domain.ModelAvailableQuery;
import pe.com.jrtotem.app.generator.mybatis.query.domain.ModelAvailableQueryCriteria;

public interface ModelAvailableQueryMapper { 
   List<ModelAvailableQuery> getListQueryByCriteria(ModelAvailableQueryCriteria criteria);
   List<ModelAvailableQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ModelAvailableQuery> getListQueryPaginationByCriteria(ModelAvailableQueryCriteria criteria, RowBounds rowBounds); 
   List<ModelAvailableQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ModelAvailableQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
