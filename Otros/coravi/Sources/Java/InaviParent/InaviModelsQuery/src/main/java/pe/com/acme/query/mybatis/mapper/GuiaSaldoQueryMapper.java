/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The GuiaSaldoQueryMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   17/03/2016 17:01:24
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.GuiaSaldoQuery;
import pe.com.acme.query.mybatis.model.GuiaSaldoQueryCriteria;

public interface GuiaSaldoQueryMapper { 
   List<GuiaSaldoQuery> getListQueryByCriteria(GuiaSaldoQueryCriteria criteria);
   List<GuiaSaldoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GuiaSaldoQuery> getListQueryPaginationByCriteria(GuiaSaldoQueryCriteria criteria, RowBounds rowBounds); 
   List<GuiaSaldoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GuiaSaldoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
