package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.FnGeneraVacacionesTruncasPersonalQuery; 
import sernanp.app.dao.query.domain.FnGeneraVacacionesTruncasPersonalQueryCriteria; 

public interface FnGeneraVacacionesTruncasPersonalQueryMapper { 
   List<FnGeneraVacacionesTruncasPersonalQuery> getListQueryByCriteria(FnGeneraVacacionesTruncasPersonalQueryCriteria criteria); 
   List<FnGeneraVacacionesTruncasPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<FnGeneraVacacionesTruncasPersonalQuery> getListQueryPaginationByCriteria(FnGeneraVacacionesTruncasPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<FnGeneraVacacionesTruncasPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(FnGeneraVacacionesTruncasPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
