package proyecto.vo;


// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Areanatural generated by hbm2java
 */
public class RecursoInformacionTema implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idrecursoinformaciontema;
	private int idcodigo;
	private int idrecursoinformacion;
	private Tema tema;
	
	
	public RecursoInformacionTema(){
		tema=new Tema();
	}


	public int getIdrecursoinformaciontema() {
		return idrecursoinformaciontema;
	}


	public void setIdrecursoinformaciontema(int idrecursoinformaciontema) {
		this.idrecursoinformaciontema = idrecursoinformaciontema;
	}


	public int getIdcodigo() {
		return idcodigo;
	}


	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}


	public int getIdrecursoinformacion() {
		return idrecursoinformacion;
	}


	public void setIdrecursoinformacion(int idrecursoinformacion) {
		this.idrecursoinformacion = idrecursoinformacion;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}


	
	

	

	
	
	
	

}