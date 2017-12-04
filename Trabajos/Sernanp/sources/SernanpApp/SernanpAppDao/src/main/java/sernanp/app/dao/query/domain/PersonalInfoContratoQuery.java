package sernanp.app.dao.query.domain;

public class PersonalInfoContratoQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srl_id_contrato;
	private Integer idpersonal;
	private String var_num_contrato;
	private String var_descripcion_regimen_contractual;
	private String dte_fec_suscrip;
	private String dte_fec_inicio;
	private String dte_fec_termino;
	private String dte_fec_cese;
	private String var_nom_cargo;
	private Double num_sueldo;
	private String var_ubicacion_fisica;
	private String var_nombre_estado;

	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}

	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getVar_num_contrato() {
		return var_num_contrato;
	}

	public void setVar_num_contrato(String var_num_contrato) {
		this.var_num_contrato = var_num_contrato;
	}

	public String getVar_descripcion_regimen_contractual() {
		return var_descripcion_regimen_contractual;
	}

	public void setVar_descripcion_regimen_contractual(
			String var_descripcion_regimen_contractual) {
		this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual;
	}

	public String getDte_fec_suscrip() {
		return dte_fec_suscrip;
	}

	public void setDte_fec_suscrip(String dte_fec_suscrip) {
		this.dte_fec_suscrip = dte_fec_suscrip;
	}

	public String getDte_fec_inicio() {
		return dte_fec_inicio;
	}

	public void setDte_fec_inicio(String dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}

	public String getDte_fec_termino() {
		return dte_fec_termino;
	}

	public void setDte_fec_termino(String dte_fec_termino) {
		this.dte_fec_termino = dte_fec_termino;
	}

	public String getDte_fec_cese() {
		return dte_fec_cese;
	}

	public void setDte_fec_cese(String dte_fec_cese) {
		this.dte_fec_cese = dte_fec_cese;
	}

	public String getVar_nom_cargo() {
		return var_nom_cargo;
	}

	public void setVar_nom_cargo(String var_nom_cargo) {
		this.var_nom_cargo = var_nom_cargo;
	}

	public String getVar_nombre_estado() {
		return var_nombre_estado;
	}

	public void setVar_nombre_estado(String var_nombre_estado) {
		this.var_nombre_estado = var_nombre_estado;
	}

	public Double getNum_sueldo() {
		return num_sueldo;
	}

	public void setNum_sueldo(Double num_sueldo) {
		this.num_sueldo = num_sueldo;
	}

	public String getVar_ubicacion_fisica() {
		return var_ubicacion_fisica;
	}

	public void setVar_ubicacion_fisica(String var_ubicacion_fisica) {
		this.var_ubicacion_fisica = var_ubicacion_fisica;
	}

}
