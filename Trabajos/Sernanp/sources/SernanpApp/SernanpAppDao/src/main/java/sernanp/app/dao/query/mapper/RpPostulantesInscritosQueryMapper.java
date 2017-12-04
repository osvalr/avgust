package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpPostulantesInscritosQuery; 
import sernanp.app.dao.query.domain.RpPostulantesInscritosQueryCriteria; 

public interface RpPostulantesInscritosQueryMapper { 
   List<RpPostulantesInscritosQuery> getListQueryByCriteria(RpPostulantesInscritosQueryCriteria criteria); 
   List<RpPostulantesInscritosQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpPostulantesInscritosQuery> getListQueryPaginationByCriteria(RpPostulantesInscritosQueryCriteria criteria, RowBounds rowBounds); 
   List<RpPostulantesInscritosQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpPostulantesInscritosQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
