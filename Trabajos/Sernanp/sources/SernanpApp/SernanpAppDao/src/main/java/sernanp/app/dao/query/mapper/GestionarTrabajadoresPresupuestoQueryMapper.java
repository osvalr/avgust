package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarTrabajadoresPresupuestoQuery; 
import sernanp.app.dao.query.domain.GestionarTrabajadoresPresupuestoQueryCriteria; 

public interface GestionarTrabajadoresPresupuestoQueryMapper { 
   List<GestionarTrabajadoresPresupuestoQuery> getListQueryByCriteria(GestionarTrabajadoresPresupuestoQueryCriteria criteria); 
   List<GestionarTrabajadoresPresupuestoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarTrabajadoresPresupuestoQuery> getListQueryPaginationByCriteria(GestionarTrabajadoresPresupuestoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarTrabajadoresPresupuestoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarTrabajadoresPresupuestoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
