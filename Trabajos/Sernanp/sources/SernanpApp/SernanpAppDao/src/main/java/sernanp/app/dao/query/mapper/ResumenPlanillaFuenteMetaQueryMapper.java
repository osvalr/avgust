package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.ResumenPlanillaFuenteMetaQuery; 
import sernanp.app.dao.query.domain.ResumenPlanillaFuenteMetaQueryCriteria; 

public interface ResumenPlanillaFuenteMetaQueryMapper { 
   List<ResumenPlanillaFuenteMetaQuery> getListQueryByCriteria(ResumenPlanillaFuenteMetaQueryCriteria criteria); 
   List<ResumenPlanillaFuenteMetaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<ResumenPlanillaFuenteMetaQuery> getListQueryPaginationByCriteria(ResumenPlanillaFuenteMetaQueryCriteria criteria, RowBounds rowBounds); 
   List<ResumenPlanillaFuenteMetaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(ResumenPlanillaFuenteMetaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
