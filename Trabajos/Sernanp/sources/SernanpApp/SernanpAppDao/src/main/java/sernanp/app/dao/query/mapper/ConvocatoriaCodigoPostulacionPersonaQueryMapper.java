package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ConvocatoriaCodigoPostulacionPersonaQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaCodigoPostulacionPersonaQueryCriteria; 

public interface ConvocatoriaCodigoPostulacionPersonaQueryMapper { 
   List<ConvocatoriaCodigoPostulacionPersonaQuery> getListQuery(ConvocatoriaCodigoPostulacionPersonaQueryCriteria criteria); 
} 
