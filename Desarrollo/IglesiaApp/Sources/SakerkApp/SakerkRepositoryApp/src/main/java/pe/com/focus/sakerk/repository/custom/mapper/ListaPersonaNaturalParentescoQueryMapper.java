package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.ListaPersonaNaturalParentescoQuery; 
import pe.com.focus.sakerk.repository.custom.model.ListaPersonaNaturalParentescoQueryCriteria; 

public interface ListaPersonaNaturalParentescoQueryMapper { 
   List<ListaPersonaNaturalParentescoQuery> getListQueryByCriteria(ListaPersonaNaturalParentescoQueryCriteria criteria); 
   List<ListaPersonaNaturalParentescoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ListaPersonaNaturalParentescoQuery> getListQueryPaginationByCriteria(ListaPersonaNaturalParentescoQueryCriteria criteria, RowBounds rowBounds); 
   List<ListaPersonaNaturalParentescoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ListaPersonaNaturalParentescoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
