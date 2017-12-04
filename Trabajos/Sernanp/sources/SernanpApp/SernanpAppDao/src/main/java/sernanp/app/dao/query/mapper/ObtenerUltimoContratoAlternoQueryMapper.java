package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerUltimoContratoAlternoQuery; 
import sernanp.app.dao.query.domain.ObtenerUltimoContratoAlternoQueryCriteria; 

public interface ObtenerUltimoContratoAlternoQueryMapper { 
   List<ObtenerUltimoContratoAlternoQuery> getListQuery(ObtenerUltimoContratoAlternoQueryCriteria criteria); 
} 
