package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpCertificadoRetencionesCuartaCatQuery; 
import sernanp.app.dao.query.domain.RpCertificadoRetencionesCuartaCatQueryCriteria; 

public interface RpCertificadoRetencionesCuartaCatQueryMapper { 
   List<RpCertificadoRetencionesCuartaCatQuery> getListQueryByCriteria(RpCertificadoRetencionesCuartaCatQueryCriteria criteria); 
   List<RpCertificadoRetencionesCuartaCatQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpCertificadoRetencionesCuartaCatQuery> getListQueryPaginationByCriteria(RpCertificadoRetencionesCuartaCatQueryCriteria criteria, RowBounds rowBounds); 
   List<RpCertificadoRetencionesCuartaCatQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpCertificadoRetencionesCuartaCatQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
