package proyecto.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

/**
 * Beneficiario generated by hbm2java
 */
public class Beneficiario implements java.io.Serializable {

	private int idbeneficiario;
	private Turismo turismo;
	private Tipobeneficiario tipobeneficiario;
	private String desc;

	public Beneficiario() {
	}

	public Beneficiario(int idbeneficiario, Turismo turismo,
			Tipobeneficiario tipobeneficiario) {
		this.idbeneficiario = idbeneficiario;
		this.turismo = turismo;
		this.tipobeneficiario = tipobeneficiario;
	}

	public Beneficiario(int idbeneficiario, Turismo turismo,
			Tipobeneficiario tipobeneficiario, String desc) {
		this.idbeneficiario = idbeneficiario;
		this.turismo = turismo;
		this.tipobeneficiario = tipobeneficiario;
		this.desc = desc;
	}

	public int getIdbeneficiario() {
		return this.idbeneficiario;
	}

	public void setIdbeneficiario(int idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public Turismo getTurismo() {
		return this.turismo;
	}

	public void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}

	public Tipobeneficiario getTipobeneficiario() {
		return this.tipobeneficiario;
	}

	public void setTipobeneficiario(Tipobeneficiario tipobeneficiario) {
		this.tipobeneficiario = tipobeneficiario;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
