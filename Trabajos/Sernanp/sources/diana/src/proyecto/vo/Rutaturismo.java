package proyecto.vo;

import java.util.ArrayList;
import java.util.List;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Rutaturismo generated by hbm2java
 */
public class Rutaturismo implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	private int idrutaturismo;
	private String codrutaturismo;
	private String nombrerutaturismo;
	private Turismo turismo;
	private String detallerutaturismo;
	private String serviciosrutaturismo;
	private List<Boletaje> listaBoletaje;
	private List<RutaturismoTipoturismo> listaRutaturismoTipoturismo;

	public Rutaturismo() { 
		turismo=new Turismo();
		listaBoletaje=new ArrayList<Boletaje>();
		listaRutaturismoTipoturismo=new ArrayList<RutaturismoTipoturismo>();
	}

	public Rutaturismo(int idrutaturismo){
		super();
		this.idrutaturismo=idrutaturismo;
	}
	
	public Rutaturismo(Turismo turismo) {
		this.turismo = turismo;
	}

	public int getIdrutaturismo() {
		return idrutaturismo;
	}

	public void setIdrutaturismo(int idrutaturismo) {
		this.idrutaturismo = idrutaturismo;
	}

	public String getCodrutaturismo() {
		return codrutaturismo;
	}

	public void setCodrutaturismo(String codrutaturismo) {
		this.codrutaturismo = codrutaturismo;
	}

	public String getNombrerutaturismo() {
		return nombrerutaturismo;
	}

	public void setNombrerutaturismo(String nombrerutaturismo) {
		this.nombrerutaturismo = nombrerutaturismo;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}

	public String getDetallerutaturismo() {
		return detallerutaturismo;
	}

	public void setDetallerutaturismo(String detallerutaturismo) {
		this.detallerutaturismo = detallerutaturismo;
	}

	public String getServiciosrutaturismo() {
		return serviciosrutaturismo;
	}

	public void setServiciosrutaturismo(String serviciosrutaturismo) {
		this.serviciosrutaturismo = serviciosrutaturismo;
	}

	public List<RutaturismoTipoturismo> getListaRutaturismoTipoturismo() {
		return listaRutaturismoTipoturismo;
	}

	public void setListaRutaturismoTipoturismo(
			List<RutaturismoTipoturismo> listaRutaturismoTipoturismo) {
		this.listaRutaturismoTipoturismo = listaRutaturismoTipoturismo;
	}

	public List<Boletaje> getListaBoletaje() {
		return listaBoletaje;
	}

	public void setListaBoletaje(List<Boletaje> listaBoletaje) {
		this.listaBoletaje = listaBoletaje;
	}

	

	
}
