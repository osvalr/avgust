package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQuery; 
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQueryCriteria; 

public interface ReporteResumenGlobalCASQueryMapper { 
   List<ReporteResumenGlobalCASQuery> getListQueryByCriteria(ReporteResumenGlobalCASQueryCriteria criteria); 
   List<ReporteResumenGlobalCASQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenGlobalCASQuery> getListQueryPaginationByCriteria(ReporteResumenGlobalCASQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenGlobalCASQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenGlobalCASQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
