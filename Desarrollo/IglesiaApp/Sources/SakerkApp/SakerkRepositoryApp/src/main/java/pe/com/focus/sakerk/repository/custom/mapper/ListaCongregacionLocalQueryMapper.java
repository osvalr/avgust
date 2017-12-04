package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.ListaCongregacionLocalQuery; 
import pe.com.focus.sakerk.repository.custom.model.ListaCongregacionLocalQueryCriteria; 

public interface ListaCongregacionLocalQueryMapper { 
   List<ListaCongregacionLocalQuery> getListQueryByCriteria(ListaCongregacionLocalQueryCriteria criteria); 
   List<ListaCongregacionLocalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ListaCongregacionLocalQuery> getListQueryPaginationByCriteria(ListaCongregacionLocalQueryCriteria criteria, RowBounds rowBounds); 
   List<ListaCongregacionLocalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ListaCongregacionLocalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
