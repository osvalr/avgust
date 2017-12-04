package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.ClienteQuery; 
import com.acme.mybatis.query.model.ClienteQueryCriteria; 

public interface ClienteQueryMapper { 
   List<ClienteQuery> getListQueryByCriteria(ClienteQueryCriteria criteria); 
   List<ClienteQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ClienteQuery> getListQueryPaginationByCriteria(ClienteQueryCriteria criteria, RowBounds rowBounds); 
   List<ClienteQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ClienteQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
