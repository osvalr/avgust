package sernanp.app.dao.query.domain;

public class GestionarConvocatoriaPersonalCriteria {

	private String orderColumn;
	private String orderDirecction;
	private Integer srl_id_convocatoria;
	private String dte_fecha_aprobacion;
	private String dte_fecha_termino_publicacion;
	private Integer int_id_estado;
	private Integer int_num_activacion;
	private String dte_fecha_inicio_publicacion;

	public GestionarConvocatoriaPersonalCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public String getDte_fecha_aprobacion() {
		return dte_fecha_aprobacion;
	}

	public void setDte_fecha_aprobacion(String dte_fecha_aprobacion) {
		this.dte_fecha_aprobacion = dte_fecha_aprobacion;
	}

	public String getDte_fecha_termino_publicacion() {
		return dte_fecha_termino_publicacion;
	}

	public void setDte_fecha_termino_publicacion(
			String dte_fecha_termino_publicacion) {
		this.dte_fecha_termino_publicacion = dte_fecha_termino_publicacion;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Integer getInt_num_activacion() {
		return int_num_activacion;
	}

	public void setInt_num_activacion(Integer int_num_activacion) {
		this.int_num_activacion = int_num_activacion;
	}

	public String getDte_fecha_inicio_publicacion() {
		return dte_fecha_inicio_publicacion;
	}

	public void setDte_fecha_inicio_publicacion(
			String dte_fecha_inicio_publicacion) {
		this.dte_fecha_inicio_publicacion = dte_fecha_inicio_publicacion;
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

	public Integer getSrl_id_convocatoria() {
		return srl_id_convocatoria;
	}

	public void setSrl_id_convocatoria(Integer srl_id_convocatoria) {
		this.srl_id_convocatoria = srl_id_convocatoria;
	}

}
