package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerTotalIngresosPorConceptoQuery; 
import sernanp.app.dao.query.domain.ObtenerTotalIngresosPorConceptoQueryCriteria; 

public interface ObtenerTotalIngresosPorConceptoQueryMapper { 
   List<ObtenerTotalIngresosPorConceptoQuery> getListQueryByCriteria(ObtenerTotalIngresosPorConceptoQueryCriteria criteria); 
   List<ObtenerTotalIngresosPorConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerTotalIngresosPorConceptoQuery> getListQueryPaginationByCriteria(ObtenerTotalIngresosPorConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerTotalIngresosPorConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerTotalIngresosPorConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
