package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQuery; 
import pe.com.focus.sakerk.repository.custom.model.InformacionEclesiasticaQueryCriteria; 

public interface InformacionEclesiasticaQueryMapper { 
   List<InformacionEclesiasticaQuery> getListQueryByCriteria(InformacionEclesiasticaQueryCriteria criteria); 
   List<InformacionEclesiasticaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<InformacionEclesiasticaQuery> getListQueryPaginationByCriteria(InformacionEclesiasticaQueryCriteria criteria, RowBounds rowBounds); 
   List<InformacionEclesiasticaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(InformacionEclesiasticaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
