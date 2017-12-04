package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SubEtapaPlazaQuery; 
import sernanp.app.dao.query.domain.SubEtapaPlazaQueryCriteria; 

public interface SubEtapaPlazaQueryMapper { 
   List<SubEtapaPlazaQuery> getListQueryByCriteria(SubEtapaPlazaQueryCriteria criteria); 
   List<SubEtapaPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SubEtapaPlazaQuery> getListQueryPaginationByCriteria(SubEtapaPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<SubEtapaPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SubEtapaPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
