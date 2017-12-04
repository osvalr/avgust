package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpxlsQuery; 
import sernanp.app.dao.query.domain.ResumenPlanillaPagosAfpxlsQueryCriteria; 

public interface ResumenPlanillaPagosAfpxlsQueryMapper { 
   List<ResumenPlanillaPagosAfpxlsQuery> getListQueryByCriteria(ResumenPlanillaPagosAfpxlsQueryCriteria criteria); 
   List<ResumenPlanillaPagosAfpxlsQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ResumenPlanillaPagosAfpxlsQuery> getListQueryPaginationByCriteria(ResumenPlanillaPagosAfpxlsQueryCriteria criteria, RowBounds rowBounds); 
   List<ResumenPlanillaPagosAfpxlsQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ResumenPlanillaPagosAfpxlsQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
