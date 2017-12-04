package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimaFotoPersonalQuery; 
import sernanp.app.dao.query.domain.UltimaFotoPersonalQueryCriteria; 

public interface UltimaFotoPersonalQueryMapper { 
   List<UltimaFotoPersonalQuery> getListQuery(UltimaFotoPersonalQueryCriteria criteria); 
} 
