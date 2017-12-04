package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PostulantePostulacionQuery; 
import sernanp.app.dao.query.domain.PostulantePostulacionQueryCriteria; 

public interface PostulantePostulacionQueryMapper { 
   List<PostulantePostulacionQuery> getListQueryByCriteria(PostulantePostulacionQueryCriteria criteria); 
   List<PostulantePostulacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PostulantePostulacionQuery> getListQueryPaginationByCriteria(PostulantePostulacionQueryCriteria criteria, RowBounds rowBounds); 
   List<PostulantePostulacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PostulantePostulacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
