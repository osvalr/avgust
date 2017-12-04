package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAfpPlanillaQuery; 
import sernanp.app.dao.query.domain.GestionarAfpPlanillaQueryCriteria; 

public interface GestionarAfpPlanillaQueryMapper { 
   List<GestionarAfpPlanillaQuery> getListQueryByCriteria(GestionarAfpPlanillaQueryCriteria criteria); 
   List<GestionarAfpPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAfpPlanillaQuery> getListQueryPaginationByCriteria(GestionarAfpPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAfpPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAfpPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
