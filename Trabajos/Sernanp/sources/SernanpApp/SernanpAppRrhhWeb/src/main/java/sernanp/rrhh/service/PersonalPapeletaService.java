package sernanp.rrhh.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sernanp.rrhh.dao.PersonalPapeletaDAO;
import sernanp.rrhh.vo.PersonalDesplazamientoVO;

public class PersonalPapeletaService {
	
	@Autowired
	private PersonalPapeletaDAO personalPapeletaDAO;
	
	
	
	
	public int verificaexistePermisoComision(int idPersonal, String fechaPC){
		return personalPapeletaDAO.verificaexistePermisoComision(idPersonal, fechaPC);
	}

		
	public void guardarPapeleta(PersonalDesplazamientoVO vo, int actividad){
		personalPapeletaDAO.guardarPapeleta(vo,actividad);
		
	}
	
	
	public int verificaexistePermiso(int idPersonal, String fechaPC){
		return personalPapeletaDAO.verificaexistePermiso(idPersonal, fechaPC);
	}
	
	
	public void guardarPapeleta(PersonalDesplazamientoVO vo){
		personalPapeletaDAO.guardarPapeleta(vo);
		
	}
	
	public List<PersonalDesplazamientoVO> listapapeletaxidP (int idPersonal, int periodo){
		return personalPapeletaDAO.listapapeletaxidP(idPersonal, periodo);
	}

	public PersonalDesplazamientoVO papeletaxid(int idPapeleta){
		return personalPapeletaDAO.papeletaxidP(idPapeleta).get(0);
	}
	
	
	public void eliminarPapeletaMarcacion(int idPapeleta, int idPersonal, String fecha, int idMarcacion){
		personalPapeletaDAO.eliminarPapeletaMarcacion(idPapeleta, idPersonal, fecha, idMarcacion);
	}
	
	public void eliminarPapeleta(int idPersonal, int idPapeleta, Date fecha_ini, Date fecha_fin, int idMarcacion){
		personalPapeletaDAO.eliminarPapeleta(idPersonal, idPapeleta, fecha_ini, fecha_fin, idMarcacion);
	}
	

	public int cantPapeletaxidPersonalFecha(int idP, Date fechaInic, Date fechFinPap){
		return personalPapeletaDAO.cantPapeletaxidPersonalFecha(idP, fechaInic, fechFinPap);
	}
	
	
	public int cantPermisosxidPersonalFecha(int idPersonal, Date fechaInic, Date fechFinPap){
		return personalPapeletaDAO.cantPermisosxidPersonalFecha(idPersonal, fechaInic, fechFinPap);
	}
}
