package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQuery; 
import sernanp.app.dao.query.domain.RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQueryCriteria; 

public interface RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQueryMapper { 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQuery> getListQueryByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQueryCriteria criteria); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQuery> getListQueryPaginationByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDocumentoConsolidadoConvocatoriaSubModeloFactorEvalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
