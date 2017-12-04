package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarAnhoMetaQuery; 
import sernanp.app.dao.query.domain.GestionarAnhoMetaQueryCriteria; 

public interface GestionarAnhoMetaQueryMapper { 
   List<GestionarAnhoMetaQuery> getListQueryByCriteria(GestionarAnhoMetaQueryCriteria criteria); 
   List<GestionarAnhoMetaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarAnhoMetaQuery> getListQueryPaginationByCriteria(GestionarAnhoMetaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarAnhoMetaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarAnhoMetaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
