package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProyectoArchivo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Proyecto proyecto;
	private Archivo archivo;
	
	
	public ProyectoArchivo(){
		proyecto=new Proyecto();
		archivo=new Archivo();
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public Archivo getArchivo() {
		return archivo;
	}


	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	
	
	
	
	

}
