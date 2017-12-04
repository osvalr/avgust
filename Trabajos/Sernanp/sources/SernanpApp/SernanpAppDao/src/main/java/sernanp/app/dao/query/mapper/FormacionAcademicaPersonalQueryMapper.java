package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQuery; 
import sernanp.app.dao.query.domain.FormacionAcademicaPersonalQueryCriteria; 

public interface FormacionAcademicaPersonalQueryMapper { 
   List<FormacionAcademicaPersonalQuery> getListQuery(FormacionAcademicaPersonalQueryCriteria criteria); 
} 
