package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQuery; 
import sernanp.app.dao.query.domain.Anios_dias_no_laborablesQueryCriteria; 

public interface Anios_dias_no_laborablesQueryMapper { 
   List<Anios_dias_no_laborablesQuery> getListQueryByCriteria(Anios_dias_no_laborablesQueryCriteria criteria); 
   List<Anios_dias_no_laborablesQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<Anios_dias_no_laborablesQuery> getListQueryPaginationByCriteria(Anios_dias_no_laborablesQueryCriteria criteria, RowBounds rowBounds); 
   List<Anios_dias_no_laborablesQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(Anios_dias_no_laborablesQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
