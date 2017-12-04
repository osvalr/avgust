package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoResponsableUnidadOperativaQuery; 
import sernanp.app.dao.query.domain.InfoResponsableUnidadOperativaQueryCriteria; 

public interface InfoResponsableUnidadOperativaQueryMapper { 
   List<InfoResponsableUnidadOperativaQuery> getListQuery(InfoResponsableUnidadOperativaQueryCriteria criteria); 
} 
