package sernanp.app.dao.query.domain;

import java.util.Date;

public class ObtenerUltimoEstadoQueryCriteria {

	private String var_nombre_tabla;
	private Integer int_id_registro;
	private Integer int_id_registro_sub_query;
	private Date tsp_fecha_registro;

	public String getVar_nombre_tabla() {
		return var_nombre_tabla;
	}

	public void setVar_nombre_tabla(String var_nombre_tabla) {
		this.var_nombre_tabla = var_nombre_tabla;
	}

	public Integer getInt_id_registro() {
		return int_id_registro;
	}

	public void setInt_id_registro(Integer int_id_registro) {
		this.int_id_registro = int_id_registro;
	}

	public Integer getInt_id_registro_sub_query() {
		return int_id_registro_sub_query;
	}

	public void setInt_id_registro_sub_query(Integer int_id_registro_sub_query) {
		this.int_id_registro_sub_query = int_id_registro_sub_query;
	}

	public Date getTsp_fecha_registro() {
		return tsp_fecha_registro;
	}

	public void setTsp_fecha_registro(Date tsp_fecha_registro) {
		this.tsp_fecha_registro = tsp_fecha_registro;
	}

}
