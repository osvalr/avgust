package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.IdiomaDAO;
import proyecto.vo.Idioma;
@Service
public class IdiomaService {
	
	@Autowired
	private IdiomaDAO idiomaDAO;

	
	
	
	
	public List<Idioma> listarIdiomas(){
		return idiomaDAO.listar(new Idioma());
	}
	

}
