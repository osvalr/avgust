package sernanp.app.business.dto;


public class FiltrarPersonalReporteDto {
	
	private Integer srl_id_regimen_contractual;
	private Integer srl_id_cargo;
	private String anho_inicio;
	private String dte_fec_inicio_desde;
	private String dte_fec_inicio_hasta;
	
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
	public String getAnho_inicio() {
		return anho_inicio;
	}
	public void setAnho_inicio(String anho_inicio) {
		this.anho_inicio = anho_inicio;
	}
	public String getDte_fec_inicio_desde() {
		return dte_fec_inicio_desde;
	}
	public void setDte_fec_inicio_desde(String dte_fec_inicio_desde) {
		this.dte_fec_inicio_desde = dte_fec_inicio_desde;
	}
	public String getDte_fec_inicio_hasta() {
		return dte_fec_inicio_hasta;
	}
	public void setDte_fec_inicio_hasta(String dte_fec_inicio_hasta) {
		this.dte_fec_inicio_hasta = dte_fec_inicio_hasta;
	}
	
	
}
