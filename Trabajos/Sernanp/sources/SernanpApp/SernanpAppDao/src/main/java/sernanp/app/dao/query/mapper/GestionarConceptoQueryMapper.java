package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConceptoQuery; 
import sernanp.app.dao.query.domain.GestionarConceptoQueryCriteria; 

public interface GestionarConceptoQueryMapper { 
   List<GestionarConceptoQuery> getListQueryByCriteria(GestionarConceptoQueryCriteria criteria); 
   List<GestionarConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConceptoQuery> getListQueryPaginationByCriteria(GestionarConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
