package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.PersonalDAO;
import proyecto.vo.Personal;
@Service
public class PersonalService {

	@Autowired
	private PersonalDAO personalDAO;
	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}
	
	
	public List<Personal> listarPersonalxNombreCompleto(Personal p){
		
		return personalDAO.listarUnico(p);
	}
	
	
	
	
	
	
	
	
	

}
