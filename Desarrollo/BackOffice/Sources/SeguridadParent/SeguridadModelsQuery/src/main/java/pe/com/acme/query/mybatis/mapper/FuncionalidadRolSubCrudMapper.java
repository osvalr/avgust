/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The FuncionalidadRolSubCrudMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   27/02/2016 14:21:57
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.FuncionalidadRolSubCrud;
import pe.com.acme.query.mybatis.model.FuncionalidadRolSubCrudCriteria;

public interface FuncionalidadRolSubCrudMapper { 
   List<FuncionalidadRolSubCrud> getListQueryByCriteria(FuncionalidadRolSubCrudCriteria criteria);
   List<FuncionalidadRolSubCrud> getListQueryByMap(Map<String, Object> paramMap); 
   List<FuncionalidadRolSubCrud> getListQueryPaginationByCriteria(FuncionalidadRolSubCrudCriteria criteria, RowBounds rowBounds); 
   List<FuncionalidadRolSubCrud> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(FuncionalidadRolSubCrudCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 