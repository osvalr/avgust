package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenGlobal728Query_Liquidacion; 
import sernanp.app.dao.query.domain.ReporteResumenGlobal728Query_LiquidacionCriteria; 

public interface ReporteResumenGlobal728Query_LiquidacionMapper { 
   List<ReporteResumenGlobal728Query_Liquidacion> getListQueryByCriteria(ReporteResumenGlobal728Query_LiquidacionCriteria criteria); 
   List<ReporteResumenGlobal728Query_Liquidacion> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenGlobal728Query_Liquidacion> getListQueryPaginationByCriteria(ReporteResumenGlobal728Query_LiquidacionCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenGlobal728Query_Liquidacion> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenGlobal728Query_LiquidacionCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
