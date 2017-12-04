package sernanp.app.dao.query.domain;

import java.util.Date;

public class ObtenerUltimoContratoAlternoQueryCriteria {

	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer srl_id_contrato;
	private Integer int_id_postulante;
	private Integer idpersonal;
	private Integer int_id_estado;
	private Date dte_fec_cese;

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

	public Integer getSrl_id_contrato() {
		return srl_id_contrato;
	}

	public void setSrl_id_contrato(Integer srl_id_contrato) {
		this.srl_id_contrato = srl_id_contrato;
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

	public Integer getInt_id_estado() {
		return int_id_estado;
	}

	public void setInt_id_estado(Integer int_id_estado) {
		this.int_id_estado = int_id_estado;
	}

	public Date getDte_fec_cese() {
		return dte_fec_cese;
	}

	public void setDte_fec_cese(Date dte_fec_cese) {
		this.dte_fec_cese = dte_fec_cese;
	}

}
