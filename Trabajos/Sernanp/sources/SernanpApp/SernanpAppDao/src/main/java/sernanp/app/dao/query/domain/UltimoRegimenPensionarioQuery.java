package sernanp.app.dao.query.domain;

public class UltimoRegimenPensionarioQuery {

	private Integer srl_id_regimen_pensionario_historial;
	private Integer idpersonal;
	private Integer srl_id_regimen_pensionario;
	private Integer int_estado;
	private String var_nombre_afp;
	private String var_codigo_afiliacion;
	private java.util.Date dte_fecha_afiliacion;

	public Integer getSrl_id_regimen_pensionario_historial() {
		return srl_id_regimen_pensionario_historial;
	}

	public void setSrl_id_regimen_pensionario_historial(
			Integer srl_id_regimen_pensionario_historial) {
		this.srl_id_regimen_pensionario_historial = srl_id_regimen_pensionario_historial;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getSrl_id_regimen_pensionario() {
		return srl_id_regimen_pensionario;
	}

	public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
		this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
	}

	public Integer getInt_estado() {
		return int_estado;
	}

	public void setInt_estado(Integer int_estado) {
		this.int_estado = int_estado;
	}

	public String getVar_nombre_afp() {
		return var_nombre_afp;
	}

	public void setVar_nombre_afp(String var_nombre_afp) {
		this.var_nombre_afp = var_nombre_afp;
	}

	public String getVar_codigo_afiliacion() {
		return var_codigo_afiliacion;
	}

	public void setVar_codigo_afiliacion(String var_codigo_afiliacion) {
		this.var_codigo_afiliacion = var_codigo_afiliacion;
	}

	public java.util.Date getDte_fecha_afiliacion() {
		return dte_fecha_afiliacion;
	}

	public void setDte_fecha_afiliacion(java.util.Date dte_fecha_afiliacion) {
		this.dte_fecha_afiliacion = dte_fecha_afiliacion;
	}

}