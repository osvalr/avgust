package sernanp.rrhh.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalVacacionesDAO;
import sernanp.rrhh.vo.PersonalVacacionesGoceVO;
import sernanp.rrhh.vo.PersonalVacacionesVO;

public class PersonalVacacionesService {
	
	@Autowired
	private PersonalVacacionesDAO personalVacacionesDAO;
	
	
	
	//05-06-2014: D.V.R
	
	public void setPersonalVacacionesDAO(PersonalVacacionesDAO personalVacacionesDAO) {
		this.personalVacacionesDAO = personalVacacionesDAO;
	}

//	public List<PersonalVacacionesVO> listapersonalVacacionesProyecto(String lastdayofyear, String nowdayofyear, String apepat, int periodo){
//		
//		return personalVacacionesDAO.listapersonalVacacionesProyecto(lastdayofyear, nowdayofyear, apepat, periodo);
//	}
	
	public List<PersonalVacacionesVO> listapersonalVacacionesProyecto(String apepat, int periodo, int idregcontractual, int ubicacion, int idANP, int estadoP){
		
		return personalVacacionesDAO.listapersonalVacacionesProyecto(apepat, periodo, idregcontractual, ubicacion, idANP, estadoP);
	}
	
	
	public List<PersonalVacacionesVO> listaPeriodosVacaciones( int periodo){
		return personalVacacionesDAO.listaPeriodosVacaciones(periodo);
	}
	

	public List<PersonalVacacionesGoceVO> listaVacacionesxidpersonal(int idPersonal, int periodo){
		
		return personalVacacionesDAO.listaVacacionesxidpersonal(idPersonal, periodo);
	}
	
	public int tieneVacacionesconGoce(int idPersonal, int periodo){
		
		return personalVacacionesDAO.tieneVacacionesconGoce(idPersonal, periodo);
	}	
	

//	public int obtienePeriodoVacacionesPendientes(int idPersonal){
//		
//		return personalVacacionesDAO.obtienePeriodoVacacionesPendientes(idPersonal);
//	}	
//	

	public List<PersonalVacacionesVO> obtieneVacacionesAutorizadasxidP(int idPersonal){
		
		return personalVacacionesDAO.obtieneVacacionesAutorizadasxidP(idPersonal);
	}
	
	
	public List<PersonalVacacionesVO> vacacionesPendientesxidPersonal(int idPersonal, int periodo){
		
		return personalVacacionesDAO.vacacionesPendientesxidPersonal(idPersonal, periodo);
	}	
	
	
	
	public int vacacionesPendientesxPeriodoxidPersonal(int idPersonal, int periodo){
		
		return personalVacacionesDAO.vacacionesPendientesxPeriodoxidPersonal(idPersonal, periodo);
	}	
	
	
	public void insertarVacacionesPersonal(PersonalVacacionesGoceVO vo, int idPersonal){
		personalVacacionesDAO.insertarVacacionesPersonal(vo, idPersonal);
	}
	
	public PersonalVacacionesGoceVO obtenerVacacionesProgramadaxid(int id){
		return personalVacacionesDAO.obtenerVacacionesProgramadaxid(id).get(0);
	}
	
	public void updateVacacionesPersonal(PersonalVacacionesGoceVO vo, int idVacaciones, int idVacacionesGoce, int idPersonal){
		personalVacacionesDAO.updateVacacionesPersonal(vo, idVacaciones, idVacacionesGoce, idPersonal);
	}
	
	
	/*		SE HA DEJADO DE UTILIZAR A SOLICITUD DEL USUARIO (REUNION: 11-07-2014)	
	public void updateFechIniVacacionesPersonal(PersonalVacacionesVO vo){
		personalVacacionesDAO.updateFechIniVacacionesPersonal(vo);
	}*/	
	
	/*		SE HA DEJADO DE UTILIZAR A SOLICITUD DEL USUARIO (REUNION: 11-07-2014)
	public int autorizarVacacionesxPeriodo(int periodo, String f_aprobVac){
		return personalVacacionesDAO.autorizarVacacionesxPeriodo(periodo, f_aprobVac);
	}*/		
	
	public int vacacionesRangoFechas(int idPersonal, Date finicio, Date ffin){
		
		return personalVacacionesDAO.vacacionesRangoFechas(idPersonal, finicio, ffin);
	}
	
	public int vacacionesRangoFecha(int idPersonal, Date finicio, Date ffin){
		
		return personalVacacionesDAO.vacacionesRangoFecha(idPersonal, finicio, ffin);
	}
	
	
	public void eliminarVacacionesProgramada (int idp, int periodo, int idVacaciones, int idVacacionesProg){
		personalVacacionesDAO.eliminarVacacionesProgramada(idp, periodo, idVacaciones, idVacacionesProg);
	}
	
	
}
