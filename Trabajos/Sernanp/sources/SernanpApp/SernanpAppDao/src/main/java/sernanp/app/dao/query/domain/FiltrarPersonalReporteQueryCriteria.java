package sernanp.app.dao.query.domain;

import java.util.Date;

public class FiltrarPersonalReporteQueryCriteria {

	private Integer srl_id_regimen_contractual;
	private Integer srl_id_cargo;
	private Integer anho_inicio;
	private Date dte_fec_inicio_desde;
	private Date dte_fec_inicio_hasta;
	
	public Integer getSrl_id_regimen_contractual() {
		return srl_id_regimen_contractual;
	}

	public void setSrl_id_regimen_contractual(Integer srl_id_regimen_contractual) {
		this.srl_id_regimen_contractual = srl_id_regimen_contractual;
	}

	public Integer getSrl_id_cargo() {
		return srl_id_cargo;
	}

	public void setSrl_id_cargo(Integer srl_id_cargo) {
		this.srl_id_cargo = srl_id_cargo;
	}

	public Integer getAnho_inicio() {
		return anho_inicio;
	}

	public void setAnho_inicio(Integer anho_inicio) {
		this.anho_inicio = anho_inicio;
	}

	public Date getDte_fec_inicio_desde() {
		return dte_fec_inicio_desde;
	}

	public void setDte_fec_inicio_desde(Date dte_fec_inicio_desde) {
		this.dte_fec_inicio_desde = dte_fec_inicio_desde;
	}

	public Date getDte_fec_inicio_hasta() {
		return dte_fec_inicio_hasta;
	}

	public void setDte_fec_inicio_hasta(Date dte_fec_inicio_hasta) {
		this.dte_fec_inicio_hasta = dte_fec_inicio_hasta;
	}


}
