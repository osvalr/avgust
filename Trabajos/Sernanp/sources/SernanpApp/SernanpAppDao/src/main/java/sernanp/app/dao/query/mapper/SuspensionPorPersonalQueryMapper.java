package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SuspensionPorPersonalQuery; 
import sernanp.app.dao.query.domain.SuspensionPorPersonalQueryCriteria; 

public interface SuspensionPorPersonalQueryMapper { 
   List<SuspensionPorPersonalQuery> getListQueryByCriteria(SuspensionPorPersonalQueryCriteria criteria); 
   List<SuspensionPorPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SuspensionPorPersonalQuery> getListQueryPaginationByCriteria(SuspensionPorPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<SuspensionPorPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SuspensionPorPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
