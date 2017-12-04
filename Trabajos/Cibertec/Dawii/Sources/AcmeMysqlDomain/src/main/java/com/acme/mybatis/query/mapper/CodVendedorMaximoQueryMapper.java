package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CodVendedorMaximoQuery; 
import com.acme.mybatis.query.model.CodVendedorMaximoQueryCriteria; 

public interface CodVendedorMaximoQueryMapper { 
   List<CodVendedorMaximoQuery> getListQueryByCriteria(CodVendedorMaximoQueryCriteria criteria); 
   List<CodVendedorMaximoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CodVendedorMaximoQuery> getListQueryPaginationByCriteria(CodVendedorMaximoQueryCriteria criteria, RowBounds rowBounds); 
   List<CodVendedorMaximoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CodVendedorMaximoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
