package proyecto.vo;

public class DetalleExpedienteSancion {

	private int idDetalleExpedienteSancion;
	private String datoVariado;
	private String observacion;
	private int estado;
	private int idexpediente;
	private int idsancion;
	
	public int getIdDetalleExpedienteSancion() {
		return idDetalleExpedienteSancion;
	}
	
	public void setIdDetalleExpedienteSancion(int idDetalleExpedienteSancion) {
		this.idDetalleExpedienteSancion = idDetalleExpedienteSancion;
	}
	
	public String getDatoVariado() {
		return datoVariado;
	}
	
	public void setDatoVariado(String datoVariado) {
		this.datoVariado = datoVariado;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdexpediente() {
		return idexpediente;
	}

	public void setIdexpediente(int idexpediente) {
		this.idexpediente = idexpediente;
	}

	public int getIdsancion() {
		return idsancion;
	}

	public void setIdsancion(int idsancion) {
		this.idsancion = idsancion;
	}
		
}