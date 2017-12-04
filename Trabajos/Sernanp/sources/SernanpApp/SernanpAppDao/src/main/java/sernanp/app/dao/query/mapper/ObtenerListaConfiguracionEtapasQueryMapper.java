package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerListaConfiguracionEtapasQuery; 
import sernanp.app.dao.query.domain.ObtenerListaConfiguracionEtapasQueryCriteria; 

public interface ObtenerListaConfiguracionEtapasQueryMapper { 
   List<ObtenerListaConfiguracionEtapasQuery> getListQueryByCriteria(ObtenerListaConfiguracionEtapasQueryCriteria criteria); 
   List<ObtenerListaConfiguracionEtapasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerListaConfiguracionEtapasQuery> getListQueryPaginationByCriteria(ObtenerListaConfiguracionEtapasQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerListaConfiguracionEtapasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerListaConfiguracionEtapasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
