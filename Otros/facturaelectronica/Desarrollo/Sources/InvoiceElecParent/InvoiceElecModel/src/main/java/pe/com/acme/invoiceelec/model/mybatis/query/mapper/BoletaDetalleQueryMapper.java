/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The BoletaDetalleQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   14/07/2016 04:08:14
*/

package pe.com.acme.invoiceelec.model.mybatis.query.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaDetalleQuery;
import pe.com.acme.invoiceelec.model.mybatis.query.dto.BoletaDetalleQueryCriteria;

public interface BoletaDetalleQueryMapper { 
   List<BoletaDetalleQuery> getListQueryByCriteria(BoletaDetalleQueryCriteria criteria);
   List<BoletaDetalleQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<BoletaDetalleQuery> getListQueryPaginationByCriteria(BoletaDetalleQueryCriteria criteria, RowBounds rowBounds); 
   List<BoletaDetalleQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(BoletaDetalleQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 