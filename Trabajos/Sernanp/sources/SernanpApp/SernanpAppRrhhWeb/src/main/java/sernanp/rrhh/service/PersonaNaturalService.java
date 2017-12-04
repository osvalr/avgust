package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.dao.PersonaNaturalDAO;
import sernanp.rrhh.vo.Personanatural;
@Service
public class PersonaNaturalService {
	
	@Autowired
    private PersonaNaturalDAO personaNaturalDAO;

	
	public List<Personanatural> listarPersonal(){
		
		return personaNaturalDAO.listarPersonal();
	}		

}

