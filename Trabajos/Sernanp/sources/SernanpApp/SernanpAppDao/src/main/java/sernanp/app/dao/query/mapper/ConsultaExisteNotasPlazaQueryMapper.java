package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConsultaExisteNotasPlazaQuery; 
import sernanp.app.dao.query.domain.ConsultaExisteNotasPlazaQueryCriteria; 

public interface ConsultaExisteNotasPlazaQueryMapper { 
   List<ConsultaExisteNotasPlazaQuery> getListQueryByCriteria(ConsultaExisteNotasPlazaQueryCriteria criteria); 
   List<ConsultaExisteNotasPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConsultaExisteNotasPlazaQuery> getListQueryPaginationByCriteria(ConsultaExisteNotasPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ConsultaExisteNotasPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConsultaExisteNotasPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
