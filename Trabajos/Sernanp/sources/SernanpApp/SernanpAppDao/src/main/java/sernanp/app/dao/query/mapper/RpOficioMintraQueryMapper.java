package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpOficioMintraQuery; 
import sernanp.app.dao.query.domain.RpOficioMintraQueryCriteria; 

public interface RpOficioMintraQueryMapper { 
   List<RpOficioMintraQuery> getListQueryByCriteria(RpOficioMintraQueryCriteria criteria); 
   List<RpOficioMintraQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpOficioMintraQuery> getListQueryPaginationByCriteria(RpOficioMintraQueryCriteria criteria, RowBounds rowBounds); 
   List<RpOficioMintraQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpOficioMintraQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
