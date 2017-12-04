package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.UsuarioResponsableGestionQuery; 
import sernanp.app.dao.query.domain.UsuarioResponsableGestionQueryCriteria; 

public interface UsuarioResponsableGestionQueryMapper { 
   List<UsuarioResponsableGestionQuery> getListQueryByCriteria(UsuarioResponsableGestionQueryCriteria criteria); 
   List<UsuarioResponsableGestionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<UsuarioResponsableGestionQuery> getListQueryPaginationByCriteria(UsuarioResponsableGestionQueryCriteria criteria, RowBounds rowBounds); 
   List<UsuarioResponsableGestionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(UsuarioResponsableGestionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
