package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.PersonalDiasLicenciasQuery; 
import sernanp.app.dao.query.domain.PersonalDiasLicenciasQueryCriteria; 

public interface PersonalDiasLicenciasQueryMapper { 
   List<PersonalDiasLicenciasQuery> getListQueryByCriteria(PersonalDiasLicenciasQueryCriteria criteria); 
   List<PersonalDiasLicenciasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<PersonalDiasLicenciasQuery> getListQueryPaginationByCriteria(PersonalDiasLicenciasQueryCriteria criteria, RowBounds rowBounds); 
   List<PersonalDiasLicenciasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(PersonalDiasLicenciasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
