/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The RolAplicacionCrudMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   27/02/2016 14:39:12
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.RolAplicacionCrud;
import pe.com.acme.query.mybatis.model.RolAplicacionCrudCriteria;

public interface RolAplicacionCrudMapper { 
   List<RolAplicacionCrud> getListQueryByCriteria(RolAplicacionCrudCriteria criteria);
   List<RolAplicacionCrud> getListQueryByMap(Map<String, Object> paramMap); 
   List<RolAplicacionCrud> getListQueryPaginationByCriteria(RolAplicacionCrudCriteria criteria, RowBounds rowBounds); 
   List<RolAplicacionCrud> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RolAplicacionCrudCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 