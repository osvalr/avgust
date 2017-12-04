package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteProyeccionPlanillasFFQuery; 
import sernanp.app.dao.query.domain.ReporteProyeccionPlanillasFFQueryCriteria; 

public interface ReporteProyeccionPlanillasFFQueryMapper { 
   List<ReporteProyeccionPlanillasFFQuery> getListQueryByCriteria(ReporteProyeccionPlanillasFFQueryCriteria criteria); 
   List<ReporteProyeccionPlanillasFFQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteProyeccionPlanillasFFQuery> getListQueryPaginationByCriteria(ReporteProyeccionPlanillasFFQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteProyeccionPlanillasFFQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteProyeccionPlanillasFFQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
