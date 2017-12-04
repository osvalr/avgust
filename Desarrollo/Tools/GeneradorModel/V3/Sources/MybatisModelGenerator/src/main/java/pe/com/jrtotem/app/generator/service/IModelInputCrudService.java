package pe.com.jrtotem.app.generator.service;

import java.util.List;

import pe.com.jrtotem.app.generator.dto.ModelInputDto;
import pe.com.jrtotem.app.generator.mybatis.domain.ModelInputExample;
import pe.com.jrtotem.app.generator.mybatis.domain.SubModelInput;
import pe.com.jrtotem.app.generator.util.IMybatisRepositoryHelper;

public interface IModelInputCrudService extends IMybatisRepositoryHelper {
	Integer create(ModelInputDto model) throws Exception;
	void save(ModelInputDto model) throws Exception;
	void remove(ModelInputDto model) throws Exception;
	List<ModelInputDto> list(ModelInputExample example) throws Exception;	
	void createChild(SubModelInput subModelInput) throws Exception;
	void saveChild(SubModelInput subModelInput) throws Exception;
	void removeChild(SubModelInput subModelInput) throws Exception;
}
