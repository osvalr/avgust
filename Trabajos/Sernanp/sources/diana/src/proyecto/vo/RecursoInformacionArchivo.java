package proyecto.vo;

public class RecursoInformacionArchivo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idrecursoinformacionarchivo;
	private int idcodigo;
	private RecursoInformacion recursoinformacion;
	private Archivo archivo;
	private Tipo tipoarchivo; 
	
	
	public RecursoInformacionArchivo(){
		recursoinformacion=new RecursoInformacion();
		archivo=new Archivo();
		tipoarchivo=new Tipo();
	}


	public int getIdrecursoinformacionarchivo() {
		return idrecursoinformacionarchivo;
	}


	public void setIdrecursoinformacionarchivo(int idrecursoinformacionarchivo) {
		this.idrecursoinformacionarchivo = idrecursoinformacionarchivo;
	}


	public RecursoInformacion getRecursoinformacion() {
		return recursoinformacion;
	}


	public void setRecursoinformacion(RecursoInformacion recursoinformacion) {
		this.recursoinformacion = recursoinformacion;
	}


	public Archivo getArchivo() {
		return archivo;
	}


	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}


	public Tipo getTipoarchivo() {
		return tipoarchivo;
	}


	public void setTipoarchivo(Tipo tipoarchivo) {
		this.tipoarchivo = tipoarchivo;
	}


	public int getIdcodigo() {
		return idcodigo;
	}


	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}

	
	
	
	
	
	
}
