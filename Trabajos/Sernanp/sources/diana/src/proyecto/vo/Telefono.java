package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Tipoproyecto generated by hbm2java
 */
public class Telefono implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtelefono;
	private String numerotelefono;
	private Tipotelefono tipotelefono;
	private Personal personal;
	private int flagPrincipal;
	
	
	public Telefono() {
		tipotelefono=new Tipotelefono();
		personal=new Personal();
	}


	public int getIdtelefono() {
		return idtelefono;
	}


	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}


	public String getNumerotelefono() {
		return numerotelefono;
	}


	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}


	public Tipotelefono getTipotelefono() {
		return tipotelefono;
	}


	public void setTipotelefono(Tipotelefono tipotelefono) {
		this.tipotelefono = tipotelefono;
	}


	public Personal getPersonal() {
		return personal;
	}


	public void setPersonal(Personal personal) {
		this.personal = personal;
	}


	public int getFlagPrincipal() {
		return flagPrincipal;
	}


	public void setFlagPrincipal(int flagPrincipal) {
		this.flagPrincipal = flagPrincipal;
	}

	


	
}