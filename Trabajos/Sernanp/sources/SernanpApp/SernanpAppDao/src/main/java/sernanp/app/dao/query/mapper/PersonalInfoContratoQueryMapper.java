package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalInfoContratoQuery; 
import sernanp.app.dao.query.domain.PersonalInfoContratoQueryCriteria; 

public interface PersonalInfoContratoQueryMapper { 
   List<PersonalInfoContratoQuery> getListQueryByCriteria(PersonalInfoContratoQueryCriteria criteria); 
   List<PersonalInfoContratoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalInfoContratoQuery> getListQueryPaginationByCriteria(PersonalInfoContratoQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalInfoContratoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalInfoContratoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
