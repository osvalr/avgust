package sernanp.app.dao.query.domain;

public class GestionarNominaQueryCriteria {

	private String orderColumn;
	private String orderDirecction;

	private Integer srl_id_nomina_anio_periodo_personal;
	private String nombres_completos;
	private Integer idtipodocumento;
	private String numerodoc;
	private String ruc;
	private Integer srl_id_regimen_contractual;
	private Integer srl_id_cargo;
	private String c_fte_fto;
	private Integer int_anio;
	private Integer int_id_periodo_mes;
	private Integer int_id_estado;

	public GestionarNominaQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getIdtipodocumento() {
		return idtipodocumento;
	}

	public void setIdtipodocumento(Integer idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	public Integer getSrl_id_cargo() {
		return srl_id_cargo;
	}

	public void setSrl_id_cargo(Integer srl_id_cargo) {
		this.srl_id_cargo = srl_id_cargo;
	}

	public String getNombres_completos() {
		return nombres_completos;
	}

	public void setNombres_completos(String nombres_completos) {
		this.nombres_completos = nombres_completos;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public Integer getSrl_id_regimen_contractual() {
		return srl_id_regimen_contractual;
	}

	public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
		this.srl_id_regimen_contractual = srl_id_regimen_contractual;
	}

	public Integer getSrl_id_nomina_anio_periodo_personal() {
		return srl_id_nomina_anio_periodo_personal;
	}

	public void setSrl_id_nomina_anio_periodo_personal(
			Integer srl_id_nomina_anio_periodo_personal) {
		this.srl_id_nomina_anio_periodo_personal = srl_id_nomina_anio_periodo_personal;
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

	public String getC_fte_fto() {
		return c_fte_fto;
	}

	public void setC_fte_fto(String c_fte_fto) {
		this.c_fte_fto = c_fte_fto;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

}
