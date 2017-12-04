package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.PaisDAO;
import proyecto.vo.Pais;


@Service
public class PaisService {
	
	@Autowired
	private PaisDAO paisDAO; 
	
	public List<Pais> listar() {
		return paisDAO.listar(new Pais());  
	}

}
