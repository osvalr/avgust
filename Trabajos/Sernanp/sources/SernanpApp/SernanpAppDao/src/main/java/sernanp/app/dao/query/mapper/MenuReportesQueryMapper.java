package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.MenuReportesQuery; 
import sernanp.app.dao.query.domain.MenuReportesQueryCriteria; 

public interface MenuReportesQueryMapper { 
   List<MenuReportesQuery> getListQueryByCriteria(MenuReportesQueryCriteria criteria); 
   List<MenuReportesQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<MenuReportesQuery> getListQueryPaginationByCriteria(MenuReportesQueryCriteria criteria, RowBounds rowBounds); 
   List<MenuReportesQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(MenuReportesQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
