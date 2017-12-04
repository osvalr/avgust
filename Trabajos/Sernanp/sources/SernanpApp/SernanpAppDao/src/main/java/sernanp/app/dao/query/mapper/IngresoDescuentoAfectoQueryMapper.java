package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.IngresoDescuentoAfectoQuery; 
import sernanp.app.dao.query.domain.IngresoDescuentoAfectoQueryCriteria; 

public interface IngresoDescuentoAfectoQueryMapper { 
   List<IngresoDescuentoAfectoQuery> getListQueryByCriteria(IngresoDescuentoAfectoQueryCriteria criteria); 
   List<IngresoDescuentoAfectoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<IngresoDescuentoAfectoQuery> getListQueryPaginationByCriteria(IngresoDescuentoAfectoQueryCriteria criteria, RowBounds rowBounds); 
   List<IngresoDescuentoAfectoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(IngresoDescuentoAfectoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
