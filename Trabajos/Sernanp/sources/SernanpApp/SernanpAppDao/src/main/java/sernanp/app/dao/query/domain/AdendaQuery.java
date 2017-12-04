package sernanp.app.dao.query.domain;

public class AdendaQuery {

	private Integer srl_id_contrato;
	private Integer srl_id_contrato_padre;
	private String var_num_contrato;
	private Integer int_id_estado;
	private String dte_fec_inicio;
	private String dte_fec_termino;
	private String dte_fec_suscrip;

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

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
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

	public String getDte_fec_suscrip() {
		return dte_fec_suscrip;
	}

	public void setDte_fec_suscrip(String dte_fec_suscrip) {
		this.dte_fec_suscrip = dte_fec_suscrip;
	}

}
