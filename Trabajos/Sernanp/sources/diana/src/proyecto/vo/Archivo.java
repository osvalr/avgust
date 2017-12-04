package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.Date;


public class Archivo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idarchivo;
	private int idcodigo;
	private String nombreinicial;
	private String nombregenerado;
	private String mimearchivo;
	private Date fechaupload;
	private String descripcion;
	private Usuario usuario;
	private Documento documento;
	private Directorioarchivo directorioarchivo;
		
	private int flagarchivo;
	
	
	public Archivo(int idarchivo){
		this();
		this.idarchivo=idarchivo;
	}
	public Archivo() {
		usuario=new Usuario();
		documento=new Documento();
		directorioarchivo=new Directorioarchivo();
	}
	public int getIdarchivo() {
		return idarchivo;
	}
	public void setIdarchivo(int idarchivo) {
		this.idarchivo = idarchivo;
	}
	public String getNombreinicial() {
		return nombreinicial;
	}
	public void setNombreinicial(String nombreinicial) {
		this.nombreinicial = nombreinicial;
	}
	public String getNombregenerado() {
		return nombregenerado;
	}
	public void setNombregenerado(String nombregenerado) {
		this.nombregenerado = nombregenerado;
	}
	public String getMimearchivo() {
		return mimearchivo;
	}
	public void setMimearchivo(String mimearchivo) {
		this.mimearchivo = mimearchivo;
	}
	public Date getFechaupload() {
		return fechaupload;
	}
	public void setFechaupload(Date fechaupload) {
		this.fechaupload = fechaupload;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Documento getDocumento() {
		return documento;
	}
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	public Directorioarchivo getDirectorioarchivo() {
		return directorioarchivo;
	}
	public void setDirectorioarchivo(Directorioarchivo directorioarchivo) {
		this.directorioarchivo = directorioarchivo;
	}	
	public int getIdcodigo() {
		return idcodigo;
	}
	public void setIdcodigo(int idcodigo) {
		this.idcodigo = idcodigo;
	}
	public int getFlagarchivo() {
		return flagarchivo;
	}
	public void setFlagarchivo(int flagarchivo) {
		this.flagarchivo = flagarchivo;
	}
	

}
