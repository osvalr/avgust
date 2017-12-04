package sernanp.app.dao.query.domain;

public class GestionarConvocatoriaPersonalQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private String var_num_convocatoria;
	private Integer int_num_activacion;
	private Integer int_id_estado;

	public GestionarConvocatoriaPersonalQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getInt_num_activacion() {
		return int_num_activacion;
	}

	public void setInt_num_activacion(Integer int_num_activacion) {
		this.int_num_activacion = int_num_activacion;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
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

	public String getVar_num_convocatoria() {
		return var_num_convocatoria;
	}

	public void setVar_num_convocatoria(String var_num_convocatoria) {
		this.var_num_convocatoria = var_num_convocatoria;
	}

}
