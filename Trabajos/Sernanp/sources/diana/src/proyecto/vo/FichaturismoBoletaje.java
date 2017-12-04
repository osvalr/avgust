package proyecto.vo;

import java.io.Serializable;


public class FichaturismoBoletaje  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idfichaturismo;
	private Boletaje boletaje;
	private int cantidad;
	
	public FichaturismoBoletaje() {
		boletaje=new Boletaje();
	}

	

	public int getIdfichaturismo() {
		return idfichaturismo;
	}
	public void setIdfichaturismo(int idfichaturismo) {
		this.idfichaturismo = idfichaturismo;
	}

	public Boletaje getBoletaje() {
		return boletaje;
	}

	public void setBoletaje(Boletaje boletaje) {
		this.boletaje = boletaje;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
	
}
