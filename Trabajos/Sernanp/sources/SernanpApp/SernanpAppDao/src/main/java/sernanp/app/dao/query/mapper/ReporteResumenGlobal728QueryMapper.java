package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenGlobal728Query; 
import sernanp.app.dao.query.domain.ReporteResumenGlobal728QueryCriteria; 

public interface ReporteResumenGlobal728QueryMapper { 
   List<ReporteResumenGlobal728Query> getListQueryByCriteria(ReporteResumenGlobal728QueryCriteria criteria); 
   List<ReporteResumenGlobal728Query> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenGlobal728Query> getListQueryPaginationByCriteria(ReporteResumenGlobal728QueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenGlobal728Query> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenGlobal728QueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
