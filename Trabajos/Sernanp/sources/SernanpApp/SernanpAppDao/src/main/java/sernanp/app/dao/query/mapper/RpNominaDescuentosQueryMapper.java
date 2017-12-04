package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpNominaDescuentosQuery; 
import sernanp.app.dao.query.domain.RpNominaDescuentosQueryCriteria; 

public interface RpNominaDescuentosQueryMapper { 
   List<RpNominaDescuentosQuery> getListQueryByCriteria(RpNominaDescuentosQueryCriteria criteria); 
   List<RpNominaDescuentosQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpNominaDescuentosQuery> getListQueryPaginationByCriteria(RpNominaDescuentosQueryCriteria criteria, RowBounds rowBounds); 
   List<RpNominaDescuentosQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpNominaDescuentosQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
