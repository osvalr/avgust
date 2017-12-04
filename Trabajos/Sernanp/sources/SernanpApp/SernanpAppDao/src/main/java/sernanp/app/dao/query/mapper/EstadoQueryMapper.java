package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.EstadoQuery; 
import sernanp.app.dao.query.domain.EstadoQueryCriteria; 

public interface EstadoQueryMapper { 
   List<EstadoQuery> getListQueryByCriteria(EstadoQueryCriteria criteria); 
   List<EstadoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<EstadoQuery> getListQueryPaginationByCriteria(EstadoQueryCriteria criteria, RowBounds rowBounds); 
   List<EstadoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(EstadoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
