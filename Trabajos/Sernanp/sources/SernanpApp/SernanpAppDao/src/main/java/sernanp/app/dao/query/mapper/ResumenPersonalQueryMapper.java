package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.ResumenPersonalQuery;
import sernanp.app.dao.query.domain.ResumenPersonalQueryCriteria;

public interface ResumenPersonalQueryMapper { 
   List<ResumenPersonalQuery> getListQuery(ResumenPersonalQueryCriteria criteria); 
} 
