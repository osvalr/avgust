package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAnioPeriodoPlanillaQuery; 
import sernanp.app.dao.query.domain.GestionarAnioPeriodoPlanillaQueryCriteria; 

public interface GestionarAnioPeriodoPlanillaQueryMapper { 
   List<GestionarAnioPeriodoPlanillaQuery> getListQueryByCriteria(GestionarAnioPeriodoPlanillaQueryCriteria criteria); 
   List<GestionarAnioPeriodoPlanillaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAnioPeriodoPlanillaQuery> getListQueryPaginationByCriteria(GestionarAnioPeriodoPlanillaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAnioPeriodoPlanillaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAnioPeriodoPlanillaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
