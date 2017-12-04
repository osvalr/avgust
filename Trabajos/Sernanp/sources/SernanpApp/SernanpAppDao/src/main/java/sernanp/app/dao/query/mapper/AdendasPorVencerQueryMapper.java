package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.AdendasPorVencerQuery;
import sernanp.app.dao.query.domain.AdendasPorVencerQueryCriteria;

public interface AdendasPorVencerQueryMapper { 
   List<AdendasPorVencerQuery> getListQuery(AdendasPorVencerQueryCriteria criteria); 
} 
