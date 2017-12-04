package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpResumenGeneralPlanillasQuery; 
import sernanp.app.dao.query.domain.RpResumenGeneralPlanillasQueryCriteria; 

public interface RpResumenGeneralPlanillasQueryMapper { 
   List<RpResumenGeneralPlanillasQuery> getListQueryByCriteria(RpResumenGeneralPlanillasQueryCriteria criteria); 
   List<RpResumenGeneralPlanillasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpResumenGeneralPlanillasQuery> getListQueryPaginationByCriteria(RpResumenGeneralPlanillasQueryCriteria criteria, RowBounds rowBounds); 
   List<RpResumenGeneralPlanillasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpResumenGeneralPlanillasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
