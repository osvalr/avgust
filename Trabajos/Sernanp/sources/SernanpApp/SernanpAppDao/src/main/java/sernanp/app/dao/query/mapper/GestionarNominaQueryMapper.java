package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarNominaQuery; 
import sernanp.app.dao.query.domain.GestionarNominaQueryCriteria; 

public interface GestionarNominaQueryMapper { 
   List<GestionarNominaQuery> getListQueryByCriteria(GestionarNominaQueryCriteria criteria); 
   List<GestionarNominaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarNominaQuery> getListQueryPaginationByCriteria(GestionarNominaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarNominaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarNominaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
