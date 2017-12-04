package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ContratoCasCcQuery; 
import sernanp.app.dao.query.domain.ContratoCasCcQueryCriteria; 

public interface ContratoCasCcQueryMapper { 
   List<ContratoCasCcQuery> getListQuery(ContratoCasCcQueryCriteria criteria); 
} 
