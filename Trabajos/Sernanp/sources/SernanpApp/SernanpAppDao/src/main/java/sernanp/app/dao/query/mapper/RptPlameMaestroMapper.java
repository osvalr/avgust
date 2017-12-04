package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RptPlameMaestro; 
import sernanp.app.dao.query.domain.RptPlameMaestroCriteria; 

public interface RptPlameMaestroMapper { 
   List<RptPlameMaestro> getListQueryByCriteria(RptPlameMaestroCriteria criteria); 
   List<RptPlameMaestro> getListQueryByMap(Map<String, Object> paramMap); 
   List<RptPlameMaestro> getListQueryPaginationByCriteria(RptPlameMaestroCriteria criteria, RowBounds rowBounds); 
   List<RptPlameMaestro> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RptPlameMaestroCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
