package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import proyecto.dao.PersonalRegistroDAO;
import proyecto.vo.PersonalFichaRegistro;
import proyecto.vo.PersonalRegistro;

public class PersonalRegistroService {

	@Autowired
	private PersonalRegistroDAO personalregistroDAO;

	public void setPersonalregistroDAO(PersonalRegistroDAO personalregistroDAO) {
		this.personalregistroDAO = personalregistroDAO;
	}
	
	
	public void guardarPersonal(List<PersonalRegistro> pr){
		
		personalregistroDAO.insertar(pr);
	}
	
	public void eliminarPersonal(int idpr){
		
		personalregistroDAO.eliminar(idpr);
	}
	
	public long guardarPersonalinform(PersonalRegistro pr){
		
		return personalregistroDAO.insertarinform(pr);
	}
	
	public void actualizarPersonal(List<PersonalRegistro> pr){
		
		personalregistroDAO.actualizar(pr);
	}
	
	public List<PersonalRegistro> listarPersonalxPJyAN(int idpj, int idanp){
		
		return personalregistroDAO.listarPersonalxPJyAN(idpj, idanp);
	}
	
	public List<PersonalRegistro> listarPersonalxDoc(){
		
		return personalregistroDAO.listarPersonalxDoc();
	}
	
	public List<PersonalRegistro> listarPersonaxNombreCompleto(int idpj, int idanp, PersonalRegistro pr){
		
		return personalregistroDAO.listarPersonaUnicoxAreaNatural(idpj,idanp,pr);
	}
	
	public List<PersonalRegistro> listarPersonalxFicha(int idficharegistro){
		
		return personalregistroDAO.listarPersonalxFicha(idficharegistro);
	}	
	
	public List<PersonalRegistro> listarPersonalRegistroxID(int idpersonalregistro){
		return personalregistroDAO.listarPersonalRegistroxID(idpersonalregistro);
	}
	
	public int listarPersonalxTipoNumdoc(int idtipo, String numdoc, int idpj){
		return personalregistroDAO.listarPersonalxTipoNumdoc(idtipo, numdoc, idpj);
	}
	
	public int listarPersonalxTipoNumdoc(int idtipo, String numdoc, int idpj, int idpr){
		return personalregistroDAO.listarPersonalxTipoNumdoc(idtipo, numdoc, idpr);
	}
	
	public int listarPersonalxID(int idpersonalregistro){
		return personalregistroDAO.listarPersonalxID(idpersonalregistro);
	}
	
}
