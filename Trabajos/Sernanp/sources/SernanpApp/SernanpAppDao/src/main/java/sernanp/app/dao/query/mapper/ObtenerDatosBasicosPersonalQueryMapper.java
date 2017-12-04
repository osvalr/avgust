package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQuery; 
import sernanp.app.dao.query.domain.ObtenerDatosBasicosPersonalQueryCriteria; 

public interface ObtenerDatosBasicosPersonalQueryMapper { 
   List<ObtenerDatosBasicosPersonalQuery> getListQuery(ObtenerDatosBasicosPersonalQueryCriteria criteria); 
} 
