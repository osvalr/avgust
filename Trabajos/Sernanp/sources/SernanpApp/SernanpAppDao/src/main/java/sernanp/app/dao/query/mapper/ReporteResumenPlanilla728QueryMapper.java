package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenPlanilla728Query; 
import sernanp.app.dao.query.domain.ReporteResumenPlanilla728QueryCriteria; 

public interface ReporteResumenPlanilla728QueryMapper { 
   List<ReporteResumenPlanilla728Query> getListQueryByCriteria(ReporteResumenPlanilla728QueryCriteria criteria); 
   List<ReporteResumenPlanilla728Query> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenPlanilla728Query> getListQueryPaginationByCriteria(ReporteResumenPlanilla728QueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenPlanilla728Query> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenPlanilla728QueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
