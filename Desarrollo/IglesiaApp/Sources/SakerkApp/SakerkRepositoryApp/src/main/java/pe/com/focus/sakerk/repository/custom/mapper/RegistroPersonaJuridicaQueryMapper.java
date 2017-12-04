package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.RegistroPersonaJuridicaQuery; 
import pe.com.focus.sakerk.repository.custom.model.RegistroPersonaJuridicaQueryCriteria; 

public interface RegistroPersonaJuridicaQueryMapper { 
   List<RegistroPersonaJuridicaQuery> getListQueryByCriteria(RegistroPersonaJuridicaQueryCriteria criteria); 
   List<RegistroPersonaJuridicaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RegistroPersonaJuridicaQuery> getListQueryPaginationByCriteria(RegistroPersonaJuridicaQueryCriteria criteria, RowBounds rowBounds); 
   List<RegistroPersonaJuridicaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RegistroPersonaJuridicaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
