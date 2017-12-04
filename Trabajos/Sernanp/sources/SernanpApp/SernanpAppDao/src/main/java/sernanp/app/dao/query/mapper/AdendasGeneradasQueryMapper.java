package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.AdendasGeneradasQuery; 
import sernanp.app.dao.query.domain.AdendasGeneradasQueryCriteria; 

public interface AdendasGeneradasQueryMapper { 
   List<AdendasGeneradasQuery> getListQuery(AdendasGeneradasQueryCriteria criteria); 
} 
