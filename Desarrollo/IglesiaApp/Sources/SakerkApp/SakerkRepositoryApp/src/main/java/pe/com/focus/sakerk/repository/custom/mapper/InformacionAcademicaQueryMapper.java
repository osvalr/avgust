package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQuery; 
import pe.com.focus.sakerk.repository.custom.model.InformacionAcademicaQueryCriteria; 

public interface InformacionAcademicaQueryMapper { 
   List<InformacionAcademicaQuery> getListQueryByCriteria(InformacionAcademicaQueryCriteria criteria); 
   List<InformacionAcademicaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<InformacionAcademicaQuery> getListQueryPaginationByCriteria(InformacionAcademicaQueryCriteria criteria, RowBounds rowBounds); 
   List<InformacionAcademicaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(InformacionAcademicaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
