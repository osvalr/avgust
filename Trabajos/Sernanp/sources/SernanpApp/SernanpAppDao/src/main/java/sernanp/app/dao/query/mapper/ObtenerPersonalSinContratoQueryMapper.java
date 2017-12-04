package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerPersonalSinContratoQuery; 
import sernanp.app.dao.query.domain.ObtenerPersonalSinContratoQueryCriteria; 

public interface ObtenerPersonalSinContratoQueryMapper { 
   List<ObtenerPersonalSinContratoQuery> getListQuery(ObtenerPersonalSinContratoQueryCriteria criteria); 
} 
