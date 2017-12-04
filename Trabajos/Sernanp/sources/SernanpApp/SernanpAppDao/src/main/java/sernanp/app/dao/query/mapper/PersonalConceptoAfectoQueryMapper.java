package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalConceptoAfectoQuery; 
import sernanp.app.dao.query.domain.PersonalConceptoAfectoQueryCriteria; 

public interface PersonalConceptoAfectoQueryMapper { 
   List<PersonalConceptoAfectoQuery> getListQueryByCriteria(PersonalConceptoAfectoQueryCriteria criteria); 
   List<PersonalConceptoAfectoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalConceptoAfectoQuery> getListQueryPaginationByCriteria(PersonalConceptoAfectoQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalConceptoAfectoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalConceptoAfectoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
