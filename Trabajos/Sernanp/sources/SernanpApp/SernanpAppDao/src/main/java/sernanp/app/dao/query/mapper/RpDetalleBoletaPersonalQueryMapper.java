package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDetalleBoletaPersonalQuery; 
import sernanp.app.dao.query.domain.RpDetalleBoletaPersonalQueryCriteria; 

public interface RpDetalleBoletaPersonalQueryMapper { 
   List<RpDetalleBoletaPersonalQuery> getListQueryByCriteria(RpDetalleBoletaPersonalQueryCriteria criteria); 
   List<RpDetalleBoletaPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDetalleBoletaPersonalQuery> getListQueryPaginationByCriteria(RpDetalleBoletaPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDetalleBoletaPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDetalleBoletaPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
