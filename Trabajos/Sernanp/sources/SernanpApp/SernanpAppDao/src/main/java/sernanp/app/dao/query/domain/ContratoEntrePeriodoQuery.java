package sernanp.app.dao.query.domain;

public class ContratoEntrePeriodoQuery {

	private Integer srl_id_contrato;
	private Integer srl_id_contrato_padre;
	private java.util.Date dte_fec_suscrip;
	private java.util.Date dte_fec_inicio;
	private java.util.Date dte_fec_termino;
	private Integer int_id_estado;
	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer int_id_postulante;
	private Integer idpersonal;

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

	public java.util.Date getDte_fec_suscrip() {
		return dte_fec_suscrip;
	}

	public void setDte_fec_suscrip(java.util.Date dte_fec_suscrip) {
		this.dte_fec_suscrip = dte_fec_suscrip;
	}

	public java.util.Date getDte_fec_inicio() {
		return dte_fec_inicio;
	}

	public void setDte_fec_inicio(java.util.Date dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}

	public java.util.Date getDte_fec_termino() {
		return dte_fec_termino;
	}

	public void setDte_fec_termino(java.util.Date dte_fec_termino) {
		this.dte_fec_termino = dte_fec_termino;
	}

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}

	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}

	public Integer getInt_id_postulante() {
		return int_id_postulante;
	}

	public void setInt_id_postulante(Integer int_id_postulante) {
		this.int_id_postulante = int_id_postulante;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

}
