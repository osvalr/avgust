package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.EstudioQuery; 
import pe.com.focus.sakerk.repository.custom.model.EstudioQueryCriteria; 

public interface EstudioQueryMapper { 
   List<EstudioQuery> getListQueryByCriteria(EstudioQueryCriteria criteria); 
   List<EstudioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<EstudioQuery> getListQueryPaginationByCriteria(EstudioQueryCriteria criteria, RowBounds rowBounds); 
   List<EstudioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(EstudioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
