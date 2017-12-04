package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.VendedorQuery; 
import com.acme.mybatis.query.model.VendedorQueryCriteria; 

public interface VendedorQueryMapper { 
   List<VendedorQuery> getListQueryByCriteria(VendedorQueryCriteria criteria); 
   List<VendedorQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<VendedorQuery> getListQueryPaginationByCriteria(VendedorQueryCriteria criteria, RowBounds rowBounds); 
   List<VendedorQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(VendedorQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
