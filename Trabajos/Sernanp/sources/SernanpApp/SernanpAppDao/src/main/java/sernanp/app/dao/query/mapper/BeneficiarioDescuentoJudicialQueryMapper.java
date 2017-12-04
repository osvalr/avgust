package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.BeneficiarioDescuentoJudicialQuery; 
import sernanp.app.dao.query.domain.BeneficiarioDescuentoJudicialQueryCriteria; 

public interface BeneficiarioDescuentoJudicialQueryMapper { 
   List<BeneficiarioDescuentoJudicialQuery> getListQueryByCriteria(BeneficiarioDescuentoJudicialQueryCriteria criteria); 
   List<BeneficiarioDescuentoJudicialQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<BeneficiarioDescuentoJudicialQuery> getListQueryPaginationByCriteria(BeneficiarioDescuentoJudicialQueryCriteria criteria, RowBounds rowBounds); 
   List<BeneficiarioDescuentoJudicialQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(BeneficiarioDescuentoJudicialQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
