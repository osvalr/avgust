package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalLicenciasQuery; 
import sernanp.app.dao.query.domain.PersonalLicenciasQueryCriteria; 

public interface PersonalLicenciasQueryMapper { 
   List<PersonalLicenciasQuery> getListQueryByCriteria(PersonalLicenciasQueryCriteria criteria); 
   List<PersonalLicenciasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalLicenciasQuery> getListQueryPaginationByCriteria(PersonalLicenciasQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalLicenciasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalLicenciasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
