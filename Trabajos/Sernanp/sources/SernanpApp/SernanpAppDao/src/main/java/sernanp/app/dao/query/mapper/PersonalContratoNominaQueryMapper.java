package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalContratoNominaQuery; 
import sernanp.app.dao.query.domain.PersonalContratoNominaQueryCriteria; 

public interface PersonalContratoNominaQueryMapper { 
   List<PersonalContratoNominaQuery> getListQueryByCriteria(PersonalContratoNominaQueryCriteria criteria); 
   List<PersonalContratoNominaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalContratoNominaQuery> getListQueryPaginationByCriteria(PersonalContratoNominaQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalContratoNominaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalContratoNominaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
