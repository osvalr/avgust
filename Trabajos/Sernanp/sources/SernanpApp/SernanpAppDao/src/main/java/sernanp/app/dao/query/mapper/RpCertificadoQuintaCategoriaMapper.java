package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoria; 
import sernanp.app.dao.query.domain.RpCertificadoQuintaCategoriaCriteria; 

public interface RpCertificadoQuintaCategoriaMapper { 
   List<RpCertificadoQuintaCategoria> getListQueryByCriteria(RpCertificadoQuintaCategoriaCriteria criteria); 
   List<RpCertificadoQuintaCategoria> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpCertificadoQuintaCategoria> getListQueryPaginationByCriteria(RpCertificadoQuintaCategoriaCriteria criteria, RowBounds rowBounds); 
   List<RpCertificadoQuintaCategoria> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpCertificadoQuintaCategoriaCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
