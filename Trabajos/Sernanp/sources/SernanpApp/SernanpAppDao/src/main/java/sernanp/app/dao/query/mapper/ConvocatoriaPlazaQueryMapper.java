package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaPlazaQueryCriteria; 

public interface ConvocatoriaPlazaQueryMapper { 
   List<ConvocatoriaPlazaQuery> getListQueryByCriteria(ConvocatoriaPlazaQueryCriteria criteria); 
   List<ConvocatoriaPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaPlazaQuery> getListQueryPaginationByCriteria(ConvocatoriaPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
