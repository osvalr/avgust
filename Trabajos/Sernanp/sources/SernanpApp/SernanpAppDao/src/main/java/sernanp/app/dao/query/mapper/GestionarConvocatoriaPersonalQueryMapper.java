package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQuery; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalQueryCriteria; 

public interface GestionarConvocatoriaPersonalQueryMapper { 
   List<GestionarConvocatoriaPersonalQuery> getListQueryByCriteria(GestionarConvocatoriaPersonalQueryCriteria criteria); 
   List<GestionarConvocatoriaPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConvocatoriaPersonalQuery> getListQueryPaginationByCriteria(GestionarConvocatoriaPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarConvocatoriaPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConvocatoriaPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
