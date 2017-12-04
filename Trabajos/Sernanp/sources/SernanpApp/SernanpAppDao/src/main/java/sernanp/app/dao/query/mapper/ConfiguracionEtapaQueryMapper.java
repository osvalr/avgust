package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConfiguracionEtapaQuery; 
import sernanp.app.dao.query.domain.ConfiguracionEtapaQueryCriteria; 

public interface ConfiguracionEtapaQueryMapper { 
   List<ConfiguracionEtapaQuery> getListQueryByCriteria(ConfiguracionEtapaQueryCriteria criteria); 
   List<ConfiguracionEtapaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConfiguracionEtapaQuery> getListQueryPaginationByCriteria(ConfiguracionEtapaQueryCriteria criteria, RowBounds rowBounds); 
   List<ConfiguracionEtapaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConfiguracionEtapaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
