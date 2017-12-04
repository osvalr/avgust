package pe.com.focus.generator.crud.extjs.mybatis.mapper; 

import java.util.List;

import pe.com.focus.generator.crud.extjs.mybatis.model.InfoColumnsMysqlQuery;
import pe.com.focus.generator.crud.extjs.mybatis.model.InfoColumnsMysqlQueryCriteria;

public interface InfoColumnsMysqlQueryMapper { 
   List<InfoColumnsMysqlQuery> getListQuery(InfoColumnsMysqlQueryCriteria criteria); 
   List<InfoColumnsMysqlQuery> getListQueryPostgres(InfoColumnsMysqlQueryCriteria criteria);
} 
