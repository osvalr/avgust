package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerTipoYClasePlanillaQuery; 
import sernanp.app.dao.query.domain.ObtenerTipoYClasePlanillaQueryCriteria; 

public interface ObtenerTipoYClasePlanillaQueryMapper { 
   List<ObtenerTipoYClasePlanillaQuery> getListQueryByCriteria(ObtenerTipoYClasePlanillaQueryCriteria criteria); 
   List<ObtenerTipoYClasePlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerTipoYClasePlanillaQuery> getListQueryPaginationByCriteria(ObtenerTipoYClasePlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerTipoYClasePlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerTipoYClasePlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
