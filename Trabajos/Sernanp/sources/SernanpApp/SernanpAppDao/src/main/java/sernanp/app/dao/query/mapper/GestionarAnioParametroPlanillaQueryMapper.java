package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAnioParametroPlanillaQuery; 
import sernanp.app.dao.query.domain.GestionarAnioParametroPlanillaQueryCriteria; 

public interface GestionarAnioParametroPlanillaQueryMapper { 
   List<GestionarAnioParametroPlanillaQuery> getListQueryByCriteria(GestionarAnioParametroPlanillaQueryCriteria criteria); 
   List<GestionarAnioParametroPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAnioParametroPlanillaQuery> getListQueryPaginationByCriteria(GestionarAnioParametroPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAnioParametroPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAnioParametroPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
