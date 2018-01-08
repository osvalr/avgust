/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The JornadaQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   09/03/2016 20:09:12
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.JornadaQuery;
import pe.com.acme.query.mybatis.model.JornadaQueryCriteria;

public interface JornadaQueryMapper { 
   List<JornadaQuery> getListQueryByCriteria(JornadaQueryCriteria criteria);
   List<JornadaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<JornadaQuery> getListQueryPaginationByCriteria(JornadaQueryCriteria criteria, RowBounds rowBounds); 
   List<JornadaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(JornadaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 