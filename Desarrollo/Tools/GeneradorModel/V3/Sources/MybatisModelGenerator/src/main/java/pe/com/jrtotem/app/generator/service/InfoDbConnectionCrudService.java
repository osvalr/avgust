package pe.com.jrtotem.app.generator.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnection;
import pe.com.jrtotem.app.generator.mybatis.domain.InfoDbConnectionExample;
import pe.com.jrtotem.app.generator.mybatis.mapper.InfoDbConnectionMapper;
import pe.com.jrtotem.app.generator.util.MybatisRepositoryHelper;

@Service
public class InfoDbConnectionCrudService extends MybatisRepositoryHelper implements IInfoDbConnectionCrudService {

	@Transactional
	@Override
	public Integer create(InfoDbConnection infoDbConnection) throws Exception {
		
		InfoDbConnectionExample example = new InfoDbConnectionExample();
		example.createCriteria().andNameEqualTo(infoDbConnection.getName());
		
		List<InfoDbConnection> list = this.selectByExample(InfoDbConnectionMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.insertSelective(InfoDbConnectionMapper.class, infoDbConnection);
		Integer lastId = infoDbConnection.getId_info_db_connection();
		return lastId;
	}

	@Transactional
	@Override
	public void save(InfoDbConnection infoDbConnection) throws Exception {
		
		InfoDbConnectionExample example = new InfoDbConnectionExample();
		example.createCriteria().andNameEqualTo(infoDbConnection.getName()).andId_info_db_connectionNotEqualTo(infoDbConnection.getId_info_db_connection());
		
		List<InfoDbConnection> list = this.selectByExample(InfoDbConnectionMapper.class, example);
		
		if(!list.isEmpty()){
			throw new Exception("There is already a record with the entered name.");
		}
		
		this.updateByPrimaryKeySelective(InfoDbConnectionMapper.class, infoDbConnection);
	}

	@Transactional
	@Override
	public void remove(InfoDbConnection infoDbConnection) throws Exception {
		this.deleteByPrimaryKey(InfoDbConnectionMapper.class, infoDbConnection);
	}

	@Override
	public List<InfoDbConnection> list(InfoDbConnectionExample example) throws Exception {
		List<InfoDbConnection> list = this.selectByExample(InfoDbConnectionMapper.class, example);
		return list;
	}

}
