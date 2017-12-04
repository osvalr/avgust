package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.PostulanteGanadorQuery;
import sernanp.app.dao.query.domain.PostulanteGanadorQueryCriteria;

public interface PostulanteGanadorQueryMapper { 
   List<PostulanteGanadorQuery> getListQuery(PostulanteGanadorQueryCriteria criteria); 
} 
