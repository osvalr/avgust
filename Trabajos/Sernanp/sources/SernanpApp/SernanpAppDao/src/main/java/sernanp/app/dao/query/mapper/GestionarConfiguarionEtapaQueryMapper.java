package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.GestionarConfiguarionEtapaQuery; 
import sernanp.app.dao.query.domain.GestionarConfiguarionEtapaQueryCriteria; 

public interface GestionarConfiguarionEtapaQueryMapper { 
   List<GestionarConfiguarionEtapaQuery> getListQueryByCriteria(GestionarConfiguarionEtapaQueryCriteria criteria); 
   List<GestionarConfiguarionEtapaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<GestionarConfiguarionEtapaQuery> getListQueryPaginationByCriteria(GestionarConfiguarionEtapaQueryCriteria criteria, RowBounds rowBounds); 
   List<GestionarConfiguarionEtapaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(GestionarConfiguarionEtapaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
