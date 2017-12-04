package sernanp.app.dao.query.domain;

public class ObtenerTotalRetencionPorConceptoQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private Integer srl_id_anio_periodo_planilla;
	private Integer idpersonal;
	private Integer srl_id_concepto_planilla;
	private Integer int_id_estado;

	public ObtenerTotalRetencionPorConceptoQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getSrl_id_anio_periodo_planilla() {
		return srl_id_anio_periodo_planilla;
	}

	public void setSrl_id_anio_periodo_planilla(
			Integer srl_id_anio_periodo_planilla) {
		this.srl_id_anio_periodo_planilla = srl_id_anio_periodo_planilla;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getSrl_id_concepto_planilla() {
		return srl_id_concepto_planilla;
	}

	public void setSrl_id_concepto_planilla(Integer srl_id_concepto_planilla) {
		this.srl_id_concepto_planilla = srl_id_concepto_planilla;
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

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

}
