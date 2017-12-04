package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptREMDetalle; 
import sernanp.app.dao.query.domain.RptREMDetalleCriteria; 

public interface RptREMDetalleMapper { 
   List<RptREMDetalle> getListQueryByCriteria(RptREMDetalleCriteria criteria); 
   List<RptREMDetalle> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptREMDetalle> getListQueryPaginationByCriteria(RptREMDetalleCriteria criteria, RowBounds rowBounds); 
   List<RptREMDetalle> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptREMDetalleCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
