package sernanp.app.dao.query.domain;

public class ConvocatoriasQueryCriteria {

	private Integer int_estado;
	private String var_num_convocatoria;
	private String var_nombre_convocatoria;
	private java.util.Date tsp_fecha_registro_desde;
	private java.util.Date tsp_fecha_registro_hasta;
	private java.util.Date dte_fecha_vegencia_inicio;
	private java.util.Date dte_fecha_vigencia_fin;
	private Integer int_id_area_organica;
	private Integer anho;

	public Integer getInt_estado() {
		return int_estado;
	}

	public void setInt_estado(Integer int_estado) {
		this.int_estado = int_estado;
	}

	public String getVar_num_convocatoria() {
		return var_num_convocatoria;
	}

	public void setVar_num_convocatoria(String var_num_convocatoria) {
		this.var_num_convocatoria = var_num_convocatoria;
	}

	public String getVar_nombre_convocatoria() {
		return var_nombre_convocatoria;
	}

	public void setVar_nombre_convocatoria(String var_nombre_convocatoria) {
		this.var_nombre_convocatoria = var_nombre_convocatoria;
	}

	public java.util.Date getTsp_fecha_registro_desde() {
		return tsp_fecha_registro_desde;
	}

	public void setTsp_fecha_registro_desde(
			java.util.Date tsp_fecha_registro_desde) {
		this.tsp_fecha_registro_desde = tsp_fecha_registro_desde;
	}

	public java.util.Date getTsp_fecha_registro_hasta() {
		return tsp_fecha_registro_hasta;
	}

	public void setTsp_fecha_registro_hasta(
			java.util.Date tsp_fecha_registro_hasta) {
		this.tsp_fecha_registro_hasta = tsp_fecha_registro_hasta;
	}

	public java.util.Date getDte_fecha_vegencia_inicio() {
		return dte_fecha_vegencia_inicio;
	}

	public void setDte_fecha_vegencia_inicio(
			java.util.Date dte_fecha_vegencia_inicio) {
		this.dte_fecha_vegencia_inicio = dte_fecha_vegencia_inicio;
	}

	public java.util.Date getDte_fecha_vigencia_fin() {
		return dte_fecha_vigencia_fin;
	}

	public void setDte_fecha_vigencia_fin(java.util.Date dte_fecha_vigencia_fin) {
		this.dte_fecha_vigencia_fin = dte_fecha_vigencia_fin;
	}

	public Integer getInt_id_area_organica() {
		return int_id_area_organica;
	}

	public void setInt_id_area_organica(Integer int_id_area_organica) {
		this.int_id_area_organica = int_id_area_organica;
	}

	public Integer getAnho() {
		return anho;
	}

	public void setAnho(Integer anho) {
		this.anho = anho;
	}

}
