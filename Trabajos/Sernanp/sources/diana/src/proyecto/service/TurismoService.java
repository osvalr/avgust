package proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.dao.TurismoDAO;
import proyecto.vo.Turismo;

@Service
public class TurismoService {
	
	@Autowired
	private TurismoDAO turismoDAO;
	
	
	public int consultarIdTurismoxIdAreanatural(int idareanatural){
		int idturismo=0;
		Turismo tur=new Turismo();
		tur.setIdareanatural(idareanatural);
		List<Turismo> lista=turismoDAO.listar(tur);
		if(lista.size()==1){
			idturismo=lista.get(0).getIdturismo();
		}
		return idturismo;
		
	}
	
	public List<Turismo> listarAreasNaturalesConTurismo(){
		return turismoDAO.listar(new Turismo());
	}

	public List<Turismo> consultarAreaNaturalConTurismoxNombreAnp(String desareanatural){
		Turismo turismo=new Turismo();
		turismo.setDesareanatural(desareanatural);
		return consultarAreaNaturalConTurismo(turismo);
	}
	public List<Turismo> consultarAreaNaturalConTurismo(Turismo turismo){
		return turismoDAO.listar(turismo);
	}
	 
}
