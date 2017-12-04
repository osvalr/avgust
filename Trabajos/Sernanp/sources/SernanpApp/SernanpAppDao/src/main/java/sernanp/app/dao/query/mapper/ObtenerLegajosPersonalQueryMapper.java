package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerLegajosPersonalQuery; 
import sernanp.app.dao.query.domain.ObtenerLegajosPersonalQueryCriteria; 

public interface ObtenerLegajosPersonalQueryMapper { 
   List<ObtenerLegajosPersonalQuery> getListQuery(ObtenerLegajosPersonalQueryCriteria criteria); 
} 
