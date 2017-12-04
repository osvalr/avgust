package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQuery; 
import sernanp.app.dao.query.domain.RpNominaDescuentosMaestroQueryCriteria; 

public interface RpNominaDescuentosMaestroQueryMapper { 
   List<RpNominaDescuentosMaestroQuery> getListQueryByCriteria(RpNominaDescuentosMaestroQueryCriteria criteria); 
   List<RpNominaDescuentosMaestroQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpNominaDescuentosMaestroQuery> getListQueryPaginationByCriteria(RpNominaDescuentosMaestroQueryCriteria criteria, RowBounds rowBounds); 
   List<RpNominaDescuentosMaestroQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpNominaDescuentosMaestroQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
