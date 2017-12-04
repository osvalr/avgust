package pe.com.jrtotem.app.generator.service;


import java.util.List;

import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.util.IMybatisRepositoryHelper;

public interface IInfoDbConnectionCrudService extends IMybatisRepositoryHelper {
	Integer create(InfoDbConnection model) throws Exception;
	void save(InfoDbConnection model) throws Exception;
	void remove(InfoDbConnection model) throws Exception;
	List<InfoDbConnection> list(InfoDbConnectionExample example) throws Exception;
}
