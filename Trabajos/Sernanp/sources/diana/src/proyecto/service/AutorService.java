package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.AutorDAO;
import proyecto.vo.Autor;
@Service
public class AutorService {

	@Autowired
	private AutorDAO autorDAO;
	
	
	
	


	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}


	

	public int guardarAutor(Autor autor){
		int codigo=0;
		if(autor.getIdautor()==0){
			codigo=autorDAO.insertar(autor) ;
		}
		else{
			//actualiza
		}
		return codigo;
	}
	

	
	public List<Autor>  consultarAutores(Autor autor)  {
	    return autorDAO.listarUnico(autor);
	
    }



	
	
	
}
