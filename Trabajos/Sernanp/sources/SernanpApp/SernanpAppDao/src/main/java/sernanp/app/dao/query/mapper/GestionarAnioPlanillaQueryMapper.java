package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAnioPlanillaQuery; 
import sernanp.app.dao.query.domain.GestionarAnioPlanillaQueryCriteria; 

public interface GestionarAnioPlanillaQueryMapper { 
   List<GestionarAnioPlanillaQuery> getListQueryByCriteria(GestionarAnioPlanillaQueryCriteria criteria); 
   List<GestionarAnioPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAnioPlanillaQuery> getListQueryPaginationByCriteria(GestionarAnioPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAnioPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAnioPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
