package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerDependenciaAnpSedeQuery; 
import sernanp.app.dao.query.domain.ObtenerDependenciaAnpSedeQueryCriteria; 

public interface ObtenerDependenciaAnpSedeQueryMapper { 
   List<ObtenerDependenciaAnpSedeQuery> getListQueryByCriteria(ObtenerDependenciaAnpSedeQueryCriteria criteria); 
   List<ObtenerDependenciaAnpSedeQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerDependenciaAnpSedeQuery> getListQueryPaginationByCriteria(ObtenerDependenciaAnpSedeQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerDependenciaAnpSedeQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerDependenciaAnpSedeQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
