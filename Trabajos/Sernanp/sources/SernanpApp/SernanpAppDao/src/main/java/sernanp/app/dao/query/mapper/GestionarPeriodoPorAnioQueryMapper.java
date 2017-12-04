package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarPeriodoPorAnioQuery; 
import sernanp.app.dao.query.domain.GestionarPeriodoPorAnioQueryCriteria; 

public interface GestionarPeriodoPorAnioQueryMapper { 
   List<GestionarPeriodoPorAnioQuery> getListQueryByCriteria(GestionarPeriodoPorAnioQueryCriteria criteria); 
   List<GestionarPeriodoPorAnioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarPeriodoPorAnioQuery> getListQueryPaginationByCriteria(GestionarPeriodoPorAnioQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarPeriodoPorAnioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarPeriodoPorAnioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
