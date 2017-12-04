package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.PersonaNaturalQuery; 
import sernanp.app.dao.query.domain.PersonaNaturalQueryCriteria; 

public interface PersonaNaturalQueryMapper { 
   List<PersonaNaturalQuery> getListQuery(PersonaNaturalQueryCriteria criteria); 
} 
