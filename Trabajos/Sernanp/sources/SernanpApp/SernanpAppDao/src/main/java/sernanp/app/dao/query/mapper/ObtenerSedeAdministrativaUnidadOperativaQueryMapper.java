package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQuery; 
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaUnidadOperativaQueryCriteria; 

public interface ObtenerSedeAdministrativaUnidadOperativaQueryMapper { 
   List<ObtenerSedeAdministrativaUnidadOperativaQuery> getListQueryByCriteria(ObtenerSedeAdministrativaUnidadOperativaQueryCriteria criteria); 
   List<ObtenerSedeAdministrativaUnidadOperativaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerSedeAdministrativaUnidadOperativaQuery> getListQueryPaginationByCriteria(ObtenerSedeAdministrativaUnidadOperativaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerSedeAdministrativaUnidadOperativaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerSedeAdministrativaUnidadOperativaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
