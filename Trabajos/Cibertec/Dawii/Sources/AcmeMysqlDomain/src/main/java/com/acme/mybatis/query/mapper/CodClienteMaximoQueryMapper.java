package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CodClienteMaximoQuery; 
import com.acme.mybatis.query.model.CodClienteMaximoQueryCriteria; 

public interface CodClienteMaximoQueryMapper { 
   List<CodClienteMaximoQuery> getListQueryByCriteria(CodClienteMaximoQueryCriteria criteria); 
   List<CodClienteMaximoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CodClienteMaximoQuery> getListQueryPaginationByCriteria(CodClienteMaximoQueryCriteria criteria, RowBounds rowBounds); 
   List<CodClienteMaximoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CodClienteMaximoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
