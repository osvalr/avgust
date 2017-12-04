package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQuery; 
import pe.com.focus.sakerk.repository.custom.model.PersonaJuridicaQueryCriteria; 

public interface PersonaJuridicaQueryMapper { 
   List<PersonaJuridicaQuery> getListQueryByCriteria(PersonaJuridicaQueryCriteria criteria); 
   List<PersonaJuridicaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonaJuridicaQuery> getListQueryPaginationByCriteria(PersonaJuridicaQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonaJuridicaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonaJuridicaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
