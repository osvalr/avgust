package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.FnGeneraDescuentoPersonalQuery;
import sernanp.app.dao.query.domain.FnGeneraDescuentoPersonalQueryCriteria;

public interface FnGeneraDescuentoPersonalQueryMapper { 
   List<FnGeneraDescuentoPersonalQuery> getListQueryByCriteria(FnGeneraDescuentoPersonalQueryCriteria criteria);
} 
