package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosDetalleQuery; 
import sernanp.app.dao.query.domain.RpResumenPlanillaPagosDetalleQueryCriteria; 

public interface RpResumenPlanillaPagosDetalleQueryMapper { 
   List<RpResumenPlanillaPagosDetalleQuery> getListQueryByCriteria(RpResumenPlanillaPagosDetalleQueryCriteria criteria); 
   List<RpResumenPlanillaPagosDetalleQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpResumenPlanillaPagosDetalleQuery> getListQueryPaginationByCriteria(RpResumenPlanillaPagosDetalleQueryCriteria criteria, RowBounds rowBounds); 
   List<RpResumenPlanillaPagosDetalleQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpResumenPlanillaPagosDetalleQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
