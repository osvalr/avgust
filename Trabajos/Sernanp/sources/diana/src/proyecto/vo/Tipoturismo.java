package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Tipoturismo generated by hbm2java
 */
public class Tipoturismo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtipoturismo;
	private String nombretipoturismo;
	private List<Actividadturismo> listaActividadturismo;

	public Tipoturismo() {
		listaActividadturismo=new ArrayList<Actividadturismo>();
	}

	public int getIdtipoturismo() {
		return idtipoturismo;
	}

	public void setIdtipoturismo(int idtipoturismo) {
		this.idtipoturismo = idtipoturismo;
	}

	public String getNombretipoturismo() {
		return nombretipoturismo;
	}

	public void setNombretipoturismo(String nombretipoturismo) {
		this.nombretipoturismo = nombretipoturismo;
	}

	public List<Actividadturismo> getListaActividadturismo() {
		return listaActividadturismo;
	}

	public void setListaActividadturismo(
			List<Actividadturismo> listaActividadturismo) {
		this.listaActividadturismo = listaActividadturismo;
	}  
   
	
	
	
	
}
