package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpCertificadoCuartaCategoriaQuery; 
import sernanp.app.dao.query.domain.RpCertificadoCuartaCategoriaQueryCriteria; 

public interface RpCertificadoCuartaCategoriaQueryMapper { 
   List<RpCertificadoCuartaCategoriaQuery> getListQueryByCriteria(RpCertificadoCuartaCategoriaQueryCriteria criteria); 
   List<RpCertificadoCuartaCategoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpCertificadoCuartaCategoriaQuery> getListQueryPaginationByCriteria(RpCertificadoCuartaCategoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpCertificadoCuartaCategoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpCertificadoCuartaCategoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
