package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ArchivoQuery; 
import sernanp.app.dao.query.domain.ArchivoQueryCriteria; 

public interface ArchivoQueryMapper { 
   List<ArchivoQuery> getListQueryByCriteria(ArchivoQueryCriteria criteria); 
   List<ArchivoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ArchivoQuery> getListQueryPaginationByCriteria(ArchivoQueryCriteria criteria, RowBounds rowBounds); 
   List<ArchivoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ArchivoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
