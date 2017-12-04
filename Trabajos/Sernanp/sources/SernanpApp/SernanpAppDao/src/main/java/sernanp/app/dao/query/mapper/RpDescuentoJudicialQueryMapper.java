package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDescuentoJudicialQuery; 
import sernanp.app.dao.query.domain.RpDescuentoJudicialQueryCriteria; 

public interface RpDescuentoJudicialQueryMapper { 
   List<RpDescuentoJudicialQuery> getListQueryByCriteria(RpDescuentoJudicialQueryCriteria criteria); 
   List<RpDescuentoJudicialQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDescuentoJudicialQuery> getListQueryPaginationByCriteria(RpDescuentoJudicialQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDescuentoJudicialQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDescuentoJudicialQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
