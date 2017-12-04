package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpPadronTrabajadoresQuery; 
import sernanp.app.dao.query.domain.RpPadronTrabajadoresQueryCriteria; 

public interface RpPadronTrabajadoresQueryMapper { 
   List<RpPadronTrabajadoresQuery> getListQueryByCriteria(RpPadronTrabajadoresQueryCriteria criteria); 
   List<RpPadronTrabajadoresQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpPadronTrabajadoresQuery> getListQueryPaginationByCriteria(RpPadronTrabajadoresQueryCriteria criteria, RowBounds rowBounds); 
   List<RpPadronTrabajadoresQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpPadronTrabajadoresQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
