package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalNominaQuery; 
import sernanp.app.dao.query.domain.PersonalNominaQueryCriteria; 

public interface PersonalNominaQueryMapper { 
   List<PersonalNominaQuery> getListQueryByCriteria(PersonalNominaQueryCriteria criteria); 
   List<PersonalNominaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalNominaQuery> getListQueryPaginationByCriteria(PersonalNominaQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalNominaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalNominaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
