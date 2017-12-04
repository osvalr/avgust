package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQuery; 
import sernanp.app.dao.query.domain.CodigoPostulacionDisponibleQueryCriteria; 

public interface CodigoPostulacionDisponibleQueryMapper { 
   List<CodigoPostulacionDisponibleQuery> getListQuery(CodigoPostulacionDisponibleQueryCriteria criteria); 
} 
