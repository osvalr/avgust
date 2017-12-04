package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.FiltrarPersonalQuery; 
import sernanp.app.dao.query.domain.FiltrarPersonalQueryCriteria; 

public interface FiltrarPersonalQueryMapper { 
   List<FiltrarPersonalQuery> getListQuery(FiltrarPersonalQueryCriteria criteria); 
} 
