package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ListaLanzamientoConvocatoriaQuery; 
import sernanp.app.dao.query.domain.ListaLanzamientoConvocatoriaQueryCriteria; 

public interface ListaLanzamientoConvocatoriaQueryMapper { 
   List<ListaLanzamientoConvocatoriaQuery> getListQueryByCriteria(ListaLanzamientoConvocatoriaQueryCriteria criteria); 
   List<ListaLanzamientoConvocatoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ListaLanzamientoConvocatoriaQuery> getListQueryPaginationByCriteria(ListaLanzamientoConvocatoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<ListaLanzamientoConvocatoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ListaLanzamientoConvocatoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
