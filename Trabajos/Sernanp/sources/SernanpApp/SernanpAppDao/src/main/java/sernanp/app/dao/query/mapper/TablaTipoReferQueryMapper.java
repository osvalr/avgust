package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.TablaTipoReferQuery; 
import sernanp.app.dao.query.domain.TablaTipoReferQueryCriteria; 

public interface TablaTipoReferQueryMapper { 
   List<TablaTipoReferQuery> getListQueryByCriteria(TablaTipoReferQueryCriteria criteria); 
   List<TablaTipoReferQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<TablaTipoReferQuery> getListQueryPaginationByCriteria(TablaTipoReferQueryCriteria criteria, RowBounds rowBounds); 
   List<TablaTipoReferQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(TablaTipoReferQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
