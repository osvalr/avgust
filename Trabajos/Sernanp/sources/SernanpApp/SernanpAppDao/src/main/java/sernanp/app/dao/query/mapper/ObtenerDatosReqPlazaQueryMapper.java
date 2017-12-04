package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerDatosReqPlazaQuery; 
import sernanp.app.dao.query.domain.ObtenerDatosReqPlazaQueryCriteria; 

public interface ObtenerDatosReqPlazaQueryMapper { 
   List<ObtenerDatosReqPlazaQuery> getListQueryByCriteria(ObtenerDatosReqPlazaQueryCriteria criteria); 
   List<ObtenerDatosReqPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerDatosReqPlazaQuery> getListQueryPaginationByCriteria(ObtenerDatosReqPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerDatosReqPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerDatosReqPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
