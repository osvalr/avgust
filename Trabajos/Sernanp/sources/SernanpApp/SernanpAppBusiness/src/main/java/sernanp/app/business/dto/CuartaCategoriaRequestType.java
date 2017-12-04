package sernanp.app.business.dto;

public class CuartaCategoriaRequestType {
	
	private Double uit;
	private Double totalIngresoMensual;
	private Integer cantidadMeses;
	
	public Double getUit() {
		return uit;
	}
	public void setUit(Double uit) {
		this.uit = uit;
	}
	public Double getTotalIngresoMensual() {
		return totalIngresoMensual;
	}
	public void setTotalIngresoMensual(Double totalIngresoMensual) {
		this.totalIngresoMensual = totalIngresoMensual;
	}
	public Integer getCantidadMeses() {
		return cantidadMeses;
	}
	public void setCantidadMeses(Integer cantidadMeses) {
		this.cantidadMeses = cantidadMeses;
	}
}
