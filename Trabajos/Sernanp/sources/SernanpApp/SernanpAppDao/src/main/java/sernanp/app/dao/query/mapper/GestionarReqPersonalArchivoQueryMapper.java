package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarReqPersonalArchivoQuery; 
import sernanp.app.dao.query.domain.GestionarReqPersonalArchivoQueryCriteria; 

public interface GestionarReqPersonalArchivoQueryMapper { 
   List<GestionarReqPersonalArchivoQuery> getListQueryByCriteria(GestionarReqPersonalArchivoQueryCriteria criteria); 
   List<GestionarReqPersonalArchivoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarReqPersonalArchivoQuery> getListQueryPaginationByCriteria(GestionarReqPersonalArchivoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarReqPersonalArchivoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarReqPersonalArchivoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
