package sernanp.app.dao.query.domain;

public class ResumenNominaPagosQueryCriteria {
	
	private String orderColumn;
	private String orderDirecction;
	private Integer int_anio;
	private Integer int_id_periodo_mes;
	private Integer srl_id_regimen_contractual;
	private String c_fte_fto;
	private String c_meta;
	
	public ResumenNominaPagosQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}
	
	public Integer getInt_id_periodo_mes() {
		return int_id_periodo_mes;
	}
	
	public void setInt_id_periodo_mes(Integer int_id_periodo_mes) {
		this.int_id_periodo_mes = int_id_periodo_mes;
	}
	
	public Integer getInt_anio() {
		return int_anio;
	}
	
	public void setInt_anio(Integer int_anio) {
		this.int_anio = int_anio;
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

	public String getC_fte_fto() {
		return c_fte_fto;
	}

	public void setC_fte_fto(String c_fte_fto) {
		this.c_fte_fto = c_fte_fto;
	}

	public String getC_meta() {
		return c_meta;
	}

	public void setC_meta(String c_meta) {
		this.c_meta = c_meta;
	}
	
}
