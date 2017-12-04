package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PostulanteNumeroTelefonoQuery; 
import sernanp.app.dao.query.domain.PostulanteNumeroTelefonoQueryCriteria; 

public interface PostulanteNumeroTelefonoQueryMapper { 
   List<PostulanteNumeroTelefonoQuery> getListQueryByCriteria(PostulanteNumeroTelefonoQueryCriteria criteria); 
   List<PostulanteNumeroTelefonoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PostulanteNumeroTelefonoQuery> getListQueryPaginationByCriteria(PostulanteNumeroTelefonoQueryCriteria criteria, RowBounds rowBounds); 
   List<PostulanteNumeroTelefonoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PostulanteNumeroTelefonoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
