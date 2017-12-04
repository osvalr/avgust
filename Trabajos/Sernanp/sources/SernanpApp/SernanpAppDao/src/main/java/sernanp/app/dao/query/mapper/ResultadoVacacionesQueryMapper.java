package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ResultadoVacacionesQuery; 
import sernanp.app.dao.query.domain.ResultadoVacacionesQueryCriteria; 

public interface ResultadoVacacionesQueryMapper { 
   List<ResultadoVacacionesQuery> getListQuery(ResultadoVacacionesQueryCriteria criteria); 
} 
