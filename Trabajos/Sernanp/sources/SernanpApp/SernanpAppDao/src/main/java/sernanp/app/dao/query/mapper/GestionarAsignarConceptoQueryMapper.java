package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQuery; 
import sernanp.app.dao.query.domain.GestionarAsignarConceptoQueryCriteria; 

public interface GestionarAsignarConceptoQueryMapper { 
   List<GestionarAsignarConceptoQuery> getListQueryByCriteria(GestionarAsignarConceptoQueryCriteria criteria); 
   List<GestionarAsignarConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAsignarConceptoQuery> getListQueryPaginationByCriteria(GestionarAsignarConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAsignarConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAsignarConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
