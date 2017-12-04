package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptEmitirDetalleNominaxMesxRCQuery; 
import sernanp.app.dao.query.domain.RptEmitirDetalleNominaxMesxRCQueryCriteria; 

public interface RptEmitirDetalleNominaxMesxRCQueryMapper { 
   List<RptEmitirDetalleNominaxMesxRCQuery> getListQueryByCriteria(RptEmitirDetalleNominaxMesxRCQueryCriteria criteria); 
   List<RptEmitirDetalleNominaxMesxRCQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptEmitirDetalleNominaxMesxRCQuery> getListQueryPaginationByCriteria(RptEmitirDetalleNominaxMesxRCQueryCriteria criteria, RowBounds rowBounds); 
   List<RptEmitirDetalleNominaxMesxRCQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptEmitirDetalleNominaxMesxRCQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
