package com.acme.mybatis.query.mapper;

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CatalogoQuery;
import com.acme.mybatis.query.model.CatalogoQueryCriteria;

public interface CatalogoQueryMapper { 
   List<CatalogoQuery> getListQueryByCriteria(CatalogoQueryCriteria criteria); 
   List<CatalogoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CatalogoQuery> getListQueryPaginationByCriteria(CatalogoQueryCriteria criteria, RowBounds rowBounds); 
   List<CatalogoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CatalogoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
