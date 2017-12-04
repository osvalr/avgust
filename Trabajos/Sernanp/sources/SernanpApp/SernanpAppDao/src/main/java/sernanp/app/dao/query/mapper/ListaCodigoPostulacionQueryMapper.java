package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ListaCodigoPostulacionQuery; 
import sernanp.app.dao.query.domain.ListaCodigoPostulacionQueryCriteria; 

public interface ListaCodigoPostulacionQueryMapper { 
   List<ListaCodigoPostulacionQuery> getListQueryByCriteria(ListaCodigoPostulacionQueryCriteria criteria); 
   List<ListaCodigoPostulacionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ListaCodigoPostulacionQuery> getListQueryPaginationByCriteria(ListaCodigoPostulacionQueryCriteria criteria, RowBounds rowBounds); 
   List<ListaCodigoPostulacionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ListaCodigoPostulacionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
