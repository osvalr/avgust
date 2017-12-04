package sernanp.rrhh.vo;

// Generated 14/10/2010 09:52:30 AM by Hibernate Tools 3.3.0.GA

import java.sql.Time;
import java.sql.Date;

/**
 * Personanatural generated by hbm2java
 */
public class Personanatural extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpersonanatural;
	private String apepat;
	private String apemat; 
	private String nombre;
	private Tipo tipodocumento;
	private String numerodocumento;
	private String direccion; 
	private String ruc;
	private Date fechanacimiento;
	private String fnacimiento;
	private Tipo sexo;
	private Tipo estadocivil;
		
	
	public Personanatural() {
		super();
		tipodocumento	= new Tipo();
		sexo			= new Tipo();
		estadocivil		= new Tipo();
	}

		
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(String fnacimiento) {
		this.fnacimiento = fnacimiento;
	}


	public int getIdpersonanatural() {
		return idpersonanatural;
	}


	public void setIdpersonanatural(int idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}


	public String getApepat() {
		return apepat;
	}


	public void setApepat(String apepat) {
		this.apepat = apepat;
	}


	public String getApemat() {
		return apemat;
	}


	public void setApemat(String apemat) {
		this.apemat = apemat;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Tipo getTipodocumento() {
		return tipodocumento;
	}


	public void setTipodocumento(Tipo tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public String getNumerodocumento() {
		return numerodocumento;
	}


	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}


	public Date getFechanacimiento() {
		return fechanacimiento;
	}


	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}


	public Tipo getSexo() {
		return sexo;
	}


	public void setSexo(Tipo sexo) {
		this.sexo = sexo;
	}


	public Tipo getEstadocivil() {
		return estadocivil;
	}


	public void setEstadocivil(Tipo estadocivil) {
		this.estadocivil = estadocivil;
	}
}