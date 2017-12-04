package sernanp.app.dao.query.domain;

public class ObtenerUltimoEstadoQuery {

	private Integer srl_id_detalle_historial_estado;
	private Integer srl_id_estado_tabla;
	private Integer int_id_registro;
	private String var_cod_estado;
	private String tsp_fecha_registro;

	public Integer getSrl_id_detalle_historial_estado() {
		return srl_id_detalle_historial_estado;
	}

	public void setSrl_id_detalle_historial_estado(
			Integer srl_id_detalle_historial_estado) {
		this.srl_id_detalle_historial_estado = srl_id_detalle_historial_estado;
	}

	public Integer getSrl_id_estado_tabla() {
		return srl_id_estado_tabla;
	}

	public void setSrl_id_estado_tabla(Integer srl_id_estado_tabla) {
		this.srl_id_estado_tabla = srl_id_estado_tabla;
	}

	public Integer getInt_id_registro() {
		return int_id_registro;
	}

	public void setInt_id_registro(Integer int_id_registro) {
		this.int_id_registro = int_id_registro;
	}

	public String getVar_cod_estado() {
		return var_cod_estado;
	}

	public void setVar_cod_estado(String var_cod_estado) {
		this.var_cod_estado = var_cod_estado;
	}

	public String getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(String tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

}
