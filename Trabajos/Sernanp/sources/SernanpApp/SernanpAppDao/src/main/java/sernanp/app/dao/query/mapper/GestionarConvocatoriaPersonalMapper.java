package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonal; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPersonalCriteria; 

public interface GestionarConvocatoriaPersonalMapper { 
   List<GestionarConvocatoriaPersonal> getListQueryByCriteria(GestionarConvocatoriaPersonalCriteria criteria); 
   List<GestionarConvocatoriaPersonal> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConvocatoriaPersonal> getListQueryPaginationByCriteria(GestionarConvocatoriaPersonalCriteria criteria, RowBounds rowBounds); 
   List<GestionarConvocatoriaPersonal> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConvocatoriaPersonalCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
