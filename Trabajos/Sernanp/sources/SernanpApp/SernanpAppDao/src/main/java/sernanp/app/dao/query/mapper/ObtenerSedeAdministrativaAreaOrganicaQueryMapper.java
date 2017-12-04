package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQuery; 
import sernanp.app.dao.query.domain.ObtenerSedeAdministrativaAreaOrganicaQueryCriteria; 

public interface ObtenerSedeAdministrativaAreaOrganicaQueryMapper { 
   List<ObtenerSedeAdministrativaAreaOrganicaQuery> getListQueryByCriteria(ObtenerSedeAdministrativaAreaOrganicaQueryCriteria criteria); 
   List<ObtenerSedeAdministrativaAreaOrganicaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerSedeAdministrativaAreaOrganicaQuery> getListQueryPaginationByCriteria(ObtenerSedeAdministrativaAreaOrganicaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerSedeAdministrativaAreaOrganicaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerSedeAdministrativaAreaOrganicaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
