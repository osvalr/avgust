/*
* Copyright «©» 2016, INVERSIONES LA IQUEÑA S.A.C. All rights reserved.
*
* This file was generated by MybatisModelGenerator v.3.0.
* All changes made in this file will be lost if you recompile the source schema.
*
* [MybatisModelGenerator v.3.0] by JRaffo 
*/

/**
* The PerfilAplicacionSubCrudMapper interface conten the methods for run the SQL Query.
*
* @author  Javier Raffo
* @version 1.0
* @since   26/02/2016 16:45:53
*/

package pe.com.acme.query.mybatis.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.acme.query.mybatis.model.PerfilAplicacionSubCrud;
import pe.com.acme.query.mybatis.model.PerfilAplicacionSubCrudCriteria;

public interface PerfilAplicacionSubCrudMapper { 
   List<PerfilAplicacionSubCrud> getListQueryByCriteria(PerfilAplicacionSubCrudCriteria criteria);
   List<PerfilAplicacionSubCrud> getListQueryByMap(Map<String, Object> paramMap); 
   List<PerfilAplicacionSubCrud> getListQueryPaginationByCriteria(PerfilAplicacionSubCrudCriteria criteria, RowBounds rowBounds); 
   List<PerfilAplicacionSubCrud> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PerfilAplicacionSubCrudCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap);
} 
