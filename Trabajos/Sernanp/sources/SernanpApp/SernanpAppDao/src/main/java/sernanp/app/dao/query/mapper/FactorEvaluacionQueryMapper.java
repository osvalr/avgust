package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.FactorEvaluacionQuery; 
import sernanp.app.dao.query.domain.FactorEvaluacionQueryCriteria; 

public interface FactorEvaluacionQueryMapper { 
   List<FactorEvaluacionQuery> getListQueryByCriteria(FactorEvaluacionQueryCriteria criteria); 
   List<FactorEvaluacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<FactorEvaluacionQuery> getListQueryPaginationByCriteria(FactorEvaluacionQueryCriteria criteria, RowBounds rowBounds); 
   List<FactorEvaluacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(FactorEvaluacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
