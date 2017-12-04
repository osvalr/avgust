package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpNetQuery; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpNetQueryCriteria; 

public interface ResumenPlanillaPagosAfpNetQueryMapper { 
   List<ResumenPlanillaPagosAfpNetQuery> getListQueryByCriteria(ResumenPlanillaPagosAfpNetQueryCriteria criteria); 
   List<ResumenPlanillaPagosAfpNetQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ResumenPlanillaPagosAfpNetQuery> getListQueryPaginationByCriteria(ResumenPlanillaPagosAfpNetQueryCriteria criteria, RowBounds rowBounds); 
   List<ResumenPlanillaPagosAfpNetQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ResumenPlanillaPagosAfpNetQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
