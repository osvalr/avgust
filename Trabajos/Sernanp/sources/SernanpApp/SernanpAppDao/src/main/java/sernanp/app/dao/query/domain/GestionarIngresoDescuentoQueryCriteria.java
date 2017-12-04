package sernanp.app.dao.query.domain;

public class GestionarIngresoDescuentoQueryCriteria {

	private String orderColumn;
	private String orderDirecction;

	private Integer srl_id_ingreso_descuento_planilla;
	private String var_cod_ingreso_descuento;
	private String var_descrip_corto_ingreso_descuento;
	private String var_cod_pdt;
	private String var_cod_mef;
	private Integer int_id_tipo_ingreso_descuento;
	private Integer int_id_subtipo_ingreso_descuento;
	private Integer int_id_estado;

	public GestionarIngresoDescuentoQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getInt_id_subtipo_ingreso_descuento() {
		return int_id_subtipo_ingreso_descuento;
	}

	public void setInt_id_subtipo_ingreso_descuento(
			Integer int_id_subtipo_ingreso_descuento) {
		this.int_id_subtipo_ingreso_descuento = int_id_subtipo_ingreso_descuento;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public String getVar_cod_mef() {
		return var_cod_mef;
	}

	public void setVar_cod_mef(String var_cod_mef) {
		this.var_cod_mef = var_cod_mef;
	}

	public String getVar_cod_ingreso_descuento() {
		return var_cod_ingreso_descuento;
	}

	public void setVar_cod_ingreso_descuento(String var_cod_ingreso_descuento) {
		this.var_cod_ingreso_descuento = var_cod_ingreso_descuento;
	}

	public String getVar_cod_pdt() {
		return var_cod_pdt;
	}

	public void setVar_cod_pdt(String var_cod_pdt) {
		this.var_cod_pdt = var_cod_pdt;
	}

	public String getVar_descrip_corto_ingreso_descuento() {
		return var_descrip_corto_ingreso_descuento;
	}

	public void setVar_descrip_corto_ingreso_descuento(
			String var_descrip_corto_ingreso_descuento) {
		this.var_descrip_corto_ingreso_descuento = var_descrip_corto_ingreso_descuento;
	}

	public Integer getSrl_id_ingreso_descuento_planilla() {
		return srl_id_ingreso_descuento_planilla;
	}

	public void setSrl_id_ingreso_descuento_planilla(
			Integer srl_id_ingreso_descuento_planilla) {
		this.srl_id_ingreso_descuento_planilla = srl_id_ingreso_descuento_planilla;
	}

	public Integer getInt_id_tipo_ingreso_descuento() {
		return int_id_tipo_ingreso_descuento;
	}

	public void setInt_id_tipo_ingreso_descuento(
			Integer int_id_tipo_ingreso_descuento) {
		this.int_id_tipo_ingreso_descuento = int_id_tipo_ingreso_descuento;
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

}
