package proyecto.service;

import java.util.List;

import proyecto.constants.ValueConstants;
import proyecto.dao.EjecutorDAO;
import proyecto.dao.ProyectoEjecutorDAO;
import proyecto.param.ProyectoParam;
import proyecto.vo.Areanatural;
import proyecto.vo.Ejecutor;

public class EjecutorService {

	private EjecutorDAO ejecutorDAO;
	private ProyectoEjecutorDAO proyectoEjecutorDAO;

	
	

	



	

	public void setProyectoEjecutorDAO(ProyectoEjecutorDAO proyectoEjecutorDAO) {
		this.proyectoEjecutorDAO = proyectoEjecutorDAO;
	}









	public void setEjecutorDAO(EjecutorDAO ejecutorDAO) {
		this.ejecutorDAO = ejecutorDAO;
	}




	
	public int guardarEjecutor(Ejecutor ejecutor){
		int codigo=0;
		if(ejecutor.getIdejecutor()==0){
			codigo=ejecutorDAO.insertar(ejecutor);
		}
		else{
			//actualiza
		}
		return codigo;
	}
	

	public List<Ejecutor>  consultarInstitucionesEjecutoras(Ejecutor ejecutor)  {
		
	    return ejecutorDAO.listar(ejecutor);
	
    }



	public List<Ejecutor>  listarInstitucionesEjecutoras()  {
			
		    return ejecutorDAO.listar(new Ejecutor());
		
	}
	

    public List<Ejecutor>  consultarInstitucionesEjecutorasFinancierasxAreasNaturales(Areanatural areanatural)  {
    	ProyectoParam p=new ProyectoParam();
		p.setAreanatural(areanatural);
		p.getProyectoEjecutor().getTipoejecutor().setIdtipo(ValueConstants.EJECUTOR_FINANCIERO);
	    return proyectoEjecutorDAO.listarEjecutorxAreanatural(p);
	
    }
    
    public List<Ejecutor>  consultarInstitucionesEjecutorasTecnicasxAreasNaturales(Areanatural areanatural)  {
    	ProyectoParam p=new ProyectoParam();
		p.setAreanatural(areanatural);
		p.getProyectoEjecutor().getTipoejecutor().setIdtipo(ValueConstants.EJECUTOR_TECNICO);
	    return proyectoEjecutorDAO.listarEjecutorxAreanatural(p);
	
    }
	/*
	public List<Ejecutor>  consultarInstitucionesEjecutorasxAreasNaturales(Areanatural areanatural)  {
		
	    return proyectoEjecutorDAO.listarEjecutorxAreanatural(areanatural);
	
    }
    */

	
	
}
