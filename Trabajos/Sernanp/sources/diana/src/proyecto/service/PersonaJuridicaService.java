package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.PersonaDAO;
import proyecto.dao.PersonaJuridicaDAO;
import proyecto.dao.TipoDAO;
import proyecto.vo.Personajuridica;
@Service
public class PersonaJuridicaService {

	//@Autowired
	//private TipoDAO tipoDAO;
	@Autowired
    private PersonaJuridicaDAO personaJuridicaDAO;
	//@Autowired
    //private PersonaDAO personaDAO;
	

    
    public Personajuridica listarPersonaJuridica(int idpersonaj){
    	return personaJuridicaDAO.listarPersonaJuridica(idpersonaj).get(0);
    }



	public void setPersonaJuridicaDAO(PersonaJuridicaDAO personaJuridicaDAO) {
		this.personaJuridicaDAO = personaJuridicaDAO;
	}
    
    
    
//    public int guardarInstitucion(Personajuridica personajuridica){
//    	int codigo=0;
//    	if(personajuridica.getIdpersonajuridica()==0){
//    		int codPersona=personaDAO.insertar(personajuridica);
//        	personajuridica.setIdpersona(codPersona);
//        	codigo=personaJuridicaDAO.insertar(personajuridica);
//    	}
//    	else{
//    		//actualizar
//    	}
//    	return codigo;
//    	
//    }
    
    
    
    
    
    
    
    
    
	
	

	
	
	

	
	
	
	

}
