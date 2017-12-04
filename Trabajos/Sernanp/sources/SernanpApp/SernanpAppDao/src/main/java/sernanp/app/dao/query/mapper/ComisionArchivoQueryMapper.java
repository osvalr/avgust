package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ComisionArchivoQuery; 
import sernanp.app.dao.query.domain.ComisionArchivoQueryCriteria; 

public interface ComisionArchivoQueryMapper { 
   List<ComisionArchivoQuery> getListQueryByCriteria(ComisionArchivoQueryCriteria criteria); 
   List<ComisionArchivoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ComisionArchivoQuery> getListQueryPaginationByCriteria(ComisionArchivoQueryCriteria criteria, RowBounds rowBounds); 
   List<ComisionArchivoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ComisionArchivoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
