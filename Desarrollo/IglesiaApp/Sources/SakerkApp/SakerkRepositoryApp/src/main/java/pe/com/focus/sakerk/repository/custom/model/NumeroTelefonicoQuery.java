package pe.com.focus.sakerk.repository.custom.model;

public class NumeroTelefonicoQuery implements java.io.Serializable {

	
	private static final long serialVersionUID = -4165796054814562550L;
	
	private Integer id_numero_telefonico;
	private Integer id_persona;
	private String numero_telefono;
	private Integer id_tipo_telefono;
	private String descrip_tipo_telefono;
	private Integer id_empresa_operadora;
	private String razon_social;
	private Integer id_estado;
	private String descrip_estado;
	private String fecha_registro;

	public Integer getId_numero_telefonico() {
		return id_numero_telefonico;
	}

	public void setId_numero_telefonico(Integer id_numero_telefonico) {
		this.id_numero_telefonico = id_numero_telefonico;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public Integer getId_tipo_telefono() {
		return id_tipo_telefono;
	}

	public void setId_tipo_telefono(Integer id_tipo_telefono) {
		this.id_tipo_telefono = id_tipo_telefono;
	}

	public String getDescrip_tipo_telefono() {
		return descrip_tipo_telefono;
	}

	public void setDescrip_tipo_telefono(String descrip_tipo_telefono) {
		this.descrip_tipo_telefono = descrip_tipo_telefono;
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

	public Integer getId_empresa_operadora() {
		return id_empresa_operadora;
	}

	public void setId_empresa_operadora(Integer id_empresa_operadora) {
		this.id_empresa_operadora = id_empresa_operadora;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

}
