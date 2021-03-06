/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The ProveedorPorNombreQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   14/03/2016 01:09:00
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.ProveedorPorNombreQuery;
import pe.com.acme.query.mybatis.model.ProveedorPorNombreQueryCriteria;

public interface ProveedorPorNombreQueryMapper { 
   List<ProveedorPorNombreQuery> getListQueryByCriteria(ProveedorPorNombreQueryCriteria criteria);
   List<ProveedorPorNombreQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ProveedorPorNombreQuery> getListQueryPaginationByCriteria(ProveedorPorNombreQueryCriteria criteria, RowBounds rowBounds); 
   List<ProveedorPorNombreQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ProveedorPorNombreQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
