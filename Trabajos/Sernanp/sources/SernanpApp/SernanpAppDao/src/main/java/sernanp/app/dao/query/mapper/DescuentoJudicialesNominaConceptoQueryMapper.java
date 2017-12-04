package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.DescuentoJudicialesNominaConceptoQuery; 
import sernanp.app.dao.query.domain.DescuentoJudicialesNominaConceptoQueryCriteria; 

public interface DescuentoJudicialesNominaConceptoQueryMapper { 
   List<DescuentoJudicialesNominaConceptoQuery> getListQueryByCriteria(DescuentoJudicialesNominaConceptoQueryCriteria criteria); 
   List<DescuentoJudicialesNominaConceptoQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<DescuentoJudicialesNominaConceptoQuery> getListQueryPaginationByCriteria(DescuentoJudicialesNominaConceptoQueryCriteria criteria, RowBounds rowBounds); 
   List<DescuentoJudicialesNominaConceptoQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(DescuentoJudicialesNominaConceptoQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
