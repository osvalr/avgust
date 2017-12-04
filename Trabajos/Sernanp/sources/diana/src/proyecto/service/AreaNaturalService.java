package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.constants.ValueConstants;
import proyecto.dao.AreaNaturalDAO;
import proyecto.dao.AreaOrganicaDAO;
import proyecto.dao.ProyectoAreanaturalDAO;
import proyecto.dao.TurismoDAO;
import proyecto.param.AreanaturalParam;
import proyecto.util.ProyectoUtil;
import proyecto.vo.Areanatural;
import proyecto.vo.Categoriaanp;
import proyecto.vo.ProyectoAreanatural;
import proyecto.vo.Turismo;

@Service
public class AreaNaturalService {
	
	@Autowired
	private ActividadTurismoService actividadTurismoService;

	private AreaNaturalDAO areaNaturalDAO;
	private AreaOrganicaDAO areaOrganicaDAO; 
	private ProyectoAreanaturalDAO proyectoAreanaturalDAO;
	private TurismoDAO turismoDAO;
	
	public void setTurismoDAO(TurismoDAO turismoDAO) {
		this.turismoDAO = turismoDAO;
	}
 
	public void setProyectoAreanaturalDAO(
			ProyectoAreanaturalDAO proyectoAreanaturalDAO) {
		this.proyectoAreanaturalDAO = proyectoAreanaturalDAO;
	} 

	public void setAreaNaturalDAO(AreaNaturalDAO areaNaturalDAO) {
		this.areaNaturalDAO = areaNaturalDAO;
	}

	
	public void setAreaOrganicaDAO(AreaOrganicaDAO areaOrganicaDAO) {
		this.areaOrganicaDAO = areaOrganicaDAO;
	}

	public List<AreanaturalParam> consultarMontoProyectosxAreasNaturales(){
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 return  proyectoAreanaturalDAO.listarMontoProyectoxAreaNatural(pa,ValueConstants.TOTAL);
	}
	
	
	public List<AreanaturalParam> consultarMontoRedondeadoProyectosxAreasNaturales(){
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 List<AreanaturalParam> lista=  proyectoAreanaturalDAO.listarMontoProyectoxAreaNatural(pa,ValueConstants.TOTAL);
		 for(AreanaturalParam a: lista ){
			 a.setMontoTotalProyectos(ProyectoUtil.redondear(a.getMontoTotalProyectos(), 2));
			// System.out.println(a.getMontoTotalProyectos());
			 a.setMontoTotalVigente(ProyectoUtil.redondear(a.getMontoTotalVigente(), 2));
			 a.setMontoTotalVencido(ProyectoUtil.redondear(a.getMontoTotalVencido(), 2));
		 }
		 return lista;
	}
	
	
	public List<AreanaturalParam> consultarCantidadProyectosxAreasNaturales(){
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 return  proyectoAreanaturalDAO.listarCantidadProyectoxAreaNatural(pa,ValueConstants.TOTAL);
	}

	
	
	public AreanaturalParam consultarCantidadProyectosxIdAreaNatural(int idareanatural){
		 AreanaturalParam ap=new AreanaturalParam();
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 pa.getAreanatural().setIdareanatural(idareanatural);
		 List<AreanaturalParam> lista=proyectoAreanaturalDAO.listarCantidadProyectoxAreaNatural(pa,ValueConstants.TOTAL);
		 if(lista.size()!=0){
			 ap=lista.get(0);
		 }
		 return  ap;
	}
	
	public AreanaturalParam consultarMontoProyectosxIdAreaNatural(int idareanatural){
		 AreanaturalParam ap=new AreanaturalParam(); 
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 pa.getAreanatural().setIdareanatural(idareanatural);
		 List<AreanaturalParam> lista=proyectoAreanaturalDAO.listarMontoProyectoxAreaNatural(pa,ValueConstants.TOTAL);
		 if(lista.size()!=0){
			 ap=lista.get(0);
		 }
		 return  ap;
	}
	
	
	
