package pe.com.jrtotem.app.generator.service;

import java.util.List;

import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.util.IMybatisRepositoryHelper;

public interface IBuildSettingCrudService extends IMybatisRepositoryHelper {
	
	Integer create(BuildSetting model) throws Exception;
	void save(BuildSetting model) throws Exception;
	void remove(BuildSetting model) throws Exception;
	List<BuildSetting> list(BuildSettingExample example) throws Exception;

}
