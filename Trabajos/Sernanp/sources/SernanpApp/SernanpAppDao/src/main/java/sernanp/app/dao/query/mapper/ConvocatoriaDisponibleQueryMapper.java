package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaDisponibleQueryCriteria; 

public interface ConvocatoriaDisponibleQueryMapper { 
   List<ConvocatoriaDisponibleQuery> getListQuery(ConvocatoriaDisponibleQueryCriteria criteria); 
} 
