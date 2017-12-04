package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEvaluacionEscritaQuery; 
import sernanp.app.dao.query.domain.RpSeleccionPostulantesEvaluacionEscritaQueryCriteria; 

public interface RpSeleccionPostulantesEvaluacionEscritaQueryMapper { 
   List<RpSeleccionPostulantesEvaluacionEscritaQuery> getListQueryByCriteria(RpSeleccionPostulantesEvaluacionEscritaQueryCriteria criteria); 
   List<RpSeleccionPostulantesEvaluacionEscritaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpSeleccionPostulantesEvaluacionEscritaQuery> getListQueryPaginationByCriteria(RpSeleccionPostulantesEvaluacionEscritaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpSeleccionPostulantesEvaluacionEscritaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpSeleccionPostulantesEvaluacionEscritaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
