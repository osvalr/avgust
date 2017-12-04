package proyecto.vo;

import java.sql.Timestamp;

public class PersonalRegistro {

	private int idpersonalregistro;
	private String nombre;
	private String apepat;
	private String apemat;
	private Tipo tipodocumento;
	private Tipo tipolocal;
	private String numerodocumento;
	private Tipo sexo;
	private String empresa;
	private String fechaingreso;
	
	//----
	
	private String horaingreso;
	private String fechasalida;
	private String horasalida;
		
	//-----
	
	
	private Operadorturismo operadorturismo;
	private Areanatural areanatural;
	
	private int idestado;
			
	public PersonalRegistro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdpersonalregistro() {
		return idpersonalregistro;
	}
	public void setIdpersonalregistro(int idpersonalregistro) {
		this.idpersonalregistro = idpersonalregistro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Tipo getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(Tipo tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public Tipo getTipolocal() {
		return tipolocal;
	}
	public void setTipolocal(Tipo tipolocal) {
		this.tipolocal = tipolocal;
	}
	public String getNumerodocumento() {
		return numerodocumento;
	}
	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	public Tipo getSexo() {
		return sexo;
	}
	public void setSexo(Tipo sexo) {
		this.sexo = sexo;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Operadorturismo getOperadorturismo() {
		return operadorturismo;
	}

	public void setOperadorturismo(Operadorturismo operadorturismo) {
		this.operadorturismo = operadorturismo;
	}

	public Areanatural getAreanatural() {
		return areanatural;
	}

	public void setAreanatural(Areanatural areanatural) {
		this.areanatural = areanatural;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getHoraingreso() {
		return horaingreso;
	}

	public void setHoraingreso(String horaingreso) {
		this.horaingreso = horaingreso;
	}

	public String getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}
	
	//-----
	
	
}
