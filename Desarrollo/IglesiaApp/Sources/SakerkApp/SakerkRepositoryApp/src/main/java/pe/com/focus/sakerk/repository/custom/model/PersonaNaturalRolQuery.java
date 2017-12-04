package pe.com.focus.sakerk.repository.custom.model;

public class PersonaNaturalRolQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_persona_natural_rol;
	private Integer id_persona_natural;
	private Integer id_rol;
	private String nombre_rol;
	private Integer id_estado;
	private String descrip_estado_generico;
	private String fecha_registro;

	public Integer getId_persona_natural_rol() {
		return id_persona_natural_rol;
	}

	public void setId_persona_natural_rol(Integer id_persona_natural_rol) {
		this.id_persona_natural_rol = id_persona_natural_rol;
	}

	public Integer getId_persona_natural() {
		return id_persona_natural;
	}

	public void setId_persona_natural(Integer id_persona_natural) {
		this.id_persona_natural = id_persona_natural;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescrip_estado_generico() {
		return descrip_estado_generico;
	}

	public void setDescrip_estado_generico(String descrip_estado_generico) {
		this.descrip_estado_generico = descrip_estado_generico;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
