package pe.com.acme.seguridad.business.implement;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.acme.domain.mybatis.mapper.LogInHistoricoMapper;
import pe.com.acme.domain.mybatis.mapper.UsuarioMapper;
import pe.com.acme.domain.mybatis.model.LogInHistorico;
import pe.com.acme.domain.mybatis.model.LogInHistoricoExample;
import pe.com.acme.domain.mybatis.model.Usuario;
import pe.com.acme.domain.mybatis.model.UsuarioExample;
import pe.com.acme.seguridad.business.dto.SessionStatusDto;
import pe.com.acme.seguridad.business.service.AutenticacionService;
import pe.com.acme.util.MybatisRepositoryHelper;

@Service
public class AutenticacionServiceImpl extends MybatisRepositoryHelper implements AutenticacionService{
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public SessionStatusDto logIn(String user, String password, String userAgent, String remoteAddr) throws Exception {
		
		SessionStatusDto sessionStatusDto;
		
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andNombre_usuarioEqualTo(user);
		
		Usuario usuario = this.selectOneByExample(UsuarioMapper.class, example);
		
		if(usuario != null){
			
			if(usuario.getClave_usuario().equals(password)){
				LogInHistorico logInHistorico = new LogInHistorico();
				logInHistorico.setId_usuario(usuario.getId_usuario());
				logInHistorico.setId_session(this.nextSessionId());
				logInHistorico.setUser_agent(userAgent);
				logInHistorico.setRemote_addr(remoteAddr);
				logInHistorico.setId_estado(new Short("1"));
				logInHistorico.setId_usuario_reg(usuario.getId_usuario());
				logInHistorico.setId_usuario_mod(usuario.getId_usuario());
				logInHistorico.setFecha_registro(new Date());
				logInHistorico.setFecha_modificacion(new Date());
				
				this.insertSelective(LogInHistoricoMapper.class, logInHistorico);
				
				sessionStatusDto = new SessionStatusDto();
				sessionStatusDto.setId_usuario(usuario.getId_usuario());
				sessionStatusDto.setId_session(logInHistorico.getId_session());
				sessionStatusDto.setStatusLogin(true);
				
			}else{
				sessionStatusDto = new SessionStatusDto();
				sessionStatusDto.setStatusLogin(false);
				sessionStatusDto.setMessage("Clave incorrecta.");
			}
			
		}else{
			sessionStatusDto = new SessionStatusDto();
			sessionStatusDto.setStatusLogin(false);
			sessionStatusDto.setMessage("El Usuario no existe.");
		}
		
		return sessionStatusDto;
	}

	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public boolean logOut(String idSession, String userAgent, String remoteAddr) throws Exception {
		
		if(this.checkLogIn(idSession, userAgent, remoteAddr)){
			
			LogInHistoricoExample example = new LogInHistoricoExample();
			example.createCriteria().andId_sessionEqualTo(idSession);
			
			LogInHistorico logInHistorico = this.selectOneByExample(LogInHistoricoMapper.class, example);
			
			logInHistorico.setId_estado(new Short("2"));
			
			this.updateByPrimaryKeySelective(LogInHistoricoMapper.class, logInHistorico);
			
			return true;
			
		}else{
			return false;
		}
		
	}

	@Override
	public boolean checkLogIn(String idSession, String userAgent, String remoteAddr) throws Exception {
		
		LogInHistoricoExample example = new LogInHistoricoExample();
		example.createCriteria().andId_sessionEqualTo(idSession).andUser_agentEqualTo(userAgent).andRemote_addrEqualTo(remoteAddr).andId_estadoEqualTo(new Short("1"));
		
		LogInHistorico logInHistorico = this.selectOneByExample(LogInHistoricoMapper.class, example);
		
		if(logInHistorico != null){
			return true;
		}
		
		return false;
	}
	
	@Transactional(rollbackForClassName = {"Exception"})
	@Override
	public boolean setData(String idSession, String userAgent, String remoteAddr, Integer id_aplicacion, Integer id_rol) throws Exception {
		if(this.checkLogIn(idSession, userAgent, remoteAddr)){
			
			LogInHistoricoExample example = new LogInHistoricoExample();
			example.createCriteria().andId_sessionEqualTo(idSession);
			
			LogInHistorico logInHistorico = this.selectOneByExample(LogInHistoricoMapper.class, example);
			
			logInHistorico.setId_aplicacion(id_aplicacion);
			logInHistorico.setId_rol(id_rol);
			
			this.updateByPrimaryKeySelective(LogInHistoricoMapper.class, logInHistorico);
			
			return true;
		}else{
			return false;
		}
	}
	
	public String nextSessionId() {
		SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	 }

}
