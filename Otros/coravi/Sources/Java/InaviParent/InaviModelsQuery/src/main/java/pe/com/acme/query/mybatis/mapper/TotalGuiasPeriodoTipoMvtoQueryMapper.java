/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The TotalGuiasPeriodoTipoMvtoQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   28/07/2016 04:02:19
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.TotalGuiasPeriodoTipoMvtoQuery;
import pe.com.acme.query.mybatis.model.TotalGuiasPeriodoTipoMvtoQueryCriteria;

public interface TotalGuiasPeriodoTipoMvtoQueryMapper { 
   List<TotalGuiasPeriodoTipoMvtoQuery> getListQueryByCriteria(TotalGuiasPeriodoTipoMvtoQueryCriteria criteria);
   List<TotalGuiasPeriodoTipoMvtoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<TotalGuiasPeriodoTipoMvtoQuery> getListQueryPaginationByCriteria(TotalGuiasPeriodoTipoMvtoQueryCriteria criteria, RowBounds rowBounds); 
   List<TotalGuiasPeriodoTipoMvtoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(TotalGuiasPeriodoTipoMvtoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
