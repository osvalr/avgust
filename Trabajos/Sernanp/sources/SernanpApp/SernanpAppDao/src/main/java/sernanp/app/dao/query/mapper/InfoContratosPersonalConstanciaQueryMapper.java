package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoContratosPersonalConstanciaQuery; 
import sernanp.app.dao.query.domain.InfoContratosPersonalConstanciaQueryCriteria; 

public interface InfoContratosPersonalConstanciaQueryMapper { 
   List<InfoContratosPersonalConstanciaQuery> getListQuery(InfoContratosPersonalConstanciaQueryCriteria criteria); 
} 
