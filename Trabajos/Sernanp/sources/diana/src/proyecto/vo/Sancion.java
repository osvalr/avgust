package proyecto.vo;

public class Sancion {
		
	private int idsancion;
	private String descripcionsancion;
	private String observacion;
	//private List<ExpedienteSancion> listaSancion;
	
	public Sancion(){
		// listaSancion= new ArrayList<ExpedienteSancion>();
	}
	
	public int getIdsancion() {
		return idsancion;
	}

	public void setIdsancion(int idsancion) {
		this.idsancion = idsancion;
	}
	
	public String getDescripcionsancion() {
		return descripcionsancion;
	}
	
	public void setDescripcionsancion(String descripcionsancion) {
		this.descripcionsancion = descripcionsancion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}