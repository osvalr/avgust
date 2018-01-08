/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaPesoQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   12/03/2016 02:17:53
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.GuiaPesoQuery;
import pe.com.acme.query.mybatis.model.GuiaPesoQueryCriteria;

public interface GuiaPesoQueryMapper { 
   List<GuiaPesoQuery> getListQueryByCriteria(GuiaPesoQueryCriteria criteria);
   List<GuiaPesoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GuiaPesoQuery> getListQueryPaginationByCriteria(GuiaPesoQueryCriteria criteria, RowBounds rowBounds); 
   List<GuiaPesoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GuiaPesoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
