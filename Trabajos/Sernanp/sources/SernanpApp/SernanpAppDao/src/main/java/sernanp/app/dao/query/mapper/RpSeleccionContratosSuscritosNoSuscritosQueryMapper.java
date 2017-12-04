package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpSeleccionContratosSuscritosNoSuscritosQuery; 
import sernanp.app.dao.query.domain.RpSeleccionContratosSuscritosNoSuscritosQueryCriteria; 

public interface RpSeleccionContratosSuscritosNoSuscritosQueryMapper { 
   List<RpSeleccionContratosSuscritosNoSuscritosQuery> getListQueryByCriteria(RpSeleccionContratosSuscritosNoSuscritosQueryCriteria criteria); 
   List<RpSeleccionContratosSuscritosNoSuscritosQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpSeleccionContratosSuscritosNoSuscritosQuery> getListQueryPaginationByCriteria(RpSeleccionContratosSuscritosNoSuscritosQueryCriteria criteria, RowBounds rowBounds); 
   List<RpSeleccionContratosSuscritosNoSuscritosQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpSeleccionContratosSuscritosNoSuscritosQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
