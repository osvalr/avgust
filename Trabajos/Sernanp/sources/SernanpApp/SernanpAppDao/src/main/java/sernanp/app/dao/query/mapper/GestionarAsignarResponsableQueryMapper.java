package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAsignarResponsableQuery; 
import sernanp.app.dao.query.domain.GestionarAsignarResponsableQueryCriteria; 

public interface GestionarAsignarResponsableQueryMapper { 
   List<GestionarAsignarResponsableQuery> getListQueryByCriteria(GestionarAsignarResponsableQueryCriteria criteria); 
   List<GestionarAsignarResponsableQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAsignarResponsableQuery> getListQueryPaginationByCriteria(GestionarAsignarResponsableQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAsignarResponsableQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAsignarResponsableQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
