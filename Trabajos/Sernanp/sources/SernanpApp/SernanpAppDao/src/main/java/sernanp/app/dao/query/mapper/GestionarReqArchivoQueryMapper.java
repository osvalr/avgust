package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarReqArchivoQuery; 
import sernanp.app.dao.query.domain.GestionarReqArchivoQueryCriteria; 

public interface GestionarReqArchivoQueryMapper { 
   List<GestionarReqArchivoQuery> getListQueryByCriteria(GestionarReqArchivoQueryCriteria criteria); 
   List<GestionarReqArchivoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarReqArchivoQuery> getListQueryPaginationByCriteria(GestionarReqArchivoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarReqArchivoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarReqArchivoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
