package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerMetaFuenteGenericaQuery; 
import sernanp.app.dao.query.domain.ObtenerMetaFuenteGenericaQueryCriteria; 

public interface ObtenerMetaFuenteGenericaQueryMapper { 
   List<ObtenerMetaFuenteGenericaQuery> getListQueryByCriteria(ObtenerMetaFuenteGenericaQueryCriteria criteria); 
   List<ObtenerMetaFuenteGenericaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerMetaFuenteGenericaQuery> getListQueryPaginationByCriteria(ObtenerMetaFuenteGenericaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerMetaFuenteGenericaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerMetaFuenteGenericaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
