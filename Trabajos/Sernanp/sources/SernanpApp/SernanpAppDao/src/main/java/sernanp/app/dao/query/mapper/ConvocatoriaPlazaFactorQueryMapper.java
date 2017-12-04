package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaFactorQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaFactorQueryCriteria; 

public interface ConvocatoriaPlazaFactorQueryMapper { 
   List<ConvocatoriaPlazaFactorQuery> getListQueryByCriteria(ConvocatoriaPlazaFactorQueryCriteria criteria); 
   List<ConvocatoriaPlazaFactorQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaPlazaFactorQuery> getListQueryPaginationByCriteria(ConvocatoriaPlazaFactorQueryCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaPlazaFactorQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaPlazaFactorQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
