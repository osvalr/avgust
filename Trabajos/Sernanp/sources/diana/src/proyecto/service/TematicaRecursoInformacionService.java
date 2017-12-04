package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.TematicaRecursoInformacionDAO;
import proyecto.vo.TematicaRecursoInformacion;
@Service
public class TematicaRecursoInformacionService {

	@Autowired
	private TematicaRecursoInformacionDAO tematicaRecursoInformacionDAO;
	

	
	
	



	
	



	
	

	


	public void setTematicaRecursoInformacionDAO(
			TematicaRecursoInformacionDAO tematicaRecursoInformacionDAO) {
		this.tematicaRecursoInformacionDAO = tematicaRecursoInformacionDAO;
	}



















	public List<TematicaRecursoInformacion>  listarTematicas()  {
	    return tematicaRecursoInformacionDAO.listar(new TematicaRecursoInformacion());
	
    }



	
	
	
}
