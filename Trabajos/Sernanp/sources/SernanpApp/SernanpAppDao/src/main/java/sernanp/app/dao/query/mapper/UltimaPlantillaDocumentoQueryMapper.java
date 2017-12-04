package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimaPlantillaDocumentoQuery; 
import sernanp.app.dao.query.domain.UltimaPlantillaDocumentoQueryCriteria; 

public interface UltimaPlantillaDocumentoQueryMapper { 
   List<UltimaPlantillaDocumentoQuery> getListQuery(UltimaPlantillaDocumentoQueryCriteria criteria); 
} 
