package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQuery_Liquidacion; 
import sernanp.app.dao.query.domain.ReporteResumenGlobalCASQuery_LiquidacionCriteria; 

public interface ReporteResumenGlobalCASQuery_LiquidacionMapper { 
   List<ReporteResumenGlobalCASQuery_Liquidacion> getListQueryByCriteria(ReporteResumenGlobalCASQuery_LiquidacionCriteria criteria); 
   List<ReporteResumenGlobalCASQuery_Liquidacion> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenGlobalCASQuery_Liquidacion> getListQueryPaginationByCriteria(ReporteResumenGlobalCASQuery_LiquidacionCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenGlobalCASQuery_Liquidacion> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenGlobalCASQuery_LiquidacionCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
