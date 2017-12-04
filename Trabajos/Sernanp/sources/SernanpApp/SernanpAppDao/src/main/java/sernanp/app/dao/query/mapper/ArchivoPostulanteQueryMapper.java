package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ArchivoPostulanteQuery; 
import sernanp.app.dao.query.domain.ArchivoPostulanteQueryCriteria; 

public interface ArchivoPostulanteQueryMapper { 
   List<ArchivoPostulanteQuery> getListQueryByCriteria(ArchivoPostulanteQueryCriteria criteria); 
   List<ArchivoPostulanteQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ArchivoPostulanteQuery> getListQueryPaginationByCriteria(ArchivoPostulanteQueryCriteria criteria, RowBounds rowBounds); 
   List<ArchivoPostulanteQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ArchivoPostulanteQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
