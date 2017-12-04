package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerDetalleDesvinculacionQuery; 
import sernanp.app.dao.query.domain.ObtenerDetalleDesvinculacionQueryCriteria; 

public interface ObtenerDetalleDesvinculacionQueryMapper { 
   List<ObtenerDetalleDesvinculacionQuery> getListQuery(ObtenerDetalleDesvinculacionQueryCriteria criteria); 
} 
