package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQuery; 
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosQueryCriteria; 

public interface RpResumenPlanillaPagosQueryMapper { 
   List<RpResumenPlanillaPagosQuery> getListQueryByCriteria(RpResumenPlanillaPagosQueryCriteria criteria); 
   List<RpResumenPlanillaPagosQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpResumenPlanillaPagosQuery> getListQueryPaginationByCriteria(RpResumenPlanillaPagosQueryCriteria criteria, RowBounds rowBounds); 
   List<RpResumenPlanillaPagosQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpResumenPlanillaPagosQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
