package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpBoletasPersonalQuery; 
import sernanp.app.dao.query.domain.RpBoletasPersonalQueryCriteria; 

public interface RpBoletasPersonalQueryMapper { 
   List<RpBoletasPersonalQuery> getListQueryByCriteria(RpBoletasPersonalQueryCriteria criteria); 
   List<RpBoletasPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpBoletasPersonalQuery> getListQueryPaginationByCriteria(RpBoletasPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<RpBoletasPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpBoletasPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
