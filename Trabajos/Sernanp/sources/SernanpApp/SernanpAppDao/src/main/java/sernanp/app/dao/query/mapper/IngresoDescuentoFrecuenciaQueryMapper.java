package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.IngresoDescuentoFrecuenciaQuery; 
import sernanp.app.dao.query.domain.IngresoDescuentoFrecuenciaQueryCriteria; 

public interface IngresoDescuentoFrecuenciaQueryMapper { 
   List<IngresoDescuentoFrecuenciaQuery> getListQueryByCriteria(IngresoDescuentoFrecuenciaQueryCriteria criteria); 
   List<IngresoDescuentoFrecuenciaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<IngresoDescuentoFrecuenciaQuery> getListQueryPaginationByCriteria(IngresoDescuentoFrecuenciaQueryCriteria criteria, RowBounds rowBounds); 
   List<IngresoDescuentoFrecuenciaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(IngresoDescuentoFrecuenciaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
