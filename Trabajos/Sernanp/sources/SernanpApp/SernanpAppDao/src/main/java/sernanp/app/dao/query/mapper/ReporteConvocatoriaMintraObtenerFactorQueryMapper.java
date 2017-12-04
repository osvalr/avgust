package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraObtenerFactorQuery; 
import sernanp.app.dao.query.domain.ReporteConvocatoriaMintraObtenerFactorQueryCriteria; 

public interface ReporteConvocatoriaMintraObtenerFactorQueryMapper { 
   List<ReporteConvocatoriaMintraObtenerFactorQuery> getListQueryByCriteria(ReporteConvocatoriaMintraObtenerFactorQueryCriteria criteria); 
   List<ReporteConvocatoriaMintraObtenerFactorQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ReporteConvocatoriaMintraObtenerFactorQuery> getListQueryPaginationByCriteria(ReporteConvocatoriaMintraObtenerFactorQueryCriteria criteria, RowBounds rowBounds); 
   List<ReporteConvocatoriaMintraObtenerFactorQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ReporteConvocatoriaMintraObtenerFactorQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
