package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RequerimientoDisponibleQuery; 
import sernanp.app.dao.query.domain.RequerimientoDisponibleQueryCriteria; 

public interface RequerimientoDisponibleQueryMapper { 
   List<RequerimientoDisponibleQuery> getListQueryByCriteria(RequerimientoDisponibleQueryCriteria criteria); 
   List<RequerimientoDisponibleQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RequerimientoDisponibleQuery> getListQueryPaginationByCriteria(RequerimientoDisponibleQueryCriteria criteria, RowBounds rowBounds); 
   List<RequerimientoDisponibleQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RequerimientoDisponibleQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
