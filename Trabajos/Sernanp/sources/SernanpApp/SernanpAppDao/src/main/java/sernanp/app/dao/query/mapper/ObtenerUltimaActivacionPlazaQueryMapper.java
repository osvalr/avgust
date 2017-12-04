package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerUltimaActivacionPlazaQuery; 
import sernanp.app.dao.query.domain.ObtenerUltimaActivacionPlazaQueryCriteria; 

public interface ObtenerUltimaActivacionPlazaQueryMapper { 
   List<ObtenerUltimaActivacionPlazaQuery> getListQueryByCriteria(ObtenerUltimaActivacionPlazaQueryCriteria criteria); 
   List<ObtenerUltimaActivacionPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerUltimaActivacionPlazaQuery> getListQueryPaginationByCriteria(ObtenerUltimaActivacionPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerUltimaActivacionPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerUltimaActivacionPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
