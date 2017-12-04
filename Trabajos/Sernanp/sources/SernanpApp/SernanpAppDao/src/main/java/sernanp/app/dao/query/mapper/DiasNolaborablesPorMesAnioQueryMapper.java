package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DiasNolaborablesPorMesAnioQuery; 
import sernanp.app.dao.query.domain.DiasNolaborablesPorMesAnioQueryCriteria; 

public interface DiasNolaborablesPorMesAnioQueryMapper { 
   List<DiasNolaborablesPorMesAnioQuery> getListQueryByCriteria(DiasNolaborablesPorMesAnioQueryCriteria criteria); 
   List<DiasNolaborablesPorMesAnioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DiasNolaborablesPorMesAnioQuery> getListQueryPaginationByCriteria(DiasNolaborablesPorMesAnioQueryCriteria criteria, RowBounds rowBounds); 
   List<DiasNolaborablesPorMesAnioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DiasNolaborablesPorMesAnioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
