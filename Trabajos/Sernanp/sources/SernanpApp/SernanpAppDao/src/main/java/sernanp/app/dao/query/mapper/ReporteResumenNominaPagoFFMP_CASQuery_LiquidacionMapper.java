package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQuery_Liquidacion; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria; 

public interface ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionMapper { 
   List<ReporteResumenNominaPagoFFMP_CASQuery_Liquidacion> getListQueryByCriteria(ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria criteria); 
   List<ReporteResumenNominaPagoFFMP_CASQuery_Liquidacion> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenNominaPagoFFMP_CASQuery_Liquidacion> getListQueryPaginationByCriteria(ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenNominaPagoFFMP_CASQuery_Liquidacion> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenNominaPagoFFMP_CASQuery_LiquidacionCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
