package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPlaza; 
import sernanp.app.dao.query.domain.GestionarConvocatoriaPlazaCriteria; 

public interface GestionarConvocatoriaPlazaMapper { 
   List<GestionarConvocatoriaPlaza> getListQueryByCriteria(GestionarConvocatoriaPlazaCriteria criteria); 
   List<GestionarConvocatoriaPlaza> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConvocatoriaPlaza> getListQueryPaginationByCriteria(GestionarConvocatoriaPlazaCriteria criteria, RowBounds rowBounds); 
   List<GestionarConvocatoriaPlaza> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConvocatoriaPlazaCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
