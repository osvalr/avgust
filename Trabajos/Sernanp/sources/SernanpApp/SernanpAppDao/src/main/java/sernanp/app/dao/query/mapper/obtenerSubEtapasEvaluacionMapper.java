package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.obtenerSubEtapasEvaluacion; 
import sernanp.app.dao.query.domain.obtenerSubEtapasEvaluacionCriteria; 

public interface obtenerSubEtapasEvaluacionMapper { 
   List<obtenerSubEtapasEvaluacion> getListQueryByCriteria(obtenerSubEtapasEvaluacionCriteria criteria); 
   List<obtenerSubEtapasEvaluacion> getListQueryByMap(Map<String, Object> paramMap); 
   List<obtenerSubEtapasEvaluacion> getListQueryPaginationByCriteria(obtenerSubEtapasEvaluacionCriteria criteria, RowBounds rowBounds); 
   List<obtenerSubEtapasEvaluacion> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(obtenerSubEtapasEvaluacionCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
