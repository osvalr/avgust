package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConceptoAfectoQuery; 
import sernanp.app.dao.query.domain.ConceptoAfectoQueryCriteria; 

public interface ConceptoAfectoQueryMapper { 
   List<ConceptoAfectoQuery> getListQueryByCriteria(ConceptoAfectoQueryCriteria criteria); 
   List<ConceptoAfectoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConceptoAfectoQuery> getListQueryPaginationByCriteria(ConceptoAfectoQueryCriteria criteria, RowBounds rowBounds); 
   List<ConceptoAfectoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConceptoAfectoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
