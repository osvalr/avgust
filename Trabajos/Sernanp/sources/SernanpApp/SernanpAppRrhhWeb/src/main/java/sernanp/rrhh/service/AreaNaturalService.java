package sernanp.rrhh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sernanp.rrhh.constants.ValueConstants;
import sernanp.rrhh.dao.AreaNaturalDAO;
import sernanp.rrhh.vo.Areanatural;
import sernanp.rrhh.vo.Categoriaanp;

@Service
public class AreaNaturalService {

	@Autowired
	private AreaNaturalDAO areaNaturalDAO;

	public List<Areanatural>  listarAreasNaturales()  {
			
		    Areanatural a=new Areanatural();
		    a.getAdministracionAreanatural().setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
		    //a.setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
		    a.setFlagactivo(ValueConstants.FLAG_ACTIVO);
		    return areaNaturalDAO.listar(a);
		
	}	
		
	public List<Areanatural>  listarAreasNaturales(Categoriaanp ctg)  {
		
	    return areaNaturalDAO.listar(ctg);
	
	}
	
	public List<Areanatural>  listarSedes()  {
		
	    Areanatural a=new Areanatural();
	    a.getAdministracionAreanatural().setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
	    a.setFlagactivo(ValueConstants.FLAG_ACTIVO);
	    return areaNaturalDAO.listar(a);
	
	}
	
	public Areanatural consultarAreasNaturalxId(int idareanatural)  {
		
	    Areanatural a=new Areanatural();
	    a.setIdareanatural(idareanatural);
	    List<Areanatural> lista=new ArrayList<Areanatural>();
	    
	    lista=areaNaturalDAO.listar(a);
	    
	    if(lista.size()!=0){
	    	return lista.get(0);
	    }else
	    {
	    	return null;
	    }	
	}
	
	public Areanatural  consultarAreaNaturalxCodigo(String codigo)  {
			
		    Areanatural a=new Areanatural();
		    //a.setEstado(1);
		    a.setCodareanatural(codigo);
		    List<Areanatural> lista=new ArrayList<Areanatural>();
		    lista=areaNaturalDAO.listar(a);
		    if(lista.size()==1){
		    	return lista.get(0);
		    }else
		    {
		    	return null;
		    }
		    
		
	}	
		
	public List<Areanatural>  consultarAreasNaturales(Areanatural areanatural)  {
		
	    return areaNaturalDAO.listar(areanatural);
	
    }    	
	 
}