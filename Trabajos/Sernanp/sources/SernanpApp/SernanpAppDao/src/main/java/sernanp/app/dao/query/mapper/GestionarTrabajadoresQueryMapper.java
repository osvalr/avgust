package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarTrabajadoresQuery; 
import sernanp.app.dao.query.domain.GestionarTrabajadoresQueryCriteria; 

public interface GestionarTrabajadoresQueryMapper { 
   List<GestionarTrabajadoresQuery> getListQueryByCriteria(GestionarTrabajadoresQueryCriteria criteria); 
   List<GestionarTrabajadoresQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarTrabajadoresQuery> getListQueryPaginationByCriteria(GestionarTrabajadoresQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarTrabajadoresQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarTrabajadoresQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
