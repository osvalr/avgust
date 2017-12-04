package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAsignarResponsable; 
import sernanp.app.dao.query.domain.GestionarAsignarResponsableCriteria; 

public interface GestionarAsignarResponsableMapper { 
   List<GestionarAsignarResponsable> getListQueryByCriteria(GestionarAsignarResponsableCriteria criteria); 
   List<GestionarAsignarResponsable> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAsignarResponsable> getListQueryPaginationByCriteria(GestionarAsignarResponsableCriteria criteria, RowBounds rowBounds); 
   List<GestionarAsignarResponsable> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAsignarResponsableCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
