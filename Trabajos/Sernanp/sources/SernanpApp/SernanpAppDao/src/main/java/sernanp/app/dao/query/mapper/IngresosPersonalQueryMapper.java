package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.IngresosPersonalQuery; 
import sernanp.app.dao.query.domain.IngresosPersonalQueryCriteria; 

public interface IngresosPersonalQueryMapper { 
   List<IngresosPersonalQuery> getListQueryByCriteria(IngresosPersonalQueryCriteria criteria); 
   List<IngresosPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<IngresosPersonalQuery> getListQueryPaginationByCriteria(IngresosPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<IngresosPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(IngresosPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
