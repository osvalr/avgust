package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaQuery; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaQueryCriteria; 

public interface RpDocumentoConsolidadoConvocatoriaQueryMapper { 
   List<RpDocumentoConsolidadoConvocatoriaQuery> getListQueryByCriteria(RpDocumentoConsolidadoConvocatoriaQueryCriteria criteria); 
   List<RpDocumentoConsolidadoConvocatoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDocumentoConsolidadoConvocatoriaQuery> getListQueryPaginationByCriteria(RpDocumentoConsolidadoConvocatoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDocumentoConsolidadoConvocatoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDocumentoConsolidadoConvocatoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
