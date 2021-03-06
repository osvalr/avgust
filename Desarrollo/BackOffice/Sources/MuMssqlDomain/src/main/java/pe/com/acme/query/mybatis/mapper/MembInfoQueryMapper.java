/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The MembInfoQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   29/03/2016 20:39:11
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.MembInfoQuery;
import pe.com.acme.query.mybatis.model.MembInfoQueryCriteria;

public interface MembInfoQueryMapper { 
   List<MembInfoQuery> getListQueryByCriteria(MembInfoQueryCriteria criteria);
   List<MembInfoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<MembInfoQuery> getListQueryPaginationByCriteria(MembInfoQueryCriteria criteria, RowBounds rowBounds); 
   List<MembInfoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(MembInfoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
