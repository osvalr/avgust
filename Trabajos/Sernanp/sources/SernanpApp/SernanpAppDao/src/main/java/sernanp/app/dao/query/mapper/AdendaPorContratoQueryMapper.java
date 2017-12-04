package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.AdendaPorContratoQuery; 
import sernanp.app.dao.query.domain.AdendaPorContratoQueryCriteria; 

public interface AdendaPorContratoQueryMapper { 
   List<AdendaPorContratoQuery> getListQuery(AdendaPorContratoQueryCriteria criteria); 
} 
