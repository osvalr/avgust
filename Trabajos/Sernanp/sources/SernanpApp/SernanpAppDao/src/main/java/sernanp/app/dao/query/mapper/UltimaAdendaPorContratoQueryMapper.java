package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQuery; 
import sernanp.app.dao.query.domain.UltimaAdendaPorContratoQueryCriteria; 

public interface UltimaAdendaPorContratoQueryMapper { 
   List<UltimaAdendaPorContratoQuery> getListQuery(UltimaAdendaPorContratoQueryCriteria criteria); 
} 
