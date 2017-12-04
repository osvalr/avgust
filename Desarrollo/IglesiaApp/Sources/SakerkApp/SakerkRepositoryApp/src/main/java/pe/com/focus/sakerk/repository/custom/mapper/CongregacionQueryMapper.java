package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.CongregacionQuery; 
import pe.com.focus.sakerk.repository.custom.model.CongregacionQueryCriteria; 

public interface CongregacionQueryMapper { 
   List<CongregacionQuery> getListQueryByCriteria(CongregacionQueryCriteria criteria); 
   List<CongregacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<CongregacionQuery> getListQueryPaginationByCriteria(CongregacionQueryCriteria criteria, RowBounds rowBounds); 
   List<CongregacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(CongregacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
