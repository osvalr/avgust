package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalInfoAdendasPorContratoQuery; 
import sernanp.app.dao.query.domain.PersonalInfoAdendasPorContratoQueryCriteria; 

public interface PersonalInfoAdendasPorContratoQueryMapper { 
   List<PersonalInfoAdendasPorContratoQuery> getListQueryByCriteria(PersonalInfoAdendasPorContratoQueryCriteria criteria); 
   List<PersonalInfoAdendasPorContratoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalInfoAdendasPorContratoQuery> getListQueryPaginationByCriteria(PersonalInfoAdendasPorContratoQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalInfoAdendasPorContratoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalInfoAdendasPorContratoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
