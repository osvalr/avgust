/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The PerfilPorNombreQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/02/2016 23:43:29
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.PerfilPorNombreQuery;
import pe.com.acme.query.mybatis.model.PerfilPorNombreQueryCriteria;

public interface PerfilPorNombreQueryMapper { 
   List<PerfilPorNombreQuery> getListQueryByCriteria(PerfilPorNombreQueryCriteria criteria);
   List<PerfilPorNombreQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PerfilPorNombreQuery> getListQueryPaginationByCriteria(PerfilPorNombreQueryCriteria criteria, RowBounds rowBounds); 
   List<PerfilPorNombreQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PerfilPorNombreQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
