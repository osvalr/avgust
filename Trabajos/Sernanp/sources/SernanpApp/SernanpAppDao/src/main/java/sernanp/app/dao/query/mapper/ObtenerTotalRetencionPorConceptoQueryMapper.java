package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerTotalRetencionPorConceptoQuery; 
import sernanp.app.dao.query.domain.ObtenerTotalRetencionPorConceptoQueryCriteria; 

public interface ObtenerTotalRetencionPorConceptoQueryMapper { 
   List<ObtenerTotalRetencionPorConceptoQuery> getListQueryByCriteria(ObtenerTotalRetencionPorConceptoQueryCriteria criteria); 
   List<ObtenerTotalRetencionPorConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerTotalRetencionPorConceptoQuery> getListQueryPaginationByCriteria(ObtenerTotalRetencionPorConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerTotalRetencionPorConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerTotalRetencionPorConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
