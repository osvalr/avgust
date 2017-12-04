package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ActividadTurismoDAO;
import proyecto.vo.Actividadturismo;

@Service
public class ActividadTurismoService {

	@Autowired
	private ActividadTurismoDAO actividadTurismoDAO; 
	
	public List<Actividadturismo> listar()  {
		return actividadTurismoDAO.listar();  
	}

	public List<Actividadturismo> listar( int  idarea )  {
		return actividadTurismoDAO.listar( idarea );  
	}
	
	public List<Actividadturismo> listarActividadesxTipoTurismo( int  idtipoturismo )  {
		Actividadturismo at=new Actividadturismo();
		at.getTipoturismo().setIdtipoturismo(idtipoturismo);
		return actividadTurismoDAO.listar(at);  
	}
	
	
	
}
