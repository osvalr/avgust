package proyecto.vo;

 import java.text.SimpleDateFormat;
 import java.util.Date;

public class Resolucion {
	
	private int idresolucion;
	private String fecharesolucion;
	private String numeroresolucion;
	private String fecha;
	private Archivo archivo;

	// JCEV 13-09-2012
	private String fechanotificacion;

	// JCEV 13-09-2012
	private int annoresolucion;
	
	public Resolucion(){
		super();
		archivo              = new Archivo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		this.setAnnoresolucion(Integer.parseInt(sdf.format(new Date())));
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getIdresolucion() {
		return idresolucion;
	}
	
	public void setIdresolucion(int idresolucion) {
		this.idresolucion = idresolucion;
	}
	
	public String getNumeroresolucion() {
		return numeroresolucion;
	}
	
	public void setNumeroresolucion(String numeroresolucion) {
		this.numeroresolucion = numeroresolucion;
	}
	
	public String getFecharesolucion() {
		return fecharesolucion;
	}
	
	public void setFecharesolucion(String fecharesolucion) {
		this.fecharesolucion = fecharesolucion;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public String getFechanotificacion() {
		return fechanotificacion;
	}

	public void setFechanotificacion(String fechanotificacion) {
		this.fechanotificacion = fechanotificacion;
	}

	public int getAnnoresolucion() {
		return annoresolucion;
	}

	public void setAnnoresolucion(int annoresolucion) {
		this.annoresolucion = annoresolucion;
	}
	
}