package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PostulantePlazaQuery; 
import sernanp.app.dao.query.domain.PostulantePlazaQueryCriteria; 

public interface PostulantePlazaQueryMapper { 
   List<PostulantePlazaQuery> getListQueryByCriteria(PostulantePlazaQueryCriteria criteria); 
   List<PostulantePlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PostulantePlazaQuery> getListQueryPaginationByCriteria(PostulantePlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<PostulantePlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PostulantePlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
