package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.EditorialDAO;
import proyecto.dao.RecursoInformacionEditorialDAO;
import proyecto.dao.TemaDAO;
import proyecto.vo.Editorial;
import proyecto.vo.Tema;
@Service
public class TemaService {

	@Autowired
	private TemaDAO temaDAO;
	

	
	
	



	public void setTemaDAO(TemaDAO temaDAO) {
		this.temaDAO = temaDAO;
	}



	
	

	
	public List<Tema>  consultarTemas(Tema tema)  {
	    return temaDAO.listar(tema);
	
    }



	public int guardarTema(Tema tema){
		return temaDAO.insertar(tema);
	}
	
	
	
}
