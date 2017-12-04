package sernanp.rrhh.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalLicenciasDAO;
import sernanp.rrhh.vo.PersonalLicenciasVO;

public class PersonalLicenciasService {
	
	@Autowired
	private PersonalLicenciasDAO personalLicenciasDAO;
	
	
	public List<PersonalLicenciasVO> listaLicenciasxidPersonal(int idPersonal){
		return personalLicenciasDAO.listaLicenciasxidPersonal(idPersonal);
	}
	
	
//	public void insertarLicenciasPersonal(PersonalLicenciasVO vo, int intEstado){
//		personalLicenciasDAO.insertarLicenciasPersonal(vo,intEstado);
//	}
	
	public void insertarLicenciasPersonal(PersonalLicenciasVO vo){
		personalLicenciasDAO.insertarLicenciasPersonal(vo);
	}
	
	
	public void cerrarLicenciasPersonal(int IdLicencia){
		personalLicenciasDAO.cerrarLicenciasPersonal(IdLicencia);
	}

	
	public void eliminarLicenciasPersonal(int IdLicencia, int idPersonal, Date f_inicioLic, Date f_finLic){
		personalLicenciasDAO.eliminarLicenciasPersonal(IdLicencia, idPersonal, f_inicioLic, f_finLic);
	}
	
	public int licenciasRangoFechas(int idPersonal, Date finicio, Date ffin){
		
		return personalLicenciasDAO.licenciasRangoFechas(idPersonal, finicio, ffin);
	}

}
