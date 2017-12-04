package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteSelectEtapasSeleccionQuery; 
import sernanp.app.dao.query.domain.ReporteSelectEtapasSeleccionQueryCriteria; 

public interface ReporteSelectEtapasSeleccionQueryMapper { 
   List<ReporteSelectEtapasSeleccionQuery> getListQueryByCriteria(ReporteSelectEtapasSeleccionQueryCriteria criteria); 
   List<ReporteSelectEtapasSeleccionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteSelectEtapasSeleccionQuery> getListQueryPaginationByCriteria(ReporteSelectEtapasSeleccionQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteSelectEtapasSeleccionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteSelectEtapasSeleccionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
