package com.acme.mybatis.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import com.acme.mybatis.query.model.CotizacionQuery; 
import com.acme.mybatis.query.model.CotizacionQueryCriteria; 

public interface CotizacionQueryMapper { 
   List<CotizacionQuery> getListQueryByCriteria(CotizacionQueryCriteria criteria); 
   List<CotizacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CotizacionQuery> getListQueryPaginationByCriteria(CotizacionQueryCriteria criteria, RowBounds rowBounds); 
   List<CotizacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CotizacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
