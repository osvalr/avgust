package pe.com.acme.seguridad.business.service;

import pe.com.acme.seguridad.business.dto.SessionStatusDto;
import pe.com.acme.util.IMybatisRepositoryHelper;

public interface AutenticacionService extends IMybatisRepositoryHelper {
	SessionStatusDto logIn(String user, String password, String userAgent, String remoteAddr) throws Exception;
	boolean logOut(String idSession, String userAgent, String remoteAddr) throws Exception;
	boolean setData(String idSession, String userAgent, String remoteAddr, Integer id_aplicacion, Integer id_rol) throws Exception;
	boolean checkLogIn(String idSession, String userAgent, String remoteAddr) throws Exception;
}
