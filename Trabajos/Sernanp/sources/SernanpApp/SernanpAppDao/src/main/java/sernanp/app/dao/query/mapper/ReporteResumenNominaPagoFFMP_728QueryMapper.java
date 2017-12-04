package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728Query; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_728QueryCriteria; 

public interface ReporteResumenNominaPagoFFMP_728QueryMapper { 
   List<ReporteResumenNominaPagoFFMP_728Query> getListQueryByCriteria(ReporteResumenNominaPagoFFMP_728QueryCriteria criteria); 
   List<ReporteResumenNominaPagoFFMP_728Query> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenNominaPagoFFMP_728Query> getListQueryPaginationByCriteria(ReporteResumenNominaPagoFFMP_728QueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenNominaPagoFFMP_728Query> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenNominaPagoFFMP_728QueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
