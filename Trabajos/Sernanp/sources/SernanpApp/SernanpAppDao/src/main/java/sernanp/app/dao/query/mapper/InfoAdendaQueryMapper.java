package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoAdendaQuery; 
import sernanp.app.dao.query.domain.InfoAdendaQueryCriteria; 

public interface InfoAdendaQueryMapper { 
   List<InfoAdendaQuery> getListQuery(InfoAdendaQueryCriteria criteria); 
} 
