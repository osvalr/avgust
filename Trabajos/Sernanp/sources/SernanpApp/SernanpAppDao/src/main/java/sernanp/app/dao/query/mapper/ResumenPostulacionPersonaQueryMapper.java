package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ResumenPostulacionPersonaQuery; 
import sernanp.app.dao.query.domain.ResumenPostulacionPersonaQueryCriteria; 

public interface ResumenPostulacionPersonaQueryMapper { 
   List<ResumenPostulacionPersonaQuery> getListQuery(ResumenPostulacionPersonaQueryCriteria criteria); 
} 
