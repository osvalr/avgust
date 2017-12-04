package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesFichaPostulacionQuery; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesFichaPostulacionQueryCriteria; 

public interface RpSeleccionPostulantesFichaPostulacionQueryMapper { 
   List<RpSeleccionPostulantesFichaPostulacionQuery> getListQueryByCriteria(RpSeleccionPostulantesFichaPostulacionQueryCriteria criteria); 
   List<RpSeleccionPostulantesFichaPostulacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpSeleccionPostulantesFichaPostulacionQuery> getListQueryPaginationByCriteria(RpSeleccionPostulantesFichaPostulacionQueryCriteria criteria, RowBounds rowBounds); 
   List<RpSeleccionPostulantesFichaPostulacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpSeleccionPostulantesFichaPostulacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
