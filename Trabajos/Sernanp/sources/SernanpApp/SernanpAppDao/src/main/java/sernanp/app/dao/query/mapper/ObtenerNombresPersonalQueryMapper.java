package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerNombresPersonalQuery; 
import sernanp.app.dao.query.domain.ObtenerNombresPersonalQueryCriteria; 

public interface ObtenerNombresPersonalQueryMapper { 
   List<ObtenerNombresPersonalQuery> getListQueryByCriteria(ObtenerNombresPersonalQueryCriteria criteria); 
   List<ObtenerNombresPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerNombresPersonalQuery> getListQueryPaginationByCriteria(ObtenerNombresPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerNombresPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerNombresPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
