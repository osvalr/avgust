package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteBancoQuery; 
import sernanp.app.dao.query.domain.ReporteBancoQueryCriteria; 

public interface ReporteBancoQueryMapper { 
   List<ReporteBancoQuery> getListQueryByCriteria(ReporteBancoQueryCriteria criteria); 
   List<ReporteBancoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteBancoQuery> getListQueryPaginationByCriteria(ReporteBancoQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteBancoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteBancoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
