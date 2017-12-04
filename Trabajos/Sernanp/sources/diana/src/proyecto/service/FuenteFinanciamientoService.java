package proyecto.service;

import java.util.ArrayList;
import java.util.List;

import proyecto.constants.ValueConstants;
import proyecto.dao.FuenteFinanciamientoDAO;
import proyecto.dao.ProyectoFteFtoDAO;
import proyecto.vo.Areanatural;
import proyecto.vo.Fuentefinanciamiento;
import proyecto.vo.ProyectoAreanatural;
import proyecto.vo.ProyectoFteFto;

public class FuenteFinanciamientoService {

	private FuenteFinanciamientoDAO fuenteFinanciamientoDAO;
	private ProyectoFteFtoDAO proyectoFteFtoDAO;

	
	

	




	public void setFuenteFinanciamientoDAO(
			FuenteFinanciamientoDAO fuenteFinanciamientoDAO) {
		this.fuenteFinanciamientoDAO = fuenteFinanciamientoDAO;
	}









	public void setProyectoFteFtoDAO(ProyectoFteFtoDAO proyectoFteFtoDAO) {
		this.proyectoFteFtoDAO = proyectoFteFtoDAO;
	}




	public int guardarFuenteFinanciamiento(Fuentefinanciamiento fuentefinanciamiento){
		int codigo=0;
		if(fuentefinanciamiento.getIdftefto()==0){
			codigo=fuenteFinanciamientoDAO.insertar(fuentefinanciamiento);
		}
		else{
			//actualiza
		}
		return codigo;
	}
	

	public List<Fuentefinanciamiento>  consultarInstitucionesFuentes(Fuentefinanciamiento fuentefinanciamiento)  {
		
	    return fuenteFinanciamientoDAO.listar(fuentefinanciamiento);
	
}




	public List<Fuentefinanciamiento>  listarInstitucionesFuentes()  {
			
		    return fuenteFinanciamientoDAO.listar(new Fuentefinanciamiento());
		
	}
	

public List<Fuentefinanciamiento>  consultarInstitucionesFuentesxAreasNaturales(Areanatural areanatural)  {
		
	    return proyectoFteFtoDAO.listarFuenteFtoxAreanatural(areanatural);
	
}


public List<ProyectoFteFto>  consultarInstitucionesFuentesxIdAreaNatural(int idareanatural)  {
	ProyectoAreanatural pa=new ProyectoAreanatural();
	pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
	pa.getAreanatural().setIdareanatural(idareanatural);
    return proyectoFteFtoDAO.listarProyectoFuenteFtoxAreanatural(pa,ValueConstants.ORDEN_MONTO);

}


public List<ProyectoFteFto> consultarMayorMontoInstitucionesFuentesxIdAreaNatural(int numero, int idareanatural){
	 ProyectoAreanatural pa=new ProyectoAreanatural();
	 List<ProyectoFteFto> lista=new ArrayList<ProyectoFteFto>();
	 pa.getProyecto().setFlagProyecto(ValueConstants.FLAG_ACTIVO);
	 pa.getAreanatural().setIdareanatural(idareanatural);
	 List<ProyectoFteFto> listaProyFte=proyectoFteFtoDAO.listarProyectoFuenteFtoxAreanatural(pa,ValueConstants.ORDEN_MONTO);
	 ProyectoFteFto pfotros=new ProyectoFteFto();
	 pfotros.getFteFto().getPersonajuridica().setNombrepersonajuridica("Otros");
	 double monto=0;
	 for(int i=0;i<listaProyFte.size();i++){
		 if(i<numero){
		     lista.add(listaProyFte.get(i));
		 }
		 else{
			 monto+=listaProyFte.get(i).getMonto();
		 }
		  
	 }
	 pfotros.setMonto(monto);
	 lista.add(pfotros);
	 return lista;
	 
}



public List<ProyectoFteFto> consultarMayorMontoVariosInstitucionesFuentesxIdAreaNatural(List<ProyectoFteFto> lista){
	
	double monto=0;
	List<ProyectoFteFto> listaAux=new ArrayList<ProyectoFteFto>();
	for(int i=0;i<lista.size();i++){
		if(i==0 || i==(lista.size()-1)){
			monto+=lista.get(i).getMonto() ;
		}
		else{
			listaAux.add(lista.get(i));
		}
		
	}
	ProyectoFteFto pf=new ProyectoFteFto();
	pf.setMonto(monto);
	pf.getFteFto().getPersonajuridica().setNombrepersonajuridica("Otros");
	listaAux.add(pf);
	return listaAux;
	 
}



public List<ProyectoFteFto> calcularTotalFuentes(List<ProyectoFteFto> lista){
	double total=0;
	
	for(ProyectoFteFto pf:lista){
		total+=pf.getMonto();
	}
	ProyectoFteFto pf=new ProyectoFteFto();
	pf.getFteFto().getPersonajuridica().setNombrepersonajuridica("TOTAL");
	pf.setMonto(total);
	lista.add(pf);
	return lista;
	
}




	
}
