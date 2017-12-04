package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaRegistradaQueryCriteria; 

public interface ConvocatoriaRegistradaQueryMapper { 
   List<ConvocatoriaRegistradaQuery> getListQuery(ConvocatoriaRegistradaQueryCriteria criteria); 
} 
