package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Tipoareaorganica generated by hbm2java
 */
public class Tipoareaorganica implements java.io.Serializable {

	private int idtipoarea;
	private String codtipoarea;
	private String destipoarea;
	private List<Areaorganica> areaorganicas = new ArrayList<Areaorganica>();

	public Tipoareaorganica() {
	}

	public Tipoareaorganica(String codtipoarea, String destipoarea,
			List<Areaorganica> areaorganicas) {
		this.codtipoarea = codtipoarea;
		this.destipoarea = destipoarea;
		this.areaorganicas = areaorganicas;
	}

	public int getIdtipoarea() {
		return this.idtipoarea;
	}

	public void setIdtipoarea(int idtipoarea) {
		this.idtipoarea = idtipoarea;
	}

	public String getCodtipoarea() {
		return this.codtipoarea;
	}

	public void setCodtipoarea(String codtipoarea) {
		this.codtipoarea = codtipoarea;
	}

	public String getDestipoarea() {
		return this.destipoarea;
	}

	public void setDestipoarea(String destipoarea) {
		this.destipoarea = destipoarea;
	}

	public List<Areaorganica> getAreaorganicas() {
		return this.areaorganicas;
	}

	public void setAreaorganicas(List<Areaorganica> areaorganicas) {
		this.areaorganicas = areaorganicas;
	}

}
