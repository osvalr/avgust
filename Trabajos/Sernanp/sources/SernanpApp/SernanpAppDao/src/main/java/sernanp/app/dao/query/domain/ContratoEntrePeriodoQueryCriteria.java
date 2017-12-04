package sernanp.app.dao.query.domain;

import java.util.Date;

public class ContratoEntrePeriodoQueryCriteria {

	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer int_id_postulante;
	private Integer idpersonal;
	private Integer srl_id_contrato;
	private Date dte_fec_inicio;
	private Date dte_fec_termino;

	public Date getDte_fec_inicio() {
		return dte_fec_inicio;
	}

	public void setDte_fec_inicio(Date dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}

	public Date getDte_fec_termino() {
		return dte_fec_termino;
	}

	public void setDte_fec_termino(Date dte_fec_termino) {
		this.dte_fec_termino = dte_fec_termino;
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

	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}

	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
	}

}
