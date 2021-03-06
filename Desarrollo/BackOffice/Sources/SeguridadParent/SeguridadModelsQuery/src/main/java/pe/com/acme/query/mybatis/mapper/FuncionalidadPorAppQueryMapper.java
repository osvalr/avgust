/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The FuncionalidadPorAppQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   25/02/2016 21:57:17
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.FuncionalidadPorAppQuery;
import pe.com.acme.query.mybatis.model.FuncionalidadPorAppQueryCriteria;

public interface FuncionalidadPorAppQueryMapper { 
   List<FuncionalidadPorAppQuery> getListQueryByCriteria(FuncionalidadPorAppQueryCriteria criteria);
   List<FuncionalidadPorAppQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<FuncionalidadPorAppQuery> getListQueryPaginationByCriteria(FuncionalidadPorAppQueryCriteria criteria, RowBounds rowBounds); 
   List<FuncionalidadPorAppQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(FuncionalidadPorAppQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
