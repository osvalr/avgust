/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaPorJornadaClienteQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   16/03/2016 18:45:19
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.GuiaPorJornadaClienteQuery;
import pe.com.acme.query.mybatis.model.GuiaPorJornadaClienteQueryCriteria;

public interface GuiaPorJornadaClienteQueryMapper { 
   List<GuiaPorJornadaClienteQuery> getListQueryByCriteria(GuiaPorJornadaClienteQueryCriteria criteria);
   List<GuiaPorJornadaClienteQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GuiaPorJornadaClienteQuery> getListQueryPaginationByCriteria(GuiaPorJornadaClienteQueryCriteria criteria, RowBounds rowBounds); 
   List<GuiaPorJornadaClienteQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GuiaPorJornadaClienteQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 