package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerTotalSueldoPorMesCorte; 
import sernanp.app.dao.query.domain.ObtenerTotalSueldoPorMesCorteCriteria; 

public interface ObtenerTotalSueldoPorMesCorteMapper { 
   List<ObtenerTotalSueldoPorMesCorte> getListQueryByCriteria(ObtenerTotalSueldoPorMesCorteCriteria criteria); 
   List<ObtenerTotalSueldoPorMesCorte> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerTotalSueldoPorMesCorte> getListQueryPaginationByCriteria(ObtenerTotalSueldoPorMesCorteCriteria criteria, RowBounds rowBounds); 
   List<ObtenerTotalSueldoPorMesCorte> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerTotalSueldoPorMesCorteCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
