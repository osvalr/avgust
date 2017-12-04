package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoTrabajadorQuery; 
import sernanp.app.dao.query.domain.InfoTrabajadorQueryCriteria; 

public interface InfoTrabajadorQueryMapper { 
   List<InfoTrabajadorQuery> getListQuery(InfoTrabajadorQueryCriteria criteria); 
} 
