package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaReqQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaReqQueryCriteria; 

public interface ConvocatoriaPlazaReqQueryMapper { 
   List<ConvocatoriaPlazaReqQuery> getListQueryByCriteria(ConvocatoriaPlazaReqQueryCriteria criteria); 
   List<ConvocatoriaPlazaReqQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaPlazaReqQuery> getListQueryPaginationByCriteria(ConvocatoriaPlazaReqQueryCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaPlazaReqQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaPlazaReqQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
