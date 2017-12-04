package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.ResponsableContratosQuery;
import sernanp.app.dao.query.domain.ResponsableContratosQueryCriteria;

public interface ResponsableContratosQueryMapper { 
   List<ResponsableContratosQuery> getListQuery(ResponsableContratosQueryCriteria criteria); 
} 
