package proyecto.service;

import java.util.List;

import proyecto.dao.CategoriaAnpDAO;
import proyecto.dao.ProyectoAreanaturalDAO;
import proyecto.vo.Categoriaanp;

public class CategoriaAnpService {

	private CategoriaAnpDAO categoriaAnpDAO;
	private ProyectoAreanaturalDAO proyectoAreanaturalDAO;
	
	public void setCategoriaAnpDAO(CategoriaAnpDAO categoriaAnpDAO) {
		this.categoriaAnpDAO = categoriaAnpDAO;
	}
	
	public void setProyectoAreanaturalDAO(
			ProyectoAreanaturalDAO proyectoAreanaturalDAO) {
		this.proyectoAreanaturalDAO = proyectoAreanaturalDAO;
	}


	public List<Categoriaanp>  listarCategoriasAnpsActivas()  {
			
		Categoriaanp c=new Categoriaanp();
		
		return categoriaAnpDAO.listar(c);
		
	}
	

	public List<Categoriaanp>  listarCategoriasAnpsActivasConProyectos()  {
		
		Categoriaanp c=new Categoriaanp();
		
		return proyectoAreanaturalDAO.listarProyectoAgrupadoxCategoria(c);
		
	}
	
	// JCEV 24-07-2012
		public List<Categoriaanp>  listarCategoriasAnps()  {
				
		return categoriaAnpDAO.listarCategoriasAnps();
			
		}
	
	
}
