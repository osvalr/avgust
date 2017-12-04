package sernanp.app.business.dto;

public class CuartaCategoriaResponseType {
	
	private Double rentaBruta;
	private Double deducion;
	private Double rentaNeta;
	private Double deduccion7Uit;
	private Double totalRentaImponible;
	private Double totalImpuestoAnual;
	private Double totalImpuestoMensual;
	
	public Double getRentaBruta() {
		return rentaBruta;
	}
	public void setRentaBruta(Double rentaBruta) {
		this.rentaBruta = rentaBruta;
	}
	public Double getDeducion() {
		return deducion;
	}
	public void setDeducion(Double deducion) {
		this.deducion = deducion;
	}
	public Double getRentaNeta() {
		return rentaNeta;
	}
	public void setRentaNeta(Double rentaNeta) {
		this.rentaNeta = rentaNeta;
	}
	public Double getDeduccion7Uit() {
		return deduccion7Uit;
	}
	public void setDeduccion7Uit(Double deduccion7Uit) {
		this.deduccion7Uit = deduccion7Uit;
	}
	public Double getTotalRentaImponible() {
		return totalRentaImponible;
	}
	public void setTotalRentaImponible(Double totalRentaImponible) {
		this.totalRentaImponible = totalRentaImponible;
	}
	public Double getTotalImpuestoAnual() {
		return totalImpuestoAnual;
	}
	public void setTotalImpuestoAnual(Double totalImpuestoAnual) {
		this.totalImpuestoAnual = totalImpuestoAnual;
	}
	public Double getTotalImpuestoMensual() {
		return totalImpuestoMensual;
	}
	public void setTotalImpuestoMensual(Double totalImpuestoMensual) {
		this.totalImpuestoMensual = totalImpuestoMensual;
	}
}
