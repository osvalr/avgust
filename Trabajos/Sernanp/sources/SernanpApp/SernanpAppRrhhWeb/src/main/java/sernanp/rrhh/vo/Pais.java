package sernanp.rrhh.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.util.ArrayList;
import java.util.List;

/**
 * Pais generated by hbm2java
 */
public class Pais implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpais;
	private String codpais;
	private String nompais;
	private String nacionalidad;
	private List<Persona> personas = new ArrayList<Persona>();

	public Pais() {
	}

	public Pais(int idpais) {
	}
	public int getIdpais() {
		return idpais;
	}

	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}

	public String getCodpais() {
		return codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}



	
	

}
