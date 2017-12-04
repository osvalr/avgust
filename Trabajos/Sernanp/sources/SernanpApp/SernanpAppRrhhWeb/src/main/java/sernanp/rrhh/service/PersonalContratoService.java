package sernanp.rrhh.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalContratoDAO;
import sernanp.rrhh.vo.PersonalContratoVO;

public class PersonalContratoService {
	@Autowired
	private PersonalContratoDAO personalContratoDAO;

	public void setPersonacontratoDAO(PersonalContratoDAO personacontratoDAO) {
		this.personalContratoDAO = personacontratoDAO;
	}
	
	public boolean verificaDiferenciaFechaContrato(int idpersonal, Date fechaic){
		
		return personalContratoDAO.verificaDiferenciaFechaContrato(idpersonal, fechaic);
	}
	
	
	public List<PersonalContratoVO> listacontratoxidpersonal(int idPersonalContrato){
		
		return personalContratoDAO.listacontratoxidpersonal(idPersonalContrato);
	}
	
	
}
