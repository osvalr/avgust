package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAsignarIngDescQuery; 
import sernanp.app.dao.query.domain.GestionarAsignarIngDescQueryCriteria; 

public interface GestionarAsignarIngDescQueryMapper { 
   List<GestionarAsignarIngDescQuery> getListQueryByCriteria(GestionarAsignarIngDescQueryCriteria criteria); 
   List<GestionarAsignarIngDescQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAsignarIngDescQuery> getListQueryPaginationByCriteria(GestionarAsignarIngDescQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAsignarIngDescQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAsignarIngDescQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
