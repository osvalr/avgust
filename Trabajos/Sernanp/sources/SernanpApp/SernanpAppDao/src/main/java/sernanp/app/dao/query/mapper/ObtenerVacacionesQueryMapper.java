package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ObtenerVacacionesQuery; 
import sernanp.app.dao.query.domain.ObtenerVacacionesQueryCriteria; 

public interface ObtenerVacacionesQueryMapper { 
   List<ObtenerVacacionesQuery> getListQuery(ObtenerVacacionesQueryCriteria criteria); 
} 
