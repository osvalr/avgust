package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ResponsableSernanpQuery; 
import sernanp.app.dao.query.domain.ResponsableSernanpQueryCriteria; 

public interface ResponsableSernanpQueryMapper { 
   List<ResponsableSernanpQuery> getListQuery(ResponsableSernanpQueryCriteria criteria); 
} 
