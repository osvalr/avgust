package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA


/**
 * Tipoproyecto generated by hbm2java
 */
public class Tipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtipo;
	private String nombretipo;
	private String codigotipo;
	private int ordentipo;
	private String destipo;
	private String abrevtipo;
	private int codigointtipo;
	private String mensajetipo;
	private int idtabla;
	
	
	public Tipo() {
	}
	public Tipo(int idtabla){
		this.idtabla=idtabla;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getNombretipo() {
		return nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}

	public String getCodigotipo() {
		return codigotipo;
	}

	public void setCodigotipo(String codigotipo) {
		this.codigotipo = codigotipo;
	}

	public int getOrdentipo() {
		return ordentipo;
	}

	public void setOrdentipo(int ordentipo) {
		this.ordentipo = ordentipo;
	}

	public String getDestipo() {
		return destipo;
	}

	public void setDestipo(String destipo) {
		this.destipo = destipo;
	}

	public String getAbrevtipo() {
		return abrevtipo;
	}

	public void setAbrevtipo(String abrevtipo) {
		this.abrevtipo = abrevtipo;
	}

	public int getIdtabla() {
		return idtabla;
	}

	public void setIdtabla(int idtabla) {
		this.idtabla = idtabla;
	}
	public int getCodigointtipo() {
		return codigointtipo;
	}
	public void setCodigointtipo(int codigointtipo) {
		this.codigointtipo = codigointtipo;
	}
	public String getMensajetipo() {
		return mensajetipo;
	}
	public void setMensajetipo(String mensajetipo) {
		this.mensajetipo = mensajetipo;
	}

	
	
	

}
