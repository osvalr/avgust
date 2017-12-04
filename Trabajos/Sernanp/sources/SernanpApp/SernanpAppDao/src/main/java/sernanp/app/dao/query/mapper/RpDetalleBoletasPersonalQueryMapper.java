package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDetalleBoletasPersonalQuery; 
import sernanp.app.dao.query.domain.RpDetalleBoletasPersonalQueryCriteria; 

public interface RpDetalleBoletasPersonalQueryMapper { 
   List<RpDetalleBoletasPersonalQuery> getListQueryByCriteria(RpDetalleBoletasPersonalQueryCriteria criteria); 
   List<RpDetalleBoletasPersonalQuery> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDetalleBoletasPersonalQuery> getListQueryPaginationByCriteria(RpDetalleBoletasPersonalQueryCriteria criteria, RowBounds rowBounds); 
   List<RpDetalleBoletasPersonalQuery> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDetalleBoletasPersonalQueryCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
