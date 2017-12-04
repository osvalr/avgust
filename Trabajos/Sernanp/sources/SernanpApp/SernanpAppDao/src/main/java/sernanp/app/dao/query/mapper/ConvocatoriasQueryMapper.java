package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ConvocatoriasQuery; 
import sernanp.app.dao.query.domain.ConvocatoriasQueryCriteria; 

public interface ConvocatoriasQueryMapper { 
   List<ConvocatoriasQuery> getListQuery(ConvocatoriasQueryCriteria criteria); 
} 
