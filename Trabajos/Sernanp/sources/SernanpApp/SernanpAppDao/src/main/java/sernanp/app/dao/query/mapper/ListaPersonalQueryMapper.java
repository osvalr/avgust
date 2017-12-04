package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ListaPersonalQuery; 
import sernanp.app.dao.query.domain.ListaPersonalQueryCriteria; 

public interface ListaPersonalQueryMapper { 
   List<ListaPersonalQuery> getListQueryByCriteria(ListaPersonalQueryCriteria criteria); 
   List<ListaPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ListaPersonalQuery> getListQueryPaginationByCriteria(ListaPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<ListaPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ListaPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
