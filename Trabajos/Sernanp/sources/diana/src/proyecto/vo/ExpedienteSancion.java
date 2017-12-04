package proyecto.vo;

public class ExpedienteSancion {
	
	private Expediente expediente;
	private Sancion sancion;
	private int estado;
//	private String observacion;

	// JCEV 17-09-2012 17:30 pm.
	//private List<DetalleExpedienteSancion> listaDetalleExpedienteSancion;
	private DetalleExpedienteSancion detalleExpedienteSancion;
		
	public ExpedienteSancion() {
		expediente = new Expediente();
		sancion    = new Sancion();
		detalleExpedienteSancion = new DetalleExpedienteSancion();
	}
	
	public Expediente getExpediente() {
		return expediente;
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public Sancion getSancion() {
		return sancion;
	}
	
	public void setSancion(Sancion sancion) {
		this.sancion = sancion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public DetalleExpedienteSancion getDetalleExpedienteSancion() {
		return detalleExpedienteSancion;
	}

	public void setDetalleExpedienteSancion(
			DetalleExpedienteSancion detalleExpedienteSancion) {
		this.detalleExpedienteSancion = detalleExpedienteSancion;
	}
	
//	public String getObservacion() {
//		return observacion;
//	}

	//	public void setObservacion(String observacion) {
//		this.observacion = observacion;
//	}

	
	
}