package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

/**
 * Comunidad generated by hbm2java
 */
public class Comunidad implements java.io.Serializable {

	private int comunidad;
	private String nombrecomunida;

	public Comunidad() {
	}

	public Comunidad(String nombrecomunida) {
		this.nombrecomunida = nombrecomunida;
	}

	public int getComunidad() {
		return this.comunidad;
	}

	public void setComunidad(int comunidad) {
		this.comunidad = comunidad;
	}

	public String getNombrecomunida() {
		return this.nombrecomunida;
	}

	public void setNombrecomunida(String nombrecomunida) {
		this.nombrecomunida = nombrecomunida;
	}

}
