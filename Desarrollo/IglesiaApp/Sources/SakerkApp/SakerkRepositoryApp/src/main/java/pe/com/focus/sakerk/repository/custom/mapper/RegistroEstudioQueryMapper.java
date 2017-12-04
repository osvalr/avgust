package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.RegistroEstudioQuery; 
import pe.com.focus.sakerk.repository.custom.model.RegistroEstudioQueryCriteria; 

public interface RegistroEstudioQueryMapper { 
   List<RegistroEstudioQuery> getListQueryByCriteria(RegistroEstudioQueryCriteria criteria); 
   List<RegistroEstudioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RegistroEstudioQuery> getListQueryPaginationByCriteria(RegistroEstudioQueryCriteria criteria, RowBounds rowBounds); 
   List<RegistroEstudioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RegistroEstudioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
