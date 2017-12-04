package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoriaQuery; 
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoriaQueryCriteria; 

public interface RpCertificadoQuintaCategoriaQueryMapper { 
   List<RpCertificadoQuintaCategoriaQuery> getListQueryByCriteria(RpCertificadoQuintaCategoriaQueryCriteria criteria); 
   List<RpCertificadoQuintaCategoriaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpCertificadoQuintaCategoriaQuery> getListQueryPaginationByCriteria(RpCertificadoQuintaCategoriaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpCertificadoQuintaCategoriaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpCertificadoQuintaCategoriaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
