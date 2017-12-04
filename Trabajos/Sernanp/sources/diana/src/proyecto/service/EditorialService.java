package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.EditorialDAO;
import proyecto.dao.RecursoInformacionEditorialDAO;
import proyecto.vo.Editorial;
@Service
public class EditorialService {

	@Autowired
	private EditorialDAO editorialDAO;
	private RecursoInformacionEditorialDAO recursoInformacionEditorialDAO;

	
	
	public void setEditorialDAO(EditorialDAO editorialDAO) {
		this.editorialDAO = editorialDAO;
	}


	public void setRecursoInformacionEditorialDAO(
			RecursoInformacionEditorialDAO recursoInformacionEditorialDAO) {
		this.recursoInformacionEditorialDAO = recursoInformacionEditorialDAO;
	}


	public int guardarEditorial(Editorial editorial){
		int codigo=0;
		if(editorial.getIdeditorial()==0){
			codigo=editorialDAO.insertar(editorial);
		}
		else{
			//actualiza
		}
		return codigo;
	}
	

	
	public List<Editorial>  consultarEditoriales(Editorial editorial)  {
	    return editorialDAO.listar(editorial);
	
    }



	
	
	
}
