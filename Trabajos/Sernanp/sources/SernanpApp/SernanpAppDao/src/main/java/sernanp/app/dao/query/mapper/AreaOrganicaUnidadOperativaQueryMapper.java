package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.AreaOrganicaUnidadOperativaQuery; 
import sernanp.app.dao.query.domain.AreaOrganicaUnidadOperativaQueryCriteria; 

public interface AreaOrganicaUnidadOperativaQueryMapper { 
   List<AreaOrganicaUnidadOperativaQuery> getListQueryByCriteria(AreaOrganicaUnidadOperativaQueryCriteria criteria); 
   List<AreaOrganicaUnidadOperativaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<AreaOrganicaUnidadOperativaQuery> getListQueryPaginationByCriteria(AreaOrganicaUnidadOperativaQueryCriteria criteria, RowBounds rowBounds); 
   List<AreaOrganicaUnidadOperativaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(AreaOrganicaUnidadOperativaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
