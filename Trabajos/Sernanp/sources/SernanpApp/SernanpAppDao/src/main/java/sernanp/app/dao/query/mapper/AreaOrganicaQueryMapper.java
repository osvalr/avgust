package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.AreaOrganicaQuery;
import sernanp.app.dao.query.domain.AreaOrganicaQueryCriteria;

public interface AreaOrganicaQueryMapper { 
   List<AreaOrganicaQuery> getListQuery(AreaOrganicaQueryCriteria criteria); 
} 
