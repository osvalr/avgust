package sernanp.app.dao.query.mapper; 

import java.util.List; 
import java.util.Map; 
import org.apache.ibatis.session.RowBounds; 
import sernanp.app.dao.query.domain.RpDetalleBoletaPersonal; 
import sernanp.app.dao.query.domain.RpDetalleBoletaPersonalCriteria; 

public interface RpDetalleBoletaPersonalMapper { 
   List<RpDetalleBoletaPersonal> getListQueryByCriteria(RpDetalleBoletaPersonalCriteria criteria); 
   List<RpDetalleBoletaPersonal> getListQueryByMap(Map<String, Object> paramMap); 
   List<RpDetalleBoletaPersonal> getListQueryPaginationByCriteria(RpDetalleBoletaPersonalCriteria criteria, RowBounds rowBounds); 
   List<RpDetalleBoletaPersonal> getListQueryPaginationByMap(Map<String, Object> paramMap, RowBounds rowBounds); 
   int getCountRowsByCriteria(RpDetalleBoletaPersonalCriteria criteria); 
   int getCountRowsByMap(Map<String, Object> paramMap); 
} 
