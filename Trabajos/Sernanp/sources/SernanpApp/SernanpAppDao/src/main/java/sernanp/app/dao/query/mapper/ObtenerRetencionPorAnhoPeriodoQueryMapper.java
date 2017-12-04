package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerRetencionPorAnhoPeriodoQuery; 
import sernanp.app.dao.query.domain.ObtenerRetencionPorAnhoPeriodoQueryCriteria; 

public interface ObtenerRetencionPorAnhoPeriodoQueryMapper { 
   List<ObtenerRetencionPorAnhoPeriodoQuery> getListQueryByCriteria(ObtenerRetencionPorAnhoPeriodoQueryCriteria criteria); 
   List<ObtenerRetencionPorAnhoPeriodoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerRetencionPorAnhoPeriodoQuery> getListQueryPaginationByCriteria(ObtenerRetencionPorAnhoPeriodoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerRetencionPorAnhoPeriodoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerRetencionPorAnhoPeriodoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
