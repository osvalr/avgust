package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraQuery; 
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraQueryCriteria; 

public interface ReporteConvocatoriaMintraQueryMapper { 
   List<ReporteConvocatoriaMintraQuery> getListQueryByCriteria(ReporteConvocatoriaMintraQueryCriteria criteria); 
   List<ReporteConvocatoriaMintraQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteConvocatoriaMintraQuery> getListQueryPaginationByCriteria(ReporteConvocatoriaMintraQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteConvocatoriaMintraQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteConvocatoriaMintraQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
