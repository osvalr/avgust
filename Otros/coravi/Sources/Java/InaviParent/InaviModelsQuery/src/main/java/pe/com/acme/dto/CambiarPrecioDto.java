package pe.com.acme.dto;

public class CambiarPrecioDto {
	
	private Integer id_guia;
	private String nombreCliente;
	private Double pesoNeto;
	private Double precioActual;
	private Double importeActual;
	private Double nuevoPrecio;
	private Double nuevoImporte;
	
	public Integer getId_guia() {
		return id_guia;
	}
	public void setId_guia(Integer id_guia) {
		this.id_guia = id_guia;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Double getPesoNeto() {
		return pesoNeto;
	}
	public void setPesoNeto(Double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}
	public Double getPrecioActual() {
		return precioActual;
	}
	public void setPrecioActual(Double precioActual) {
		this.precioActual = precioActual;
	}
	public Double getNuevoPrecio() {
		return nuevoPrecio;
	}
	public void setNuevoPrecio(Double nuevoPrecio) {
		this.nuevoPrecio = nuevoPrecio;
	}
	public Double getNuevoImporte() {
		return nuevoImporte;
	}
	public void setNuevoImporte(Double nuevoImporte) {
		this.nuevoImporte = nuevoImporte;
	}
	public Double getImporteActual() {
		return importeActual;
	}
	public void setImporteActual(Double importeActual) {
		this.importeActual = importeActual;
	}
}
