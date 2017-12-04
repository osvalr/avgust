package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerCantidadPostulacionesPorConvocatoriaQuery; 
import sernanp.app.dao.query.domain.ObtenerCantidadPostulacionesPorConvocatoriaQueryCriteria; 

public interface ObtenerCantidadPostulacionesPorConvocatoriaQueryMapper { 
   List<ObtenerCantidadPostulacionesPorConvocatoriaQuery> getListQuery(ObtenerCantidadPostulacionesPorConvocatoriaQueryCriteria criteria); 
} 
