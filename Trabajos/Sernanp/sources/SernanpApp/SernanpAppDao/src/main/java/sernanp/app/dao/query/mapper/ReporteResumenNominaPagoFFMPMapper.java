package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMPCriteria; 

public interface ReporteResumenNominaPagoFFMPMapper { 
   List<ReporteResumenNominaPagoFFMP> getListQueryByCriteria(ReporteResumenNominaPagoFFMPCriteria criteria); 
   List<ReporteResumenNominaPagoFFMP> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenNominaPagoFFMP> getListQueryPaginationByCriteria(ReporteResumenNominaPagoFFMPCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenNominaPagoFFMP> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenNominaPagoFFMPCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
