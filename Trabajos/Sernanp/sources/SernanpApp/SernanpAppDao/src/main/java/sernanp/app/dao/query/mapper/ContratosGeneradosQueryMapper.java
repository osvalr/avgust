package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ContratosGeneradosQuery; 
import sernanp.app.dao.query.domain.ContratosGeneradosQueryCriteria; 

public interface ContratosGeneradosQueryMapper { 
   List<ContratosGeneradosQuery> getListQuery(ContratosGeneradosQueryCriteria criteria); 
} 
