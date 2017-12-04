package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerTotalIngresosAfectoPorConceptoQuery; 
import sernanp.app.dao.query.domain.ObtenerTotalIngresosAfectoPorConceptoQueryCriteria; 

public interface ObtenerTotalIngresosAfectoPorConceptoQueryMapper { 
   List<ObtenerTotalIngresosAfectoPorConceptoQuery> getListQueryByCriteria(ObtenerTotalIngresosAfectoPorConceptoQueryCriteria criteria); 
   List<ObtenerTotalIngresosAfectoPorConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerTotalIngresosAfectoPorConceptoQuery> getListQueryPaginationByCriteria(ObtenerTotalIngresosAfectoPorConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerTotalIngresosAfectoPorConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerTotalIngresosAfectoPorConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
