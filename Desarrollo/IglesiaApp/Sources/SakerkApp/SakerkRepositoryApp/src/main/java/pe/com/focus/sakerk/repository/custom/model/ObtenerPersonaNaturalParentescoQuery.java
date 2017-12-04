package pe.com.focus.sakerk.repository.custom.model;

public class ObtenerPersonaNaturalParentescoQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_persona_natural;
	private String nombres_completos;
	private String fecha_nacimiento;
	private Integer id_tipo_documento;
	private String descrip_tipo_documento;
	private String numero_documento;
	private Integer id_estado;
	private String descrip_estado_generico;
	private String fecha_registro;

	public Integer getId_persona_natural() {
		return id_persona_natural;
	}

	public void setId_persona_natural(Integer id_persona_natural) {
		this.id_persona_natural = id_persona_natural;
	}

	public String getNombres_completos() {
		return nombres_completos;
	}

	public void setNombres_completos(String nombres_completos) {
		this.nombres_completos = nombres_completos;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(Integer id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public String getDescrip_tipo_documento() {
		return descrip_tipo_documento;
	}

	public void setDescrip_tipo_documento(String descrip_tipo_documento) {
		this.descrip_tipo_documento = descrip_tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
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
