package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarMetaFuenteGenericaQuery; 
import sernanp.app.dao.query.domain.GestionarMetaFuenteGenericaQueryCriteria; 

public interface GestionarMetaFuenteGenericaQueryMapper { 
   List<GestionarMetaFuenteGenericaQuery> getListQueryByCriteria(GestionarMetaFuenteGenericaQueryCriteria criteria); 
   List<GestionarMetaFuenteGenericaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarMetaFuenteGenericaQuery> getListQueryPaginationByCriteria(GestionarMetaFuenteGenericaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarMetaFuenteGenericaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarMetaFuenteGenericaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
