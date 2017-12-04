package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpResumenAfpQuery; 
import sernanp.app.dao.query.domain.RpResumenAfpQueryCriteria; 

public interface RpResumenAfpQueryMapper { 
   List<RpResumenAfpQuery> getListQueryByCriteria(RpResumenAfpQueryCriteria criteria); 
   List<RpResumenAfpQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpResumenAfpQuery> getListQueryPaginationByCriteria(RpResumenAfpQueryCriteria criteria, RowBounds rowBounds); 
   List<RpResumenAfpQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpResumenAfpQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
