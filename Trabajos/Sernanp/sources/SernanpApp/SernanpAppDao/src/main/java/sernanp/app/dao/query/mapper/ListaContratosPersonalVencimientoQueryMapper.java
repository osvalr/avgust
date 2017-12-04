package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.ListaContratosPersonalVencimientoQuery; 
import sernanp.app.dao.query.domain.ListaContratosPersonalVencimientoQueryCriteria; 

public interface ListaContratosPersonalVencimientoQueryMapper { 
   List<ListaContratosPersonalVencimientoQuery> getListQuery(ListaContratosPersonalVencimientoQueryCriteria criteria); 
} 
