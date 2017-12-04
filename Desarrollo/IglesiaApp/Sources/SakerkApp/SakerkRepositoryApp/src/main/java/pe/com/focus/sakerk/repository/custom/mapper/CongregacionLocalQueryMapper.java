package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQuery; 
import pe.com.focus.sakerk.repository.custom.model.CongregacionLocalQueryCriteria; 

public interface CongregacionLocalQueryMapper { 
   List<CongregacionLocalQuery> getListQueryByCriteria(CongregacionLocalQueryCriteria criteria); 
   List<CongregacionLocalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CongregacionLocalQuery> getListQueryPaginationByCriteria(CongregacionLocalQueryCriteria criteria, RowBounds rowBounds); 
   List<CongregacionLocalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CongregacionLocalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
