package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptResumenPadronTrabajadoresQuery; 
import sernanp.app.dao.query.domain.RptResumenPadronTrabajadoresQueryCriteria; 

public interface RptResumenPadronTrabajadoresQueryMapper { 
   List<RptResumenPadronTrabajadoresQuery> getListQueryByCriteria(RptResumenPadronTrabajadoresQueryCriteria criteria); 
   List<RptResumenPadronTrabajadoresQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptResumenPadronTrabajadoresQuery> getListQueryPaginationByCriteria(RptResumenPadronTrabajadoresQueryCriteria criteria, RowBounds rowBounds); 
   List<RptResumenPadronTrabajadoresQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptResumenPadronTrabajadoresQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
