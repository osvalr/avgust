/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The BoletaWebQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   21/08/2016 19:17:19
*/

package pe.com.acme.invoiceelec.model.mybatis.query.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaWebQueryCriteria;

public interface BoletaWebQueryMapper { 
   List<BoletaWebQuery> getListQueryByCriteria(BoletaWebQueryCriteria criteria);
   List<BoletaWebQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<BoletaWebQuery> getListQueryPaginationByCriteria(BoletaWebQueryCriteria criteria, RowBounds rowBounds); 
   List<BoletaWebQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(BoletaWebQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
