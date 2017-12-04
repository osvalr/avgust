package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.MesesLicenciasPersonalQuery; 
import sernanp.app.dao.query.domain.MesesLicenciasPersonalQueryCriteria; 

public interface MesesLicenciasPersonalQueryMapper { 
   List<MesesLicenciasPersonalQuery> getListQueryByCriteria(MesesLicenciasPersonalQueryCriteria criteria); 
   List<MesesLicenciasPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<MesesLicenciasPersonalQuery> getListQueryPaginationByCriteria(MesesLicenciasPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<MesesLicenciasPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(MesesLicenciasPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
