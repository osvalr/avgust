package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptEmitirNominaxMesxRCQuery; 
import sernanp.app.dao.query.domain.RptEmitirNominaxMesxRCQueryCriteria; 

public interface RptEmitirNominaxMesxRCQueryMapper { 
   List<RptEmitirNominaxMesxRCQuery> getListQueryByCriteria(RptEmitirNominaxMesxRCQueryCriteria criteria); 
   List<RptEmitirNominaxMesxRCQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptEmitirNominaxMesxRCQuery> getListQueryPaginationByCriteria(RptEmitirNominaxMesxRCQueryCriteria criteria, RowBounds rowBounds); 
   List<RptEmitirNominaxMesxRCQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptEmitirNominaxMesxRCQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
