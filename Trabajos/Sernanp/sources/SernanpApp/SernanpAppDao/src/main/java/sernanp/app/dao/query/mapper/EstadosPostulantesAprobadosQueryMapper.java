package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.EstadosPostulantesAprobadosQuery; 
import sernanp.app.dao.query.domain.EstadosPostulantesAprobadosQueryCriteria; 

public interface EstadosPostulantesAprobadosQueryMapper { 
   List<EstadosPostulantesAprobadosQuery> getListQueryByCriteria(EstadosPostulantesAprobadosQueryCriteria criteria); 
   List<EstadosPostulantesAprobadosQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<EstadosPostulantesAprobadosQuery> getListQueryPaginationByCriteria(EstadosPostulantesAprobadosQueryCriteria criteria, RowBounds rowBounds); 
   List<EstadosPostulantesAprobadosQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(EstadosPostulantesAprobadosQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
