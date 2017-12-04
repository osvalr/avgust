package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimoRegimenPensionarioQuery; 
import sernanp.app.dao.query.domain.UltimoRegimenPensionarioQueryCriteria; 

public interface UltimoRegimenPensionarioQueryMapper { 
   List<UltimoRegimenPensionarioQuery> getListQuery(UltimoRegimenPensionarioQueryCriteria criteria); 
}  
