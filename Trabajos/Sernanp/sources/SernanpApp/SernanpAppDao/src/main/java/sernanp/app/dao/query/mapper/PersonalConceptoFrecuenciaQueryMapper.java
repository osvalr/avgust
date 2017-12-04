package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQuery; 
import sernanp.app.dao.query.domain.PersonalConceptoFrecuenciaQueryCriteria; 

public interface PersonalConceptoFrecuenciaQueryMapper { 
   List<PersonalConceptoFrecuenciaQuery> getListQueryByCriteria(PersonalConceptoFrecuenciaQueryCriteria criteria); 
   List<PersonalConceptoFrecuenciaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalConceptoFrecuenciaQuery> getListQueryPaginationByCriteria(PersonalConceptoFrecuenciaQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalConceptoFrecuenciaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalConceptoFrecuenciaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