	public List<AreanaturalParam> consultarMayorCantidadProyectosxAreasNaturales(int numero,int orden){
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 List<AreanaturalParam> listaArea=proyectoAreanaturalDAO.listarCantidadProyectoxAreaNatural(pa,orden);
		 List<AreanaturalParam> lista=new ArrayList<AreanaturalParam>();
		 int total=0;
		 int vigentes=0;
		 int vencidos=0;
		 AreanaturalParam aotros=new AreanaturalParam();
		 aotros.getAreanatural().setDesareanatural("Otros");
		 for(int i=0;i<listaArea.size();i++){
			 AreanaturalParam a=new AreanaturalParam(); 
			 if(i<numero){
			     lista.add(listaArea.get(i)); 
			 }
			 else{
				 total+=listaArea.get(i).getCantidadProyectos(); 
				 vigentes+=listaArea.get(i).getCantidadProyectosVigente(); 
				 vencidos+=listaArea.get(i).getCantidadProyectosVencidos(); 
			 }
			  
		 }
		 aotros.setCantidadProyectos(total);
		 aotros.setCantidadProyectosVigente(vigentes);
		 aotros.setCantidadProyectosVencidos(vencidos);
		 lista.add(aotros);
		 return lista;
		 
	}
	
	
	
	
	
	
	public List<AreanaturalParam> consultarMayorMontoProyectosxAreasNaturales(int numero,int orden ){
		 ProyectoAreanatural pa=new ProyectoAreanatural();
		 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
		 List<AreanaturalParam> listaArea=proyectoAreanaturalDAO.listarMontoProyectoxAreaNatural(pa,orden);
		 List<AreanaturalParam> lista=new ArrayList<AreanaturalParam>();
		 int total=0;
		 int vigentes=0;
		 int vencidos=0;
		 AreanaturalParam aotros=new AreanaturalParam();
		 aotros.getAreanatural().setDesareanatural("Otros");
		 for(int i=0;i<listaArea.size();i++){
			 AreanaturalParam a=new AreanaturalParam();
			 if(i<numero){
			     lista.add(listaArea.get(i));
			 }
			 else{
				 total+=listaArea.get(i).getMontoTotalProyectos();
				 
				 vigentes+=listaArea.get(i).getMontoTotalVigente();
				 
				 vencidos+=listaArea.get(i).getMontoTotalVencido(); 
			 }
			  
		 }
		 aotros.setMontoTotalProyectos(total);
		 aotros.setMontoTotalVigente(vigentes);
		 aotros.setMontoTotalVencido(vencidos);
		 lista.add(aotros);
		 return lista; 
	} 
	/*
	public Areanatural consultarAreaNaturalxIdAreaOrganica(int idAreaOrganica){
		Areanatural an=new Areanatural();
		Areaorganica ao=new Areaorganica();
		List<Areaorganica> lista=new ArrayList<Areaorganica>();
		lista=areaOrganicaDAO.listar(new Areaorganica(idAreaOrganica));
		if(lista.size()!=0){
			ao=lista.get(0);
			List<Areanatural> listaArea=new ArrayList<Areanatural>();
			Areanatural anat=new Areanatural();
			anat.setIdareanatural(ao.getAreanatural().getIdareanatural());
			anat.setEstado(ValueConstants.FLAG_TODOS);
			listaArea=areaNaturalDAO.listar(anat);
			if(listaArea.size()!=0){
				an=listaArea.get(0);
			}
		}
		return an;
		
	}
	*/

	public List<Areanatural>  listarAreasNaturales()  {
			
		    Areanatural a=new Areanatural();
		    a.getAdministracionAreanatural().setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
		    //a.setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
		    a.setFlagactivo(ValueConstants.FLAG_ACTIVO);
		    return areaNaturalDAO.listar(a);
		
	}
	
	//Actualizado JCEV	
	public List<Areanatural>  listarAreasNaturales(Categoriaanp ctg)  {
		
	    return areaNaturalDAO.listar(ctg);
	
	}

	//10-05-2013 (Y.C)
	public List<Areanatural>  listarAreasNaturalesxCtg(Categoriaanp ctg)  {
		
	    return areaNaturalDAO.listarxctg(ctg);
	
	}
	
	public List<Areanatural>  listarSedes()  {
		
	    Areanatural a=new Areanatural();
	    a.getAdministracionAreanatural().setIdadministracionareanatural(ValueConstants.AREA_ADMINISTRACION_PUBLICA);
	    a.setFlagactivo(ValueConstants.FLAG_ACTIVO);
	    return areaNaturalDAO.listar(a);
	
}
	
	public Areanatural  consultarAreasNaturalxId(int idareanatural)  {
		
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
	
	
	public List<Areanatural>  consultarAreasNaturalesConTurismo()  {
		List<Turismo> lista=new ArrayList<Turismo>();
		lista= turismoDAO.listar(new Turismo());
		List<Areanatural> listaArea=new ArrayList<Areanatural>();
		for(Turismo t:lista){ 
			Areanatural a = new Areanatural();
			a.setIdareanatural(t.getIdareanatural());
			a.setDesareanatural(t.getDesareanatural());
			a.getCategoriaanp().setIdcategoriaanp(t.getCategoriaanp().getIdcategoriaanp());
			a.getCategoriaanp().setDescategoriaanp(t.getCategoriaanp().getDescategoriaanp());
			a.getCategoriaanp().setSiglascategoriaanp(t.getCategoriaanp().getSiglascategoriaanp());
			listaArea.add(a);
		}
		return listaArea;
	
    }
	
	public Areanatural  consultarAreasNaturalConTurismo(int idareanatural)  {
		Turismo tur=new Turismo();
		tur.setIdareanatural(idareanatural);
		List<Turismo> lista=new ArrayList<Turismo>();
		lista= turismoDAO.listar(tur);
		if(lista.size()!=0){
			Areanatural a = new Areanatural();
			Turismo t=lista.get(0);
			a.setIdareanatural(t.getIdareanatural());
			a.setDesareanatural(t.getDesareanatural());
			a.getCategoriaanp().setIdcategoriaanp(t.getCategoriaanp().getIdcategoriaanp());
			a.getCategoriaanp().setDescategoriaanp(t.getCategoriaanp().getDescategoriaanp());
			a.getCategoriaanp().setSiglascategoriaanp(t.getCategoriaanp().getSiglascategoriaanp());
			return a;
		}
		else{
			return null;
		}

	
    }
	
	public List<Areanatural>  consultarAreasNaturales(Areanatural areanatural)  {
		
	    return areaNaturalDAO.listar(areanatural);
	
    }
	
    
	public List<Areanatural>  consultarAreasNaturalesConProyectos(Areanatural areanatural)  {
		return proyectoAreanaturalDAO.listarProyectoAgrupado(areanatural);
		
	}
	/*
	public Areanatural buscarxAreaOrganica(int idAreaorganica){
		return areaNaturalDAO.buscarxAreaOrganica(idAreaorganica);
	}
	*/
	
	/*
	public Areanatural consultarAreaNaturalxIdAreaOrganica(int idAreaorganica){
		return areaNaturalDAO.buscarxAreaOrganica(idAreaorganica);
	}
	
	*/
	
	 
}
