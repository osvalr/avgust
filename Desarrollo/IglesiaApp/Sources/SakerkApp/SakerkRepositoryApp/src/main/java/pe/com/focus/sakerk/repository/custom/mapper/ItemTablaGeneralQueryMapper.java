package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.ItemTablaGeneralQuery; 
import pe.com.focus.sakerk.repository.custom.model.ItemTablaGeneralQueryCriteria; 

public interface ItemTablaGeneralQueryMapper { 
   List<ItemTablaGeneralQuery> getListQueryByCriteria(ItemTablaGeneralQueryCriteria criteria); 
   List<ItemTablaGeneralQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ItemTablaGeneralQuery> getListQueryPaginationByCriteria(ItemTablaGeneralQueryCriteria criteria, RowBounds rowBounds); 
   List<ItemTablaGeneralQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ItemTablaGeneralQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
