package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteVacantesPublicasQuery; 
import sernanp.app.dao.query.domain.ReporteVacantesPublicasQueryCriteria; 

public interface ReporteVacantesPublicasQueryMapper { 
   List<ReporteVacantesPublicasQuery> getListQueryByCriteria(ReporteVacantesPublicasQueryCriteria criteria); 
   List<ReporteVacantesPublicasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteVacantesPublicasQuery> getListQueryPaginationByCriteria(ReporteVacantesPublicasQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteVacantesPublicasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteVacantesPublicasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
