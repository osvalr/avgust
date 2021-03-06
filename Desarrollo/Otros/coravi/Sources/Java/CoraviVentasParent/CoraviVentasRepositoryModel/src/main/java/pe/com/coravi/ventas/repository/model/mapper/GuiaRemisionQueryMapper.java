/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaRemisionQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   20/11/2016 11:35:44
*/

package pe.com.coravi.ventas.repository.model.mapper;

import org.apache.ibatis.session.RowBounds;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQuery;
import pe.com.coravi.ventas.repository.model.dto.GuiaRemisionQueryCriteria;

import java.util.List;
import java.util.Map;

public interface GuiaRemisionQueryMapper { 
   List<GuiaRemisionQuery> getListQueryByCriteria(GuiaRemisionQueryCriteria criteria);
   List<GuiaRemisionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GuiaRemisionQuery> getListQueryPaginationByCriteria(GuiaRemisionQueryCriteria criteria, RowBounds rowBounds); 
   List<GuiaRemisionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GuiaRemisionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
