package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQuery; 
import pe.com.focus.sakerk.repository.custom.model.NumeroTelefonicoQueryCriteria; 

public interface NumeroTelefonicoQueryMapper { 
   List<NumeroTelefonicoQuery> getListQueryByCriteria(NumeroTelefonicoQueryCriteria criteria); 
   List<NumeroTelefonicoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<NumeroTelefonicoQuery> getListQueryPaginationByCriteria(NumeroTelefonicoQueryCriteria criteria, RowBounds rowBounds); 
   List<NumeroTelefonicoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(NumeroTelefonicoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
