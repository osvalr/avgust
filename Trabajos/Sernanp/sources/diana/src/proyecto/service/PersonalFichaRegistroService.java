package proyecto.service;

import java.util.List;

import proyecto.dao.PersonalFichaRegistroDAO;
import proyecto.vo.FichaRegistro;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;

public class PersonalFichaRegistroService {

	private PersonalFichaRegistroDAO personalficharegistroDAO;

	public void setPersonalficharegistroDAO(
			PersonalFichaRegistroDAO personalficharegistroDAO) {
		this.personalficharegistroDAO = personalficharegistroDAO;
	}
	
	public void consolidarFicha(List<PersonalFichaRegistro> lpfr){
		this.personalficharegistroDAO.consolidarFicha(lpfr);
	}
	
	public void datosConsolidado(FichaRegistro fr ,PersonalRegistro pr){
		PersonalFichaRegistro pfr = new PersonalFichaRegistro();
		
		pfr = personalficharegistroDAO.datosConsolidado(fr, pr).get(0);
		
		pr.setHoraingreso(pfr.getHoraingreso());
		pr.setFechasalida(pfr.getFechasalida());
		pr.setHorasalida(pfr.getHorasalida());
		pr.setIdestado(pfr.getIdestado());
		
	}
}
