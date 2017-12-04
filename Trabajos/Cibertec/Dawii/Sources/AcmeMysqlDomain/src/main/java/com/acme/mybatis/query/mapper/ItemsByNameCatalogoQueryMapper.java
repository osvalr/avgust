package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.ItemsByNameCatalogoQuery; 
import com.acme.mybatis.query.model.ItemsByNameCatalogoQueryCriteria; 

public interface ItemsByNameCatalogoQueryMapper { 
   List<ItemsByNameCatalogoQuery> getListQueryByCriteria(ItemsByNameCatalogoQueryCriteria criteria); 
   List<ItemsByNameCatalogoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ItemsByNameCatalogoQuery> getListQueryPaginationByCriteria(ItemsByNameCatalogoQueryCriteria criteria, RowBounds rowBounds); 
   List<ItemsByNameCatalogoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ItemsByNameCatalogoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
