package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQuery; 
import pe.com.focus.sakerk.repository.custom.model.TablaGeneralDetalleQueryCriteria; 

public interface TablaGeneralDetalleQueryMapper { 
   List<TablaGeneralDetalleQuery> getListQueryByCriteria(TablaGeneralDetalleQueryCriteria criteria); 
   List<TablaGeneralDetalleQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<TablaGeneralDetalleQuery> getListQueryPaginationByCriteria(TablaGeneralDetalleQueryCriteria criteria, RowBounds rowBounds); 
   List<TablaGeneralDetalleQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(TablaGeneralDetalleQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
