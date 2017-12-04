package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.AdendaQuery; 
import sernanp.app.dao.query.domain.AdendaQueryCriteria; 

public interface AdendaQueryMapper { 
   List<AdendaQuery> getListQuery(AdendaQueryCriteria criteria); 
} 
