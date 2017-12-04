package com.acme.mybatis.query.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CatalogoItemQuery;
import com.acme.mybatis.query.model.CatalogoItemQueryCriteria;

public interface CatalogoItemQueryMapper { 
   List<CatalogoItemQuery> getListQueryByCriteria(CatalogoItemQueryCriteria criteria);
   List<CatalogoItemQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CatalogoItemQuery> getListQueryPaginationByCriteria(CatalogoItemQueryCriteria criteria, RowBounds rowBounds); 
   List<CatalogoItemQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CatalogoItemQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
