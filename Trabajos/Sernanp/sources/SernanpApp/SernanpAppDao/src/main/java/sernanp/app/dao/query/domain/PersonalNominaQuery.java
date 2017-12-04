package sernanp.app.dao.query.domain;

public class PersonalNominaQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer idpersonal;
	private String nombre_completo;
	private java.util.Date fechanacimiento;
	private Integer srl_id_regimen_pensionario;
	private Integer srl_id_afp;
	private Integer int_id_tipo_comision;
	private Integer srl_id_entidad_bancaria;
	private String var_numero_cuenta_bancaria;
	private Integer int_estado;
	private Integer int_flag;

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public Integer getIdpersonanatural() {
		return idpersonanatural;
	}

	public void setIdpersonanatural(Integer idpersonanatural) {
		this.idpersonanatural = idpersonanatural;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public java.util.Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(java.util.Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Integer getSrl_id_regimen_pensionario() {
		return srl_id_regimen_pensionario;
	}

	public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
		this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
	}

	public Integer getSrl_id_afp() {
		return srl_id_afp;
	}

	public void setSrl_id_afp(Integer srl_id_afp) {
		this.srl_id_afp = srl_id_afp;
	}

	public Integer getInt_id_tipo_comision() {
		return int_id_tipo_comision;
	}

	public void setInt_id_tipo_comision(Integer int_id_tipo_comision) {
		this.int_id_tipo_comision = int_id_tipo_comision;
	}

	public Integer getInt_estado() {
		return int_estado;
	}

	public void setInt_estado(Integer int_estado) {
		this.int_estado = int_estado;
	}

	public Integer getInt_flag() {
		return int_flag;
	}

	public void setInt_flag(Integer int_flag) {
		this.int_flag = int_flag;
	}

	public Integer getSrl_id_entidad_bancaria() {
		return srl_id_entidad_bancaria;
	}

	public void setSrl_id_entidad_bancaria(Integer srl_id_entidad_bancaria) {
		this.srl_id_entidad_bancaria = srl_id_entidad_bancaria;
	}

	public String getVar_numero_cuenta_bancaria() {
		return var_numero_cuenta_bancaria;
	}

	public void setVar_numero_cuenta_bancaria(String var_numero_cuenta_bancaria) {
		this.var_numero_cuenta_bancaria = var_numero_cuenta_bancaria;
	}

}
