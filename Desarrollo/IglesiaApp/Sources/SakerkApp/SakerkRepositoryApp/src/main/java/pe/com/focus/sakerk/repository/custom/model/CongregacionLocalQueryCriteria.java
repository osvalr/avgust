package pe.com.focus.sakerk.repository.custom.model;

public class CongregacionLocalQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private Integer id_persona;
	private Integer id_persona_juridica;
	private Integer id_congregacion_general;
	private Integer id_pais;
	private String cod_depto;
	private String cod_prov;
	private Integer id_ubigeo;
	private Integer id_estado;
	private String razon_social;

	public CongregacionLocalQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
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

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public Integer getId_persona_juridica() {
		return id_persona_juridica;
	}

	public void setId_persona_juridica(Integer id_persona_juridica) {
		this.id_persona_juridica = id_persona_juridica;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Integer getId_congregacion_general() {
		return id_congregacion_general;
	}

	public void setId_congregacion_general(Integer id_congregacion_general) {
		this.id_congregacion_general = id_congregacion_general;
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

}
