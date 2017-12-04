package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.ActividadTurismoDAO;
import proyecto.dao.TipoturismoDAO;
import proyecto.vo.Actividadturismo;
import proyecto.vo.Rutaturismo;
import proyecto.vo.Tipoturismo;

@Service
public class TipoTurismoService {
	
	@Autowired
	private TipoturismoDAO tipoturismoDAO;  
	@Autowired
	private ActividadTurismoDAO actividadTurismoDAO;
	
	public List<Tipoturismo> listar() {   
		return this.tipoturismoDAO.listar();   
	}  

	public List<Tipoturismo> listar( int idarea) {   
		return this.tipoturismoDAO.listar(idarea);    
	}  
	
	public List<Tipoturismo>listarxRuta(int idrutaturismo ){
		return this.tipoturismoDAO.listarxRuta(idrutaturismo);
	}
	 
	
	public List<Tipoturismo>listarTipoTurismoxRuta(int idrutaturismo ){
		Rutaturismo rt=new Rutaturismo();
		rt.setIdrutaturismo(idrutaturismo);
		return this.tipoturismoDAO.listarTipoturismoxRutaturismo(rt);
	}
	
	public List<Tipoturismo>listarTipoTurismo(){
		List<Tipoturismo> lista=tipoturismoDAO.listarTipoturismo(new Tipoturismo());
		for(Tipoturismo t:lista){
			Actividadturismo at=new Actividadturismo();
			at.getTipoturismo().setIdtipoturismo(t.getIdtipoturismo());
			t.setListaActividadturismo(actividadTurismoDAO.listar(at));
		}
		return lista;
	} 
	
	

}
