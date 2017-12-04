package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.LicenciasPersonalPorMesAnioActividadQuery; 
import sernanp.app.dao.query.domain.LicenciasPersonalPorMesAnioActividadQueryCriteria; 

public interface LicenciasPersonalPorMesAnioActividadQueryMapper { 
   List<LicenciasPersonalPorMesAnioActividadQuery> getListQueryByCriteria(LicenciasPersonalPorMesAnioActividadQueryCriteria criteria); 
   List<LicenciasPersonalPorMesAnioActividadQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<LicenciasPersonalPorMesAnioActividadQuery> getListQueryPaginationByCriteria(LicenciasPersonalPorMesAnioActividadQueryCriteria criteria, RowBounds rowBounds); 
   List<LicenciasPersonalPorMesAnioActividadQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(LicenciasPersonalPorMesAnioActividadQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
