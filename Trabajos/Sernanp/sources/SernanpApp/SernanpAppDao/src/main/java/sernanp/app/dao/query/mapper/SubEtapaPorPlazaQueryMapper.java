package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SubEtapaPorPlazaQuery; 
import sernanp.app.dao.query.domain.SubEtapaPorPlazaQueryCriteria; 

public interface SubEtapaPorPlazaQueryMapper { 
   List<SubEtapaPorPlazaQuery> getListQueryByCriteria(SubEtapaPorPlazaQueryCriteria criteria); 
   List<SubEtapaPorPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SubEtapaPorPlazaQuery> getListQueryPaginationByCriteria(SubEtapaPorPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<SubEtapaPorPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SubEtapaPorPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
