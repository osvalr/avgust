package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CodProductoMaximoQuery; 
import com.acme.mybatis.query.model.CodProductoMaximoQueryCriteria; 

public interface CodProductoMaximoQueryMapper { 
   List<CodProductoMaximoQuery> getListQueryByCriteria(CodProductoMaximoQueryCriteria criteria); 
   List<CodProductoMaximoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CodProductoMaximoQuery> getListQueryPaginationByCriteria(CodProductoMaximoQueryCriteria criteria, RowBounds rowBounds); 
   List<CodProductoMaximoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CodProductoMaximoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
