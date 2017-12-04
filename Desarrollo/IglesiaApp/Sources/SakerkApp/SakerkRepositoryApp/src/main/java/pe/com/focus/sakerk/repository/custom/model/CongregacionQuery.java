package pe.com.focus.sakerk.repository.custom.model;

public class CongregacionQuery implements java.io.Serializable {

	private static final long serialVersionUID = 5910944766576776722L;
	private Integer id_congregacion_general;
	private Integer id_congregacion_padre;
	private String nombre_congregacion;
	private String nombre_congregacion_padre;
	private Integer id_estado;
	private String descrip_estado;
	private String fecha_registro;

	public String getNombre_congregacion() {
		return nombre_congregacion;
	}

	public void setNombre_congregacion(String nombre_congregacion) {
		this.nombre_congregacion = nombre_congregacion;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescrip_estado() {
		return descrip_estado;
	}

	public void setDescrip_estado(String descrip_estado) {
		this.descrip_estado = descrip_estado;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Integer getId_congregacion_general() {
		return id_congregacion_general;
	}

	public void setId_congregacion_general(Integer id_congregacion_general) {
		this.id_congregacion_general = id_congregacion_general;
	}

	public Integer getId_congregacion_padre() {
		return id_congregacion_padre;
	}

	public void setId_congregacion_padre(Integer id_congregacion_padre) {
		this.id_congregacion_padre = id_congregacion_padre;
	}

	public String getNombre_congregacion_padre() {
		return nombre_congregacion_padre;
	}

	public void setNombre_congregacion_padre(String nombre_congregacion_padre) {
		this.nombre_congregacion_padre = nombre_congregacion_padre;
	}

}
