package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalInfoFormacionQuery; 
import sernanp.app.dao.query.domain.PersonalInfoFormacionQueryCriteria; 

public interface PersonalInfoFormacionQueryMapper { 
   List<PersonalInfoFormacionQuery> getListQueryByCriteria(PersonalInfoFormacionQueryCriteria criteria); 
   List<PersonalInfoFormacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalInfoFormacionQuery> getListQueryPaginationByCriteria(PersonalInfoFormacionQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalInfoFormacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalInfoFormacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
