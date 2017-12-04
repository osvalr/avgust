package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728Query_Liquidacion; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria; 

public interface ReporteResumenNominaPagoFFMP_728Query_LiquidacionMapper { 
   List<ReporteResumenNominaPagoFFMP_728Query_Liquidacion> getListQueryByCriteria(ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria criteria); 
   List<ReporteResumenNominaPagoFFMP_728Query_Liquidacion> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenNominaPagoFFMP_728Query_Liquidacion> getListQueryPaginationByCriteria(ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenNominaPagoFFMP_728Query_Liquidacion> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenNominaPagoFFMP_728Query_LiquidacionCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
