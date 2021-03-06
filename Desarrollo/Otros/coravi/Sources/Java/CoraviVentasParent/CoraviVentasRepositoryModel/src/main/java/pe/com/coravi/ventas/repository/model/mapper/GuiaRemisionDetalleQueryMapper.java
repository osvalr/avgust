/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaRemisionDetalleQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:35:51
*/

package pe.com.coravi.ventas.repository.model.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionDetalleQuery;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionDetalleQueryCriteria;

public interface GuiaRemisionDetalleQueryMapper { 
   List<GuiaRemisionDetalleQuery> getListQueryByCriteria(GuiaRemisionDetalleQueryCriteria criteria);
   List<GuiaRemisionDetalleQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GuiaRemisionDetalleQuery> getListQueryPaginationByCriteria(GuiaRemisionDetalleQueryCriteria criteria, RowBounds rowBounds); 
   List<GuiaRemisionDetalleQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GuiaRemisionDetalleQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
