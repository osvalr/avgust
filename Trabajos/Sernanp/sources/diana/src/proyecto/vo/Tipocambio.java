package proyecto.vo;

import java.util.Date;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Tipoproyecto generated by hbm2java
 */
public class Tipocambio implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtipocambio;
	private double valor;
	private Date fecha;
 	private Moneda monedaOrigen;
	private Moneda monedaDestino;
	private int anio;
	private int mes;
	private String destipocambio;
	public Tipocambio() {
		monedaOrigen=new Moneda();
		monedaDestino=new Moneda();
	}
	public int getIdtipocambio() {
		return idtipocambio;
	}
	public void setIdtipocambio(int idtipocambio) {
		this.idtipocambio = idtipocambio;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Moneda getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(Moneda monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public Moneda getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(Moneda monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getDestipocambio() {
		return destipocambio;
	}
	public void setDestipocambio(String destipocambio) {
		this.destipocambio = destipocambio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}

	

	

}
