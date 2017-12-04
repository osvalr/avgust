package proyecto.vo;

import java.io.Serializable;


public class Parametro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idparametro;
	private String nombreparametro;
	private String valorparametro;
	
	
	
	public Parametro() {
		
	}



	public int getIdparametro() {
		return idparametro;
	}



	public void setIdparametro(int idparametro) {
		this.idparametro = idparametro;
	}



	public String getNombreparametro() {
		return nombreparametro;
	}



	public void setNombreparametro(String nombreparametro) {
		this.nombreparametro = nombreparametro;
	}



	public String getValorparametro() {
		return valorparametro;
	}



	public void setValorparametro(String valorparametro) {
		this.valorparametro = valorparametro;
	}

	
	

}
