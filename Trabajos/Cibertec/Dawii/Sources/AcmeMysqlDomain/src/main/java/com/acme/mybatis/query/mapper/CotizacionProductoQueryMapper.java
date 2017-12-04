package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CotizacionProductoQuery; 
import com.acme.mybatis.query.model.CotizacionProductoQueryCriteria; 

public interface CotizacionProductoQueryMapper { 
   List<CotizacionProductoQuery> getListQueryByCriteria(CotizacionProductoQueryCriteria criteria); 
   List<CotizacionProductoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CotizacionProductoQuery> getListQueryPaginationByCriteria(CotizacionProductoQueryCriteria criteria, RowBounds rowBounds); 
   List<CotizacionProductoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CotizacionProductoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
