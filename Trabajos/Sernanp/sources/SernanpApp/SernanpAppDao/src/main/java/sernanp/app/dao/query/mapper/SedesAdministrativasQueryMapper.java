package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SedesAdministrativasQuery; 
import sernanp.app.dao.query.domain.SedesAdministrativasQueryCriteria; 

public interface SedesAdministrativasQueryMapper { 
   List<SedesAdministrativasQuery> getListQueryByCriteria(SedesAdministrativasQueryCriteria criteria); 
   List<SedesAdministrativasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SedesAdministrativasQuery> getListQueryPaginationByCriteria(SedesAdministrativasQueryCriteria criteria, RowBounds rowBounds); 
   List<SedesAdministrativasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SedesAdministrativasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
