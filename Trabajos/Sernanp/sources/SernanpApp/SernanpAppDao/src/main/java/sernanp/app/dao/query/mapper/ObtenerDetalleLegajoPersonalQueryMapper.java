package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerDetalleLegajoPersonalQuery; 
import sernanp.app.dao.query.domain.ObtenerDetalleLegajoPersonalQueryCriteria; 

public interface ObtenerDetalleLegajoPersonalQueryMapper { 
   List<ObtenerDetalleLegajoPersonalQuery> getListQuery(ObtenerDetalleLegajoPersonalQueryCriteria criteria); 
} 
