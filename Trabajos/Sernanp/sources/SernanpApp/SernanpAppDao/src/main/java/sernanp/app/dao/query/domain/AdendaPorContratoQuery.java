package sernanp.app.dao.query.domain;

public class AdendaPorContratoQuery {

	private Integer srl_id_contrato;
	private Integer srl_id_contrato_padre;
	private String var_num_contrato;
	private String var_num_contrato_padre;
	private String dte_fec_suscrip;
	private String dte_fec_inicio;
	private String dte_fec_termino;
	private String dte_fec_cese;
	private Integer int_id_estado;
	private String var_nombre_estado;
	private Integer srl_id_postulante_conv_area_org;

	//11-02-2015 DAVID
	private Integer flag_digital_contrato;

	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}

	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
	}

	public Integer getSrl_id_contrato_padre() {
		return srl_id_contrato_padre;
	}

	public void setSrl_id_contrato_padre(Integer srl_id_contrato_padre) {
		this.srl_id_contrato_padre = srl_id_contrato_padre;
	}

	public String getVar_num_contrato() {
		return var_num_contrato;
	}

	public void setVar_num_contrato(String var_num_contrato) {
		this.var_num_contrato = var_num_contrato;
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

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public String getVar_nombre_estado() {
		return var_nombre_estado;
	}

	public void setVar_nombre_estado(String var_nombre_estado) {
		this.var_nombre_estado = var_nombre_estado;
	}

	public String getVar_num_contrato_padre() {
		return var_num_contrato_padre;
	}

	public void setVar_num_contrato_padre(String var_num_contrato_padre) {
		this.var_num_contrato_padre = var_num_contrato_padre;
	}

	public String getDte_fec_cese() {
		return dte_fec_cese;
	}

	public void setDte_fec_cese(String dte_fec_cese) {
		this.dte_fec_cese = dte_fec_cese;
	}

	public Integer getSrl_id_postulante_conv_area_org() {
		return srl_id_postulante_conv_area_org;
	}

	public void setSrl_id_postulante_conv_area_org(
			Integer srl_id_postulante_conv_area_org) {
		this.srl_id_postulante_conv_area_org = srl_id_postulante_conv_area_org;
	}

	public Integer getFlag_digital_contrato() {
		return flag_digital_contrato;
	}

	public void setFlag_digital_contrato(Integer flag_digital_contrato) {
		this.flag_digital_contrato = flag_digital_contrato;
	}

}
