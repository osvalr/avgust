package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.PlantillaDocumentoQuery; 
import sernanp.app.dao.query.domain.PlantillaDocumentoQueryCriteria; 

public interface PlantillaDocumentoQueryMapper { 
   List<PlantillaDocumentoQuery> getListQuery(PlantillaDocumentoQueryCriteria criteria); 
} 
