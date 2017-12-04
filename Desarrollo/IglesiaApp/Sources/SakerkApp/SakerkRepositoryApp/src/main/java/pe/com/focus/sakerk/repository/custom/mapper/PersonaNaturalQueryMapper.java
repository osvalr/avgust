package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQuery; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalQueryCriteria; 

public interface PersonaNaturalQueryMapper { 
   List<PersonaNaturalQuery> getListQueryByCriteria(PersonaNaturalQueryCriteria criteria); 
   List<PersonaNaturalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonaNaturalQuery> getListQueryPaginationByCriteria(PersonaNaturalQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonaNaturalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonaNaturalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
