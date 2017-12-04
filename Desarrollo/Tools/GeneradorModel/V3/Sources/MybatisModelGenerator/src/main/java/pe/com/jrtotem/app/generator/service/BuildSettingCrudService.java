package pe.com.jrtotem.app.generator.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jrtotem.app.generator.mybatis.domain.BuildSetting;
import pe.com.jrtotem.app.generator.mybatis.domain.BuildSettingExample;
import pe.com.jrtotem.app.generator.mybatis.mapper.BuildSettingMapper;
import pe.com.jrtotem.app.generator.util.MybatisRepositoryHelper;

@Service
public class BuildSettingCrudService extends MybatisRepositoryHelper implements IBuildSettingCrudService {

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public Integer create(BuildSetting model) throws Exception {
		
		BuildSettingExample example = new BuildSettingExample();
		example.createCriteria().andName_settingEqualTo(model.getName_setting());
		
		List<BuildSetting> list = this.selectByExample(BuildSettingMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.insertSelective(BuildSettingMapper.class, model);
		Integer lastId = model.getId_build_setting();
		return lastId;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void save(BuildSetting model) throws Exception {
		
		BuildSettingExample example = new BuildSettingExample();
		example.createCriteria().andName_settingEqualTo(model.getName_setting()).andId_build_settingNotEqualTo(model.getId_build_setting());
		
		List<BuildSetting> list = this.selectByExample(BuildSettingMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.updateByPrimaryKeySelective(BuildSettingMapper.class, model);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public void remove(BuildSetting model) throws Exception {
		this.deleteByPrimaryKey(BuildSettingMapper.class, model);
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public List<BuildSetting> list(BuildSettingExample example) throws Exception {
		List<BuildSetting> list = this.selectByExample(BuildSettingMapper.class, example);
		return list;
	}

}
