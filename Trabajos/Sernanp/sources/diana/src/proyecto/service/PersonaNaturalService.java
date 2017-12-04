package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.PersonaDAO;
import proyecto.dao.PersonaNaturalDAO;
import proyecto.vo.PersonalRegistro;
import proyecto.vo.Personanatural;
@Service
public class PersonaNaturalService {

	@Autowired
    private PersonaDAO personaDAO;
	@Autowired
    private PersonaNaturalDAO personaNaturalDAO;

    
    
    
	public boolean validarNumeroDocumentoUnico(Personanatural personanatural){
		boolean rpta=true;
		if(personaNaturalDAO.contarUnico(personanatural)!=0){
		   rpta=false;
		}
		return rpta;
	
	}
		
	//Agregado (Y.C.B)	
	
	public Personanatural listarPersonaNaturalxID(int idpersona){
		
		return personaNaturalDAO.listarPersonaNaturalxID(idpersona).get(0);
	}

		
}

