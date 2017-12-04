package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.AportesNominaConceptoQuery; 
import sernanp.app.dao.query.domain.AportesNominaConceptoQueryCriteria; 

public interface AportesNominaConceptoQueryMapper { 
   List<AportesNominaConceptoQuery> getListQueryByCriteria(AportesNominaConceptoQueryCriteria criteria); 
   List<AportesNominaConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<AportesNominaConceptoQuery> getListQueryPaginationByCriteria(AportesNominaConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<AportesNominaConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(AportesNominaConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
