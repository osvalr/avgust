package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarReqPersonalQuery; 
import sernanp.app.dao.query.domain.GestionarReqPersonalQueryCriteria; 

public interface GestionarReqPersonalQueryMapper { 
   List<GestionarReqPersonalQuery> getListQueryByCriteria(GestionarReqPersonalQueryCriteria criteria); 
   List<GestionarReqPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarReqPersonalQuery> getListQueryPaginationByCriteria(GestionarReqPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarReqPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarReqPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
