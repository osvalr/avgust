package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerAreaActualPersonalQuery; 
import sernanp.app.dao.query.domain.ObtenerAreaActualPersonalQueryCriteria; 

public interface ObtenerAreaActualPersonalQueryMapper { 
   List<ObtenerAreaActualPersonalQuery> getListQueryByCriteria(ObtenerAreaActualPersonalQueryCriteria criteria); 
   List<ObtenerAreaActualPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerAreaActualPersonalQuery> getListQueryPaginationByCriteria(ObtenerAreaActualPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerAreaActualPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerAreaActualPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
