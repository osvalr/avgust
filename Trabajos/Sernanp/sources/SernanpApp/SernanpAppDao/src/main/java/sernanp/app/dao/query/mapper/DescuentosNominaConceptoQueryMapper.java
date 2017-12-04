package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DescuentosNominaConceptoQuery; 
import sernanp.app.dao.query.domain.DescuentosNominaConceptoQueryCriteria; 

public interface DescuentosNominaConceptoQueryMapper { 
   List<DescuentosNominaConceptoQuery> getListQueryByCriteria(DescuentosNominaConceptoQueryCriteria criteria); 
   List<DescuentosNominaConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DescuentosNominaConceptoQuery> getListQueryPaginationByCriteria(DescuentosNominaConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<DescuentosNominaConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DescuentosNominaConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
