package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteBancoFiltroQuery; 
import sernanp.app.dao.query.domain.ReporteBancoFiltroQueryCriteria; 

public interface ReporteBancoFiltroQueryMapper { 
   List<ReporteBancoFiltroQuery> getListQueryByCriteria(ReporteBancoFiltroQueryCriteria criteria); 
   List<ReporteBancoFiltroQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteBancoFiltroQuery> getListQueryPaginationByCriteria(ReporteBancoFiltroQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteBancoFiltroQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteBancoFiltroQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
