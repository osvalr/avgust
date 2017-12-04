package pe.com.focus.sakerk.repository.custom.model;

public class PersonaNaturalQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private Integer id_persona;
	private String nombres_completos;
	private Integer id_tipo_documento;
	private String numero_documento;
	private Integer id_genero;
	private Integer id_pais;
	private String cod_depto;
	private String cod_prov;
	private Integer id_ubigeo;
	private Integer id_congregacion_general_padre;
	private Integer id_congregacion_general_distrito;
	private Integer id_persona_pertenece;
	private Integer id_estado;

	public PersonaNaturalQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public Integer getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(Integer id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public Integer getId_genero() {
		return id_genero;
	}

	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public String getCod_depto() {
		return cod_depto;
	}

	public void setCod_depto(String cod_depto) {
		this.cod_depto = cod_depto;
	}

	public String getCod_prov() {
		return cod_prov;
	}

	public void setCod_prov(String cod_prov) {
		this.cod_prov = cod_prov;
	}

	public Integer getId_ubigeo() {
		return id_ubigeo;
	}

	public void setId_ubigeo(Integer id_ubigeo) {
		this.id_ubigeo = id_ubigeo;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderDirecction() {
		return orderDirecction;
	}

	public void setOrderDirecction(String orderDirecction) {
		this.orderDirecction = orderDirecction;
	}

	public String getNombres_completos() {
		return nombres_completos;
	}

	public void setNombres_completos(String nombres_completos) {
		this.nombres_completos = nombres_completos;
	}

	public Integer getId_congregacion_general_padre() {
		return id_congregacion_general_padre;
	}

	public void setId_congregacion_general_padre(
			Integer id_congregacion_general_padre) {
		this.id_congregacion_general_padre = id_congregacion_general_padre;
	}

	public Integer getId_congregacion_general_distrito() {
		return id_congregacion_general_distrito;
	}

	public void setId_congregacion_general_distrito(
			Integer id_congregacion_general_distrito) {
		this.id_congregacion_general_distrito = id_congregacion_general_distrito;
	}

	public Integer getId_persona_pertenece() {
		return id_persona_pertenece;
	}

	public void setId_persona_pertenece(Integer id_persona_pertenece) {
		this.id_persona_pertenece = id_persona_pertenece;
	}

}
