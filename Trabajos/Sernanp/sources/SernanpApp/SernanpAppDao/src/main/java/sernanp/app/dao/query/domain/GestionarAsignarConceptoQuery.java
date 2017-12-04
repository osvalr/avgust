package sernanp.app.dao.query.domain;


public class GestionarAsignarConceptoQuery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idpersona;
	private Integer idpersonanatural;
	private Integer idpersonal;
	private String nombre_completo;
	private String nombre;
	private String apepat;
	private String apemat;
	private String descrip_documento;
	private String numerodoc;
	private String ruc;
	private String fechanacimiento;
	
	private String nompais;
	private String descrip_genero;
	private String telefono;
	private String correoinstitucional;
	private String descrip_depto;
	private String descrip_prov;
	private String descrip_ubigeo;
	private String direccion;

	private Integer srl_id_regimen_pensionario;
	private String var_descripcion_regimen_pensionario;
	private Integer srl_id_afp;
	private String var_nombre_afp;
	private Integer int_id_tipo_comision;
	private String descrip_tipo_comision;

	private String dte_fecha_afiliacion;
	private String var_codigo_afiliacion;
	private Integer srl_id_entidad_bancaria;
	private String var_desc_entidad_bancaria;
	private String var_numero_cuenta_bancaria;

	private Integer int_estado;
	private String desc_estado;
	
	//ADD 03-08-2015 DAVID
	private String dte_fec_inicio;
	private String var_descripcion_regimen_contractual;
	
	public String getDte_fec_inicio() {
		return dte_fec_inicio;
	}

	public void setDte_fec_inicio(String dte_fec_inicio) {
		this.dte_fec_inicio = dte_fec_inicio;
	}

	public String getVar_descripcion_regimen_contractual() {
		return var_descripcion_regimen_contractual;
	}

	public void setVar_descripcion_regimen_contractual(
			String var_descripcion_regimen_contractual) {
		this.var_descripcion_regimen_contractual = var_descripcion_regimen_contractual;
	}
	
	
	//END ADD



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

	public String getDescrip_documento() {
		return descrip_documento;
	}

	public void setDescrip_documento(String descrip_documento) {
		this.descrip_documento = descrip_documento;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getInt_estado() {
		return int_estado;
	}

	public void setInt_estado(Integer int_estado) {
		this.int_estado = int_estado;
	}

	public String getDesc_estado() {
		return desc_estado;
	}

	public void setDesc_estado(String desc_estado) {
		this.desc_estado = desc_estado;
	}

	public Integer getSrl_id_regimen_pensionario() {
		return srl_id_regimen_pensionario;
	}

	public void setSrl_id_regimen_pensionario(Integer srl_id_regimen_pensionario) {
		this.srl_id_regimen_pensionario = srl_id_regimen_pensionario;
	}

	public String getVar_descripcion_regimen_pensionario() {
		return var_descripcion_regimen_pensionario;
	}

	public void setVar_descripcion_regimen_pensionario(
			String var_descripcion_regimen_pensionario) {
		this.var_descripcion_regimen_pensionario = var_descripcion_regimen_pensionario;
	}

	public Integer getSrl_id_afp() {
		return srl_id_afp;
	}

	public void setSrl_id_afp(Integer srl_id_afp) {
		this.srl_id_afp = srl_id_afp;
	}

	public String getVar_nombre_afp() {
		return var_nombre_afp;
	}

	public void setVar_nombre_afp(String var_nombre_afp) {
		this.var_nombre_afp = var_nombre_afp;
	}

	public Integer getInt_id_tipo_comision() {
		return int_id_tipo_comision;
	}

	public void setInt_id_tipo_comision(Integer int_id_tipo_comision) {
		this.int_id_tipo_comision = int_id_tipo_comision;
	}

	public String getDescrip_tipo_comision() {
		return descrip_tipo_comision;
	}

	public void setDescrip_tipo_comision(String descrip_tipo_comision) {
		this.descrip_tipo_comision = descrip_tipo_comision;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public String getDescrip_genero() {
		return descrip_genero;
	}

	public void setDescrip_genero(String descrip_genero) {
		this.descrip_genero = descrip_genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoinstitucional() {
		return correoinstitucional;
	}

	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}

	public String getDescrip_depto() {
		return descrip_depto;
	}

	public void setDescrip_depto(String descrip_depto) {
		this.descrip_depto = descrip_depto;
	}

	public String getDescrip_prov() {
		return descrip_prov;
	}

	public void setDescrip_prov(String descrip_prov) {
		this.descrip_prov = descrip_prov;
	}

	public String getDescrip_ubigeo() {
		return descrip_ubigeo;
	}

	public void setDescrip_ubigeo(String descrip_ubigeo) {
		this.descrip_ubigeo = descrip_ubigeo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDte_fecha_afiliacion() {
		return dte_fecha_afiliacion;
	}

	public void setDte_fecha_afiliacion(String dte_fecha_afiliacion) {
		this.dte_fecha_afiliacion = dte_fecha_afiliacion;
	}

	public String getVar_codigo_afiliacion() {
		return var_codigo_afiliacion;
	}

	public void setVar_codigo_afiliacion(String var_codigo_afiliacion) {
		this.var_codigo_afiliacion = var_codigo_afiliacion;
	}

	public Integer getSrl_id_entidad_bancaria() {
		return srl_id_entidad_bancaria;
	}

	public void setSrl_id_entidad_bancaria(Integer srl_id_entidad_bancaria) {
		this.srl_id_entidad_bancaria = srl_id_entidad_bancaria;
	}

	public String getVar_desc_entidad_bancaria() {
		return var_desc_entidad_bancaria;
	}

	public void setVar_desc_entidad_bancaria(String var_desc_entidad_bancaria) {
		this.var_desc_entidad_bancaria = var_desc_entidad_bancaria;
	}

	public String getVar_numero_cuenta_bancaria() {
		return var_numero_cuenta_bancaria;
	}

	public void setVar_numero_cuenta_bancaria(String var_numero_cuenta_bancaria) {
		this.var_numero_cuenta_bancaria = var_numero_cuenta_bancaria;
	}

}
