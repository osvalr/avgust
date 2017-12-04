package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerMetaPorAreaAnhoQuery; 
import sernanp.app.dao.query.domain.ObtenerMetaPorAreaAnhoQueryCriteria; 

public interface ObtenerMetaPorAreaAnhoQueryMapper { 
   List<ObtenerMetaPorAreaAnhoQuery> getListQueryByCriteria(ObtenerMetaPorAreaAnhoQueryCriteria criteria); 
   List<ObtenerMetaPorAreaAnhoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerMetaPorAreaAnhoQuery> getListQueryPaginationByCriteria(ObtenerMetaPorAreaAnhoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerMetaPorAreaAnhoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerMetaPorAreaAnhoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
