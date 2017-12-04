package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQuery; 
import sernanp.app.dao.query.domain.ReporteResumenNominaPagoFFMP_CASQueryCriteria; 

public interface ReporteResumenNominaPagoFFMP_CASQueryMapper { 
   List<ReporteResumenNominaPagoFFMP_CASQuery> getListQueryByCriteria(ReporteResumenNominaPagoFFMP_CASQueryCriteria criteria); 
   List<ReporteResumenNominaPagoFFMP_CASQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenNominaPagoFFMP_CASQuery> getListQueryPaginationByCriteria(ReporteResumenNominaPagoFFMP_CASQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenNominaPagoFFMP_CASQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenNominaPagoFFMP_CASQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
