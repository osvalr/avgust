package sernanp.app.dao.query.domain;

public class GestionarAnhoMetaQueryCriteria {

	private String orderColumn;
	private String orderDirecction;

	private Integer srl_id_anio_meta;
	private Integer srl_id_anio_planilla;
	private Integer idarea;
	private Integer idunidad;
	private String cod_meta;

	public GestionarAnhoMetaQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getIdunidad() {
		return idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public Integer getSrl_id_anio_planilla() {
		return srl_id_anio_planilla;
	}

	public void setSrl_id_anio_planilla(Integer srl_id_anio_planilla) {
		this.srl_id_anio_planilla = srl_id_anio_planilla;
	}

	public String getCod_meta() {
		return cod_meta;
	}

	public void setCod_meta(String cod_meta) {
		this.cod_meta = cod_meta;
	}

	public Integer getSrl_id_anio_meta() {
		return srl_id_anio_meta;
	}

	public void setSrl_id_anio_meta(Integer srl_id_anio_meta) {
		this.srl_id_anio_meta = srl_id_anio_meta;
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
