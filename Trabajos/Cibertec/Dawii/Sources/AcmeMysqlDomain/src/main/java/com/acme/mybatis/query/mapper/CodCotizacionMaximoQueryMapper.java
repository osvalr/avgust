package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CodCotizacionMaximoQuery; 
import com.acme.mybatis.query.model.CodCotizacionMaximoQueryCriteria; 

public interface CodCotizacionMaximoQueryMapper { 
   List<CodCotizacionMaximoQuery> getListQueryByCriteria(CodCotizacionMaximoQueryCriteria criteria); 
   List<CodCotizacionMaximoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CodCotizacionMaximoQuery> getListQueryPaginationByCriteria(CodCotizacionMaximoQueryCriteria criteria, RowBounds rowBounds); 
   List<CodCotizacionMaximoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CodCotizacionMaximoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
