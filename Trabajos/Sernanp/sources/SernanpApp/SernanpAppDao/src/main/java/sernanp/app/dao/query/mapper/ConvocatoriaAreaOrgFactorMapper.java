package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaAreaOrgFactor; 
import sernanp.app.dao.query.domain.ConvocatoriaAreaOrgFactorCriteria; 

public interface ConvocatoriaAreaOrgFactorMapper { 
   List<ConvocatoriaAreaOrgFactor> getListQueryByCriteria(ConvocatoriaAreaOrgFactorCriteria criteria); 
   List<ConvocatoriaAreaOrgFactor> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaAreaOrgFactor> getListQueryPaginationByCriteria(ConvocatoriaAreaOrgFactorCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaAreaOrgFactor> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaAreaOrgFactorCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
