package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.AdendaFinalPorContratoQuery; 
import sernanp.app.dao.query.domain.AdendaFinalPorContratoQueryCriteria; 

public interface AdendaFinalPorContratoQueryMapper { 
   List<AdendaFinalPorContratoQuery> getListQueryByCriteria(AdendaFinalPorContratoQueryCriteria criteria); 
   List<AdendaFinalPorContratoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<AdendaFinalPorContratoQuery> getListQueryPaginationByCriteria(AdendaFinalPorContratoQueryCriteria criteria, RowBounds rowBounds); 
   List<AdendaFinalPorContratoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(AdendaFinalPorContratoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
