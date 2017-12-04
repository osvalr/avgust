package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptJORDetalle; 
import sernanp.app.dao.query.domain.RptJORDetalleCriteria; 

public interface RptJORDetalleMapper { 
   List<RptJORDetalle> getListQueryByCriteria(RptJORDetalleCriteria criteria); 
   List<RptJORDetalle> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptJORDetalle> getListQueryPaginationByCriteria(RptJORDetalleCriteria criteria, RowBounds rowBounds); 
   List<RptJORDetalle> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptJORDetalleCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
