package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQuery; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalRolQueryCriteria; 

public interface PersonaNaturalRolQueryMapper { 
   List<PersonaNaturalRolQuery> getListQueryByCriteria(PersonaNaturalRolQueryCriteria criteria); 
   List<PersonaNaturalRolQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonaNaturalRolQuery> getListQueryPaginationByCriteria(PersonaNaturalRolQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonaNaturalRolQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonaNaturalRolQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
