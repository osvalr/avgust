package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerFactorPorConfiguracionQuery; 
import sernanp.app.dao.query.domain.ObtenerFactorPorConfiguracionQueryCriteria; 

public interface ObtenerFactorPorConfiguracionQueryMapper { 
   List<ObtenerFactorPorConfiguracionQuery> getListQueryByCriteria(ObtenerFactorPorConfiguracionQueryCriteria criteria); 
   List<ObtenerFactorPorConfiguracionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerFactorPorConfiguracionQuery> getListQueryPaginationByCriteria(ObtenerFactorPorConfiguracionQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerFactorPorConfiguracionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerFactorPorConfiguracionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
