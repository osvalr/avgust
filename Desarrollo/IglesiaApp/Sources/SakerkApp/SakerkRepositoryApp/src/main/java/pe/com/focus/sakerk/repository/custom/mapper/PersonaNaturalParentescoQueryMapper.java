package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQuery; 
import pe.com.focus.sakerk.repository.custom.model.PersonaNaturalParentescoQueryCriteria; 

public interface PersonaNaturalParentescoQueryMapper { 
   List<PersonaNaturalParentescoQuery> getListQueryByCriteria(PersonaNaturalParentescoQueryCriteria criteria); 
   List<PersonaNaturalParentescoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonaNaturalParentescoQuery> getListQueryPaginationByCriteria(PersonaNaturalParentescoQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonaNaturalParentescoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonaNaturalParentescoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
