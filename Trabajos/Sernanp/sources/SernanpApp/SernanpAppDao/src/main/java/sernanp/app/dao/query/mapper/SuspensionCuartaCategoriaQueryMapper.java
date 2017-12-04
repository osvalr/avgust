package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SuspensionCuartaCategoriaQuery; 
import sernanp.app.dao.query.domain.SuspensionCuartaCategoriaQueryCriteria; 

public interface SuspensionCuartaCategoriaQueryMapper { 
   List<SuspensionCuartaCategoriaQuery> getListQueryByCriteria(SuspensionCuartaCategoriaQueryCriteria criteria); 
   List<SuspensionCuartaCategoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SuspensionCuartaCategoriaQuery> getListQueryPaginationByCriteria(SuspensionCuartaCategoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<SuspensionCuartaCategoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SuspensionCuartaCategoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
