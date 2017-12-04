package pe.com.acme.muanker.business.service;

import pe.com.acme.util.IMybatisRepositoryHelper;

public interface AutenticacionService extends IMybatisRepositoryHelper {
	boolean logIn(String user, String password) throws Exception;
}
