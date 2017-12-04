package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.ProductoQuery; 
import com.acme.mybatis.query.model.ProductoQueryCriteria; 

public interface ProductoQueryMapper { 
   List<ProductoQuery> getListQueryByCriteria(ProductoQueryCriteria criteria); 
   List<ProductoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ProductoQuery> getListQueryPaginationByCriteria(ProductoQueryCriteria criteria, RowBounds rowBounds); 
   List<ProductoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ProductoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
