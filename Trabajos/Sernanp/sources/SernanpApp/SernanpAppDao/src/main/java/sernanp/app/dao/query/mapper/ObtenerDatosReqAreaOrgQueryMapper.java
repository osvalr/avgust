package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ObtenerDatosReqAreaOrgQuery; 
import sernanp.app.dao.query.domain.ObtenerDatosReqAreaOrgQueryCriteria; 

public interface ObtenerDatosReqAreaOrgQueryMapper { 
   List<ObtenerDatosReqAreaOrgQuery> getListQueryByCriteria(ObtenerDatosReqAreaOrgQueryCriteria criteria); 
   List<ObtenerDatosReqAreaOrgQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerDatosReqAreaOrgQuery> getListQueryPaginationByCriteria(ObtenerDatosReqAreaOrgQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerDatosReqAreaOrgQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerDatosReqAreaOrgQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
