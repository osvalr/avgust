package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarIngresoDescuentoQuery; 
import sernanp.app.dao.query.domain.GestionarIngresoDescuentoQueryCriteria; 

public interface GestionarIngresoDescuentoQueryMapper { 
   List<GestionarIngresoDescuentoQuery> getListQueryByCriteria(GestionarIngresoDescuentoQueryCriteria criteria); 
   List<GestionarIngresoDescuentoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarIngresoDescuentoQuery> getListQueryPaginationByCriteria(GestionarIngresoDescuentoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarIngresoDescuentoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarIngresoDescuentoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
