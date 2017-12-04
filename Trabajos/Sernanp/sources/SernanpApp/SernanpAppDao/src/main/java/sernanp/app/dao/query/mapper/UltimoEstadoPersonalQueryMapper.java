package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimoEstadoPersonalQuery; 
import sernanp.app.dao.query.domain.UltimoEstadoPersonalQueryCriteria; 

public interface UltimoEstadoPersonalQueryMapper { 
   List<UltimoEstadoPersonalQuery> getListQuery(UltimoEstadoPersonalQueryCriteria criteria); 
} 
