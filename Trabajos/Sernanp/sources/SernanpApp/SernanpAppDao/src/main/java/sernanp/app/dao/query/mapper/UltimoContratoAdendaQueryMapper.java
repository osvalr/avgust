package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.UltimoContratoAdendaQuery; 
import sernanp.app.dao.query.domain.UltimoContratoAdendaQueryCriteria; 

public interface UltimoContratoAdendaQueryMapper { 
   List<UltimoContratoAdendaQuery> getListQuery(UltimoContratoAdendaQueryCriteria criteria); 
} 
