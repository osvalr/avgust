package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import proyecto.dao.EstadoDAO;
import proyecto.vo.Estado;

public class EstadoService {

	private EstadoDAO estadoDAO;

	

	
	


	
	
	
	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}






	public List<Estado>  listarEstadoProyecto()  {
		return estadoDAO.listarEstadoProyecto(new Estado());		
   } 
	



	public List<Estado>  listarEstadoVigencia()  {
		
		    List<Estado> lista=new ArrayList<Estado>();
		    Estado e1=new Estado();
		    e1.setIdestado(1);
		    e1.setNombestado("Vigente");
		    lista.add(e1);
		    Estado e2=new Estado();
		    e2.setIdestado(2);
		    e2.setNombestado("Concluido");
		    lista.add(e2);
			return lista;		
	}
	
	


}
