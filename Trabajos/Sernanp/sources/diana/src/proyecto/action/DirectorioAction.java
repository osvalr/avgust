package proyecto.action;

import java.util.ArrayList;
import java.util.List;

import proyecto.service.PersonalService;
import proyecto.service.TelefonoService;
import proyecto.util.Pagination;
import proyecto.vo.Personal;
import proyecto.vo.Telefono;

import com.opensymphony.xwork2.ActionSupport;

public class DirectorioAction  extends ActionSupport {
	
	/** 
	 *             
	 */
	private static final long serialVersionUID = 1L;
	List<Personal> listaPersonal;
	List<Telefono> listaTelefono;
	Pagination paginador;  
  
	  
	
	public DirectorioAction(){
		listaPersonal=new ArrayList<Personal>();
		listaTelefono=new ArrayList<Telefono>();
		paginador=new Pagination();      
	}    
	
	
	public String consultarDirectorio(){
		
		Telefono busTel=new Telefono();
		//Pagination
		int total=telefonoService.calcularCantidadRegistrosDirectorio(busTel);
		System.out.println("total paginas:"+total);
		paginador.setPagina(0);
		paginador.setTotal(total);
		paginador.setItemsxpag(5);
		paginador.paginar();
		listaTelefono=telefonoService.consultarDirectorioPaginado(busTel, 0, paginador.getItemsxpag());
		System.out.println(listaTelefono.size());
		return "inicio";
	}
	
	

	
	
	
	
	
	public List<Personal> getListaPersonal() {
		return listaPersonal;
	}


	public void setListaPersonal(List<Personal> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}


	public List<Telefono> getListaTelefono() {
		return listaTelefono;
	}


	public void setListaTelefono(List<Telefono> listaTelefono) {
		this.listaTelefono = listaTelefono;
	}
	








	public Pagination getPaginador() {
		return paginador;
	}


	public void setPaginador(Pagination paginador) {
		this.paginador = paginador;
	}









	private PersonalService personalService;
	private TelefonoService telefonoService;



	public void setPersonalService(PersonalService personalService) {
		this.personalService = personalService;
	}


	public void setTelefonoService(TelefonoService telefonoService) {
		this.telefonoService = telefonoService;
	}
	
	
	
	
	
}
