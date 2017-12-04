package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.AniosLicenciasPersonalQuery; 
import sernanp.app.dao.query.domain.AniosLicenciasPersonalQueryCriteria; 

public interface AniosLicenciasPersonalQueryMapper { 
   List<AniosLicenciasPersonalQuery> getListQueryByCriteria(AniosLicenciasPersonalQueryCriteria criteria); 
   List<AniosLicenciasPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<AniosLicenciasPersonalQuery> getListQueryPaginationByCriteria(AniosLicenciasPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<AniosLicenciasPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(AniosLicenciasPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
