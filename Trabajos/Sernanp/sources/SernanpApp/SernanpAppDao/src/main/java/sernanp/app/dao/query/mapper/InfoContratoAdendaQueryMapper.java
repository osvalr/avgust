package sernanp.app.dao.query.mapper; 

import java.util.List;

import sernanp.app.dao.query.domain.InfoContratoAdendaQuery;
import sernanp.app.dao.query.domain.InfoContratoAdendaQueryCriteria;

public interface InfoContratoAdendaQueryMapper { 
   List<InfoContratoAdendaQuery> getListQuery(InfoContratoAdendaQueryCriteria criteria); 
} 
