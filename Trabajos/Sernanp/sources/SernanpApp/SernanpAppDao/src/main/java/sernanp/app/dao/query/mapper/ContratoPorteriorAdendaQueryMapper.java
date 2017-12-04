package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ContratoPorteriorAdendaQuery; 
import sernanp.app.dao.query.domain.ContratoPorteriorAdendaQueryCriteria; 

public interface ContratoPorteriorAdendaQueryMapper { 
   List<ContratoPorteriorAdendaQuery> getListQuery(ContratoPorteriorAdendaQueryCriteria criteria); 
} 
