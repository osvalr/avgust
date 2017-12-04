package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarParametroPlanillaQuery; 
import sernanp.app.dao.query.domain.GestionarParametroPlanillaQueryCriteria; 

public interface GestionarParametroPlanillaQueryMapper { 
   List<GestionarParametroPlanillaQuery> getListQueryByCriteria(GestionarParametroPlanillaQueryCriteria criteria); 
   List<GestionarParametroPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarParametroPlanillaQuery> getListQueryPaginationByCriteria(GestionarParametroPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarParametroPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarParametroPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
