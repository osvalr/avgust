package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Proyecto generated by hbm2java
 */
public class ProyectoFteFto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;
	private Fuentefinanciamiento fteFto;
	private double monto;
	private Moneda moneda;
	private Tipocambio tipocambio;
	
	public ProyectoFteFto() {
		proyecto=new Proyecto();
		fteFto=new Fuentefinanciamiento();
		tipocambio=new Tipocambio();
		moneda=new Moneda();
	}


	
	
	public Moneda getMoneda() {
		return moneda;
	}




	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}




	public Tipocambio getTipocambio() {
		return tipocambio;
	}




	public void setTipocambio(Tipocambio tipocambio) {
		this.tipocambio = tipocambio;
	}




	public double getMonto() {
		return monto;
	}




	public void setMonto(double monto) {
		this.monto = monto;
	}




	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public Fuentefinanciamiento getFteFto() {
		return fteFto;
	}


	public void setFteFto(Fuentefinanciamiento fteFto) {
		this.fteFto = fteFto;
	}


	


	

	
	
	

}