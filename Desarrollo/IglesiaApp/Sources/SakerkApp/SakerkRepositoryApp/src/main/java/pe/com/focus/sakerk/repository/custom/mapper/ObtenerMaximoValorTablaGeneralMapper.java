package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.ObtenerMaximoValorTablaGeneral; 
import pe.com.focus.sakerk.repository.custom.model.ObtenerMaximoValorTablaGeneralCriteria; 

public interface ObtenerMaximoValorTablaGeneralMapper { 
   List<ObtenerMaximoValorTablaGeneral> getListQueryByCriteria(ObtenerMaximoValorTablaGeneralCriteria criteria); 
   List<ObtenerMaximoValorTablaGeneral> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerMaximoValorTablaGeneral> getListQueryPaginationByCriteria(ObtenerMaximoValorTablaGeneralCriteria criteria, RowBounds rowBounds); 
   List<ObtenerMaximoValorTablaGeneral> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerMaximoValorTablaGeneralCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
