package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ContratoPorPersonaQuery; 
import sernanp.app.dao.query.domain.ContratoPorPersonaQueryCriteria; 

public interface ContratoPorPersonaQueryMapper { 
   List<ContratoPorPersonaQuery> getListQuery(ContratoPorPersonaQueryCriteria criteria); 
} 
