package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpNominaDescuentoConceptoQuery; 
import sernanp.app.dao.query.domain.RpNominaDescuentoConceptoQueryCriteria; 

public interface RpNominaDescuentoConceptoQueryMapper { 
   List<RpNominaDescuentoConceptoQuery> getListQueryByCriteria(RpNominaDescuentoConceptoQueryCriteria criteria); 
   List<RpNominaDescuentoConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpNominaDescuentoConceptoQuery> getListQueryPaginationByCriteria(RpNominaDescuentoConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<RpNominaDescuentoConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpNominaDescuentoConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
