package pe.com.acme.muanker.business.implement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.acme.domain.mybatis.mapper.MembInfoMapper;
import pe.com.acme.domain.mybatis.model.MembInfo;
import pe.com.acme.domain.mybatis.model.MembInfoExample;
import pe.com.acme.muanker.business.service.AutenticacionService;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class AutenticacionServiceImpl extends MybatisRepositoryHelper implements AutenticacionService{
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public boolean logIn(String user, String password) throws Exception {
		
		MembInfoExample example = new MembInfoExample();
		example.createCriteria().andMemb___idEqualTo(user);
		
		MembInfo membInfo = this.selectOneByExample(MembInfoMapper.class, example);
		
		if(membInfo != null){
			
			if(membInfo.getMemb__pwd().equals(password)){
				
				return true;
				
			}else{
				return false;
			}
			
		}else{
			
			return false;
			
		}
		
	}

}
