package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DireccionSedePrestacionQuery; 
import sernanp.app.dao.query.domain.DireccionSedePrestacionQueryCriteria; 

public interface DireccionSedePrestacionQueryMapper { 
   List<DireccionSedePrestacionQuery> getListQueryByCriteria(DireccionSedePrestacionQueryCriteria criteria); 
   List<DireccionSedePrestacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DireccionSedePrestacionQuery> getListQueryPaginationByCriteria(DireccionSedePrestacionQueryCriteria criteria, RowBounds rowBounds); 
   List<DireccionSedePrestacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DireccionSedePrestacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
