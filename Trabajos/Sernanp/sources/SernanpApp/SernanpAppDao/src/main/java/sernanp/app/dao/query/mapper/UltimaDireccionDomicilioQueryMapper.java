package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimaDireccionDomicilioQuery; 
import sernanp.app.dao.query.domain.UltimaDireccionDomicilioQueryCriteria; 

public interface UltimaDireccionDomicilioQueryMapper { 
   List<UltimaDireccionDomicilioQuery> getListQuery(UltimaDireccionDomicilioQueryCriteria criteria); 
} 
