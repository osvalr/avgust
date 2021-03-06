package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Areanatural generated by hbm2java
 */
public class Areanatural implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idareanatural;
	private Categoriaanp categoriaanp;
	private String codareanatural;
	private String desareanatural;
	private String siglasareanatural;
	private int cantidad;
	private String ubicacionareanatural; 
	private String codigosigareanatural;
	private int flagactivo;
	private int flagestado;
	private AdministracionAreanatural administracionAreanatural;
	List<Proyecto> proyectos=new ArrayList<Proyecto>();
	//private Turismo turismo ;
	

	public Areanatural() {
		categoriaanp=new Categoriaanp();
		administracionAreanatural=new AdministracionAreanatural();
	}

	public Areanatural(int idareanatural) {
		this();
		this.idareanatural=idareanatural;
	}
	
	public Areanatural(Categoriaanp categoriaanp) {
		this();
		this.categoriaanp = categoriaanp;
	}

	public int getFlagactivo() {
		return flagactivo;
	}

	public void setFlagactivo(int flagactivo) {
		this.flagactivo = flagactivo;
	}

	public int getIdareanatural() {
		return this.idareanatural;
	}

	public void setIdareanatural(int idareanatural) {
		this.idareanatural = idareanatural;
	}

	public Categoriaanp getCategoriaanp() {
		return this.categoriaanp;
	}

	public void setCategoriaanp(Categoriaanp categoriaanp) {
		this.categoriaanp = categoriaanp;
	}

	public String getCodareanatural() {
		return this.codareanatural;
	}

	public void setCodareanatural(String codareanatural) {
		this.codareanatural = codareanatural;
	}

	public String getDesareanatural() {
		return this.desareanatural;
	}

	public void setDesareanatural(String desareanatural) {
		this.desareanatural = desareanatural;
	}

	
	
	
	public int getFlagestado() {
		return flagestado;
	}

	public void setFlagestado(int flagestado) {
		this.flagestado = flagestado;
	}

	public String getUbicacionareanatural() {
		return this.ubicacionareanatural;
	}

	public void setUbicacionareanatural(String ubicacionareanatural) {
		this.ubicacionareanatural = ubicacionareanatural;
	}

	public String getCodigosigareanatural() {
		return this.codigosigareanatural;
	}

	public void setCodigosigareanatural(String codigosigareanatural) {
		this.codigosigareanatural = codigosigareanatural;
	}

	

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}


	public String getSiglasareanatural() {
		return siglasareanatural;
	}


	public void setSiglasareanatural(String siglasareanatural) {
		this.siglasareanatural = siglasareanatural;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public AdministracionAreanatural getAdministracionAreanatural() {
		return administracionAreanatural;
	}

	public void setAdministracionAreanatural(
			AdministracionAreanatural administracionAreanatural) {
		this.administracionAreanatural = administracionAreanatural;
	}

	

	
	
	

}
