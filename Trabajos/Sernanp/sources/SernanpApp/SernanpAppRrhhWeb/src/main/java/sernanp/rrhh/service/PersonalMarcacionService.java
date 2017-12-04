package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalMarcacionDAO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;
import sernanp.rrhh.vo.PersonalMarcacionVO;
import sernanp.rrhh.vo.PersonalVO;
import sernanp.rrhh.vo.Personanatural;

public class PersonalMarcacionService {
	@Autowired
	private PersonalMarcacionDAO personalMarcacionDAO;	
	
	
	public void setPersonalMarcacionDAO(PersonalMarcacionDAO personalMarcacionDAO) {
		this.personalMarcacionDAO = personalMarcacionDAO;
	}

	public void guardarListaMarcaciones(List<PersonalMarcacionVO> alLista, int int_flag){
		personalMarcacionDAO.guardarListaMarcacionesData(alLista, int_flag);
	}

	
	public void guardardiasnolaborables(){
		
	}
	
	
	public void guardarMarcacionManual(PersonalMarcacionVO datospmvista, int i, PersonalDesplazamientoVO vop){
		personalMarcacionDAO.guardarMarcacionManual(datospmvista, i, vop);
	}
	
	public void actualizarMarcacionManual(PersonalDesplazamientoVO vop, List<PersonalMarcacionVO> datospmvista, int estadoAsistencia){
		personalMarcacionDAO.actualizarMarcacionManual(vop, datospmvista, estadoAsistencia);
	}	
	
	public List<PersonalVO> Idpersonalxnumerodoc(String nrodoc){
		return personalMarcacionDAO.Idpersonalxnumerodoc(nrodoc);
	}
	

	public List<PersonalMarcacionVO> MarcacionxIdpersonalfechamarc(int idpersonal, String strfechamarc){
		return personalMarcacionDAO.MarcacionxIdpersonalfechamarc(idpersonal, strfechamarc);
	}
	
	
	public List<PersonalMarcacionVO> MarcacionxIdpersonalfechamarchoramarc(int idpersonal, String strfechamarc, String hormarc){
		return personalMarcacionDAO.MarcacionxIdpersonalfechamarchoramarc(idpersonal, strfechamarc,hormarc);
	}
	
	public List<PersonalMarcacionVO> MarcacionxIdpersonalActividadfechamarchoramarc(int idpersonal,int idactividad, String strfechamarc, String strhoramarc){
		return personalMarcacionDAO.MarcacionxIdpersonalActividadfechamarchoramarc(idpersonal,idactividad, strfechamarc, strhoramarc);
	}
	
	
	
	public PersonalMarcacionVO MarcacionxId(int idMarcacion){
		return personalMarcacionDAO.MarcacionxId(idMarcacion).get(0);
	}
	
	
	public List<PersonalMarcacionVO> MarcacionxIdPapeleta(int idPapeleta){
		return personalMarcacionDAO.MarcacionxIdPapeleta(idPapeleta);
	}
	

}
