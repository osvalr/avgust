package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DeduccionPersonalQuery; 
import sernanp.app.dao.query.domain.DeduccionPersonalQueryCriteria; 

public interface DeduccionPersonalQueryMapper { 
   List<DeduccionPersonalQuery> getListQueryByCriteria(DeduccionPersonalQueryCriteria criteria); 
   List<DeduccionPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DeduccionPersonalQuery> getListQueryPaginationByCriteria(DeduccionPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<DeduccionPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DeduccionPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
