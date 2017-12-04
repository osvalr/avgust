package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.TablaTipoQuery; 
import sernanp.app.dao.query.domain.TablaTipoQueryCriteria; 

public interface TablaTipoQueryMapper { 
   List<TablaTipoQuery> getListQuery(TablaTipoQueryCriteria criteria); 
} 
