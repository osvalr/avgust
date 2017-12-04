package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarEtapasProcesoSeleccionQuery; 
import sernanp.app.dao.query.domain.GestionarEtapasProcesoSeleccionQueryCriteria; 

public interface GestionarEtapasProcesoSeleccionQueryMapper { 
   List<GestionarEtapasProcesoSeleccionQuery> getListQueryByCriteria(GestionarEtapasProcesoSeleccionQueryCriteria criteria); 
   List<GestionarEtapasProcesoSeleccionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarEtapasProcesoSeleccionQuery> getListQueryPaginationByCriteria(GestionarEtapasProcesoSeleccionQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarEtapasProcesoSeleccionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarEtapasProcesoSeleccionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
