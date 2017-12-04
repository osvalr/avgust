package sernanp.app.dao.query.domain;

import java.util.Date;

public class PersonalDiasLicenciasQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idpersonal;
	private Date dte_fec_inicio_lic;
	private Date dte_fec_fin_lic;

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Date getDte_fec_inicio_lic() {
		return dte_fec_inicio_lic;
	}

	public void setDte_fec_inicio_lic(Date dte_fec_inicio_lic) {
		this.dte_fec_inicio_lic = dte_fec_inicio_lic;
	}

	public Date getDte_fec_fin_lic() {
		return dte_fec_fin_lic;
	}

	public void setDte_fec_fin_lic(Date dte_fec_fin_lic) {
		this.dte_fec_fin_lic = dte_fec_fin_lic;
	}

}
