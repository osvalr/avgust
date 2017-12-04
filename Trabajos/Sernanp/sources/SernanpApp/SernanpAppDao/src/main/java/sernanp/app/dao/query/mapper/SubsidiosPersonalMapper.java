package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SubsidiosPersonal; 
import sernanp.app.dao.query.domain.SubsidiosPersonalCriteria; 

public interface SubsidiosPersonalMapper { 
   List<SubsidiosPersonal> getListQueryByCriteria(SubsidiosPersonalCriteria criteria); 
   List<SubsidiosPersonal> getListQueryByMap(Map<String, Object> paramMap); 
   List<SubsidiosPersonal> getListQueryPaginationByCriteria(SubsidiosPersonalCriteria criteria, RowBounds rowBounds); 
   List<SubsidiosPersonal> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SubsidiosPersonalCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
