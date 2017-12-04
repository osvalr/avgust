package sernanp.app.dao.query.mapper; 

import java.util.List; 
import sernanp.app.dao.query.domain.InfoResponsableSernanp; 
import sernanp.app.dao.query.domain.InfoResponsableSernanpCriteria; 

public interface InfoResponsableSernanpMapper { 
   List<InfoResponsableSernanp> getListQuery(InfoResponsableSernanpCriteria criteria); 
} 
