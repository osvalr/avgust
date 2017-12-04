package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAfpPlanillaComisionQuery; 
import sernanp.app.dao.query.domain.GestionarAfpPlanillaComisionQueryCriteria; 

public interface GestionarAfpPlanillaComisionQueryMapper { 
   List<GestionarAfpPlanillaComisionQuery> getListQueryByCriteria(GestionarAfpPlanillaComisionQueryCriteria criteria); 
   List<GestionarAfpPlanillaComisionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAfpPlanillaComisionQuery> getListQueryPaginationByCriteria(GestionarAfpPlanillaComisionQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAfpPlanillaComisionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAfpPlanillaComisionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
