package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaEtapaQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaEtapaQueryCriteria; 

public interface ConvocatoriaEtapaQueryMapper { 
   List<ConvocatoriaEtapaQuery> getListQueryByCriteria(ConvocatoriaEtapaQueryCriteria criteria); 
   List<ConvocatoriaEtapaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaEtapaQuery> getListQueryPaginationByCriteria(ConvocatoriaEtapaQueryCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaEtapaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaEtapaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
