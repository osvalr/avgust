package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.AportePersonalQuery; 
import sernanp.app.dao.query.domain.AportePersonalQueryCriteria; 

public interface AportePersonalQueryMapper { 
   List<AportePersonalQuery> getListQueryByCriteria(AportePersonalQueryCriteria criteria); 
   List<AportePersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<AportePersonalQuery> getListQueryPaginationByCriteria(AportePersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<AportePersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(AportePersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
