package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQuery; 
import sernanp.app.dao.query.domain.ReporteResumenGeneralPlanillaQueryCriteria; 

public interface ReporteResumenGeneralPlanillaQueryMapper { 
   List<ReporteResumenGeneralPlanillaQuery> getListQueryByCriteria(ReporteResumenGeneralPlanillaQueryCriteria criteria); 
   List<ReporteResumenGeneralPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenGeneralPlanillaQuery> getListQueryPaginationByCriteria(ReporteResumenGeneralPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenGeneralPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenGeneralPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
