package sernanp.app.dao.query.mapper;

import java.util.List;

import sernanp.app.dao.query.domain.ResumenNominaPagosQuery;
import sernanp.app.dao.query.domain.ResumenNominaPagosQueryCriteria;

public interface ResumenNominaPagosQueryMapper {
   List<ResumenNominaPagosQuery> getListQueryByCriteria(ResumenNominaPagosQueryCriteria criteria);
}
