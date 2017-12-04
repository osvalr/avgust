package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.AdendaEntrePeriodoPorContratoQuery; 
import sernanp.app.dao.query.domain.AdendaEntrePeriodoPorContratoQueryCriteria; 

public interface AdendaEntrePeriodoPorContratoQueryMapper { 
   List<AdendaEntrePeriodoPorContratoQuery> getListQuery(AdendaEntrePeriodoPorContratoQueryCriteria criteria); 
} 
