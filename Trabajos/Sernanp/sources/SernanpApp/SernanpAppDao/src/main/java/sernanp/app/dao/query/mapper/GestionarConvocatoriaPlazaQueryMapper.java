package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPlazaQuery; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPlazaQueryCriteria; 

public interface GestionarConvocatoriaPlazaQueryMapper { 
   List<GestionarConvocatoriaPlazaQuery> getListQueryByCriteria(GestionarConvocatoriaPlazaQueryCriteria criteria); 
   List<GestionarConvocatoriaPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConvocatoriaPlazaQuery> getListQueryPaginationByCriteria(GestionarConvocatoriaPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarConvocatoriaPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConvocatoriaPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
