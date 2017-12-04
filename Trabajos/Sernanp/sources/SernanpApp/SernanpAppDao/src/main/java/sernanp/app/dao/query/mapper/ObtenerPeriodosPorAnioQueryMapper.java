package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerPeriodosPorAnioQuery; 
import sernanp.app.dao.query.domain.ObtenerPeriodosPorAnioQueryCriteria; 

public interface ObtenerPeriodosPorAnioQueryMapper { 
   List<ObtenerPeriodosPorAnioQuery> getListQueryByCriteria(ObtenerPeriodosPorAnioQueryCriteria criteria); 
   List<ObtenerPeriodosPorAnioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerPeriodosPorAnioQuery> getListQueryPaginationByCriteria(ObtenerPeriodosPorAnioQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerPeriodosPorAnioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerPeriodosPorAnioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
