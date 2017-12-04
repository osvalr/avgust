package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.ContratosPorVencerQuery;
import sernanp.app.dao.query.domain.ContratosPorVencerQueryCriteria;

public interface ContratosPorVencerQueryMapper { 
   List<ContratosPorVencerQuery> getListQuery(ContratosPorVencerQueryCriteria criteria); 
} 
