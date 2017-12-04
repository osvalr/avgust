package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.dao.LoginDAO;
import sernanp.rrhh.vo.LoginVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	
	public List<LoginVO> buscarClave(LoginVO loginVO) throws Exception {
		return loginDAO.buscarClave(loginVO);
	}
	
}
