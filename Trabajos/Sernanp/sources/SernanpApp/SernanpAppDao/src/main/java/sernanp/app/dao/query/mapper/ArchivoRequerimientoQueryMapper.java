package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ArchivoRequerimientoQuery; 
import sernanp.app.dao.query.domain.ArchivoRequerimientoQueryCriteria; 

public interface ArchivoRequerimientoQueryMapper { 
   List<ArchivoRequerimientoQuery> getListQueryByCriteria(ArchivoRequerimientoQueryCriteria criteria); 
   List<ArchivoRequerimientoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ArchivoRequerimientoQuery> getListQueryPaginationByCriteria(ArchivoRequerimientoQueryCriteria criteria, RowBounds rowBounds); 
   List<ArchivoRequerimientoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ArchivoRequerimientoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
