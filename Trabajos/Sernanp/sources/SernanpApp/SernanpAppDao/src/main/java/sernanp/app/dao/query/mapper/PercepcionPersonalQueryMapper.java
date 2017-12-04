package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PercepcionPersonalQuery; 
import sernanp.app.dao.query.domain.PercepcionPersonalQueryCriteria; 

public interface PercepcionPersonalQueryMapper { 
   List<PercepcionPersonalQuery> getListQueryByCriteria(PercepcionPersonalQueryCriteria criteria); 
   List<PercepcionPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PercepcionPersonalQuery> getListQueryPaginationByCriteria(PercepcionPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<PercepcionPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PercepcionPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
