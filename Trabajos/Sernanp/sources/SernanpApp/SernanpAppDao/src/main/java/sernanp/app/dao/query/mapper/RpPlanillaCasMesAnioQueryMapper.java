package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpPlanillaCasMesAnioQuery; 
import sernanp.app.dao.query.domain.RpPlanillaCasMesAnioQueryCriteria; 

public interface RpPlanillaCasMesAnioQueryMapper { 
   List<RpPlanillaCasMesAnioQuery> getListQueryByCriteria(RpPlanillaCasMesAnioQueryCriteria criteria); 
   List<RpPlanillaCasMesAnioQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpPlanillaCasMesAnioQuery> getListQueryPaginationByCriteria(RpPlanillaCasMesAnioQueryCriteria criteria, RowBounds rowBounds); 
   List<RpPlanillaCasMesAnioQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpPlanillaCasMesAnioQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
