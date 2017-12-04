package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.ContratoEntrePeriodoQuery;
import sernanp.app.dao.query.domain.ContratoEntrePeriodoQueryCriteria;

public interface ContratoEntrePeriodoQueryMapper { 
   List<ContratoEntrePeriodoQuery> getListQuery(ContratoEntrePeriodoQueryCriteria criteria); 
} 
