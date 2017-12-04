package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ResponsableUnidadOperativaQuery; 
import sernanp.app.dao.query.domain.ResponsableUnidadOperativaQueryCriteria; 

public interface ResponsableUnidadOperativaQueryMapper { 
   List<ResponsableUnidadOperativaQuery> getListQuery(ResponsableUnidadOperativaQueryCriteria criteria); 
} 
