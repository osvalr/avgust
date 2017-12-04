package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.NumeroConvocatoriaQuery; 
import sernanp.app.dao.query.domain.NumeroConvocatoriaQueryCriteria; 

public interface NumeroConvocatoriaQueryMapper { 
   List<NumeroConvocatoriaQuery> getListQueryByCriteria(NumeroConvocatoriaQueryCriteria criteria); 
   List<NumeroConvocatoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<NumeroConvocatoriaQuery> getListQueryPaginationByCriteria(NumeroConvocatoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<NumeroConvocatoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(NumeroConvocatoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
