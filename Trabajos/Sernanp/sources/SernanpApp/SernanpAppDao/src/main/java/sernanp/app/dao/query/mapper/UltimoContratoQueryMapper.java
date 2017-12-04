package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimoContratoQuery; 
import sernanp.app.dao.query.domain.UltimoContratoQueryCriteria; 

public interface UltimoContratoQueryMapper { 
   List<UltimoContratoQuery> getListQuery(UltimoContratoQueryCriteria criteria); 
} 
