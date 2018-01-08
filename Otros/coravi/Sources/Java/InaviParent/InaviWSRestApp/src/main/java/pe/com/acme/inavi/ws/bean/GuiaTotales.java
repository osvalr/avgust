package pe.com.acme.inavi.ws.bean;

public class GuiaTotales {
	
	private Double total_peso_bruto; 
	private Double total_peso_tara; 
	private Double total_peso_devolucion; 
	private Double total_peso_tara_devo;
	private Double total_peso_neto;
	private String taraCompleta;
	
	public Double getTotal_peso_bruto() {
		return total_peso_bruto;
	}
	public void setTotal_peso_bruto(Double total_peso_bruto) {
		this.total_peso_bruto = total_peso_bruto;
	}
	public Double getTotal_peso_tara() {
		return total_peso_tara;
	}
	public void setTotal_peso_tara(Double total_peso_tara) {
		this.total_peso_tara = total_peso_tara;
	}
	public Double getTotal_peso_devolucion() {
		return total_peso_devolucion;
	}
	public void setTotal_peso_devolucion(Double total_peso_devolucion) {
		this.total_peso_devolucion = total_peso_devolucion;
	}
	public Double getTotal_peso_neto() {
		return total_peso_neto;
	}
	public void setTotal_peso_neto(Double total_peso_neto) {
		this.total_peso_neto = total_peso_neto;
	}
	public Double getTotal_peso_tara_devo() {
		return total_peso_tara_devo;
	}
	public void setTotal_peso_tara_devo(Double total_peso_tara_devo) {
		this.total_peso_tara_devo = total_peso_tara_devo;
	}
	public String getTaraCompleta() {
		return taraCompleta;
	}
	public void setTaraCompleta(String taraCompleta) {
		this.taraCompleta = taraCompleta;
	} 
	
}
