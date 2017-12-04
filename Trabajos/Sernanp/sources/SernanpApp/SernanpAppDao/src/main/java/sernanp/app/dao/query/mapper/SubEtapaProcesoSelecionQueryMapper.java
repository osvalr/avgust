package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQuery; 
import sernanp.app.dao.query.domain.SubEtapaProcesoSelecionQueryCriteria; 

public interface SubEtapaProcesoSelecionQueryMapper { 
   List<SubEtapaProcesoSelecionQuery> getListQueryByCriteria(SubEtapaProcesoSelecionQueryCriteria criteria); 
   List<SubEtapaProcesoSelecionQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<SubEtapaProcesoSelecionQuery> getListQueryPaginationByCriteria(SubEtapaProcesoSelecionQueryCriteria criteria, RowBounds rowBounds); 
   List<SubEtapaProcesoSelecionQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(SubEtapaProcesoSelecionQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
