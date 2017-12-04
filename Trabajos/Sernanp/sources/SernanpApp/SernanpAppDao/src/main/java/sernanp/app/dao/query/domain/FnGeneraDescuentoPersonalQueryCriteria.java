package sernanp.app.dao.query.domain;

public class FnGeneraDescuentoPersonalQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private java.util.Date dte_fecha_inicio;
	private java.util.Date dte_fecha_fin;
	private Integer int_anho;
	private Integer int_mes;
	private Integer srl_id_regimen_contractual;
	private Integer idpersonal;

	public FnGeneraDescuentoPersonalQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public java.util.Date getDte_fecha_inicio() {
		return dte_fecha_inicio;
	}

	public void setDte_fecha_inicio(java.util.Date dte_fecha_inicio) {
		this.dte_fecha_inicio = dte_fecha_inicio;
	}

	public java.util.Date getDte_fecha_fin() {
		return dte_fecha_fin;
	}

	public void setDte_fecha_fin(java.util.Date dte_fecha_fin) {
		this.dte_fecha_fin = dte_fecha_fin;
	}

	public Integer getInt_anho() {
		return int_anho;
	}

	public void setInt_anho(Integer int_anho) {
		this.int_anho = int_anho;
	}

	public Integer getInt_mes() {
		return int_mes;
	}

	public void setInt_mes(Integer int_mes) {
		this.int_mes = int_mes;
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

	public Integer getSrl_id_regimen_contractual() {
		return srl_id_regimen_contractual;
	}

	public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
		this.srl_id_regimen_contractual = srl_id_regimen_contractual;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

}
