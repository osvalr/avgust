package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpNomina728MesAnioFuenteMetaQuery; 
import sernanp.app.dao.query.domain.RpNomina728MesAnioFuenteMetaQueryCriteria; 

public interface RpNomina728MesAnioFuenteMetaQueryMapper { 
   List<RpNomina728MesAnioFuenteMetaQuery> getListQueryByCriteria(RpNomina728MesAnioFuenteMetaQueryCriteria criteria); 
   List<RpNomina728MesAnioFuenteMetaQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpNomina728MesAnioFuenteMetaQuery> getListQueryPaginationByCriteria(RpNomina728MesAnioFuenteMetaQueryCriteria criteria, RowBounds rowBounds); 
   List<RpNomina728MesAnioFuenteMetaQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpNomina728MesAnioFuenteMetaQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
