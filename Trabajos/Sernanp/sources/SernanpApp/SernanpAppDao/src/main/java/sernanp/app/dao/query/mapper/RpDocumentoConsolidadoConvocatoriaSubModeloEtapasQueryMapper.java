package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria; 

public interface RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryMapper { 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery> getListQueryByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria criteria); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery> getListQueryPaginationByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloEtapasQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
