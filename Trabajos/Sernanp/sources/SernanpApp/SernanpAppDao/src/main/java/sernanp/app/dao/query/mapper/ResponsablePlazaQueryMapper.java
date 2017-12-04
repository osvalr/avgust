package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ResponsablePlazaQuery; 
import sernanp.app.dao.query.domain.ResponsablePlazaQueryCriteria; 

public interface ResponsablePlazaQueryMapper { 
   List<ResponsablePlazaQuery> getListQueryByCriteria(ResponsablePlazaQueryCriteria criteria); 
   List<ResponsablePlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ResponsablePlazaQuery> getListQueryPaginationByCriteria(ResponsablePlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ResponsablePlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ResponsablePlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
