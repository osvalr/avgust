package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.dao.SeguridadDAO;

@Service
public class SeguridadService {
	@Autowired
	private SeguridadDAO seguridadDAO;
	
	public String generaClave(String strUsuario, Integer intIdSistema, Integer intIdUsuario) {
		return seguridadDAO.generaClave(strUsuario, intIdSistema, intIdUsuario);
	}
}
