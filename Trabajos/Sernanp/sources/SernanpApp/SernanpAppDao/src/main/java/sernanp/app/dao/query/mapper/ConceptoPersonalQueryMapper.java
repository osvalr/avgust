package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConceptoPersonalQuery; 
import sernanp.app.dao.query.domain.ConceptoPersonalQueryCriteria; 

public interface ConceptoPersonalQueryMapper { 
   List<ConceptoPersonalQuery> getListQueryByCriteria(ConceptoPersonalQueryCriteria criteria); 
   List<ConceptoPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConceptoPersonalQuery> getListQueryPaginationByCriteria(ConceptoPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<ConceptoPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConceptoPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
