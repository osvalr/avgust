package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalPorRegimenContractualQuery; 
import sernanp.app.dao.query.domain.PersonalPorRegimenContractualQueryCriteria; 

public interface PersonalPorRegimenContractualQueryMapper { 
   List<PersonalPorRegimenContractualQuery> getListQueryByCriteria(PersonalPorRegimenContractualQueryCriteria criteria); 
   List<PersonalPorRegimenContractualQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalPorRegimenContractualQuery> getListQueryPaginationByCriteria(PersonalPorRegimenContractualQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalPorRegimenContractualQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalPorRegimenContractualQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
