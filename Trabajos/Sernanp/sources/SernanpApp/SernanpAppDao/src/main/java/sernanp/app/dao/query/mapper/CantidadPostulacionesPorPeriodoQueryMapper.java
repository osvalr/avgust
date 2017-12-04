package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.CantidadPostulacionesPorPeriodoQuery; 
import sernanp.app.dao.query.domain.CantidadPostulacionesPorPeriodoQueryCriteria; 

public interface CantidadPostulacionesPorPeriodoQueryMapper { 
   List<CantidadPostulacionesPorPeriodoQuery> getListQuery(CantidadPostulacionesPorPeriodoQueryCriteria criteria); 
} 
