package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQuery; 
import sernanp.app.dao.query.domain.RpPlanillaPagoONPQueryCriteria; 

public interface RpPlanillaPagoONPQueryMapper { 
   List<RpPlanillaPagoONPQuery> getListQueryByCriteria(RpPlanillaPagoONPQueryCriteria criteria); 
   List<RpPlanillaPagoONPQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpPlanillaPagoONPQuery> getListQueryPaginationByCriteria(RpPlanillaPagoONPQueryCriteria criteria, RowBounds rowBounds); 
   List<RpPlanillaPagoONPQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpPlanillaPagoONPQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
