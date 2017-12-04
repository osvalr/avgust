package sernanp.rrhh.service;

import java.util.List;

import sernanp.rrhh.constants.SqlConstants;
import sernanp.rrhh.dao.PersonalAsistenciasDAO;
import sernanp.rrhh.vo.PersonalAsistenciaVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;

public class PersonalAsistenciaService {
	
	private PersonalAsistenciasDAO personalAsistenciaDAO;
	
	/*
	public PersonalAsistenciaService(){
		personalAsistenciaDAO = new PersonalAsistenciasDAO();
	}*/	

	public void setPersonalAsistenciaDAO(PersonalAsistenciasDAO personalAsistenciaDAO) {
		this.personalAsistenciaDAO = personalAsistenciaDAO;
	}


}
