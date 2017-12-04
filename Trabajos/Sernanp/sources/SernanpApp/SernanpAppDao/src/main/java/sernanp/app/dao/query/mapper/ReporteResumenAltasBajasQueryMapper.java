package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteResumenAltasBajasQuery; 
import sernanp.app.dao.query.domain.ReporteResumenAltasBajasQueryCriteria; 

public interface ReporteResumenAltasBajasQueryMapper { 
   List<ReporteResumenAltasBajasQuery> getListQueryByCriteria(ReporteResumenAltasBajasQueryCriteria criteria); 
   List<ReporteResumenAltasBajasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteResumenAltasBajasQuery> getListQueryPaginationByCriteria(ReporteResumenAltasBajasQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteResumenAltasBajasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteResumenAltasBajasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
