package proyecto.vo;

import java.io.Serializable;

public class Boletaje implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idboletaje;
	private int serieboletaje;
	private String nombreboletaje;
	private Float valorboletaje;
	private String obsboletaje;
	private Rutaturismo rutaturismo;
	private int flagmayoredad;
	private Tipo tipoboletaje;
	public Boletaje(){
		rutaturismo=new Rutaturismo();
		tipoboletaje=new Tipo();
	}
	
	
	public int getIdboletaje() {
		return idboletaje;
	}
	public void setIdboletaje(int idboletaje) {
		this.idboletaje = idboletaje;
	}
	public int getSerieboletaje() {
		return serieboletaje;
	}
	public void setSerieboletaje(int serieboletaje) {
		this.serieboletaje = serieboletaje;
	}
	public String getNombreboletaje() {
		return nombreboletaje;
	}
	public void setNombreboletaje(String nombreboletaje) {
		this.nombreboletaje = nombreboletaje;
	}
	public Float getValorboletaje() {
		return valorboletaje;
	}
	public void setValorboletaje(Float valorboletaje) {
		this.valorboletaje = valorboletaje;
	}
	public String getObsboletaje() {
		return obsboletaje;
	}
	public void setObsboletaje(String obsboletaje) {
		this.obsboletaje = obsboletaje;
	}
	public Rutaturismo getRutaturismo() {
		return rutaturismo;
	}
	public void setRutaturismo(Rutaturismo rutaturismo) {
		this.rutaturismo = rutaturismo;
	}


	public int getFlagmayoredad() {
		return flagmayoredad;
	}


	public void setFlagmayoredad(int flagmayoredad) {
		this.flagmayoredad = flagmayoredad;
	}


	public Tipo getTipoboletaje() {
		return tipoboletaje;
	}


	public void setTipoboletaje(Tipo tipoboletaje) {
		this.tipoboletaje = tipoboletaje;
	}
	
	
	
	
	
}
