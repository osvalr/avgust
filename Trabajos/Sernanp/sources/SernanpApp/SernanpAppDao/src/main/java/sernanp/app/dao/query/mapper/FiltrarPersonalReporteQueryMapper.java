package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.FiltrarPersonalReporteQuery;
import sernanp.app.dao.query.domain.FiltrarPersonalReporteQueryCriteria;

public interface FiltrarPersonalReporteQueryMapper { 
   List<FiltrarPersonalReporteQuery> getListQuery(FiltrarPersonalReporteQueryCriteria criteria); 
} 
