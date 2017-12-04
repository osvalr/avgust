package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQuery; 
import sernanp.app.dao.query.domain.GestionarNotasPostulanteQueryCriteria; 

public interface GestionarNotasPostulanteQueryMapper { 
   List<GestionarNotasPostulanteQuery> getListQueryByCriteria(GestionarNotasPostulanteQueryCriteria criteria); 
   List<GestionarNotasPostulanteQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarNotasPostulanteQuery> getListQueryPaginationByCriteria(GestionarNotasPostulanteQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarNotasPostulanteQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarNotasPostulanteQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
