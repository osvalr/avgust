package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpQuery; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpQueryCriteria; 

public interface ResumenPlanillaPagosAfpQueryMapper { 
   List<ResumenPlanillaPagosAfpQuery> getListQueryByCriteria(ResumenPlanillaPagosAfpQueryCriteria criteria); 
   List<ResumenPlanillaPagosAfpQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ResumenPlanillaPagosAfpQuery> getListQueryPaginationByCriteria(ResumenPlanillaPagosAfpQueryCriteria criteria, RowBounds rowBounds); 
   List<ResumenPlanillaPagosAfpQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ResumenPlanillaPagosAfpQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
