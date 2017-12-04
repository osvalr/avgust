package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.PersonalContratoQuery; 
import sernanp.app.dao.query.domain.PersonalContratoQueryCriteria; 

public interface PersonalContratoQueryMapper { 
   List<PersonalContratoQuery> getListQuery(PersonalContratoQueryCriteria criteria); 
} 
