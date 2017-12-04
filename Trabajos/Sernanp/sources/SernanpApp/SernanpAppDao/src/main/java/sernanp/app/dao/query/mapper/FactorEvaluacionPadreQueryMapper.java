package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.FactorEvaluacionPadreQuery; 
import sernanp.app.dao.query.domain.FactorEvaluacionPadreQueryCriteria; 

public interface FactorEvaluacionPadreQueryMapper { 
   List<FactorEvaluacionPadreQuery> getListQueryByCriteria(FactorEvaluacionPadreQueryCriteria criteria); 
   List<FactorEvaluacionPadreQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<FactorEvaluacionPadreQuery> getListQueryPaginationByCriteria(FactorEvaluacionPadreQueryCriteria criteria, RowBounds rowBounds); 
   List<FactorEvaluacionPadreQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(FactorEvaluacionPadreQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
