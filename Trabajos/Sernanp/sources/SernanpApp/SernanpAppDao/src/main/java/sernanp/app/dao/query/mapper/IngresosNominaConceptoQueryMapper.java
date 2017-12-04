package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.IngresosNominaConceptoQuery; 
import sernanp.app.dao.query.domain.IngresosNominaConceptoQueryCriteria; 

public interface IngresosNominaConceptoQueryMapper { 
   List<IngresosNominaConceptoQuery> getListQueryByCriteria(IngresosNominaConceptoQueryCriteria criteria); 
   List<IngresosNominaConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<IngresosNominaConceptoQuery> getListQueryPaginationByCriteria(IngresosNominaConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<IngresosNominaConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(IngresosNominaConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
