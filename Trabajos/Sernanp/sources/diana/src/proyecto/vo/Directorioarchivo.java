package proyecto.vo;

import java.util.ArrayList;
import java.util.List;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Tipoproyecto generated by hbm2java
 */
public class Directorioarchivo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iddirectorioarchivo;
	private int iddirectoriopadre;
	private String nomdirectorio;
	private int orddirectorio;
	private String dirdirectorio;
	private Modulo modulo;
	private List<Directorioarchivo> listaDirectorioarchivo;
	public Directorioarchivo() {
		modulo=new Modulo();
	  listaDirectorioarchivo=new ArrayList<Directorioarchivo>();	
	}
	public int getIddirectorioarchivo() {
		return iddirectorioarchivo;
	}
	public void setIddirectorioarchivo(int iddirectorioarchivo) {
		this.iddirectorioarchivo = iddirectorioarchivo;
	}
	public int getIddirectoriopadre() {
		return iddirectoriopadre;
	}
	public void setIddirectoriopadre(int iddirectoriopadre) {
		this.iddirectoriopadre = iddirectoriopadre;
	}
	public String getNomdirectorio() {
		return nomdirectorio;
	}
	public void setNomdirectorio(String nomdirectorio) {
		this.nomdirectorio = nomdirectorio;
	}
	
	public int getOrddirectorio() {
		return orddirectorio;
	}
	public void setOrddirectorio(int orddirectorio) {
		this.orddirectorio = orddirectorio;
	}
	public String getDirdirectorio() {
		return dirdirectorio;
	}
	public void setDirdirectorio(String dirdirectorio) {
		this.dirdirectorio = dirdirectorio;
	}
	public List<Directorioarchivo> getListaDirectorioarchivo() {
		return listaDirectorioarchivo;
	}
	public void setListaDirectorioarchivo(
			List<Directorioarchivo> listaDirectorioarchivo) {
		this.listaDirectorioarchivo = listaDirectorioarchivo;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	
	

}
