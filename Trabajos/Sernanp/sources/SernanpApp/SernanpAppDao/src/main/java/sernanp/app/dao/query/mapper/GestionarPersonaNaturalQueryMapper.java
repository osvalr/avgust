package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarPersonaNaturalQuery; 
import sernanp.app.dao.query.domain.GestionarPersonaNaturalQueryCriteria; 

public interface GestionarPersonaNaturalQueryMapper { 
   List<GestionarPersonaNaturalQuery> getListQueryByCriteria(GestionarPersonaNaturalQueryCriteria criteria); 
   List<GestionarPersonaNaturalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarPersonaNaturalQuery> getListQueryPaginationByCriteria(GestionarPersonaNaturalQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarPersonaNaturalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarPersonaNaturalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
