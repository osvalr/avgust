package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEntrevistaPersonalQuery; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEntrevistaPersonalQueryCriteria; 

public interface RpSeleccionPostulantesEntrevistaPersonalQueryMapper { 
   List<RpSeleccionPostulantesEntrevistaPersonalQuery> getListQueryByCriteria(RpSeleccionPostulantesEntrevistaPersonalQueryCriteria criteria); 
   List<RpSeleccionPostulantesEntrevistaPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpSeleccionPostulantesEntrevistaPersonalQuery> getListQueryPaginationByCriteria(RpSeleccionPostulantesEntrevistaPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<RpSeleccionPostulantesEntrevistaPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpSeleccionPostulantesEntrevistaPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
