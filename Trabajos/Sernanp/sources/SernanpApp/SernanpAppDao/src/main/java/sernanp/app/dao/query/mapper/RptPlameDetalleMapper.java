package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptPlameDetalle; 
import sernanp.app.dao.query.domain.RptPlameDetalleCriteria; 

public interface RptPlameDetalleMapper { 
   List<RptPlameDetalle> getListQueryByCriteria(RptPlameDetalleCriteria criteria); 
   List<RptPlameDetalle> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptPlameDetalle> getListQueryPaginationByCriteria(RptPlameDetalleCriteria criteria, RowBounds rowBounds); 
   List<RptPlameDetalle> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptPlameDetalleCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
