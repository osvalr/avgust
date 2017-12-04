package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpNominaCASMesAnioFuenteMetaQuery; 
import sernanp.app.dao.query.domain.RpNominaCASMesAnioFuenteMetaQueryCriteria; 

public interface RpNominaCASMesAnioFuenteMetaQueryMapper { 
   List<RpNominaCASMesAnioFuenteMetaQuery> getListQueryByCriteria(RpNominaCASMesAnioFuenteMetaQueryCriteria criteria); 
   List<RpNominaCASMesAnioFuenteMetaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpNominaCASMesAnioFuenteMetaQuery> getListQueryPaginationByCriteria(RpNominaCASMesAnioFuenteMetaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpNominaCASMesAnioFuenteMetaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpNominaCASMesAnioFuenteMetaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
