package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ExisteFechaInPersonalAsistenciaQuery; 
import sernanp.app.dao.query.domain.ExisteFechaInPersonalAsistenciaQueryCriteria; 

public interface ExisteFechaInPersonalAsistenciaQueryMapper { 
   List<ExisteFechaInPersonalAsistenciaQuery> getListQueryByCriteria(ExisteFechaInPersonalAsistenciaQueryCriteria criteria); 
   List<ExisteFechaInPersonalAsistenciaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ExisteFechaInPersonalAsistenciaQuery> getListQueryPaginationByCriteria(ExisteFechaInPersonalAsistenciaQueryCriteria criteria, RowBounds rowBounds); 
   List<ExisteFechaInPersonalAsistenciaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ExisteFechaInPersonalAsistenciaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
