package proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.PersonaDAO;
import proyecto.vo.Persona;
import proyecto.vo.Usuario;
@Service
public class PersonaService {

	@Autowired
	private PersonaDAO personaDAO;
	
	
	
	public boolean validarRucUnico(Persona persona){
		boolean rpta=true;
		if(personaDAO.contarUnico(persona)!=0){
			rpta =false;
		}
		return rpta;
	}
	
	
	
	
	
	
	
	

}
