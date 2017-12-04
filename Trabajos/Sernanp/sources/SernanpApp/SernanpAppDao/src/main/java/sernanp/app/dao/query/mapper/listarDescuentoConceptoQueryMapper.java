package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.listarDescuentoConceptoQuery; 
import sernanp.app.dao.query.domain.listarDescuentoConceptoQueryCriteria; 

public interface listarDescuentoConceptoQueryMapper { 
   List<listarDescuentoConceptoQuery> getListQueryByCriteria(listarDescuentoConceptoQueryCriteria criteria); 
   List<listarDescuentoConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<listarDescuentoConceptoQuery> getListQueryPaginationByCriteria(listarDescuentoConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<listarDescuentoConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(listarDescuentoConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
