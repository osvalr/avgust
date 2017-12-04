package sernanp.app.dao.query.domain;

import java.util.Date;

public class PersonalDiasLicenciasQueryCriteria {

	private String orderColumn;
	private String orderDirecction;
	private Integer idpersonal;
	private Integer int_anho;
	private Integer srl_id_per_activ;
	private Integer srl_id_pers_lic;
	private Date dte_fec_inicio_lic;

	public PersonalDiasLicenciasQueryCriteria() {
		this.orderColumn = "1";
		this.orderDirecction = "ASC";
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getInt_anho() {
		return int_anho;
	}

	public void setInt_anho(Integer int_anho) {
		this.int_anho = int_anho;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderDirecction() {
		return orderDirecction;
	}

	public void setOrderDirecction(String orderDirecction) {
		this.orderDirecction = orderDirecction;
	}

	public Integer getSrl_id_per_activ() {
		return srl_id_per_activ;
	}

	public void setSrl_id_per_activ(Integer srl_id_per_activ) {
		this.srl_id_per_activ = srl_id_per_activ;
	}

	public Integer getSrl_id_pers_lic() {
		return srl_id_pers_lic;
	}

	public void setSrl_id_pers_lic(Integer srl_id_pers_lic) {
		this.srl_id_pers_lic = srl_id_pers_lic;
	}

	public Date getDte_fec_inicio_lic() {
		return dte_fec_inicio_lic;
	}

	public void setDte_fec_inicio_lic(Date dte_fec_inicio_lic) {
		this.dte_fec_inicio_lic = dte_fec_inicio_lic;
	}

}
