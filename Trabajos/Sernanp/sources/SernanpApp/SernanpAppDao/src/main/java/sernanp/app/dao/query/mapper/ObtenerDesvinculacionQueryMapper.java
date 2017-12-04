package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerDesvinculacionQuery; 
import sernanp.app.dao.query.domain.ObtenerDesvinculacionQueryCriteria; 

public interface ObtenerDesvinculacionQueryMapper { 
   List<ObtenerDesvinculacionQuery> getListQuery(ObtenerDesvinculacionQueryCriteria criteria); 
} 
