package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.PersonalQuery; 
import sernanp.app.dao.query.domain.PersonalQueryCriteria; 

public interface PersonalQueryMapper { 
   List<PersonalQuery> getListQuery(PersonalQueryCriteria criteria); 
} 
