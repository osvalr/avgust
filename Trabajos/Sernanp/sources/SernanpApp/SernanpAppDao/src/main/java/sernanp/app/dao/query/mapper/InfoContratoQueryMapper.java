package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoContratoQuery; 
import sernanp.app.dao.query.domain.InfoContratoQueryCriteria; 

public interface InfoContratoQueryMapper { 
   List<InfoContratoQuery> getListQuery(InfoContratoQueryCriteria criteria); 
} 
