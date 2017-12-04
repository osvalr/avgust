package sernanp.rrhh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.dao.PaisDAO;
import sernanp.rrhh.vo.Pais;


@Service
public class PaisService {
	
	@Autowired
	private PaisDAO paisDAO; 
	
	public List<Pais> listar() {
		return paisDAO.listar(new Pais());  
	}
	
	/*
	public List<Pais> listarEncontradosxANP(int idanp){
		
		return paisDAO.listarEncontradosxANP(idanp);
	}
*/
}
