package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DescuentosPersonalQuery; 
import sernanp.app.dao.query.domain.DescuentosPersonalQueryCriteria; 

public interface DescuentosPersonalQueryMapper { 
   List<DescuentosPersonalQuery> getListQueryByCriteria(DescuentosPersonalQueryCriteria criteria); 
   List<DescuentosPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DescuentosPersonalQuery> getListQueryPaginationByCriteria(DescuentosPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<DescuentosPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DescuentosPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
