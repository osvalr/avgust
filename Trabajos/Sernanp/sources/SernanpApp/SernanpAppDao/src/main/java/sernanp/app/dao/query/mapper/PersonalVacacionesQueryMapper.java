package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalVacacionesQuery; 
import sernanp.app.dao.query.domain.PersonalVacacionesQueryCriteria; 

public interface PersonalVacacionesQueryMapper { 
   List<PersonalVacacionesQuery> getListQueryByCriteria(PersonalVacacionesQueryCriteria criteria); 
   List<PersonalVacacionesQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalVacacionesQuery> getListQueryPaginationByCriteria(PersonalVacacionesQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalVacacionesQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalVacacionesQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
