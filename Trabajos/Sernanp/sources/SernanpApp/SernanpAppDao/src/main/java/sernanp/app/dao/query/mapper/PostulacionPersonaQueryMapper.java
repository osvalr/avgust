package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PostulacionPersonaQuery; 
import sernanp.app.dao.query.domain.PostulacionPersonaQueryCriteria; 

public interface PostulacionPersonaQueryMapper { 
   List<PostulacionPersonaQuery> getListQueryByCriteria(PostulacionPersonaQueryCriteria criteria); 
   List<PostulacionPersonaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PostulacionPersonaQuery> getListQueryPaginationByCriteria(PostulacionPersonaQueryCriteria criteria, RowBounds rowBounds); 
   List<PostulacionPersonaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PostulacionPersonaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
