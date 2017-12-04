package pe.com.focus.sakerk.repository.custom.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import pe.com.focus.sakerk.repository.custom.model.ObtenerPersonaNaturalParentescoQuery; 
import pe.com.focus.sakerk.repository.custom.model.ObtenerPersonaNaturalParentescoQueryCriteria; 

public interface ObtenerPersonaNaturalParentescoQueryMapper { 
   List<ObtenerPersonaNaturalParentescoQuery> getListQueryByCriteria(ObtenerPersonaNaturalParentescoQueryCriteria criteria); 
   List<ObtenerPersonaNaturalParentescoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ObtenerPersonaNaturalParentescoQuery> getListQueryPaginationByCriteria(ObtenerPersonaNaturalParentescoQueryCriteria criteria, RowBounds rowBounds); 
   List<ObtenerPersonaNaturalParentescoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ObtenerPersonaNaturalParentescoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
