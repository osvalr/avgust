package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptResumenPersonalAltasBajasQuery; 
import sernanp.app.dao.query.domain.RptResumenPersonalAltasBajasQueryCriteria; 

public interface RptResumenPersonalAltasBajasQueryMapper { 
   List<RptResumenPersonalAltasBajasQuery> getListQueryByCriteria(RptResumenPersonalAltasBajasQueryCriteria criteria); 
   List<RptResumenPersonalAltasBajasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptResumenPersonalAltasBajasQuery> getListQueryPaginationByCriteria(RptResumenPersonalAltasBajasQueryCriteria criteria, RowBounds rowBounds); 
   List<RptResumenPersonalAltasBajasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptResumenPersonalAltasBajasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
