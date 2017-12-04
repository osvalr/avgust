package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoPersonalConstanciaQuery; 
import sernanp.app.dao.query.domain.InfoPersonalConstanciaQueryCriteria; 

public interface InfoPersonalConstanciaQueryMapper { 
   List<InfoPersonalConstanciaQuery> getListQuery(InfoPersonalConstanciaQueryCriteria criteria); 
} 
