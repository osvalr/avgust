package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.DetallePostulacionPersonaQuery; 
import sernanp.app.dao.query.domain.DetallePostulacionPersonaQueryCriteria; 

public interface DetallePostulacionPersonaQueryMapper { 
   List<DetallePostulacionPersonaQuery> getListQuery(DetallePostulacionPersonaQueryCriteria criteria); 
} 
