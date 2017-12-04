package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQuery; 
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralQueryCriteria; 

public interface TablaGeneralQueryMapper { 
   List<TablaGeneralQuery> getListQueryByCriteria(TablaGeneralQueryCriteria criteria); 
   List<TablaGeneralQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<TablaGeneralQuery> getListQueryPaginationByCriteria(TablaGeneralQueryCriteria criteria, RowBounds rowBounds); 
   List<TablaGeneralQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(TablaGeneralQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
