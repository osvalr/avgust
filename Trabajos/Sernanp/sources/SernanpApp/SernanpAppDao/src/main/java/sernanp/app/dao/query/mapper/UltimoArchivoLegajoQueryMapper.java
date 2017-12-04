package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimoArchivoLegajoQuery; 
import sernanp.app.dao.query.domain.UltimoArchivoLegajoQueryCriteria; 

public interface UltimoArchivoLegajoQueryMapper { 
   List<UltimoArchivoLegajoQuery> getListQuery(UltimoArchivoLegajoQueryCriteria criteria); 
} 
