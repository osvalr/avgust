package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConfigFactorEvalQuery; 
import sernanp.app.dao.query.domain.GestionarConfigFactorEvalQueryCriteria; 

public interface GestionarConfigFactorEvalQueryMapper { 
   List<GestionarConfigFactorEvalQuery> getListQueryByCriteria(GestionarConfigFactorEvalQueryCriteria criteria); 
   List<GestionarConfigFactorEvalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConfigFactorEvalQuery> getListQueryPaginationByCriteria(GestionarConfigFactorEvalQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarConfigFactorEvalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConfigFactorEvalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
