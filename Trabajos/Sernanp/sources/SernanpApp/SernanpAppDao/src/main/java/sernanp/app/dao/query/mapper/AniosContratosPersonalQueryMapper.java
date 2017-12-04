package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.AniosContratosPersonalQuery; 
import sernanp.app.dao.query.domain.AniosContratosPersonalQueryCriteria; 

public interface AniosContratosPersonalQueryMapper { 
   List<AniosContratosPersonalQuery> getListQuery(AniosContratosPersonalQueryCriteria criteria); 
} 
