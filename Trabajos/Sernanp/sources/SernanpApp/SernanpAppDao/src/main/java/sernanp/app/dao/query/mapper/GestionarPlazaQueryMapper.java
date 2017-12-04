package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarPlazaQuery; 
import sernanp.app.dao.query.domain.GestionarPlazaQueryCriteria; 

public interface GestionarPlazaQueryMapper { 
   List<GestionarPlazaQuery> getListQueryByCriteria(GestionarPlazaQueryCriteria criteria); 
   List<GestionarPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarPlazaQuery> getListQueryPaginationByCriteria(GestionarPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
