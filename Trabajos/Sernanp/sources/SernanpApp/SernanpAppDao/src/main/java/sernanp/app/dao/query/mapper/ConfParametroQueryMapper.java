package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConfParametroQuery; 
import sernanp.app.dao.query.domain.ConfParametroQueryCriteria; 

public interface ConfParametroQueryMapper { 
   List<ConfParametroQuery> getListQueryByCriteria(ConfParametroQueryCriteria criteria); 
   List<ConfParametroQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConfParametroQuery> getListQueryPaginationByCriteria(ConfParametroQueryCriteria criteria, RowBounds rowBounds); 
   List<ConfParametroQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConfParametroQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
