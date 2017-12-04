package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQuery; 
import sernanp.app.dao.query.domain.ConceptoFrecuenciaQueryCriteria; 

public interface ConceptoFrecuenciaQueryMapper { 
   List<ConceptoFrecuenciaQuery> getListQueryByCriteria(ConceptoFrecuenciaQueryCriteria criteria); 
   List<ConceptoFrecuenciaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConceptoFrecuenciaQuery> getListQueryPaginationByCriteria(ConceptoFrecuenciaQueryCriteria criteria, RowBounds rowBounds); 
   List<ConceptoFrecuenciaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConceptoFrecuenciaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
