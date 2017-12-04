package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ConvocatoriaAreaOrgFactorQuery; 
import sernanp.app.dao.query.domain.ConvocatoriaAreaOrgFactorQueryCriteria; 

public interface ConvocatoriaAreaOrgFactorQueryMapper { 
   List<ConvocatoriaAreaOrgFactorQuery> getListQueryByCriteria(ConvocatoriaAreaOrgFactorQueryCriteria criteria); 
   List<ConvocatoriaAreaOrgFactorQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ConvocatoriaAreaOrgFactorQuery> getListQueryPaginationByCriteria(ConvocatoriaAreaOrgFactorQueryCriteria criteria, RowBounds rowBounds); 
   List<ConvocatoriaAreaOrgFactorQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ConvocatoriaAreaOrgFactorQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
