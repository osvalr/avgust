package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQuery; 
import pe.com.focus.sakerk.repository.custom.model.InformacionLaboralQueryCriteria; 

public interface InformacionLaboralQueryMapper { 
   List<InformacionLaboralQuery> getListQueryByCriteria(InformacionLaboralQueryCriteria criteria); 
   List<InformacionLaboralQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<InformacionLaboralQuery> getListQueryPaginationByCriteria(InformacionLaboralQueryCriteria criteria, RowBounds rowBounds); 
   List<InformacionLaboralQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(InformacionLaboralQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
