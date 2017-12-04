package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ArchivoPlazaQuery; 
import sernanp.app.dao.query.domain.ArchivoPlazaQueryCriteria; 

public interface ArchivoPlazaQueryMapper { 
   List<ArchivoPlazaQuery> getListQueryByCriteria(ArchivoPlazaQueryCriteria criteria); 
   List<ArchivoPlazaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ArchivoPlazaQuery> getListQueryPaginationByCriteria(ArchivoPlazaQueryCriteria criteria, RowBounds rowBounds); 
   List<ArchivoPlazaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ArchivoPlazaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
